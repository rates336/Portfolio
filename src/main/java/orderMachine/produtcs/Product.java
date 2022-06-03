package orderMachine.produtcs;

import java.util.Objects;

public class Product {
    private final String name;
    private final boolean isOneSizeProduct;
    private String size;
    private final String defaultDescription;
    private String description;
    private double price;
    private int amountOfSizes;
    private double[] pricesForSizes;
    private String[] tabOfSizes;
    private int neededTimeToMakeInSeconds;
    //values

    public Product(String name, int size, String description, String defaultDescription,
                   int neededTimeToMakeInSeconds, double[] pricesForSizes) {
        this.name = name;
        tabOfSizes = new String[]{"XS", "S", "M", "L", "XL", "XXL"};
        this.pricesForSizes = pricesForSizes;
        this.amountOfSizes = this.pricesForSizes.length;
        this.size = getAndSetSize(size);
        this.description = description;
        this.defaultDescription = defaultDescription;
        this.isOneSizeProduct = false;
        this.neededTimeToMakeInSeconds = neededTimeToMakeInSeconds;
    }
    public Product(String name, String description, String defaultDescription,
                   int neededTimeToMakeInSeconds, double price) {
        this.name = name;
        size = "OneSize";
        this.description = description;
        this.defaultDescription = defaultDescription;
        this.price = price;
        this.neededTimeToMakeInSeconds = neededTimeToMakeInSeconds;
        this.isOneSizeProduct = true;
    } //Constructors for two cases first for product have sizes and second with one size
    public void setPrice(double price) {
        this.price = price;
    }
    public void setPrice(double[] pricesForSizes) {
        this.pricesForSizes = pricesForSizes;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
            return size;
    }
    public String getAndSetSize(int number) {
        if(getAmountOfSizes() <= 6) {
            size = getTabOfSizes()[number];
        } //default cases
        else {
            String[] tempTab = new String[getAmountOfSizes()];
            for (int i = 0; i < getAmountOfSizes(); i++) {
                tempTab[i] = "size" + i;
            }
            size = tempTab[number];
            //special cases
        }
        return size;
    } //If user not need so much sizes can use default cases which are a good look
    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double[] getPricesForSizes() {
        return pricesForSizes;
    }

    public double getPriceForTheSize(String size) {
        if(getAmountOfSizes() <= 6) {
            switch (size) {
                case "XS":
                    return pricesForSizes[0];
                case "S":
                    return pricesForSizes[1];
                case "M":
                    return pricesForSizes[2];
                case "L":
                    return pricesForSizes[3];
                case "XL":
                    return pricesForSizes[4];
                case "XXL":
                    return pricesForSizes[5];
                    //return price for default
                default:
                    System.out.println("Entered wrong size!! " + size);
                    return -1;
                    //error code
            }
        } else {
            String[] tempTab = new String[getAmountOfSizes()];
            for (int i = 0; i < tempTab.length; i++) {
                tempTab[i] = "size" + i;
            } //creating special cases using pattern size + SizeNumber
            for (int i = 0; i < tempTab.length; i++) {
                if(tempTab[i].equals(size))
                    return pricesForSizes[i];
            } //checking which case is expected by user
            System.out.println("Size is wrong " + size);
            return -1;
            //error code
            //$This is to correct, when adding product this not working
        }
    }

    public boolean isOneSizeProduct() {
        return isOneSizeProduct;
    }

    public String getDefaultDescription() {
        return defaultDescription;
    }

    public int getAmountOfSizes() {
        return amountOfSizes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public String getSizeOfTab(int numberElementTab) {
        if(numberElementTab >= tabOfSizes.length ||
                numberElementTab < 0) {
            //checking "Do user gave a correct number?"
            System.out.println("Wrong number entered " + numberElementTab);
            return null;
        }
        return tabOfSizes[numberElementTab];
    }*/

    public String[] getTabOfSizes() {
        return tabOfSizes;
    }

    public void setAmountOfSizes(int amountOfSizes) {
        this.amountOfSizes = amountOfSizes;
    }

    public int getNeededTimeToMakeInSeconds() {
        return neededTimeToMakeInSeconds;
    }

    public void setNeededTimeToMakeInSeconds(int neededTimeToMakeInSeconds) {
        this.neededTimeToMakeInSeconds = neededTimeToMakeInSeconds;
    }
}
