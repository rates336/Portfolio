package orderMachine.restaurant;

import orderMachine.customers.Adres;
import orderMachine.workers.Manager;
import orderMachine.workers.Waiter;
import orderMachine.workers.Worker;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Restaurant {
    static Date today = new Date();
    private String restaurantName;
    private Adres restaurantAdres;
    private Manager managerRestaurant;
    private int timeOpenRestaurant;
    private int timeCloseRestaurant;
    private List<Worker> restaurantTeam = new LinkedList<>();
    DateFormat format = new SimpleDateFormat("hh:mm:ss");
    //basic info restaurant
    public Restaurant(String restaurantName, Adres restaurantAdres,Manager managerRestaurant,
                      int timeOpenRestaurant, int timeCloseRestaurant) {
        this.restaurantName = restaurantName;
        this.restaurantAdres = restaurantAdres;
        this.managerRestaurant = managerRestaurant;
        this.timeOpenRestaurant = timeOpenRestaurant;
        this.timeCloseRestaurant = timeCloseRestaurant;
        System.out.println(format.format(today));
    }
    //Constructor

    public static Date getTodayDate() {
        return today;
    }//Getter
    public void setTimeWhenRestaurantIsOpenAndClose(int timeOpen, int timeClose) {
        timeOpenRestaurant = timeOpen;
        timeCloseRestaurant = timeClose;
    }//Setter

    public List<Worker> getRestaurantTeam() {
        return restaurantTeam;
    }//Getter
    public void addToTeam(Worker worker) {
        restaurantTeam.add(worker);
    }
    //Adding new worker to team restaurant
    public void removeFromTeam(Worker worker) {
            if(restaurantTeam.contains(worker)) {
                restaurantTeam.remove(worker);
                return;
            }
    }
    //Removing worker from team restaurant
    public void showActualRestaurantTeam() {
        for (int i = 0; i < restaurantTeam.size(); i++) {
            System.out.println(restaurantTeam.get(i));

        }
    }
    //Print all worker which are work in restaurant team
}
