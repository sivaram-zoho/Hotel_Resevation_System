package HotelReservationSystem.bookingsmanagement;

import HotelReservationSystem.hotelmanagement.*;

import java.util.List;
import java.util.Scanner;

public class ViewDetails {

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
