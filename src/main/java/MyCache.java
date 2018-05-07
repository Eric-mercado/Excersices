import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class MyCache<T,P> {

    Map<String ,InnerItem> keyValueMap;
    int usageCounter ;
    final static int GREW_UP_FACTOR = 10;
    final static int MAX_CACHE_SIZE= 5;


    public static void main(String args[]){

        MyCache cache = new MyCache();

        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4","for");
        cache.put("5","five");

        System.out.println("printing value for 1" + cache.get("1") );
        System.out.println("printing value for 2" + cache.get("2") );
        System.out.println("printing value for 3" + cache.get("3") );
        System.out.println("printing value for 4" + cache.get("4") );

        cache.put("6","six");

        System.out.println("printing value for 6" + cache.get("6") );

    }

    MyCache(){
        keyValueMap = new ConcurrentHashMap<>();
        usageCounter = 0;
    }

    public Optional get(String key){

            Optional<InnerItem> myItem = Optional.ofNullable(keyValueMap.get(key));
            myItem.get().count++;
            updateNews();

          return Optional.of(myItem.get().value);

    }

    private void updateNews() {
        InnerItem innerItem;
        usageCounter++;
        for(Map.Entry<String, InnerItem> pair: keyValueMap.entrySet()){
            innerItem = pair.getValue();
            int itemAge = innerItem.historyNumber - usageCounter;

            if(innerItem.isnew == true || itemAge > GREW_UP_FACTOR){
                pair.getValue().isnew = false;
            }
        }
    }

    public void put(String key, String value){
        InnerItem innerItem = new InnerItem(value, 0, true, usageCounter);
        Optional<InnerItem> tempValue = Optional.ofNullable(keyValueMap.get(key));

        if(!tempValue.isPresent()){
             if(keyValueMap.size() <= MAX_CACHE_SIZE ){

                replaceMinimunUsage(key, innerItem);

             }
        }

        keyValueMap.put((String) key, innerItem);

        System.out.println("putting values " + key + " " +  value);
    }

    void replaceMinimunUsage(String key, InnerItem value){

         InnerItem smallestItem = Stream.of(keyValueMap)
                 .map(a -> a.keySet().toArray())
                 .map(a -> keyValueMap.get(a))
                 .filter(a -> a.isnew = false)
                 .min(Comparator.comparing(InnerItem::getCount)).get();


        for(Map.Entry<String, InnerItem> pair: keyValueMap.entrySet() ){

            if(pair.getValue() == smallestItem){

                System.out.println("removing item " + key + " " +  value.value);
                keyValueMap.remove(pair.getKey(), pair.getValue());
                keyValueMap.put(key, value);
            }
        }
    }

    private class InnerItem{
        String value;
        int count;
        boolean isnew;
        int historyNumber;

        InnerItem(String value, int count, boolean isNew, int historyNumber){
            this.count = count;
            this.value = value;
            this.isnew = isNew;
            this.historyNumber  = historyNumber;
        }

        public void increaseCounter(){
            this.count++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerItem innerItem = (InnerItem) o;
            return count == innerItem.count &&
                    isnew == innerItem.isnew &&
                    Objects.equals(value, innerItem.value);
        }

        @Override
        public int hashCode() {

            return Objects.hash(value, count, isnew);
        }

        public int getCount(){
            return this.count;
        }
    }
}


