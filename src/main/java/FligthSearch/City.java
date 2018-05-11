package FligthSearch;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private List<City> cities;

    public City(String name){
        this.name = name;
        cities = new ArrayList<>();
    }

    public void addFligthsToCity(City adjacentCity){
        this.cities.add(adjacentCity);
    }


    public List<City> getFlightsToCity(){
        return this.cities;
    }

    public String getName(){
        return this.name;
    }

}
