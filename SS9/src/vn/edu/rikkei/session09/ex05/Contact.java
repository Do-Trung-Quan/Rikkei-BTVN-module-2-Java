package vn.edu.rikkei.session09.ex05;

public class Contact {
    public static final int PHONE_LENGTH = 10;

    private String contactId;
    private String contactName;
    private String phoneNumber;

    public Contact(String contactId, String contactName, String phoneNumber) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.setPhoneNumber(phoneNumber);
    }

    public void setPhoneNumber(String phone) {
        if (phone != null && phone.length() == PHONE_LENGTH && phone.startsWith("0")) {
            this.phoneNumber = phone;
        } else {
            System.out.printf("[Cảnh báo SĐT] Số điện thoại '%s' không đúng %d số hoặc không bắt đầu bằng 0\n", phone, PHONE_LENGTH);
            this.phoneNumber = "0000000000";
        }
    }

    public void displayContact() {
        String nameStr = String.format("[%s] %s", this.contactId, this.contactName);
        String phoneStr = this.phoneNumber.equals("0000000000") ? this.phoneNumber + " (Mặc định)" : this.phoneNumber;

        System.out.printf("| %-25s | SĐT: %-21s |\n", nameStr, phoneStr);
    }
}