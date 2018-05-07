package stepsExc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StepsCounter {


    public static void main(String[] args) {

        Coordenates first = new Coordenates(1, 1);
        Coordenates second = new Coordenates(3, 3);
        Coordenates third = new Coordenates(6, 8);
        Coordenates forth = new Coordenates(10, 10);
        Coordenates fifth = new Coordenates(10, 1);

        List<Coordenates> myCords = Arrays.asList(first, second, third, forth, fifth);//Arrays.asList(first,second,third);

        System.out.println(countSteps(myCords));

        List<Integer> myList = Arrays.asList(15,6,7,8,65) ;


    }

    static int countSteps(List<Coordenates> myCords) {
        int conter = 0;

        for (int i = 0; i <= myCords.size() - 2; i++) {
            int currentX = myCords.get(i).x;
            int currentY = myCords.get(i).y;

            int nextX = myCords.get(i + 1).x;
            int nextY = myCords.get(i + 1).y;

            int xDifference = Math.abs(currentX - nextX);
            int yDiffernce = Math.abs(currentY - nextY);

            if (xDifference < yDiffernce) {
                conter += xDifference;
                conter += yDiffernce - xDifference;
            } else {

                conter += yDiffernce;
                conter += xDifference - yDiffernce;
            }
        }

        return conter;
    }
}
