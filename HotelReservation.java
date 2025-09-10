package HotelReservationSystem;

import HotelReservationSystem.hotelmanagement.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
    public static List<GuestDetails> bookedGuest = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HotelDetails hotelDetails = new HotelDetails();

        int hotelChoice = 0;
        List<HotelDetails.Hotel> hotelList = hotelDetails.getHotels();
        int roomChoice = 0;
        int options;
        do {
            System.out.println("Welcome to My Hotel");
            System.out.println("-----------------------------");
            System.out.println("1.Book Rooms");
            System.out.println("2.View Details");
            System.out.println("3.Exit");
            System.out.print("Enter Option to Enter: ");
            options = scan.nextInt();
            switch (options) {
                case 1:
                    for (int i = 0; i < hotelList.size(); i++) {
                        System.out.println((i + 1) + "." + hotelList.get(i).getName());
                    }
                    boolean validChoice = false;
                    while (!validChoice) {
                        System.out.print("Enter Yor Choice For Hotel: ");
                        hotelChoice = scan.nextInt();
                        scan.nextLine();

                        if (hotelChoice > 0 && hotelChoice < hotelList.size()) {
                            validChoice = true;
                        } else {
                            System.out.println("Invalid Choice");
                        }
                    }

                    HotelDetails.Hotel selectedHotel = hotelList.get(hotelChoice - 1);
                    List<RoomDetails> availableRooms = selectedHotel.getAvailableRooms();

                    System.out.println("Available Rooms");
                    for (RoomDetails room : availableRooms) {
                        System.out.println("Rooms " + room.getRoomNumber() + " - " + room.getRoomType() + " - Price :" + room.getPrice());
                    }

                    System.out.print("Enter Room Number to Book: ");
                    roomChoice = scan.nextInt();
                    scan.nextLine();


                    int finalRoomChoice = roomChoice;

                    RoomDetails selectedRoom = availableRooms.stream()
                            .filter(room -> room.getRoomNumber() == finalRoomChoice)
                            .findFirst()
                            .orElse(null);


                    if (selectedRoom != null) {

                        LocalDate startDate = getDateFromUser(scan, "Enter check-in date (dd-MM-yyyy): ");
                        LocalDate endDate = getDateFromUser(scan, "Enter check-out date (dd-MM-yyyy): ");

                        long numberOfDaysStay = ChronoUnit.DAYS.between(startDate, endDate);
                        double totalPrice = numberOfDaysStay * selectedRoom.getPrice();

                        System.out.println("Booking Details");
                        System.out.println("Room: " + selectedRoom.getRoomNumber() + " - " + selectedRoom.getRoomType());
                        System.out.println("Check-in: " + startDate);
                        System.out.println("Check-out: " + endDate);
                        System.out.println("Total Price: " + totalPrice);

                        System.out.println("1.Confirm Booking");
                        System.out.println("2.Cancel Booking");
                        System.out.print("Enter to Choose: ");
                        int choiceNumber = scan.nextInt();
                        scan.nextLine();
                        if (choiceNumber == 1) {
                            GuestDetails guestDetails = getGuestDetails(scan);
                            selectedHotel.addBookedGuest(guestDetails);
                            bookedGuest.add(guestDetails);

                            String bookingStatus = Reservation.roomReservation(hotelDetails, guestDetails, selectedRoom, startDate, endDate);
                            System.out.println(bookingStatus);
                        } else {
                            System.out.println("Room Canceled");
                        }
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                case 2:
                    viewDetails(hotelDetails, scan);
                    break;
                case 3:
                    System.out.println("Exit");
                default:
                    break;
            }
        } while (options != 3);
    }

    private static GuestDetails getGuestDetails(Scanner scan) {
        System.out.print("Enter Guest Name: ");
        String guestName = scan.nextLine();

        System.out.print("Enter Guest Address: ");
        String guestAddress = scan.nextLine();

        System.out.print("Enter Guest PhoneNumber: ");
        long guestPhone = scan.nextLong();

        return new GuestDetails(0, guestAddress, guestName, guestPhone);
    }

    private static LocalDate getDateFromUser(Scanner scan, String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = null;
        boolean validDate = false;

        while (!validDate) {
            System.out.println(prompt);
            String inputDate = scan.nextLine();

            try {
                date = LocalDate.parse(inputDate, formatter);
                validDate = true;
            } catch (Exception e) {
                System.out.println("Invalid Date Format");
            }
        }
        return date;
    }

    public static void viewDetails(HotelDetails hotelDetails, Scanner scan) {
        List<HotelDetails.Hotel> hotelList = hotelDetails.getHotels();
        System.out.println("Select Hotel To View Details");

        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println((i + 1) + "." + hotelList.get(i).getName());
        }
        int hotelChoice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Enter Hotel to View:");
            hotelChoice = scan.nextInt();
            scan.nextLine();
            if (hotelChoice > 0 && hotelChoice <= hotelList.size()) {
                validChoice = true;
            } else {
                System.out.println("Invalid Choice");
            }

        }

        HotelDetails.Hotel selectedHotel = hotelList.get(hotelChoice - 1);


        List<RoomDetails> availableRooms = selectedHotel.getAvailableRooms();
        System.out.println("Available Rooms");
        for (RoomDetails room : availableRooms) {
            System.out.println("Room: " + room.getRoomNumber() + " - " + room.getRoomType());
        }

        System.out.println("Staff Details for " + selectedHotel.getName() + ":");
        for (StaffDetails staff : StaffDetails.getStaffList()) {
            System.out.println(staff);
        }
        System.out.println("Guest Details for: " + selectedHotel.getName());
        List<GuestDetails> bookedDetails = selectedHotel.getBookedGuests();
        if (bookedDetails.isEmpty()) {
            System.out.println("No guest have booked");
        } else {
            for (GuestDetails guest : bookedDetails) {
                System.out.println("GuestID: " + guest.getGuestID() + " -GuestName: " + guest.getGuestName() + "-GuestAddress: " + guest.getGuestAddress() + "-GuestPhone" + guest.getGuestPhone());
            }
        }


        HotelInformation hotelInfo = new HotelInformation(selectedHotel, availableRooms);
        System.out.println("\n" + selectedHotel.getName() + " has " + hotelInfo.getAvailableRoomsCount() + " available rooms");
    }
}
