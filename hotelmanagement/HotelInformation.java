package HotelReservationSystem.hotelmanagement;

import java.util.List;

public class HotelInformation {
    private HotelDetails.Hotel hotel;
    private List<RoomDetails> availableRooms;

    public HotelInformation(HotelDetails.Hotel hotel,List<RoomDetails> availableRooms){
    this.hotel=hotel;
    this.availableRooms=availableRooms;
    }

    public HotelDetails.Hotel getHotel() {
        return hotel;
    }

    public void setHotel(HotelDetails.Hotel hotel) {
        this.hotel = hotel;
    }

    public List<RoomDetails> getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(List<RoomDetails> availableRooms) {
        this.availableRooms = availableRooms;
    }
    public int getAvailableRoomsCount(){
return (int) availableRooms.stream().filter(room -> room.getRoomStatus()== RoomDetails.VariousStatus.AVAILABLE).count();
    }
}
