import java.util.*;
public class AverageFinder {

   public static void main(String[] args){

      ArrayList<Integer> mySetNumber = new ArrayList<>(Arrays.asList(1,7,9,11,15,29));
       ArrayList<Integer> mySecondSetNumber = new ArrayList<>(Arrays.asList(47, 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24));

     //  System.out.println(findAverage(mySetNumber));
       System.out.println(findAverage(mySecondSetNumber));
   }

    private static ArrayList<ArrayList<Integer>> findAverage(ArrayList<Integer> mySetNumber) {

       Collections.sort(mySetNumber);

       int half = mySetNumber.size()/2;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

       for(int i = 2 ; i <= half; i++){
           boolean found = false;
           if(i <= 2 ) {
               result = fillArrays(i, mySetNumber, new ArrayList<>());

               if (!result.isEmpty()) {
                   break;
               }
           } else{
               Iterator<Integer> mySetIterator = mySetNumber.iterator();

               while(mySetIterator.hasNext()){

                   ArrayList increasingNumbers = new ArrayList();
                   while(increasingNumbers.size() <= i-3){
                       increasingNumbers.add(mySetIterator.next());
                   }
                   result = fillArrays(i, mySetNumber, increasingNumbers);
                   if (!result.isEmpty()) {
                       found = true;
                       break;
                   }
               }
               if(found) break;
           }
       }
       return result;
   }


    private static double getAverage(ArrayList<Integer> mySetNumber) {
       double counter = 0;
       for(Integer thisInt: mySetNumber){
           counter += thisInt;
       }

       if((counter / mySetNumber.size()) % 1 ==0){
           return (int) counter / mySetNumber.size();
       } else{
           return 0;
       }
    }

    static ArrayList<ArrayList<Integer>> fillArrays(int firstBlockSize, ArrayList<Integer> input, List<Integer>inputIndex){

        double inputAverage =  getAverage(input);

        ArrayList<Integer> tempFirstBlock = new ArrayList<>();

        Iterator<Integer> inputIterator = input.iterator();



        //dump  posible numbers charged by the for loop calling this method
        if(inputIndex != null){
           for(int i: inputIndex){
               tempFirstBlock.add(i);
           }
        }

        while(inputIterator.hasNext() &&  tempFirstBlock.size() <= firstBlockSize - 1){

            int currentNumber = inputIterator.next();
            int currentsSum = tempFirstBlock.stream().mapToInt(Integer::intValue).sum();
            int lookUpValue = (int)inputAverage * firstBlockSize;
            int lookUpIndex = Collections.binarySearch(input, lookUpValue - currentsSum -currentNumber);

            if(lookUpIndex >0){
                tempFirstBlock.add(currentNumber);
                tempFirstBlock.add(input.get(lookUpIndex));
            }
        }

        ArrayList<Integer> secondBlock = new ArrayList<>();

        if(tempFirstBlock.size() > inputIndex.size()){
            secondBlock = cleanSecondBlock(tempFirstBlock, input);
        }


        return secondBlock.isEmpty()?
                new ArrayList<>():
                new ArrayList<ArrayList<Integer>>(Arrays.asList(tempFirstBlock, secondBlock));

    }

    private static ArrayList<Integer> cleanSecondBlock(ArrayList<Integer> firstBlock, ArrayList<Integer> input) {

       ArrayList<Integer> inputCopy = new ArrayList<>(input);

      for(Integer currentNumber: firstBlock){
          inputCopy.remove(currentNumber);
      }

      return inputCopy;
    }
}
