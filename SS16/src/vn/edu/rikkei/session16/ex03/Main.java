package vn.edu.rikkei.session16.ex03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GHI NHẬT KÝ HỆ THỐNG VỚI CONSUMER & SUPPLIER ---");
        System.out.println("Sự kiện 1: \"USER_LOGIN\"");
        System.out.println("Sự kiện 2: \"UPDATE_DATABASE\"");
        System.out.println("Sự kiện 3: \"SYSTEM_BACKUP\"\n");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             NHẬT KÝ HỆ THỐNG CONSUMER-SUPPLIER        |");
        System.out.println("+-------------------------------------------------------+");

        // 1. Định nghĩa Supplier cung cấp thời gian thực format theo yyyy-MM-dd HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Supplier<String> timeSupplier = () -> LocalDateTime.now().format(formatter);

        // 2. Định nghĩa Consumer tiêu thụ tin nhắn để in ra màn hình đúng định dạng khung
        Consumer<String> logger = msg -> {
            String output = "-> " + msg;
            System.out.printf("| %-53s |\n", output);
        };

        // 3. Thực thi ghi log thông qua AuditLogger
        try {
            AuditLogger.logEvent(timeSupplier, logger, "USER_LOGIN");
            Thread.sleep(1000); // Giả lập độ trễ 1 giây giữa các sự kiện

            AuditLogger.logEvent(timeSupplier, logger, "UPDATE_DATABASE");
            Thread.sleep(1000);

            AuditLogger.logEvent(timeSupplier, logger, "SYSTEM_BACKUP");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("+-------------------------------------------------------+");
    }
}