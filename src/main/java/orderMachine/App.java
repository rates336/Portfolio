package orderMachine;

import orderMachine.customers.Adres;
import orderMachine.orders.Order;
import orderMachine.produtcs.Product;
import orderMachine.produtcs.ProductsCollections;
import orderMachine.restaurant.Restaurant;
import orderMachine.workers.Chef;
import orderMachine.workers.Manager;
import orderMachine.workers.Waiter;

public class App {
    public static void main(String[] args) {
        Product product = new Product("burger", "rarar", "rararara",
                new double[]{0,1,2,3,4,5,6,7,8});
        //ProductsCollections collections = new ProductsCollections();
        //collections.addProduct(product);
        //System.out.println(product.getName());
        /*System.out.println(ProductsCollections.getMapOfProductsNames().get(product.getName()).getPriceForTheSize("L"));
        System.out.println(ProductsCollections.getMapOfProductsNoOneSize().get(product.getName() + " Size: M"));
        System.out.println(ProductsCollections.getMapOfProductsNoOneSize().get(product.getName() +
                " Size: " + product.getSize(1)));*/
        //collections.removeProduct(product.getName());
        //collections.removeProductSize(product.getName(), "size6");

        Order order = new Order();
        Order.setCostForDeliveryDistance();
        System.out.println(order.tempSolutionDeliveryCostCalculate());
        order.addProductToOrder(product);
        order.showTotalPrice();
        order.removeProductToOrder(product);
        System.out.println(Restaurant.getTodayDate());
        /*Restaurant restaurant = new Restaurant("Alibaba",
                new Adres("Poland", "Warsaw", "Koszykowa", 10),
                new Manager("Adrian", 2000),1130,*/0200);
        restaurant.setTimeWhenRestaurantIsOpenAndClose(1200, 2230);
        restaurant.addToTeam(new Manager("Adek", 2000));
        restaurant.addToTeam(new Waiter("Tomek", 2002));
        restaurant.addToTeam(new Waiter("Ula", 2001));
        restaurant.removeFromTeam(new Waiter("Ula", 2001));
        restaurant.showActualRestaurantTeam();



    }
}
