package FligthSearch;

public class MainClass {

    public static void main(String args[]){
        City NY =new City("NY");
        City Seatle =new City("Seatle");
        City gdl = new City("GDL");
        City MTY =new City("MTY");
        City Washington =new City("Washington");
        City Coahuila = new City("Coahuila");
        City Camboya = new City("Camboya");


        NY.addFligthsToCity(Seatle);
        NY.addFligthsToCity(Washington);

        gdl.addFligthsToCity(MTY);
        gdl.addFligthsToCity(Coahuila);

        Washington.addFligthsToCity(gdl);


        FligthFinder fligthFinder = new FligthFinder();

        fligthFinder.findDestination(NY, gdl);
    }
}
