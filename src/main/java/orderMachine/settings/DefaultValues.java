package orderMachine.settings;

import orderMachine.adres.Adres;
import orderMachine.customers.Customer;
import orderMachine.produtcs.Product;
import orderMachine.restaurant.Restaurant;
import orderMachine.workers.*;

public class DefaultValues {

    public static Product[] create10DefaultProducts() {
        Product product0 = new Product("Vege Burger", 2, "Vege Burger", "Vege Burger",
                15, new double[]{0,1,2,3});
        Product product1 = new Product("Ham Burger", 3, "Ham Burger", "Ham Burger",
                18, new double[]{0,1,2,3});
        Product product2 = new Product("Pizza", 5,"Pizza", "Pizza",
                10, new double[]{0,1,2,3,4,5,6,7,8,9,10,11});
        Product product3 = new Product("Fries", 1, "Fries", "Fries",
                4, new double[]{0,1,2});
        Product product4 = new Product("Belgian Fries", 2, "Belgian Fries", "Belgian Fries",
                5, new double[]{0,1,2});
        Product product5 = new Product("Salad with chicken", 1,"Salad with chicken", "Salad with chicken",
                6, new double[]{0,1});
        Product product6 = new Product("Salad with Tuna", 1,"Salad with Tuna", "Salad with Tuna",
                6, new double[]{0,1});
        Product product7 = new Product("Salad without meet", 0,"Salad without meet", "Salad without meet",
                6, new double[]{0,1});
        Product product8 = new Product("Tomato Soup", "Tomato Soup", "Tomato Soup",
                8, 10.0);
        Product product9 = new Product("Special meal", "Special meal", "Special meal",
                20, 24.99);
        return new Product[]{product0, product1, product2, product3, product4,
                product5, product6, product7, product8, product9};
    }
    public static Worker[] createDefaultBasicTeam() {
        Worker manager1 = new Manager("Johny", 2000);
        Worker chef1 = new Chef("Lucy", 1998);
        Worker chef2 = new Chef("Olaf", 1988);
        Worker waiter1 = new Waiter("Kasia", 2004);
        Worker deliveryMan1 = new DeliveryMan("Karol", 2002);
        return new Worker[]{manager1, chef1, chef2, waiter1, deliveryMan1};
    }
    public static Worker[] createDefaultUltimateTeam() {
        Worker manager1 = new Manager("Johny", 2000);
        Worker chef1 = new Chef("Lucy", 1998);
        Worker chef2 = new Chef("Olaf", 1988);
        Worker chef3 = new Chef("Maciej", 1989);
        Worker chef4 = new Chef("Susan", 1999);
        Worker waiter1 = new Waiter("Karolina", 2002);
        Worker waiter2 = new Waiter("Kasia", 2004);
        Worker waiter3 = new Waiter("Andrzej", 2001);
        Worker deliveryMan1 = new DeliveryMan("Zosia", 2005);
        Worker deliveryMan2 = new DeliveryMan("Seba", 1998);
        Worker deliveryMan3 = new DeliveryMan("Karol", 2002);
        return new Worker[]{manager1, chef1, chef2, chef3, chef4, waiter1, waiter2,
        waiter3, deliveryMan1, deliveryMan2, deliveryMan3};
    }
    public static Adres[] createDefault3SavedAdres(){
        Adres adres1 = new Adres("House", "Poland", "Warsaw","Koszykowa",15);
        Adres adres2 = new Adres("Work", "Germany", "Berlin", "Street", 11,36,3);
        Adres adres3 = new Adres("Friends", "Poland", "Pruszków", "Jeziorowa", 119, 19, 1);
        return new Adres[]{adres1, adres2, adres3};
    }
    public static Customer[] createDefault3Customers(){
        Customer customer1 = new Customer("Adrian", 2001,
                new Adres("House", "Poland", "Warsaw","Koszykowa",15));
        Customer customer2 = new Customer("Alan", 2005,
                new Adres("Work", "Germany", "Berlin", "Street", 11,36,3));
        Customer customer3 = new Customer("Karolina", 2002,
                new Adres("Friends", "Poland", "Pruszków", "Jeziorowa", 119, 19, 1));
        return new Customer[]{customer1, customer2, customer3};
    }
    public static Restaurant[] createDefault1Restaurant(){
        Restaurant restaurant1 = new Restaurant("The time to street FastFood",
                new Adres("Restaurant #001", "Poland", "Warsaw", "Złota", 49),
                new Manager("Olek", 1997), 12.00, 24.00);
        return new Restaurant[]{restaurant1};
    }
}
