import java.util.*;

class Room {
    int number;
    String type;
    boolean booked;

    Room(int number, String type) {
        this.number = number;
        this.type = type;
        this.booked = false;
    }

    void book() { this.booked = true; }
    void cancel() { this.booked = false; }
}

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Add some rooms
        for (int i = 1; i <= 5; i++) rooms.add(new Room(i, "Standard"));
        for (int i = 6; i <= 8; i++) rooms.add(new Room(i, "Deluxe"));
        for (int i = 9; i <= 10; i++) rooms.add(new Room(i, "Suite"));

        while (true) {
            System.out.println("\n1. View Available Rooms\n2. Book Room\n3. Cancel Booking\n4. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("--- Available Rooms ---");
                    for (Room r : rooms) {
                        if (!r.booked) {
                            System.out.println("Room " + r.number + " (" + r.type + ")");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookNum = sc.nextInt();
                    Room roomToBook = getRoom(bookNum);
                    if (roomToBook != null && !roomToBook.booked) {
                        roomToBook.book();
                        System.out.println("Room " + bookNum + " booked.");
                    } else {
                        System.out.println("already booked.");
                    }
                    break;
                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelNum = sc.nextInt();
                    Room roomToCancel = getRoom(cancelNum);
                    if (roomToCancel != null && roomToCancel.booked) {
                        roomToCancel.cancel();
                        System.out.println("Booking for room " + cancelNum + " canceled.");
                    } else {
                        System.out.println("not reserve");
                    }
                    break;
                case 4:
                    System.out.println("bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Incorrect option");
            }
        }
    }

    static Room getRoom(int number) {
        for (Room r : rooms) {
            if (r.number == number) return r;
        }
        return null;
    }
}