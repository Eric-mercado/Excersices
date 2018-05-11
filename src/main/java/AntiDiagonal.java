import java.util.*;

public class AntiDiagonal {

    public static void main(String[] args){
        int[] one = new int[]{1,2,3};
        int[] two = new int[]{4,5,6};
        int[] three = new int[]{7,8,9,};

        int[][] container = new int[][]{one,two,three};
        System.out.println(solution(container));

    }

    private static int[][] solution(int[][] matrix) {
        int x = matrix[0].length;
        int y = matrix.length;

        int maxArraySize = Math.min(x,y);
        int[][] result = new int[x+y-1][];


        //convert from Array to list
        ArrayList<ArrayList<Integer>> arrayToList = new ArrayList<ArrayList<Integer>>();
        for(int i= 0; i <= matrix.length -1; i++){
            arrayToList.add(new ArrayList<>());
            for(int j = 0; j <= matrix[i].length-1; j++)
            arrayToList.get(i).add(matrix[i][j]);
        }


        //Create Arrays
        for(int i = 0; i <= result.length -1; i++){
            result[i] = new int[calculateSize(i, maxArraySize, result.length )];
        }



        //prepare for result
        int verticalCounter = 0;
        int horizontalCounter = 0;
        boolean increaseVertical = true;
        boolean increaseHorizontal = true;
        for(int i = 0; i <= result.length-1; i++){
            Iterator verticalIterator = arrayToList.iterator();

            for(int j = 0 ; j <result[i].length-1; j++){

                Iterator horizontalIterator = arrayToList.get(i).iterator();

                result[i][j] = arrayToList.get(verticalCounter).get(horizontalCounter);
                
                if(increaseHorizontal && increaseVertical){
                    verticalCounter++;
                    horizontalCounter++;
                } else if(!increaseHorizontal && !increaseVertical){
                    verticalCounter--;
                    horizontalCounter--;
                }else if(verticalIterator.hasNext()){
                    increaseVertical = false;
                } else if(horizontalIterator.hasNext()){
                    increaseHorizontal = false;
                }
            }
        }


      /* LinkedList<Integer> queue  = new LinkedList<>();
        for(int[] partialResult: result){
            int HorizontalCounter = 0;
            int verticalCounter = 0;
            for(int currentItem)
            }
        }*/

        //Fill Arrays
        for(int[] array: matrix){
            for(int i = 0; i <= array.length ; i++ ){
                int nextI = array[i];
                fillResult(i, result);
            }

        }

        return result;
    }

    private static void fillResult(int i, int[][] result) {
        boolean found = false;

        for(int[] array: result){
           int arrayLeng = array.length -1;
            if(Objects.isNull(array[arrayLeng])){
                for(int j= 0; j <= arrayLeng; j++){
                    if(Objects.isNull(array[j])){
                        array[j] = i;
                        found = true;
                        break;
                    }
                }
            }
            if(found)break;
        }
    }

    private static int calculateSize(int i, int maxArraySize, int resultLengh ) {
        int arraySize = 0;
        if(i < maxArraySize){
             arraySize = i+1;
        }else if(  i > resultLengh - maxArraySize){
            arraySize = resultLengh -i;
        }else{
            arraySize = maxArraySize;
        }

        return arraySize;
    }
}


/*
1  2   3  4  5
6  7   8  9  10
11 12  13 14 15

1 2  3
3 4  3
5 6  3
7 8  3
9 10 3

1.-[1]
2.-[2,6]
3.-[3, 7, 11]
4.-[4,8,12]
5.-[5,9,13]
6.-[10,14]
7.-[15]

 */