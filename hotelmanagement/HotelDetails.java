package HotelReservationSystem.hotelmanagement;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDetails {

    public List<Hotel> hotels;

    public HotelDetails() {
        this.hotels = new ArrayList<>();
        hotels.add(new Hotel("Hotel ABC,Tambaram"));
        hotels.add(new Hotel("Hotel SRM,Pallavaram"));
        hotels.add(new Hotel("Hotel SRM,Guindy"));
        hotels.add(new Hotel("Hotel KFC,Urapakkam"));

    }


    public List<Hotel> getHotels() {
        return hotels;
    }

    public List<GuestDetails> getGuestDetails(Hotel hotel){
        return hotel.getBookedGuests();
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public static class Hotel {
        private String name;
        private List<RoomDetails> rooms;
        private final List<GuestDetails> bookedGuests;
        public Hotel(String name) {
            this.name = name;
            this.rooms = RoomDetails.initRooms();
            this.bookedGuests=new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<RoomDetails> getRooms() {
            return rooms;
        }

        public void setRooms(List<RoomDetails> rooms) {
            this.rooms = rooms;
        }



        public List<GuestDetails> getBookedGuests() {
            return bookedGuests;
        }

        public void addBookedGuest(GuestDetails guest) {
            bookedGuests.add(guest);
        }


        public boolean selectRoom(int roomNumber) {
            for (RoomDetails room : rooms) {
                if (room.getRoomNumber() == roomNumber && room.getRoomStatus() == RoomDetails.VariousStatus.AVAILABLE) {
                    room.setRoomStatus(RoomDetails.VariousStatus.CHECKED_IN);
                    return true;
                }
            }
            return false;

        }

        public List<RoomDetails> getAvailableRooms() {
            List<RoomDetails> availableRooms = new ArrayList<>();
            for (RoomDetails room : rooms) {
                if (room.getRoomStatus() == RoomDetails.VariousStatus.AVAILABLE) {
                    availableRooms.add(room);
                }
            }
            return availableRooms;
        }
    }

}
