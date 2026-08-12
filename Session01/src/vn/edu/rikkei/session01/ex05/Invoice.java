package vn.edu.rikkei.session01.ex05;

public class Invoice {
    private String roomID;
    private String cusName;
    private double pricePerNight;
    private int nightCount;
    private double serviceCost;
    private boolean VIP;

    private final double VAT_RATE = 0.1;
    private final double SERVICE_RATE = 0.05;

    public Invoice(String roomID, String cusName, double pricePerNight, int nightCount, double serviceCost, boolean VIP) {
        this.roomID = roomID;
        this.cusName = cusName;
        this.pricePerNight = pricePerNight;
        this.nightCount = nightCount;
        this.serviceCost = serviceCost;
        this.VIP = VIP;
    }

    public double getRoomCost(){
        return this.pricePerNight * this.nightCount;
    }

    public double getSubTotal(){
        double subTotal = getRoomCost();
        subTotal+=this.serviceCost;
        return subTotal;
    }

    public double getVatAmount(){
        return getSubTotal() * this.VAT_RATE;
    }

    public double getServiceFeeAmount(){
        return getSubTotal() * this.SERVICE_RATE;
    }

    public double getTotalAmount(){
        return getSubTotal() + getVatAmount() + getServiceFeeAmount();
    }

    public boolean isGifted(){
        return VIP && (nightCount >= 3);
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNightCount() {
        return nightCount;
    }

    public void setNightCount(int nightCount) {
        this.nightCount = nightCount;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public double getVAT_RATE() {
        return VAT_RATE;
    }

    public double getSERVICE_RATE() {
        return SERVICE_RATE;
    }
}
