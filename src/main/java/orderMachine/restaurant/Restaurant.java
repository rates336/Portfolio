package orderMachine.restaurant;

import orderMachine.customers.Adres;
import orderMachine.orders.Order;
import orderMachine.produtcs.Product;
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
    private double timeOpenRestaurant;
    private double timeCloseRestaurant;
    private List<Worker> restaurantTeam = new LinkedList<>();
    DateFormat format = new SimpleDateFormat("hh:mm:ss");
    private List<Order> listOfTodayOrders = new ArrayList<>();
    private List<List<Order>> listOfListOrders = new ArrayList<>();
    private int currentMinutes;
    private int currentSeconds;
    private int currentRemainingTime;
    //basic info restaurant

    public Restaurant(String restaurantName, Adres restaurantAdres, Manager managerRestaurant,
                      double timeOpenRestaurant, double timeCloseRestaurant) {
        this.restaurantName = restaurantName;
        this.restaurantAdres = restaurantAdres;
        this.managerRestaurant = managerRestaurant;
        this.timeOpenRestaurant = timeOpenRestaurant;
        this.timeCloseRestaurant = timeCloseRestaurant;
        System.out.println(format.format(today));
        System.out.println("Restaurant Created Successful");
    }
    //Constructor

    public static Date getTodayDate() {
        return today;
    }//Getter

    public void start(){
        currentRemainingTime = 0;
        currentSeconds = Calendar.SECOND;
        currentMinutes = Calendar.MINUTE;
        //import starej listy listOfListOrders
        System.out.println("Restaurant started work");
    }

    public void stop(){
        //in future can be stopped working without make meal in this time
    }

    public void close() {
        try {
            listOfListOrders.add(listOfTodayOrders);
            listOfTodayOrders.clear();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Restaurant finish working");
        }
    }

    public void setTimeWhenRestaurantIsOpenAndClose(double timeOpen, double timeClose) {
        timeOpenRestaurant = timeOpen;
        timeCloseRestaurant = timeClose;
        System.out.println("Time opening and closing are changed successful");
    }//Setter

    public List<Worker> getRestaurantTeam() {
        return restaurantTeam;
    }//Getter

    public void addToTeam(Worker worker) {
        restaurantTeam.add(worker);
        System.out.println("Worker add to restaurant team successful");
    }
    //Adding new worker to team restaurant

    public void removeFromTeam(Worker worker) {
        if (restaurantTeam.contains(worker)) {
            restaurantTeam.remove(worker);
            System.out.println("Worker removed from team the restaurant successful");
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

    public double getTimeOpenRestaurant() {
        return timeOpenRestaurant;
    }

    public double getTimeCloseRestaurant() {
        return timeCloseRestaurant;
    }
    //Time getters

    private String reformatTime(double time, String toReturnTypeString) {
        int hours = (int) time;
        int minutes = (int) ((time - hours) * 100);
        if(minutes > 9)
            return ("" + hours + ":" + minutes);
        else
            return "" + hours + ":" + "0" + minutes;
    }
    private int[] reformatTime(double time, int[] toReturnTypeTabOfInts) {
        int hours = (int) time;
        int minutes = (int) ((time - hours) * 100);
        return new int[]{hours, minutes};
    }
    //Refactor double values with format HH.MM to (String) HH:MM or (int[]) {HH, MM}

    public void showTimeOpenAndCloseRestaurant() {
        System.out.println("Restaurant opening at: " + reformatTime(getTimeOpenRestaurant(), "xyz"));
        System.out.println("Restaurant closing at: " + reformatTime(getTimeCloseRestaurant(), "xyz"));
    }
    //Print time when restaurant is opened

    public List<Order> getListOfTodayOrders() {
        return listOfTodayOrders;
    }

    public List<List<Order>> getListOfListOrders() {
        return listOfListOrders;
    }
    //Getters

    public void addOrder(Order order) {
        listOfTodayOrders.add(order);
        currentRemainingTime += order.getMakingTimeInSeconds();
    }

    public void setTimeToCompleteMeal(Order order) {
        currentRemainingTime = order.getMakingTimeInSeconds();
    }

    public int whenFinished(int timeInSeconds){
        int tempSeconds = Calendar.SECOND;
        int tempMinutes = Calendar.MINUTE;
        int tempHours = Calendar.HOUR;
        if(timeInSeconds == 60) {
            if(tempMinutes == 59) {
                int tempS = tempSeconds;
                while (tempMinutes == 59 || tempS > tempSeconds) {
                    tempMinutes = Calendar.MINUTE;
                    tempSeconds = Calendar.SECOND;
                    //wait(500);
                }
            }
        } else {

        }
        //This method assumes that 60 seconds in program in real time is 60 minutes
        //and 1 hour is a maximum time which can be making meal
    }
}
