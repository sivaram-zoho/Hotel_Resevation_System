package HotelReservationSystem.hotelmanagement;

public class GuestDetails {
    int guestID;
    String guestName;
    String guestAddress;
    long guestPhone;

    public GuestDetails(int guestID, String guestAddress, String guestName, long guestPhone) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.guestAddress = guestAddress;
        this.guestPhone = guestPhone;
    }

    public void setGuestPhone(long guestPhone) {
        this.guestPhone = guestPhone;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public long getGuestPhone() {
        return guestPhone;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getGuestID() {
        return guestID;
    }

}
