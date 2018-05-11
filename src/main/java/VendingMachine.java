public class VendingMachine {


    boolean productavailable = true;
    public static void main(String args[]){


        VendingMachine vendingMachine = new VendingMachine();

        double coin = coins.FIFTY.getValue() ;
        double price = 0.25;
        double change = vendingMachine.giveChange(coin, price);

        System.out.println(change);

    }

    public void setAvailable(boolean isAvail){
        this.productavailable = isAvail;
    }

    public double giveChange(double coin, double price){

        if(!productavailable){
            return coin;
        }

        if(price > coin ){
            throw  new IllegalArgumentException("coin should be greater than price");
        }

        return coin - price;
    }

    enum coins{
        DIME(0.05), QUARTER(0.25), FIFTY(0.50), DOLLAR(1.00);
        private double value;

        coins(double i) {
            this.value = i;
        }

        double getValue(){
            return value;
        }
    }
}
