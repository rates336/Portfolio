package orderMachine.orders;

import orderMachine.customers.Customer;
import orderMachine.produtcs.Product;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Order {
    private List<Product> listOfProductsOder = new ArrayList<>();
    private boolean deliveryOrNot;
    private double totalPrice = 0;
    private double deliveryCost;
    private double distance;
    private double amountWhenDeliveryIsFree;
    static Map<Integer, Integer> costForDeliveryDistance = new HashMap<>();
    private boolean isCompleted;
    private int totalTimeMakingOrder = 0;
    private Customer customer;
    //basic information


    public Order(List<Product> listOfProductsOder, boolean deliveryOrNot, double distance, Customer customer) {
        this.listOfProductsOder = listOfProductsOder;
        this.deliveryOrNot = deliveryOrNot;
        this.distance = distance;
        this.customer = customer;
        for (int i = 0; i < listOfProductsOder.size(); i++) {
            totalTimeMakingOrder += listOfProductsOder.get(i).getNeededTimeToMakeInSeconds();
            if(listOfProductsOder.get(i).isOneSizeProduct())
                totalPrice += listOfProductsOder.get(i).getPrice();
            else
                totalPrice += listOfProductsOder.get(i).getPriceForTheSize(
                        listOfProductsOder.get(i).getSize());
        }
    }
    public Order(Product product, boolean deliveryOrNot, double distance, Customer customer) {
        listOfProductsOder.add(product);
        if(product.isOneSizeProduct())
            totalPrice = product.getPrice();
        else
            totalPrice = product.getPriceForTheSize(product.getSize());
        this.deliveryOrNot = deliveryOrNot;
        this.distance = distance;
        this.customer = customer;
        totalTimeMakingOrder += product.getNeededTimeToMakeInSeconds();
    }

    public static void setCostForDeliveryDistance() {
        Order.costForDeliveryDistance.put(1, 5);
        Order.costForDeliveryDistance.put(2, 7);
        Order.costForDeliveryDistance.put(3, 8);
        Order.costForDeliveryDistance.put(5, 10);
        Order.costForDeliveryDistance.put(7, 12);
        Order.costForDeliveryDistance.put(10, 15);
    }
    //Default price for delivery for concrete distance,
    //firsts are distance, seconds are fee

    /*public double deliveryCostCalculate() {
        Random random = new Random();
        double someRandomValue = random.nextDouble() + random.nextInt(9);
        System.out.println(someRandomValue);
        int min = Collections.min(costForDeliveryDistance.values());
        int max = Collections.max(costForDeliveryDistance.values());
        return IntStream.rangeClosed(min, max)
                .filter(e -> e >= someRandomValue)
                .min();
    }*/
    //Docelowo mia?? by?? DoubleStream ale mi nie dzia??a??
    /*public double deliveryCostCalculate(double distance) {
        int min = Collections.min(costForDeliveryDistance.values());
        int max = Collections.max(costForDeliveryDistance.values());
        if(distance <= max) {
            return IntStream.rangeClosed(min, max)
                    .filter(e -> e >= distance)
                    .min();
        } else {
            System.out.println("Restaurant not delivered here, " +
                    "radius from local is bigger than 10 km");
            return -1;
        }
    }*/
    public double tempSolutionDeliveryCostCalculate() {
        return 7.5;
    }//now my solution upper is not working so it's temp implementation
    public void addProductToOrder(Product product) {
        listOfProductsOder.add(product);
        if (product.isOneSizeProduct())
            totalPrice += product.getPrice();
        else
            totalPrice += product.getPriceForTheSize(product.getSize());
        totalTimeMakingOrder += product.getNeededTimeToMakeInSeconds();
    }
    //add new product to order
    public void removeProductToOrder(Product product) {
        for (int i = 0; i < listOfProductsOder.size(); i++) {
            if(product.equals(listOfProductsOder.get(i))) {
                listOfProductsOder.remove(i);
                return;
            }
        }
    }
    //remove product from order
    public void showTotalPrice() {
        totalPrice = 0;
        for (Product tempProduct:
             listOfProductsOder) {
            if(tempProduct.isOneSizeProduct())
                totalPrice += tempProduct.getPrice();
            else
                totalPrice += tempProduct.getPriceForTheSize(tempProduct.getSize());
        }
        if(amountWhenDeliveryIsFree <= totalPrice)
            totalPrice = totalPrice;
        else
            totalPrice += tempSolutionDeliveryCostCalculate();
        System.out.println(totalPrice);

    }
    //Total price for all products from order

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int getMakingTimeInSeconds() {
        return totalTimeMakingOrder;
    }

    public List<Product> getListOfProductsOder() {
        return listOfProductsOder;
    }

    public boolean isDeliveryOrNot() {
        return deliveryOrNot;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public double getDistance() {
        return distance;
    }

    public double getAmountWhenDeliveryIsFree() {
        return amountWhenDeliveryIsFree;
    }

    public static Map<Integer, Integer> getCostForDeliveryDistance() {
        return costForDeliveryDistance;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Customer getCustomer() {
        return customer;
    }
    //Getter and Setter Do order are completed
}
