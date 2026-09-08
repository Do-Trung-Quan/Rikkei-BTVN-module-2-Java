package vn.edu.rikkei.session09.ex02;

public class ServerConnection {
    public static final int MAX_CONNECTIONS = 3;
    private static int activeConnections = 0;
    private String connectionId;
    private boolean isConnected = false;

    public ServerConnection(String connectionId) {
        this.connectionId = connectionId;
        if (activeConnections < MAX_CONNECTIONS) {
            this.isConnected = true;
            activeConnections++;
            String message = String.format("[%s] Mở thành công! (Active: %d/%d)", this.connectionId, activeConnections, MAX_CONNECTIONS);
            System.out.printf("| %-53s |\n", message);
        } else {
            this.isConnected = false;
            System.out.println("|-------------------------------------------------------|");
            String message = String.format("[%s] TỪ CHỐI KẾT NỐI! Đã đạt giới hạn tối đa %d/%d", this.connectionId, MAX_CONNECTIONS, MAX_CONNECTIONS);
            System.out.printf("| %-53s |\n", message);
        }
    }

    public void closeConnection() {
        if (this.isConnected) {
            activeConnections--;
            this.isConnected = false;
        }
    }
}