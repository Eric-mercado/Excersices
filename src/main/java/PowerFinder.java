public class PowerFinder {

    public static void main(String[] args){

        final int highMultiple = 2197;
        final int maxInteger = 2147483647;

        System.out.println( highMultiple + " is a power ? " + isPower(highMultiple));


        System.out.println( Math.cbrt(maxInteger));
    }

    private static boolean isPower(double number) {

        boolean hasRoot = false;

        double myCubicunber = Math.sqrt(number) ;

        if(Math.sqrt(number)%1 == 0 || myCubicunber%1 ==0 ){
            hasRoot =  true;
            return hasRoot;
        }

        hasRoot = findRoot(number, myCubicunber);

    return hasRoot;
    }

    static boolean findRoot(double number, double myCubicunber){

        boolean hasRoot = false ;
        for(int power  =  4; power <=32 ; power++){
            for (int base = 2; base <= (int)myCubicunber; base++){

                int currentCounter = (int) Math.pow(base,power);

                if(currentCounter == (int)number){
                    hasRoot = true;
                    power = 32;
                    break;
                } else if(currentCounter > number){
                    break;
                }
                if(hasRoot){break;}
            }
        }

        return hasRoot;
    }
}
