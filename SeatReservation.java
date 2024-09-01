import java.util.LinkedList;
import java.util.Queue;

class Reservation {
    Customer customer;
    Bus bus;
    int seatNumber;
 Reservation(Customer customer, Bus bus, int seatNumber) {
        this.customer = customer;
        this.bus = bus;
        this.seatNumber = seatNumber;
    }

    public String toString() {
        return "Reservation{customer='" + customer + "', bus='" + bus + "', seatNumber='" + seatNumber + "}";
    }

    
}
public class SeatReservation {
    LinkedList<Reservation> reservationList = new LinkedList<>();
    Queue<Customer> waitingQueue = new LinkedList<>();

    public void reserveSeat(Customer customer, Bus bus, int seatNumber) {

        Reservation reservation = new Reservation(customer, bus, seatNumber);
        reservationList.add(reservation);
        System.out.println("Successfully Reserved a Seat " + reservation);
        

    }

    public void cancelReservation(Customer customer, Bus bus) {
        Reservation cancel = null;
        for (Reservation reservation : reservationList) {
            if (reservation.customer.equals(customer) && reservation.bus.equals(bus)) {
                cancel = reservation;
                break;
            }
        }
        if (cancel != null) {
            reservationList.remove(cancel);
            System.out.println("Your Reservation has been cancelled " + cancel);
            if (!waitingQueue.isEmpty()) {
                Customer nextCustomer = waitingQueue.poll();
                reserveSeat(nextCustomer, bus, cancel.seatNumber);


            }
        } else {
            System.out.println("No matching Found");
        }
    }

    public void requestNewSeat(Customer customer) {
        waitingQueue.add(customer);
        System.out.println("You have been added to waiting queue");
    }

    public void displayAllReservation() {
        for (Reservation reservation : reservationList) {
            System.out.println(reservation);
        }
    }

}

