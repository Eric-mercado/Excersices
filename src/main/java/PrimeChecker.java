public class PrimeChecker {
    private static int upTo = 100;
    static boolean isPrime = false;

    public static void main(String args[]){

        PrimeChecker primeChecker = new PrimeChecker();


        primeChecker.findPrimes(upTo);
    }

     void findPrimes(int upTo){
        int i = 0;

        while(i < upTo){

            isPrime = isPrime(i);

            if(isPrime){
                System.out.println(i + " is prime ");

            }
            i++;
        }

    }

     boolean isPrime(int number){

        for(int i = 2 ; i < number; i++ ){
            if(number % i ==0 ){
                return false;
            }
        }
        return true;
    }
}
