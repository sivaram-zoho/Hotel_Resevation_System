package HotelReservationSystem;

import HotelReservationSystem.bookingsmanagement.BookingRooms;
import HotelReservationSystem.bookingsmanagement.ViewDetails;
import HotelReservationSystem.exceptions.InvalidAddressException;
import HotelReservationSystem.exceptions.InvalidInputException;
import HotelReservationSystem.exceptions.InvalidNameException;
import HotelReservationSystem.exceptions.InvalidPhoneNumberException;
import HotelReservationSystem.hotelmanagement.*;

import java.util.Scanner;

public class HotelReservation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HotelDetails hotelDetails = new HotelDetails();

        int options = 0;
        do {
            try {
                System.out.println("Welcome to My Hotel");
                System.out.println("-----------------------------");
                System.out.println("1.Book Rooms");
                System.out.println("2.View Details");
                System.out.println("3.Exit");
                System.out.print("Enter Option to Enter: ");
                options = scan.nextInt();
                switch (options) {
                    case 1:
                        BookingRooms.roomBooking();
                        break;
                    case 2:
                        ViewDetails.viewDetails(hotelDetails, scan);
                        break;
                    case 3:
                        System.out.println("Exit Successfully");
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (InvalidAddressException e) {
                System.out.println("Invalid Address format");
            } catch (InvalidNameException e) {
                System.out.println("Invalid Name Please enter alphabets only");
            } catch (InvalidPhoneNumberException e) {
                System.out.println("Invalid PhoneNumber or Enter only Numbers");
            } catch (Exception e) {
                System.out.println("Invalid Input");
                scan.nextLine();
            }
        } while (options != 3);

    }

}
