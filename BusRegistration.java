
import java.util.Queue;
import java.util.LinkedList;

class Bus {
    String busNumber;
    int totalSeats;
    String startingPoint;
    String endingPoint;
    String startingTime;
    double fare;

 Bus(String busNumber, int totalSeats, String startingPoint, String endingPoint, String startingTime,
            double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
    }

    public String toString() {
        return "Bus{busNumber='" + busNumber + "', totalSeats='" + totalSeats + "', startingPoint='" + startingPoint
                + "', endingPoint='" + endingPoint + "', startingTime='" + startingTime + "',fare='" + fare + "'}";
    }

}

public class BusRegistration {
    Queue<Bus> busQueue = new LinkedList<>();

    public void registerBus(String busNumber, int totalSeats, String startingPoint, String endingPoint,
            String startingTime, double fare) {
        Bus bus = new Bus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
        busQueue.add(bus);
        System.out.println("Bus Registered Successfullly "+bus);

    }

    public Bus searchByBusNumber(String busNumber) {
        for (Bus bus : busQueue) {
            if (bus.busNumber.equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    public void displayAllBuses() {
        for (Bus bus : busQueue) {
            System.out.println(bus);
        }

    }

}
