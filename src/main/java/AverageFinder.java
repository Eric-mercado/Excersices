import java.util.*;

public class AverageFinder {

   public static void main(String[] args){

       List<Integer> mySetNumber = new ArrayList<>(Arrays.asList(1,7,9,11,15,29));

       System.out.println(findAverage(mySetNumber)); 
   }

    private static ArrayList<List<Integer>> findAverage(List<Integer> mySetNumber) {

       Collections.sort(mySetNumber);

       int half = mySetNumber.size()/2;
       int averageNumber = getAverage(mySetNumber);
        ArrayList<List<Integer>> result = new ArrayList<>();

       for(int i = 2 ; i <= half; i++){

          result = fillArrays(i, mySetNumber);

           if(!fillArrays(i, mySetNumber).isEmpty()){
               break;
           }
       }
       return result;
   }


    private static int getAverage(List<Integer> mySetNumber) {
       int counter = 0;
       for(Integer thisInt: mySetNumber){
           counter += thisInt;
       }

       return counter / mySetNumber.size();
    }

    static ArrayList<List<Integer>> fillArrays(int firstBlockSize, List<Integer> input){

        LinkedList<Integer> tempFirstBlock = new LinkedList<>();
        int inputAverage =  getAverage(input);
        Iterator<Integer> inputIterator = input.iterator();

        while(inputIterator.hasNext() &&  tempFirstBlock.size() <= firstBlockSize - 1){

            int currentNumber = inputIterator.next();
            int lookUpValue = inputAverage * firstBlockSize;
            int lookUpIndex = Collections.binarySearch(input, lookUpValue -currentNumber);

            if(lookUpIndex >0){
                tempFirstBlock.add(currentNumber);
                tempFirstBlock.add(input.get(lookUpIndex));
            }
        }

        List<Integer> secondBlock = cleanSecondBlock(tempFirstBlock, input);

        return secondBlock.size()==0? null: new ArrayList<List<Integer>>(Arrays.asList(tempFirstBlock, secondBlock));

    }

    private static List<Integer> cleanSecondBlock(List<Integer> firstBlock, List<Integer> input) {

      for(Integer currentNumber: firstBlock){
          input.remove(currentNumber);
      }

      return input;
    }
}
