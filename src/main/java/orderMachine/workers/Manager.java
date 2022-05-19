package orderMachine.workers;

public class Manager implements Worker {
    String name;
    int birthYear;

    public Manager(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }
}
