import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        CustomerRegistration customerRegistration = new CustomerRegistration();
        BusRegistration busRegistration = new BusRegistration();
        SeatReservation seatReservation = new SeatReservation();

        while (true) {
            System.out.println("1. Register Customer");
            System.out.println("2. Register Bus");
            System.out.println("3. Search Buses");
            System.out.println("4. Reserve a Seat");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Request New Seat");
            System.out.println("7. Display All Reservations");
            System.out.println("8. Display All Customers");
            System.out.println("9. Display All Buses");
            System.out.println("10.Exit");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Your Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Your Mobile Number: ");
                    String mobileNumber = sc.nextLine();
                    System.out.println("Enter Your Email:");
                    String email = sc.nextLine();
                    System.out.println("Enter Your city: ");
                    String city = sc.nextLine();
                    System.out.println("Enter Your Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    customerRegistration.registerCustomer(name, mobileNumber, email, city, age);

                    break;
                case 2:
                    System.out.println("Enter Your Bus Number: ");
                    String busNumber = sc.nextLine();
                    System.out.println("Enter Total Seats: ");
                    int totalSeats = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Starting Point: ");

                    String startingPoint = sc.nextLine();
                    System.out.println("Enter Ending Point: ");
                    String endingPoint = sc.nextLine();
                    System.out.println("Enter Starting Time: ");
                    String startingTime = sc.nextLine();
                    System.out.println("Enter the Fare");
                    double fare = sc.nextDouble();
                    sc.nextLine();
                    busRegistration.registerBus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
                    break;
                case 3:
                    System.out.println("Enter the Bus Number: ");
                    String busnumber = sc.nextLine();
                    System.out.println(busRegistration.searchByBusNumber(busnumber));
                    break;
                case 4:
                    System.out.println("Enter Customer Name: ");
                    String customerName = sc.nextLine();
                    System.out.println("Enter Bus Number: ");
                    String busNumbers = sc.nextLine();
                    System.out.println("Enter Seat Number: ");
                    int seatNumber = sc.nextInt();
                    sc.nextLine();  
                    Customer customer = customerRegistration.findCustomerByName(customerName);
                    Bus bus = busRegistration.searchByBusNumber(busNumbers);
                    if (customer != null && bus != null) {
                        seatReservation.reserveSeat(customer, bus, seatNumber);
                    } else {
                        System.out.println("No found Customer or Bus");
                    }
                    break;
                case 5:
                    System.out.println("Enter Customer Name: ");
                    String cusName = sc.nextLine();
                    System.out.println("Enter Bus Number: ");
                    String busNo = sc.nextLine();
                    customer = customerRegistration.findCustomerByName(cusName);
                    bus = busRegistration.searchByBusNumber(busNo);
                    if (customer != null && bus != null) {
                        seatReservation.cancelReservation(customer, bus);

                    } else {
                        System.out.println("Customer or Bus not found");
                    }
                    break;
                case 6:
                    System.out.println("Enter Customer Name: ");
                    String cus = sc.nextLine();
                    customer = customerRegistration.findCustomerByName(cus);
                    if (customer != null) {
                        seatReservation.requestNewSeat(customer);

                    } else {
                        System.out.println("Customer Not Found");
                    }
                    break;
                case 7:
                    seatReservation.displayAllReservation();
                    break;
                case 8:
                    customerRegistration.displayAllCustomer();
                    break;
                case 9:
                    busRegistration.displayAllBuses();
                    break;
                case 10:
                    System.out.println("Existing..........");
                    sc.close();
                  return;
                    default:
                    System.out.println("Invalid Choice Please Try Again");

            }

        }

    }
}