package orderMachine.workers;

import orderMachine.orders.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Manager implements Worker {
    String name;
    int birthYear;
    //basic info
    private List<Order> historyOfActualOrdersCompletedInRestaurant = new LinkedList<>();
    private List<Order> historyOfActualOrdersNotCompletedInRestaurant = new LinkedList<>();
    private List<Order> historyOfAllOrdersCompletedInRestaurant = new ArrayList<>();
    private List<Order> historyOfAllOrdersNotCompletedInRestaurant = new ArrayList<>();
    private List<Order> queueOfActualOrdersInRestaurant = new LinkedList<>();
    //List orders to the manage
    public Manager(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public List<Order> getHistoryOfActualOrdersCompletedInRestaurant() {
        return historyOfActualOrdersCompletedInRestaurant;
    }

    public List<Order> getHistoryOfActualOrdersNotCompletedInRestaurant() {
        return historyOfActualOrdersNotCompletedInRestaurant;
    }

    public List<Order> getHistoryOfAllOrdersCompletedInRestaurant() {
        return historyOfAllOrdersCompletedInRestaurant;
    }

    public List<Order> getHistoryOfAllOrdersNotCompletedInRestaurant() {
        return historyOfAllOrdersNotCompletedInRestaurant;
    }

    public List<Order> getQueueOfActualOrdersInRestaurant() {
        return queueOfActualOrdersInRestaurant;
    }
    //Getters
    public void setHistoryOfActualOrdersCompletedInRestaurant(List<Order> historyOfActualOrdersCompletedInRestaurant) {
        this.historyOfActualOrdersCompletedInRestaurant = historyOfActualOrdersCompletedInRestaurant;
    }

    public void setHistoryOfActualOrdersNotCompletedInRestaurant(List<Order> historyOfActualOrdersNotCompletedInRestaurant) {
        this.historyOfActualOrdersNotCompletedInRestaurant = historyOfActualOrdersNotCompletedInRestaurant;
    }

    public void setHistoryOfAllOrdersCompletedInRestaurant(List<Order> historyOfAllOrdersCompletedInRestaurant) {
        this.historyOfAllOrdersCompletedInRestaurant = historyOfAllOrdersCompletedInRestaurant;
    }

    public void setHistoryOfAllOrdersNotCompletedInRestaurant(List<Order> historyOfAllOrdersNotCompletedInRestaurant) {
        this.historyOfAllOrdersNotCompletedInRestaurant = historyOfAllOrdersNotCompletedInRestaurant;
    }

    public void setQueueOfActualOrdersInRestaurant(List<Order> queueOfActualOrdersInRestaurant) {
        this.queueOfActualOrdersInRestaurant = queueOfActualOrdersInRestaurant;
    }
    //Setters
}
