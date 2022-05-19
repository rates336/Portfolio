package orderMachine.customers;

import java.util.LinkedList;
import java.util.List;

public interface ICustomer {
    String name = null;
    int birthYear = 0;
    List<IAdres> customerAdresList = new LinkedList<>();
    void addAdres(Adres adres);
    void removeAdres(Adres adres);
    void removeAdres(String adresName);
}
