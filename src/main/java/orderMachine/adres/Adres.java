package orderMachine.customers;

public class Adres implements IAdres {
    private String nameAdres = null;
    private String country = null;
    private String city = null;
    private String streetName;
    private int numberOfBuilt = 0, numberOfFlat = 0, numberOfFloor = 0;
    //basic info

    public Adres(String nameAdres, String country, String city, String streetName, int numberOfBuilt) {
        this.nameAdres = nameAdres;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.numberOfBuilt = numberOfBuilt;
    }
    public Adres(String nameAdres, String country, String city, String streetName,
                 int numberOfBuilt, int numberOfFlat, int numberOfFloor) {
        this.nameAdres = nameAdres;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.numberOfBuilt = numberOfBuilt;
        this.numberOfFlat = numberOfFlat;
        this.numberOfFloor = numberOfFloor;
    }
    //Constructors

    @Override
    public String toString() {
        return "Adres{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", numberOfBuilt=" + numberOfBuilt +
                ", numberOfFlat=" + numberOfFlat +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }

    public String getNameAdres() {
        return nameAdres;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getNumberOfBuilt() {
        return numberOfBuilt;
    }

    public int getNumberOfFlat() {
        return numberOfFlat;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }
    //Getters
}
