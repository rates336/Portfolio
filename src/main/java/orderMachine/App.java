package orderMachine;

import orderMachine.produtcs.Product;
import orderMachine.produtcs.ProductsCollections;

public class App {
    public static void main(String[] args) {
        Product product = new Product("burger", "rarar", "rararara",
                new double[]{1,2,3,4,5});
        ProductsCollections collections = new ProductsCollections();
        collections.addProduct(product);
        System.out.println(product.getName());
        System.out.println(ProductsCollections.getMapOfProductsNames().get(product.getName()).getPriceForTheSize("L"));
        System.out.println();
        System.out.println(ProductsCollections.getMapOfProductsNoOneSize().get(product.getName() +
                " Size " + product.getSize(0)));
        collections.removeProduct(product.getName());
        //System.out.println(product.hashCode());
        //product.test();
        //Product product1 = new Product();
        //product1.test();
    }
}
