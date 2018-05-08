import java.util.ArrayDeque;
import java.util.Queue;

import static com.sun.tools.doclint.Entity.ne;
import static com.sun.tools.doclint.Entity.sum;

public class Fibonacci {
    private static final int upTo = 100;

    public static void main(String args []){

        Fibonacci fibonacci = new Fibonacci();

        fibonacci.makeFibonacci(upTo);
    }


    public void makeFibonacci(int upto){


      int[] myArrayay  = new int[]{0,1};
        int newValue = 0;

        System.out.println("printing values equal or less than " +  upTo);

        while (myArrayay[0] + myArrayay[1] < upto){

            newValue = myArrayay[0] + myArrayay[1];
            System.out.print(newValue + " ");

            myArrayay[0] =  myArrayay[1] ;
            myArrayay[1] = newValue;
        }
    }
}
