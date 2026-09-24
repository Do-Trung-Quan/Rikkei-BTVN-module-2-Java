package vn.edu.rikkei.session16.ex03;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class AuditLogger {

    public static void logEvent(Supplier<String> timeSupplier, Consumer<String> logger, String eventName) {
        // Lấy thời gian từ Supplier
        String timestamp = timeSupplier.get();

        // Tạo chuỗi thông điệp
        String fullMessage = "[" + timestamp + "] - SỰ KIỆN: " + eventName;

        // Chuyển thông điệp cho Consumer xử lý
        logger.accept(fullMessage);
    }
}