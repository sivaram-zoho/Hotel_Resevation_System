package HotelReservationSystem.bookingsmanagement;

import HotelReservationSystem.hotelmanagement.*;

import java.util.List;
import java.util.Scanner;

public class ViewDetails {
    public static void displayMenu() {
        System.out.println("View All Details");
        System.out.println("1.View Hotel Details");
        System.out.println("2.View Staff Details");
        System.out.println("3.View Guest Details");
        System.out.println("4.Update Room Status");
        System.out.println("5.Back");
        System.out.println("Enter Your Option");
    }

    public static void viewDetails(HotelDetails hotelDetails, Scanner scan) {
        displayMenu();
        int options = scan.nextInt();
        scan.nextLine();
        switch (options) {
            case 1:
                viewHotelDetails(hotelDetails, scan);
                break;
            case 2:
                viewStaffDetails(hotelDetails);
                break;
            case 3:
                viewGuestDetails(hotelDetails);
                break;
            case 4:
                updateStatus(hotelDetails, scan);
                break;
            case 5:
                System.out.println("Going Back");
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }

    public static void viewStaffDetails(HotelDetails hotelDetails) {
        System.out.println("Staff Details:");
        for (StaffDetails staff : StaffDetails.getStaffList()) {
            System.out.println(staff);
        }
    }

    public static void viewGuestDetails(HotelDetails hotelDetails) {
        List<GuestDetails> bookedGuests = hotelDetails.getGuestDetails();
        System.out.println("Guest Details:");
        if (bookedGuests.isEmpty()) {
            System.out.println("No guests have booked.");
        } else {
            for (GuestDetails guest : bookedGuests) {
                System.out.println("GuestID: " + guest.getGuestID() + " - Name: " + guest.getGuestName() +
                        " - Address: " + guest.getGuestAddress() + " - Phone: " + guest.getGuestPhone());
            }
        }
    }

    public static void viewHotelDetails(HotelDetails hotelDetails, Scanner scan) {
        List<HotelDetails.Hotel> hotelList = hotelDetails.getHotels();
        HotelDetails.Hotel hotel = selectHotel(scan, hotelList);

        if (hotel != null) {
            System.out.println("Available Rooms:");
            for (RoomDetails room : hotel.getAvailableRooms()) {
                System.out.println("Room: " + room.getRoomNumber() + " - " + room.getRoomType());
            }

            HotelInformation hotelInfo = new HotelInformation(hotel, hotel.getAvailableRooms());
            System.out.println("\n" + hotel.getName() + " has " + hotelInfo.getAvailableRoomsCount() + " available rooms.");
        }
    }

    private static HotelDetails.Hotel selectHotel(Scanner scan, List<HotelDetails.Hotel> hotelList) {
        System.out.println("Select Hotel To View Details:");
        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println((i + 1) + ". " + hotelList.get(i).getName());
        }

        int hotelChoice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Enter Hotel to View: ");
            hotelChoice = scan.nextInt();
            scan.nextLine();

            if (hotelChoice > 0 && hotelChoice <= hotelList.size()) {
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        return hotelList.get(hotelChoice - 1);
    }


    public static void updateStatus(HotelDetails hotelDetails, Scanner scan) {
        List<HotelDetails.Hotel> hotelList = hotelDetails.getHotels();
        HotelDetails.Hotel hotel = selectHotel(scan, hotelList);

        if (hotel != null) {
            System.out.println("Available Rooms:");
            for (RoomDetails room : hotel.getAvailableRooms()) {
                System.out.println("Room: " + room.getRoomNumber() + " - " + room.getRoomType());
            }

            System.out.print("Enter room number to update: ");
            int roomNumber = scan.nextInt();
            scan.nextLine();

            RoomDetails selectedRoom = null;
            for (RoomDetails room : hotel.getAvailableRooms()) {
                if (room.getRoomNumber() == roomNumber) {
                    selectedRoom = room;
                    break;
                }
            }

            if (selectedRoom != null) {
                System.out.println("Room " + selectedRoom.getRoomNumber() + " - " + selectedRoom.getRoomType() + " is " + selectedRoom.getRoomStatus());
                System.out.println("Modify the room status");
                System.out.println("1. Available");
                System.out.println("2. Checked In");
                System.out.println("3. Under Maintenance");
                System.out.print("Enter your choice: ");
                int statusChoice = scan.nextInt();
                scan.nextLine();
                switch (statusChoice) {
                    case 1:
                        selectedRoom.setRoomStatus(RoomDetails.VariousStatus.AVAILABLE);
                        System.out.println("Room " + selectedRoom.getRoomNumber() + " is now available.");
                        break;
                    case 2:
                        selectedRoom.setRoomStatus(RoomDetails.VariousStatus.CHECKED_IN);
                        System.out.println("Room " + selectedRoom.getRoomNumber() + " is now checked in.");
                        break;
                    case 3:
                        selectedRoom.setRoomStatus(RoomDetails.VariousStatus.UNDER_MAINTENANCE);
                        System.out.println("Room " + selectedRoom.getRoomNumber() + " is now under maintenance.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("Room number not found.");
            }
        }
    }
}
