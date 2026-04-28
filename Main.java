package cab_booking;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Driver> drivers = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Trip> trips = new ArrayList<>();

        Matching matching = new Matching();
        FareEngine fareEngine = new FareEngine();

        while (true) {

            System.out.println("Ride Sharing System");
            System.out.println("1.Add Customer");
            System.out.println("2.Add Driver");
            System.out.println("3.Driver Go Online");
            System.out.println("4.Request Ride");
            System.out.println("5.Start Trip");
            System.out.println("6.Complete Trip");
            System.out.println("7.Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer ID: ");
                    String cid = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String cname = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String cphone = sc.nextLine();

                    customers.add(new Customer(cid, cname, cphone));
                    System.out.println("Customer added!");
                    break;

                case 2:
                    System.out.print("Enter Driver ID: ");
                    String did = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String dphone = sc.nextLine();

                    System.out.print("Enter Vehicle: ");
                    String vehicle = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String loc = sc.nextLine();

                    drivers.add(new Driver(did, dname, dphone, vehicle, loc));
                    System.out.println("Driver added!");
                    break;

                case 3:
                    System.out.print("Enter Driver ID: ");
                    String onlineId = sc.nextLine();

                    for (Driver d : drivers) {
                        if (d.driverId.equals(onlineId)) {
                            d.goOnline();
                            System.out.println("Driver is now online");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    String custId = sc.nextLine();

                    Customer cust = null;
                    for (Customer c : customers) {
                        if (c.customerId.equals(custId)) {
                            cust = c;
                            break;
                        }
                    }

                    if (cust == null) {
                        System.out.println("Customer not found");
                        break;
                    }

                    System.out.print("Enter Pickup: ");
                    String pickup = sc.nextLine();

                    System.out.print("Enter Drop: ");
                    String drop = sc.nextLine();

                    Trip trip = cust.requestRide(pickup, drop);

                    Driver driver = matching.findNearestDriver(drivers);

                    if (driver == null) {
                        System.out.println("No drivers available");
                        break;
                    }

                    driver.acceptRide(trip);
                    trips.add(trip);

                    System.out.println("Driver assigned: " + driver.name);
                    break;

                case 5:
                    System.out.print("Enter Trip ID: ");
                    String tid = sc.nextLine();

                    for (Trip t : trips) {
                        if (t.tripId.equals(tid)) {
                            t.start();
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter Trip ID: ");
                    String compId = sc.nextLine();

                    for (Trip t : trips) {
                        if (t.tripId.equals(compId)) {

                            System.out.print("Enter distance (km): ");
                            double dist = sc.nextDouble();

                            System.out.print("Enter time (min): ");
                            double time = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Ride type (economy/premium): ");
                            String type = sc.nextLine();

                            fareEngine.applySurge(1.2);

                            t.calculateFare(fareEngine, dist, time, type);
                            t.complete();

                            System.out.println("Fare: " + t.fare);
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
