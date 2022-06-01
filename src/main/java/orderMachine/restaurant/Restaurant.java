package orderMachine.restaurant;

import orderMachine.adres.Adres;
import orderMachine.orders.Order;
import orderMachine.workers.Manager;
import orderMachine.workers.Worker;
import org.w3c.dom.ls.LSOutput;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

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
    //private int currentRemainingTime;
    private int currentTimeSec;
    private int currentTimeMin;
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
        currentMakingOrders = new Order[4];
        //returnNumberOfTypeWorker(new Chef("xyz", 0)) this code not working, returning 0 probably
        Arrays.fill(currentMakingOrders, null);
    }
    //Constructor

    public Date getTodayDate() {
        return new Date();
    }//Getter

    public void start(){
        //currentRemainingTime = 0;
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
        listOfWaitingOrders.add(order);
        //currentRemainingTime += order.getMakingTimeInSeconds();
        /*for (int i = 0; i < currentMakingOrders.length; i++) {
            if(currentMakingOrders[i] == null) {
                currentMakingOrders[i] = order;
                tryCompleteOrder(i);
                break;
            }
        }*/
        System.out.println("Order added successful");
    }

    /*public void setTimeToCompleteOrder(Order order) {
        currentRemainingTime = order.getMakingTimeInSeconds();
    }*/

    public void startCompleteOrder() {
        /*int[] leftTimeMaking = new int[currentMakingOrders.length];
        for (int i = 0; i < leftTimeMaking.length; i++) {
            leftTimeMaking[i] = currentMakingOrders[i].getMakingTimeInSeconds();
        }*/

        if(!listOfWaitingOrders.isEmpty()) {
            for (int i = 0; i < currentMakingOrders.length; i++) {
                if (currentMakingOrders[i] == null) {
                    currentMakingOrders[i] = listOfWaitingOrders.get(0);
                    listOfWaitingOrders.remove(0);
                    //replace nulls orders with list of waiting orders
                    if(listOfWaitingOrders.isEmpty()) {
                        break;
                        //check does loop must be working
                    }
                } else {
                    if(currentMakingOrders.length - 1 == i)
                        System.out.println("All Chefs working now");
                }
            }
        } else {
            System.out.println("List of waiting orders is empty.");
        }
        tryCompleteOrder(); //open a method which try made orders
    }
    public boolean wait(int seconds) {
        Calendar cal = new GregorianCalendar();
        int startSec = cal.get(Calendar.SECOND);
        int startMin = cal.get(Calendar.MINUTE);
        int minutes = (Calendar.SECOND + seconds) / 60;
        if(Calendar.SECOND + seconds >= 60) {
            seconds = (Calendar.SECOND + seconds) % 60;
            while(cal.get(Calendar.MINUTE) < startMin + minutes){
                cal.setTime(new Date());
            }
            //loop when minutes are analyzing
        }
        while (cal.get(Calendar.SECOND) + (60 * minutes) < startSec + seconds) {
            cal.setTime(new Date());
        }
        //loop when seconds are analyzing
        return true;
    }
    public void tryCompleteOrder() {
        //if(Pantry have Order.neededElements)
        //in future this if check does restaurant have a needed elements to cook meal
        //in future here is
        //verification does is not, a doubled the order
        /*Order tempOrder = currentMakingOrders[numberOfPlace];
        for (int i = numberOfPlace; i < currentMakingOrders.length - 1; i++) {
            currentMakingOrders[i] = currentMakingOrders[i + 1];
        }
        currentMakingOrders[currentMakingOrders.length - 1] = listOfWaitingOrders.get(0);
        listOfWaitingOrders.remove(currentMakingOrders[currentMakingOrders.length - 1]);*/
        LinkedList<Integer> timeToMakeOrder = new LinkedList<>();
        int min = 0;
        while (Arrays.stream(currentMakingOrders).anyMatch(Objects::nonNull)) {
            //Creating loop which working to time making all orders
            //timeToMakeOrder.addAll()
            Arrays.stream(currentMakingOrders)
                    .filter(e -> e != null).mapToInt(Order::getMakingTimeInSeconds).forEach(timeToMakeOrder::add);
            //Fill list a time orders making
            if (timeToMakeOrder.stream().anyMatch(e -> e > 0)) {
                //Check Does some order has not completed
                //min = Arrays.stream(currentMakingOrders).
                min = timeToMakeOrder.stream().mapToInt(e -> e).min().orElse(0);
                //Find a minimal time to finish order
                if (wait(min)) {
                    //wait for to create an order
                    for (int i = 0; i < timeToMakeOrder.size(); i++) {
                        timeToMakeOrder.set(i, (timeToMakeOrder.get(0) - min));
                        //minus minimal time from all orders
                        if (timeToMakeOrder.get(i) <= 0) {
                            if (timeToMakeOrder.get(i) == 0) {
                                System.out.println("Order for " + currentMakingOrders[i].getCustomer() + " has been finished.");
                                //check does some order has been completed
                                //dodaj do utargu
                                currentMakingOrders[i] = null;
                            }
                            if (!listOfWaitingOrders.isEmpty()) {
                                currentMakingOrders[i] = listOfWaitingOrders.get(0);
                                listOfWaitingOrders.remove(0);
                                //check does some order waiting to create
                            }
                        }
                    }
                }
            }
        }
        /*wait(tempOrder.getMakingTimeInSeconds());
        {
            //if dostawa
            //wait 2 min + czas dostawy
            //else 2 min
            tempOrder.setIsCompleted(true);
        }
        System.out.print("Order: " + tempOrder + " for " + tempOrder.getCustomer());
        if(tempOrder.isDeliveryOrNot())
            System.out.println(" and delivered to adres: " + tempOrder.getCustomer().getCustomerAdresList());
        //In future is not, a list, and it is the delivery adres
        else
            System.out.println(" and picked to table: " + tempOrder);
        //in future this is a number of table
        listOfTodayOrders.add(tempOrder);
        tryCompleteOrder(currentMakingOrders.length - 1);*/
    }
    public int returnNumberOfTypeWorker(Worker worker) {
        int temp = 0;
        for (Worker tempWorker:
             restaurantTeam) {
            if(tempWorker.getPosition().equals(worker.getPosition()))
                temp++;
        }
        return temp;
    } //methods which check how many workers some type working in this restaurant
}
