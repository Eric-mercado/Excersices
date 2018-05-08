package FligthSearch;
/*
Input:
[1 7 15 29 11 9]
--------------------------

[1, 4, 7, 13, 15, 17, 19 22 }

Output:
[9 15] [1 7 11 29]

The average of part is (15+9)/2 = 12,
average of second part elements is (1 + 7 + 11 + 29) / 4 = 12


1.- have a sorted Array
2.-  find the central value
3.- make 2 arrays  that could change on size
4.- fill  those Arrays
5.- compare abolute values from each Array
6.- done return the Array.
 */

import java.util.*;

public class AverageFinder {


    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 7, 15, 29, 11, 9));

        //  System.out.println( findAverage(input));
        System.out.println(7 / 2);
    }

    private static List<List<Integer>> findAverage(List<Integer> input) {

        Collections.sort(input);
        int centralPosition = input.size() / 2;

        for (int i = 1; i <= centralPosition; i++) {

            if(fillArrays(i, input).isEmpty());

        }

        return null;
    }

    //[1 7  9 11 15 29]
    /*
        [1 7  9 11 15 29]
        [9  + 15   = 24 ] [9 11 15 29]

     */

    private static List<List<Integer>> fillArrays(int firsSize, List<Integer> input) {

       int generalAverage = average(input);
       List<Integer> tempInput =  new ArrayList<>();
       Iterator<Integer> inputIterator = input.iterator();

       while(tempInput.size()<= firsSize){

           int baseCheck = inputIterator.next();


           Integer lookUpvalue = (generalAverage * firsSize);
           int indexValue = Collections.binarySearch(input, baseCheck - lookUpvalue);

           if(indexValue > 0){

               tempInput.add(baseCheck);
               tempInput.add(input.get(indexValue));

           } else{

               break;

           }
       }

       List<Integer> secondHalve = removeDuplicates(tempInput, new ArrayList<Integer>(input));

        if(tempInput == secondHalve){
            return new ArrayList<>(Arrays.asList(tempInput,tempInput));
        } else {
            return null;
        }
    }

    private static List<Integer> removeDuplicates(List<Integer> tempInput, ArrayList<Integer> integers) {

        for(Integer iteration: tempInput){
            integers.remove(iteration);
        }

        return integers;

    }

    private static int average(List<Integer> numbers) {
        int counter = 0;
        for(Integer number: numbers){
            counter += number;
        }

        return counter/numbers.size();
    }
}
