package orderMachine.produtcs;

import java.util.HashMap;
import java.util.Scanner;

public class ProductsList {
    public static HashMap<String, Double> mapOfProductsOneSize = new HashMap<>();
    public static HashMap<String, Double> mapOfProductsNoOneSize = new HashMap<>();
    public void setMapOfProducts(){

    }
    public void addProduct(Product theProduct) {
        Scanner scanner = new Scanner(System.in)
        if(theProduct.isOneSizeProduct()) {
            System.out.println("Enter name and enter Price, separate this value \",\"");
            mapOfProductsOneSize.put(theProduct.getName(), theProduct.getPrice());
        } else {
            System.out.println("If you want help to add more size than 1 enter yes, else enter no");
            if (scanner.next().equals("yes"))
                Info.helpToAddingManySizesOfProduct();
            for (int i = 0; i <theProduct.getAmountOfSizes(); i++) {
                mapOfProductsNoOneSize.put(theProduct.getName() + " Size: " +
                        theProduct.get, theProduct.getPriceForTheSize(theProduct.getSize()));
            }
        }
    }
}
