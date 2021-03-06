package orderMachine;

import orderMachine.orders.Order;
import orderMachine.produtcs.Product;
import orderMachine.restaurant.Restaurant;
import orderMachine.settings.DefaultAndRandomsValues;
import orderMachine.workers.Worker;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
/*        Product product = new Product("burger", "rarar", "rararara",
                new double[]{0,1,2,3,4,5,6,7,8});
        //ProductsCollections collections = new ProductsCollections();
        //collections.addProduct(product);
        //System.out.println(product.getName());
        System.out.println(ProductsCollections.getMapOfProductsNames().get(product.getName()).getPriceForTheSize("L"));
        System.out.println(ProductsCollections.getMapOfProductsNoOneSize().get(product.getName() + " Size: M"));
        System.out.println(ProductsCollections.getMapOfProductsNoOneSize().get(product.getName() +
                " Size: " + product.getSize(1)));
        //collections.removeProduct(product.getName());
        //collections.removeProductSize(product.getName(), "size6");

        Order order = new Order();
        Order.setCostForDeliveryDistance();
        System.out.println(order.tempSolutionDeliveryCostCalculate());
        order.addProductToOrder(product);
        order.showTotalPrice();
        order.removeProductToOrder(product);
        System.out.println(Restaurant.getTodayDate());
        Restaurant restaurant = new Restaurant("Alibaba",
                new Adres("Main Test","Poland", "Warsaw", "Koszykowa", 10),
                new Manager("Adrian", 2000),1130,0200);
        restaurant.setTimeWhenRestaurantIsOpenAndClose(1200, 2230);
        restaurant.addToTeam(new Manager("Adek", 2000));
        restaurant.addToTeam(new Waiter("Tomek", 2002));
        restaurant.addToTeam(new Waiter("Ula", 2001));
        restaurant.removeFromTeam(new Waiter("Ula", 2001));
        restaurant.showActualRestaurantTeam();*/
        Restaurant restaurant = DefaultAndRandomsValues.createDefault1Restaurant()[0];
        Worker[] tabOfDefaultWorkers = DefaultAndRandomsValues.createDefaultUltimateTeam();
        for (int i = 0; i < tabOfDefaultWorkers.length; i++) {
            restaurant.addToTeam(tabOfDefaultWorkers[i]);
        }
        //restaurant.showActualRestaurantTeam();
        restaurant.showTimeOpenAndCloseRestaurant();
        restaurant.setTimeWhenRestaurantIsOpenAndClose(9.30, 23.30);
        restaurant.showTimeOpenAndCloseRestaurant();
        restaurant.removeFromTeam(restaurant.getRestaurantTeam().get(7));
        List<Product> theList = new LinkedList<>();
        theList.add(DefaultAndRandomsValues.create10DefaultProducts()[1]);

        restaurant.start();
        //restaurant.addOrder(new Order(theList, false, 3.45,
        //        DefaultValues.createDefault3Customers()[1]));

        restaurant.addOrder((new Order(DefaultAndRandomsValues.create10DefaultProducts()[5],
                false, 1, DefaultAndRandomsValues.createDefault3Customers()[0])));
        restaurant.addOrder((new Order(DefaultAndRandomsValues.create10DefaultProducts()[8],
                false, 1, DefaultAndRandomsValues.createDefault3Customers()[0])));
        restaurant.addOrder((new Order(DefaultAndRandomsValues.create10DefaultProducts()[6],
                false, 1, DefaultAndRandomsValues.createDefault3Customers()[0])));
        restaurant.addOrder((new Order(DefaultAndRandomsValues.create10DefaultProducts()[9],
                false, 1, DefaultAndRandomsValues.createDefault3Customers()[0])));
/*        restaurant.addOrder((new Order(DefaultValues.create10DefaultProducts()[1],false, 1,
                DefaultValues.createDefault3Customers()[1])));
        restaurant.addOrder((new Order(DefaultValues.create10DefaultProducts()[1],false, 1,
                DefaultValues.createDefault3Customers()[2])));*/
        restaurant.startCompleteOrder();
        System.out.println(theList.get(0));
        restaurant.addOrder(DefaultAndRandomsValues.createRandomOrder());
        /*
        Order[] testTab = new Order[5];
        for (int i = 0; i < testTab.length; i++) {
            testTab[i] = null;
        }
        Arrays.stream(testTab).forEach(System.out::println);
        System.out.println(Arrays.stream(testTab).filter(e -> e != null).count());
        System.out.println(restaurant);
*/




    }
}
