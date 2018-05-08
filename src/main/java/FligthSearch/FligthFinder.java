package FligthSearch;

import java.util.ArrayList;
import java.util.List;

public class FligthFinder {


    private static  List<String> ItineraryBuilder;
    private boolean found = false;

    public FligthFinder(){
        this.ItineraryBuilder = new ArrayList<>();
    }

    public void findDestination(City origin, City destination){

       ItineraryBuilder.add(origin.getName());

        for(City city : origin.getFlightsToCity()){

            if(city.getName() == destination.getName()){
                ItineraryBuilder.add(destination.getName());
                this.found = true;
            }
        }

        try{
        if(found){
            printItinerary();
        } else {
            this.findDestination(origin.getFlightsToCity().get(1), destination);
        }
        }catch(IndexOutOfBoundsException iobe){
            System.out.println("Not Fligths found");
        }
    }

    public void printItinerary(){


        System.out.print(this.ItineraryBuilder.get(0));
        for(int i = 1; i <= ItineraryBuilder.size()-1; i++){
            System.out.print(" -> ");
            System.out.print(this.ItineraryBuilder.get(i));
        }
    }
}
