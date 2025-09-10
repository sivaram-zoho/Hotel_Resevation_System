package HotelReservationSystem.hotelmanagement;

import java.util.ArrayList;
import java.util.List;

public class StaffDetails {
    int staffID;
    String staffName;
    long staffPhone;
    public VariousRole staffRole;

    public StaffDetails(int staffID, String staffName, long staffPhone, VariousRole staffRole) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffPhone = staffPhone;
        this.staffRole = staffRole;
    }

    public static List<StaffDetails> staffList = new ArrayList<>();

    static {
        staffList.add(new StaffDetails(1, "Shiva", 7373737420L, StaffDetails.VariousRole.MANAGER));
        staffList.add(new StaffDetails(2, "Raja", 9883949583L, StaffDetails.VariousRole.RECEPTIONIST));
        staffList.add(new StaffDetails(3, "Sai", 9475949396L, StaffDetails.VariousRole.MANAGER));
        staffList.add(new StaffDetails(4, "Balaji", 9274760385L, StaffDetails.VariousRole.RECEPTIONIST));
        staffList.add(new StaffDetails(5, "Adhi", 9284534789L, StaffDetails.VariousRole.HOUSE_KEEPING));
        staffList.add(new StaffDetails(6, "Murali", 9023676354L, StaffDetails.VariousRole.RECEPTIONIST));
        staffList.add(new StaffDetails(7, "Ruban", 7584739483L, StaffDetails.VariousRole.HOUSE_KEEPING));
        staffList.add(new StaffDetails(8, "Jimmy", 8937462980L, StaffDetails.VariousRole.RECEPTIONIST));
        staffList.add(new StaffDetails(9, "Karthik", 98327465901L, StaffDetails.VariousRole.HOUSE_KEEPING));
        staffList.add(new StaffDetails(10, "Guna", 8870090439L, StaffDetails.VariousRole.HOUSE_KEEPING));
    }

 
    public static List<StaffDetails> getStaffList() {
        return staffList;
    }
    public static void setStaffList(List<StaffDetails> staffList) {
        StaffDetails.staffList = staffList;
    }

    public void viewStaffs() {
        for (StaffDetails staff : staffList) {
            System.out.println(staff);
        }
    }

    public enum VariousRole {
        MANAGER, RECEPTIONIST, HOUSE_KEEPING
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setStaffPhone(long staffPhone) {
        this.staffPhone = staffPhone;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public int getStaffID() {
        return staffID;
    }

    public long getStaffPhone() {
        return staffPhone;
    }

    public VariousRole getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(VariousRole staffRole) {
        this.staffRole = staffRole;
    }

    public String toString() {
        return "StaffID: " + staffID + " - Name: " + staffName + " - Role: " + staffRole + " - Phone: " + staffPhone;
    }

}
