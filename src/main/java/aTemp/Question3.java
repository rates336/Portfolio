package aTemp;

public class Question3 {
    public static void main(String[] args) {
    }
    /*public void tryCompleteOrder() {
        LinkedList<Integer> timeToMakeOrder = new LinkedList<>();
        int min = 0;
        while (Arrays.stream(currentMakingOrders).anyMatch(Objects::nonNull)) {
            //Creating loop which working to time making all orders
            List<Order> tempOrders = Arrays.stream(currentMakingOrders)
                    .filter(Objects::nonNull).filter(e -> e.getMakingTimeInSeconds() == 0).toList();
            Order[] tempTab;
            tempTab = Arrays.stream(currentMakingOrders)
                    .filter(Objects::nonNull).filter(e -> e.getMakingTimeInSeconds() > 0)
                    .toArray(Order[]::new);

            Arrays.fill(currentMakingOrders, null);
            System.arraycopy(tempTab, 0, currentMakingOrders, 0, tempTab.length);

            for (Order tempOrder :
                    tempOrders) {
                tempOrder.setIsCompleted(true);
                System.out.println(tempOrder + " is completed");
            }
            tempOrders = listOfWaitingOrders.stream()
                    .filter(Objects::nonNull).filter(e -> e.getMakingTimeInSeconds() == 0).toList();
            for (Order tempOrder :
                    tempOrders) {
                tempOrder.setIsCompleted(true);
                System.out.println(tempOrder + " is completed");
            }

            Arrays.stream(currentMakingOrders)
                    .filter(e -> e != null).mapToInt(Order::getMakingTimeInSeconds).forEach(timeToMakeOrder::add);
            //Fill list a time orders making
            if (timeToMakeOrder.stream().anyMatch(e -> e > 0)) {
                //Check Does some order has not completed
                //min = Arrays.stream(currentMakingOrders).
                min = timeToMakeOrder.stream().mapToInt(e -> e).min().orElse(0);
                //Find a minimal time to finish order
                if (wait(min)) {
                    //wait for to create an order
                    for (int i = 0; i < timeToMakeOrder.size(); i++) {
                        timeToMakeOrder.set(i, (timeToMakeOrder.get(0) - min));
                        //minus minimal time from all orders
                        if (timeToMakeOrder.get(i) <= 0) {
                            if (timeToMakeOrder.get(i) == 0) {
                                System.out.println("Order for " + currentMakingOrders[i].getCustomer() + " has been finished.");
                                //check does some order has been completed
                                //dodaj do utargu
                                currentMakingOrders[i] = null;
                            }
                            if (!listOfWaitingOrders.isEmpty()) {
                                currentMakingOrders[i] = listOfWaitingOrders.get(0);
                                listOfWaitingOrders.remove(0);
                                //check does some order waiting to create
                            }
                        }
                    }
                }
            }


        }
    }*/
    //Why brackets {} modification working code
}
