package orderMachine.workers;

import orderMachine.orders.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DeliveryMan implements Worker {
    private final String name;
    private final int birthYear;
    private final String position;
    //basic info
    private List<Order> historyOfActualOrdersCompleted = new LinkedList<>();
    private List<Order> historyOfActualOrdersNotCompleted = new LinkedList<>();
    private List<Order> historyOfAllOrdersCompleted = new ArrayList<>();
    private List<Order> historyOfAllOrdersNotCompleted = new ArrayList<>();
    private List<Order> queueOfActualOrders = new LinkedList<>();
    //List orders to the delivered
    public DeliveryMan(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        position = "DeliveryMan";
    }

    public String getName() {
        return name;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public List<Order> getHistoryOfActualOrdersCompleted() {
        return historyOfActualOrdersCompleted;
    }
    public List<Order> getHistoryOfActualOrdersNotCompleted() {
        return historyOfActualOrdersNotCompleted;
    }
    public List<Order> getHistoryOfAllOrdersCompleted() {
        return historyOfAllOrdersCompleted;
    }
    public List<Order> getHistoryOfAllOrdersNotCompleted() {
        return historyOfAllOrdersNotCompleted;
    }
    public List<Order> getQueueOfActualOrders() {
        return queueOfActualOrders;
    }
    //Getters
    public void setHistoryOfActualOrdersCompleted(List<Order> historyOfActualOrdersCompleted) {
        this.historyOfActualOrdersCompleted = historyOfActualOrdersCompleted;
    }
    public void setHistoryOfActualOrdersNotCompleted(List<Order> historyOfActualOrdersNotCompleted) {
        this.historyOfActualOrdersNotCompleted = historyOfActualOrdersNotCompleted;
    }
    public void setHistoryOfAllOrdersCompleted(List<Order> historyOfAllOrdersCompleted) {
        this.historyOfAllOrdersCompleted = historyOfAllOrdersCompleted;
    }
    public void setHistoryOfAllOrdersNotCompleted(List<Order> historyOfAllOrdersNotCompleted) {
        this.historyOfAllOrdersNotCompleted = historyOfAllOrdersNotCompleted;
    }
    public void setQueueOfActualOrders(List<Order> queueOfActualOrders) {
        this.queueOfActualOrders = queueOfActualOrders;
    }

    @Override
    public String getPosition() {
        return position;
    }

    //Setters
    public void addOrderToQueue(Order order) {
        queueOfActualOrders.add(order);
    }
}
