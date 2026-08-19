package vn.edu.rikkei.session04.ex03;

import java.util.Locale;
import java.util.Scanner;

public class WeatherStationTemperatureMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] tempMatrix = new double[7][3];
        String[] days = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"};
        String[] times = {"Sáng", "Trưa", "Tối"};

        System.out.println("--- NHẬP DỮ LIỆU QUAN TRẮC NHIỆT ĐỘ 7 NGÀY (7x3) ---");

        for (int i = 0; i < 7; i++) {
            System.out.printf("[Ngày %d - %s]\n", (i + 1), days[i]);
            for (int j = 0; j < 3; j++) {
                while (true) {
                    System.out.printf(" %s: ", times[j]);
                    try {
                        tempMatrix[i][j] = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(" Lỗi: Vui lòng nhập số hợp lệ.");
                    }
                }
            }
        }

        System.out.println();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|             BẢN ĐỒ NHIỆT ĐỘ KHÍ TƯỢNG TUẦN (7x3)              |");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("| Ngày        | Sáng 06h  | Trưa 12h  | Tối 18h   | TB Ngày     |");
        System.out.println("|-------------+-----------+-----------+-----------+-------------|");

        double[] sumPerTime = new double[3];
        double totalSumAll = 0;

        for (int i = 0; i < 7; i++) {
            double dailySum = 0;
            System.out.printf("| %-11s |", days[i]);

            for (int j = 0; j < 3; j++) {
                System.out.printf(Locale.US, " %5.2f °C |", tempMatrix[i][j]);
                dailySum += tempMatrix[i][j];
                sumPerTime[j] += tempMatrix[i][j];
            }

            double dailyAverage = dailySum / 3;
            totalSumAll += dailySum;
            System.out.printf(Locale.US, " %8.2f °C |\n", dailyAverage);
        }

        System.out.println("|-------------+-----------+-----------+-----------+-------------|");
        System.out.printf("| %-11s |", "TB CẢ TUẦN");

        for (int j = 0; j < 3; j++) {
            double timeAverage = sumPerTime[j] / 7;
            System.out.printf(Locale.US, " %5.2f °C |", timeAverage);
        }

        double overallAverage = totalSumAll / 21;
        System.out.printf(Locale.US, " %8.2f °C |\n", overallAverage);
        System.out.println("+---------------------------------------------------------------+");

        scanner.close();
    }
}