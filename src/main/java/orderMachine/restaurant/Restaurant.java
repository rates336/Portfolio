package orderMachine.restaurant;

import orderMachine.customers.Adres;
import orderMachine.orders.Order;
import orderMachine.produtcs.Product;
import orderMachine.workers.Chef;
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
    private List<Order> listOfWaitingOrders = new ArrayList<>();
    private List<List<Order>> listOfListOrders = new ArrayList<>();
    private Order[] currentMakingOrders;
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
        currentMakingOrders = new Order[returnNumberOfTypeWorker(new Chef("xyz", 0))];
        Arrays.fill(currentMakingOrders, null);
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
        for (int i = 0; i < currentMakingOrders.length; i++) {
            if(currentMakingOrders[i] == null) {
                currentMakingOrders[i] = order;
                return;
            }
        }
        listOfWaitingOrders.add(order);
    }

    public void setTimeToCompleteMeal(Order order) {
        currentRemainingTime = order.getMakingTimeInSeconds();
    }

    public void tryCompleteOrder(String forStart) {
        //if(Pantry have Order.neededElements)
        //in future this if check does restaurant have a needed elements to cook meal
        int[] leftTimeMaking = new int[currentMakingOrders.length];
        for (int i = 0; i < leftTimeMaking.length; i++) {
            leftTimeMaking[i] = currentMakingOrders[i].getMakingTimeInSeconds();
        }
    }
    public void tryCompleteOrder() {

    }
    public int returnNumberOfTypeWorker(Worker worker) {
        int temp = 0;
        for (Worker tempWorker:
             restaurantTeam) {
            if(tempWorker.getPosition().equals(worker.getPosition()))
                temp++;
        }
        return temp;
    }
}
