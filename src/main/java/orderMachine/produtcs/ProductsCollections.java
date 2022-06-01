package orderMachine.produtcs;

import orderMachine.settings.Info;

import java.util.*;

public class ProductsCollections {
    public static Map<String, Double> mapOfProductsOneSize = new HashMap<>();
    public static Map<String, Double> mapOfProductsNoOneSize = new HashMap<>();
    public static Map<String, Product> mapOfProductsNames = new HashMap<>();
    //maps with key as product name + combinations
    Scanner scanner = new Scanner(System.in);

    public void addProduct(Product theProduct) {
        if(theProduct.isOneSizeProduct()) {
            System.out.println("Enter name and enter Price, separate this value \",\"");
            mapOfProductsOneSize.put(theProduct.getName(), theProduct.getPrice());
            mapOfProductsNames.put(theProduct.getName(), theProduct);
            //adding product which have one size
        } else {
            System.out.println("If you want help to add more size than 1 enter yes, else enter no");
            if (scanner.next().equals("yes"))
                Info.helpToAddingManySizesOfProduct();
            //question to user: Do you need to help in create?
            try {
                for (int i = 0; i < theProduct.getAmountOfSizes(); i++) {
                    mapOfProductsNoOneSize.put(theProduct.getName() + " Size: " +
                            theProduct.getAndSetSize(i), theProduct.getPriceForTheSize(theProduct.getAndSetSize(i)));
                }
                mapOfProductsNames.put(theProduct.getName(), theProduct);
                System.out.println("Process adding successfully finished");
                //adding product name with size as a key and price as a value
                //adding product with name as a key and product is a value
                //More can know in method getPriceForTheSize() in Product class
            } catch (Exception e) {
                System.out.println("Something it's wrong, operation added is not finished #0");
            }
            //Now it's only one error code for any errors
        }
        //adding product which have more have one size or in future will have more than one size
    }

    public void removeProduct(String name) {
        if(mapOfProductsOneSize.containsKey(name)) {
            //checking what is "type size" is the product
            try {
                mapOfProductsOneSize.remove(name);
                System.out.println("Operation removing finished successful");
                //deleting product which have only one size
            } catch (Exception e) {
                System.out.println("Error when try removing product with map");
            }
            //only one error code for any errors
        } else {
            if(mapOfProductsNoOneSize.containsKey(name + " Size: " + "XS") ||
                    mapOfProductsNoOneSize.containsKey(name + " Size: " + "size0")) {
                //checking default value - first value which must have which exist
                try {
                    Product tempProduct = mapOfProductsNames.get(name);
                    int tempInteger = tempProduct.getAmountOfSizes();
                    //temp values
                    if (tempInteger > 0) {
                        for (int i = 0; i < tempInteger - 1; i++) {
                            mapOfProductsNoOneSize.remove(name + " Size: " + tempProduct.getAndSetSize(i));
                        }
                        //deleting all sizes with map
                    } else {
                        System.out.println("The product is have null sizes");
                    }
                    System.out.println("Process removing product successfully finished");
                } catch (Exception e) {
                    System.out.println("Something while try deleting product go wrong");
                }
            } else {
                System.out.println("The product is not exist");
            }
            //Error codes
        }

    }
    //deleting product with map
    public void removeProductSize(String name, String size) {
        if(mapOfProductsNames.containsKey(name) &&
                !(mapOfProductsNames.get(name).isOneSizeProduct())) {
            //checking "Do the product exist in the collection?"
            Product tempProduct = mapOfProductsNames.get(name);
            int temp = -1;
            for (int i = 0; i < tempProduct.getAmountOfSizes(); i++) {
                if(tempProduct.getAndSetSize(i).equals(size))
                    temp = i;
            }
            //checking what is position the product
            System.out.print(temp == -1 ? "\nsize entered is wrong" : "");
            //Error message
            try {
                mapOfProductsNoOneSize.remove(name + " Size: " + tempProduct.getAndSetSize(temp));
                tempProduct.setAmountOfSizes(tempProduct.getAmountOfSizes() - 1);
                //deleting and refactoring amountSize value
                for (int i = temp; i < tempProduct.getAmountOfSizes() - 1; i++) {
                    mapOfProductsNoOneSize.put(tempProduct.getName() + " Size: " + tempProduct.getAndSetSize(i),
                            tempProduct.getPriceForTheSize(tempProduct.getAndSetSize(i + 1)));
                    mapOfProductsNoOneSize.remove(tempProduct.getName() + " Size: " + tempProduct.getAndSetSize(i + 1));
                }
                //if size is not a last of all sizes moving sizes on their positions
                System.out.println("Process removing product size with map finished successfully");
            } catch (Exception e) {
                System.out.println("Some went wrong while try to delete size");
            } //error code
        }
    }
    //deleting sizes of product with map

    public static Map<String, Double> getMapOfProductsOneSize() {
        return mapOfProductsOneSize;
    }

    public static Map<String, Double> getMapOfProductsNoOneSize() {
        return mapOfProductsNoOneSize;
    }

    public static Map<String, Product> getMapOfProductsNames() {
        return mapOfProductsNames;
    }
    //Getters
}
