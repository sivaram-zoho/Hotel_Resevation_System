package HotelReservationSystem.hotelmanagement;

public class HotelDetails {
    String hotelA;
    String hotelB;
    String hotelC;
    String hotelD;

    int roomID;
    String roomStatus;
    double pricePerNight;
    public VariousType roomType;

    int guestID;
    String guestName;
    String guestAddress;
    long guestPhone;
    public VariousStatus reserveStatus;

    int staffID;
    String staffName;
    long staffPhone;
    public VariousStaffs positions;

    public enum VariousStaffs {
        MANAGER,
        RECEPTIONIST,
        HOUSEKEEPING
    }

    public HotelDetails(String hotelA, String hotelB, String hotelC, String hotelD) {
        this.hotelA = hotelA;
        this.hotelB = hotelB;
        this.hotelC = hotelC;
        this.hotelD = hotelD;
    }

    public String getHotelA() {
        return hotelA;
    }

    public String getHotelB() {
        return hotelB;
    }

    public String getHotelC() {
        return hotelC;
    }

    public String getHotelD() {
        return hotelD;
    }

    public void setHotelA(String hotelA) {
        this.hotelA = "Hotel ABC,Chennai";
    }

    public void setHotelB(String hotelB) {
        this.hotelB = "Hotel Sangeeta, Madurai";
    }

    public void setHotelC(String hotelC) {
        this.hotelC = "Hotel SRM";
    }

    public void setHotelD(String hotelD) {
        this.hotelD = "Hotel SBM";
    }


    public enum VariousType {
        STANDARD,
        DELUXE,
        SUITE
    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public VariousType getRoomType() {
        return roomType;
    }

    public void setRoomType(VariousType roomType) {
        this.roomType = roomType;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }


    public enum VariousStatus {
        NEW,
        PAST

    }

    public int getGuestID() {
        return guestID;
    }

    public String getName() {
        return guestName;
    }

    public String getAddress() {
        return guestAddress;
    }

    public long getPhone() {
        return guestPhone;
    }

    public VariousStatus getReserveStatus() {
        return reserveStatus;
    }

    public void setAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public void setName(String guestName) {
        this.guestName = guestName;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public void setPhone(long guestPhone) {
        this.guestPhone = guestPhone;
    }

    public void setReserveStatus(VariousStatus reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    public int getStaffID() {
        return staffID;
    }

    public long getGuestPhone() {
        return guestPhone;
    }

    public long getStaffPhone() {
        return staffPhone;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getStaffName() {
        return staffName;
    }

    public VariousStaffs getPositions() {
        return positions;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setGuestPhone(long guestPhone) {
        this.guestPhone = guestPhone;
    }

    public void setPositions(VariousStaffs positions) {
        this.positions = positions;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffPhone(long staffPhone) {
        this.staffPhone = staffPhone;
    }

}
