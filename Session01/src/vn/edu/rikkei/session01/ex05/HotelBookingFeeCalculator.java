package vn.edu.rikkei.session01.ex05;

import java.util.Scanner;

public class HotelBookingFeeCalculator {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG LỄ TÂN RIKKEI LUXURY HOTEL ---");

        System.out.print("Nhập mã đặt phòng             : ");
        String roomId = inp.nextLine();

        System.out.print("Nhập tên khách hàng           : ");
        String cusName = inp.nextLine();

        System.out.print("Nhập đơn giá phòng 1 đêm (VNĐ): ");
        double pricePerNight = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập số đêm lưu trú           : ");
        int nightCount = Integer.parseInt(inp.nextLine());

        System.out.print("Nhập phí dịch vụ spa/ẩm thực  : ");
        double serviceCost = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập trạng thái thẻ VIP (true/false): ");
        boolean VIP = Boolean.parseBoolean(inp.nextLine());

        Invoice inv = new Invoice(roomId, cusName, pricePerNight, nightCount, serviceCost, VIP);

        System.out.printf("""
                =====================================================================
                             HÓA ĐƠN LƯU TRÚ RIKKEI LUXURY HOTEL
                =====================================================================
                Mã đặt phòng             : %s
                Khách hàng               : %s | Thẻ VIP: %b
                ---------------------------------------------------------------------
                CHI TIẾT CHI PHÍ (COST BREAKDOWN):
                - Tiền phòng (%d đêm)                     : %,18.2f VNĐ
                - Phí dịch vụ spa/ẩm thực                : %,18.2f VNĐ
                ---------------------------------------------------------------------
                TỔNG TRƯỚC THUẾ (SUBTOTAL)               : %,18.2f VNĐ
                - Thuế GTGT (VAT 10%%)                    : %,18.2f VNĐ
                - Phí phục vụ (Service Fee 5%%)           : %,18.2f VNĐ
                =====================================================================
                TỔNG THANH TOÁN (TOTAL AMOUNT)           : %,18.2f VNĐ
                =====================================================================
                QUYỀN LỢI QUÀ TẶNG ĐẶC BIỆT (VIP & >=3 đêm): %b
                =====================================================================
                """, inv.getRoomID(), inv.getCusName(), inv.isVIP(), inv.getNightCount(),inv.getRoomCost(), inv.getServiceCost(), inv.getSubTotal(), inv.getVatAmount(), inv.getServiceFeeAmount(), inv.getTotalAmount(), inv.isGifted());

    }
}
