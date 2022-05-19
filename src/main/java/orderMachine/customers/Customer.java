package orderMachine.customers;

import orderMachine.orders.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Customer implements ICustomer {
    private final String name = null;
    private final int birthYear = 0;
    private List<IAdres> customerAdresList = new LinkedList<>();
    private List<Order> customerOrderHistory = new ArrayList<>();
    //basic data about Customer
    public void addAdres(Adres adres) {
        customerAdresList.add(adres);
    }
    //Adding new adres
    public void removeAdres(Adres adres) {
        customerAdresList.remove(adres);
    }
    //Removing adres
    public void removeAdres(String adresName) {
        for (int i = 0; i < customerAdresList.size(); i++) {
            if(customerAdresList.get(i).getNameAdres().equals(adresName)) {
                customerAdresList.remove(i);
                return;
            }


        }
    }
    public void createNewOrder(Order order) {

    }
    //Removing adres have only adresName
    public List<IAdres> getCustomerAdresList() {
        return customerAdresList;
    }

    public List<Order> getCustomerOrderHistory() {
        return customerOrderHistory;
    }
    //Getters
}
