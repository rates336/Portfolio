package orderMachine;

import orderMachine.orders.Order;
import orderMachine.produtcs.Product;
import orderMachine.produtcs.ProductsCollections;

public class App {
    public static void main(String[] args) {
        //Product product = new Product("burger", "rarar", "rararara",
        //        new double[]{0,1,2,3,4,5,6,7,8});
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
    }
}
