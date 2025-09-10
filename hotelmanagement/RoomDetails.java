package HotelReservationSystem.hotelmanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomDetails {
    int roomNumber;
    public VariousStatus roomStatus;
    public VariousRoom roomType;
    double price;
    Date fromDate;
    Date toDate;

    public RoomDetails(int roomNumber, VariousRoom roomType, double price) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.roomStatus=VariousStatus.AVAILABLE;
    }

    public static List<RoomDetails> initRooms() {
         List<RoomDetails> rooms = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            rooms.add(new RoomDetails(i, VariousRoom.STANDARD, 500));
        }

        for (int i = 11; i <= 15; i++) {
            rooms.add(new RoomDetails(i, VariousRoom.DELUXE, 800));
        }

        for (int i = 16; i <= 20; i++) {
            rooms.add(new RoomDetails(i, VariousRoom.SUITE, 1200));
        }
        return rooms;
    }

    public enum VariousRoom {
        STANDARD, DELUXE, SUITE
    }

    public enum VariousStatus {
        AVAILABLE, CHECKED_IN, CHECKED_OUT, UNDER_MAINTENANCE
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public VariousRoom getRoomType() {
        return roomType;
    }

    public VariousStatus getRoomStatus() {
        return roomStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomStatus(VariousStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setRoomType(VariousRoom roomType) {
        this.roomType = roomType;
    }
}
