package HotelReservationSystem.hotelmanagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Reservation {
    HotelDetails hotelDetails;
    GuestDetails guestDetails;
    StaffDetails staffDetails;
    RoomDetails roomDetails;
    LocalDate startDate;
    LocalDate endDate;

    static Map<Integer, Reservation> reservationsMap = new HashMap<>();

    public Reservation(HotelDetails hotelDetails, GuestDetails guestDetails, RoomDetails roomDetails,LocalDate startDate,LocalDate endDate) {
        this.hotelDetails = hotelDetails;
        this.guestDetails = guestDetails;
        this.roomDetails = roomDetails;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public static int generateGuestID() {
        Random random = new Random();
        return random.nextInt(1000, 2000);
    }


    public static String roomReservation(HotelDetails hotelDetails, GuestDetails guestDetails, RoomDetails roomDetails,LocalDate startDate,LocalDate endDate) {
        RoomDetails roomReserve = null;
        for (HotelDetails.Hotel hotel : hotelDetails.getHotels()) {
            for (RoomDetails room : hotel.getRooms()) {
                if (room.getRoomNumber() == roomDetails.getRoomNumber() && roomDetails.getRoomStatus() == RoomDetails.VariousStatus.AVAILABLE) {
                    roomReserve = room;
                    break;
                }
            }
            if (roomReserve != null){
                break;
            }
        }


        if (roomReserve == null) {
            return "Rooms not available";
        }
        guestDetails.setGuestID(generateGuestID());
        Reservation reservation = new Reservation(hotelDetails, guestDetails, roomReserve,startDate,endDate);
        roomReserve.setRoomStatus(RoomDetails.VariousStatus.CHECKED_IN);
        reservationsMap.put(guestDetails.getGuestID(), reservation);
        return "Room booked";
    }

    public static Map<Integer, Reservation> getReservationMap() {
        return reservationsMap;
    }

    public static void setReservationMap(Map<Integer, Reservation> reservationsMap) {
        Reservation.reservationsMap = reservationsMap;
    }

    public void setGuestDetails(GuestDetails guestDetails) {
        this.guestDetails = guestDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public GuestDetails getGuestDetails() {
        return guestDetails;
    }

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public StaffDetails getStaffDetails() {
        return staffDetails;
    }

    public static Map<Integer, Reservation> getReservationsMap() {
        return reservationsMap;
    }

    public static void setReservationsMap(Map<Integer, Reservation> reservationsMap) {
        Reservation.reservationsMap = reservationsMap;
    }

    public void setStaffDetails(StaffDetails staffDetails) {
        this.staffDetails = staffDetails;
    }
}
