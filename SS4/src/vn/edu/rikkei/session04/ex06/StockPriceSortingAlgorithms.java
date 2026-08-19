package vn.edu.rikkei.session04.ex06;

import java.util.Arrays;

public class StockPriceSortingAlgorithms {
    public static void main(String[] args) {
        double[] prices = {85.5, 92.0, 78.5, 88.0, 95.5, 81.0, 75.0, 90.0};

        System.out.println("--- HỆ THỐNG PHÂN TÍCH GIÁ CỔ PHIẾU RIKKEI SECURITY ---");
        System.out.println("Lịch sử 8 phiên gốc: " + Arrays.toString(prices));

        // Tạo bản sao cho Selection Sort
        double[] arraySelection = new double[prices.length];
        System.arraycopy(prices, 0, arraySelection, 0, prices.length);

        // Tạo bản sao cho Insertion Sort
        double[] arrayInsertion = new double[prices.length];
        System.arraycopy(prices, 0, arrayInsertion, 0, prices.length);

        // 1. Thuật toán Selection Sort
        int selectionSwaps = 0;
        for (int i = 0; i < arraySelection.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arraySelection.length; j++) {
                if (arraySelection[j] < arraySelection[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                double temp = arraySelection[i];
                arraySelection[i] = arraySelection[minIndex];
                arraySelection[minIndex] = temp;
                selectionSwaps++;
            }
        }

        // 2. Thuật toán Insertion Sort
        int insertionShifts = 0;
        for (int i = 1; i < arrayInsertion.length; i++) {
            double key = arrayInsertion[i];
            int j = i - 1;
            while (j >= 0 && arrayInsertion[j] > key) {
                arrayInsertion[j + 1] = arrayInsertion[j];
                j--;
                insertionShifts++;
            }
            arrayInsertion[j + 1] = key;
        }

        // Đánh giá
        String evaluation;
        if (selectionSwaps < insertionShifts) {
            evaluation = "Selection Sort ít thao tác ghi hơn";
        } else if (insertionShifts < selectionSwaps) {
            evaluation = "Insertion Sort ít thao tác ghi hơn";
        } else {
            evaluation = "Hai thuật toán có hiệu năng ghi bằng nhau";
        }

        // 3. Hiển thị báo cáo
        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|          BẢNG SO SÁNH HIỆU NĂNG THUẬT TOÁN            |");
        System.out.println("+-------------------------------------------------------+");

        String sortedArrayStr = Arrays.toString(arraySelection);
        

        String selectionResult = String.format("Hoàn thành với %d lần hoán vị", selectionSwaps);
        String insertionResult = String.format("Hoàn thành với %d lần dịch chuyển", insertionShifts);

        System.out.printf("| Mảng sau sắp xếp:   %-34s|\n", sortedArrayStr);
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| Selection Sort:     %-34s|\n", selectionResult);
        System.out.printf("| Insertion Sort:     %-34s|\n", insertionResult);
        System.out.printf("| Đánh giá tối ưu:    %-34s|\n", evaluation);
        System.out.println("+-------------------------------------------------------+");
    }
}