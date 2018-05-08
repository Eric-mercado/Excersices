import java.util.LinkedList;
import java.util.List;

public class ArmStrong {

    private static final Integer upTo= 1000;
    private static final Integer test = 999;

    public static void main(String args[]) {

        ArmStrong armStrong = new ArmStrong();

        armStrong.doArmstrong(upTo);

    }

    public void doArmstrong(Integer upTo){

        List<Integer> list = new LinkedList<Integer>();
        int Acuumulator  = 0;

        for(Integer i=0 ; i< upTo ; i++){
            int ii = i.intValue() ;
            // make i to Array
            while ( ii > 0) {
               double tempInt  = ( ii % 10);
               tempInt = Math.pow(tempInt, 3);
               ii /= 10;
               Acuumulator += tempInt;
            }

            if(Acuumulator == i ){
                System.out.println( "Armstrong found on :" +   "[ " + i + " ]");
            } else {
                System.out.println(i);
            }

            list.clear();
            Acuumulator = 0;
        }

    }
}
