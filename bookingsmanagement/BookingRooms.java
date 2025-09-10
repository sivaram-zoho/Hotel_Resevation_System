package HotelReservationSystem.bookingsmanagement;

import BankingApplication.Banking.exceptions.InvalidAddressException;
import BankingApplication.Banking.exceptions.InvalidInputException;
import BankingApplication.Banking.exceptions.InvalidNameException;
import BankingApplication.Banking.exceptions.InvalidPhoneNumberException;
import HotelReservationSystem.hotelmanagement.GuestDetails;
import HotelReservationSystem.hotelmanagement.HotelDetails;
import HotelReservationSystem.hotelmanagement.Reservation;
import HotelReservationSystem.hotelmanagement.RoomDetails;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingRooms {
    public static List<GuestDetails> bookedGuest = new ArrayList<>();

    public static void roomBooking() throws Exception {

        Scanner scan = new Scanner(System.in);
        HotelDetails hotelDetails = new HotelDetails();

        int hotelChoice = 0;
        List<HotelDetails.Hotel> hotelList = hotelDetails.getHotels();
        int roomChoice = 0;

        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println((i + 1) + "." + hotelList.get(i).getName());
        }
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Enter Yor Choice For Hotel: ");
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
        for (
                RoomDetails room : availableRooms) {
            System.out.println("Rooms " + room.getRoomNumber() + " - " + room.getRoomType() + " - Price :" + room.getPrice());
        }

        System.out.print("Enter Room Number to Book: ");
        roomChoice = scan.nextInt();
        scan.nextLine();
        String roomChoiceString = String.valueOf(roomChoice);
        if (!roomChoiceString.matches("^[0-9]+$")) {
            throw new InvalidInputException("");
        }

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

            String choiceNumberString = String.valueOf(choiceNumber);
            if (!choiceNumberString.matches("^[0-9]+$")) {
                throw new InvalidInputException("");
            }

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
    }

    private static GuestDetails getGuestDetails(Scanner scan) throws InvalidPhoneNumberException, InvalidNameException, InvalidAddressException {
        System.out.print("Enter Guest Name: ");
        String guestName = scan.nextLine();
        if (!guestName.matches("[a-zA-Z ]+")) {
            throw new InvalidNameException("");
        }

        System.out.print("Enter Guest Address: ");
        String guestAddress = scan.nextLine();
        if (!guestAddress.matches("^[0-9 a-zA-Z,.'-]+$")) {
            throw new InvalidAddressException("");
        }
        System.out.print("Enter Guest PhoneNumber: ");
        long guestPhone = scan.nextLong();
        String phoneNumberString = String.valueOf(guestPhone);
        if (!phoneNumberString.matches("^[0-9]+$")) {
            throw new InvalidPhoneNumberException("");
        }

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

}