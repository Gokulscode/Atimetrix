class TicketBooking implements Runnable {
    int ticketsAvailable = 1;

    public void run() {
        System.out.println("Waiting: " + Thread.currentThread().getName());
        try { Thread.sleep(1000); } catch (Exception e) {}  // Simulate booking delay
        ticketsAvailable--;  // Race here: both threads may see 1 and decrement to 0 or -1
        System.out.println("Booked for: " + Thread.currentThread().getName() + ", Tickets left: " + ticketsAvailable);
    }
}

public class RaceDemo {
    public static void main(String[] args) {
        TicketBooking obj = new TicketBooking();
        new Thread(obj, "Passenger1").start();
        new Thread(obj, "Passenger2").start();
    }
}