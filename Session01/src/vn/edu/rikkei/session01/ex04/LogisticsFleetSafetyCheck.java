package vn.edu.rikkei.session01.ex04;

import java.util.Scanner;

public class LogisticsFleetSafetyCheck {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG KIỂM ĐỊNH AN TOÀN ĐỘI XE LOGISTICS ---");

        System.out.print("Nhập mã xe tải                   : ");
        String truckId = inp.nextLine();

        System.out.print("Nhập lượng nhiên liệu hiện có (L): ");
        double currentFuel = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập mức hiệu suất (km/L)        : ");
        double efficiency = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập tải trọng thực tế (Tấn)     : ");
        double currentWeight = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập tải trọng tối đa (Tấn)      : ");
        double maxWeight = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập trạng thái bảo dưỡng (true/false): ");
        boolean isMaintained = Boolean.parseBoolean(inp.nextLine());

        Truck truck = new Truck(truckId, currentFuel, efficiency, currentWeight, maxWeight, isMaintained);

        // Biến kiểm thử toán tử tăng giảm
        int inspectionCount = 1;

        System.out.printf("""
                =====================================================================
                            BÁO CÁO KIỂM ĐỊNH XUẤT BẾN XE LOGISTICS
                =====================================================================
                Mã phương tiện               : %s
                Quãng đường tối đa khả thi   : %.2f km
                ---------------------------------------------------------------------
                CỜ ĐÁNH GIÁ TIÊU CHÍ (BOOLEAN FLAGS):
                - Tiêu chí Nhiên liệu (>=200km) : %b
                - Tiêu chí Tải trọng (<=15 Tấn) : %b
                - Tiêu chí Bảo dưỡng định kỳ    : %b
                ---------------------------------------------------------------------
                CẢNH BÁO KHẨN CẤP (OR CHECK) : %b
                =====================================================================
                QUYẾT ĐỊNH XUẤT BẾN (AND CHECK): %b
                =====================================================================
                [Kiểm thử toán tử ++]: Lần kiểm định hậu tố (count++) : %d
                [Kiểm thử toán tử ++]: Lần kiểm định tiền tố (++count) : %d
                =====================================================================
                """,
                truck.getTruckId(),
                truck.getMaxDistance(),
                truck.isFuelOk(),
                truck.isWeightOk(),
                truck.isMaintained(),
                truck.isWarning(),
                truck.isReadyToDepart(),
                inspectionCount++, // Trả về 1, sau đó inspectionCount tăng lên 2
                ++inspectionCount  // Tăng inspectionCount lên 3, sau đó trả về 3
        );

        inp.close();
    }
}