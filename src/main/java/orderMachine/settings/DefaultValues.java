package orderMachine.settings;

import orderMachine.customers.Adres;
import orderMachine.produtcs.Product;
import orderMachine.workers.*;

public class DefaultValues {

    public void Create10DefaultProducts() {
        Product product0 = new Product("Vege Burger", "Vege Burger", "Vege Burger",
                new double[]{0,1,2,3});
        Product product1 = new Product("Ham Burger", "Ham Burger", "Ham Burger",
                new double[]{0,1,2,3});
        Product product2 = new Product("Pizza", "Pizza", "Pizza",
                new double[]{0,1,2,3,4,5,6,7,8,9,10,11});
        Product product3 = new Product("Fries", "Fries", "Fries",
                new double[]{0,1,2});
        Product product4 = new Product("Belgian Fries", "Belgian Fries", "Belgian Fries",
                new double[]{0,1,2});
        Product product5 = new Product("Salad with chicken", "Salad with chicken", "Salad with chicken",
                new double[]{0,1});
        Product product6 = new Product("Salad with Tuna", "Salad with Tuna", "Salad with Tuna",
                new double[]{0,1});
        Product product7 = new Product("Salad without meet", "Salad without meet", "Salad without meet",
                new double[]{0,1});
        Product product8 = new Product("Tomato Soup", "M", "Tomato Soup", "Tomato Soup",
                10.0);
        Product product9 = new Product("Special meal","L", "Special meal", "Special meal",
                24.99);
    }
    public void CreateDefaultBasicTeam() {
        Worker manager1 = new Manager("Johny", 2000);
        Worker chef1 = new Chef("Lucy", 1998);
        Worker chef2 = new Chef("Olaf", 1988);
        Worker waiter1 = new Waiter("Kasia", 2004);
        Worker deliveryMan1 = new DeliveryMan("Karol", 2002);
    }
    public void CreateDefaultUltimateTeam() {
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
    }
    public void CreateDefault3SavedAdres(){
        Adres adres1 = new Adres("House", "Poland", "Warsaw","Koszykowa",15);
        Adres adres2 = new Adres("Work", "Germany", "Berlin", "Street", 11,36,3);
        Adres adres3 = new Adres("Friends", "Poland", "Pruszków", "Jeziorowa", 119, 19, 1);
    }
    public void CreateDefault5Customers(){

    }
}
