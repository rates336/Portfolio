package orderMachine;

import orderMachine.produtcs.Product;

public class App {
    public static void main(String[] args) {
        double[] tab = {1,2,3,4,5};
        //new double[]{1,2,3,4,5}
        Product product = new Product("burger", 5, "rarar", "rararara",
                tab);
        //System.out.println(product.hashCode());
        //product.test();
        //Product product1 = new Product();
        //product1.test();
    }
}
