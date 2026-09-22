package vn.edu.rikkei.session15.ex01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        MovieManager<Movie> manager = new MovieManager<>();

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm phim");
            System.out.println("2. Xóa phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Hiển thị phim");
            System.out.println("5. Tìm kiếm phim theo tên");
            System.out.println("6. Lọc phim theo rating");
            System.out.println("7. Thoát");

            int choice = getIntInput("");

            switch (choice) {
                case 1:
                    addMovie(manager);
                    break;
                case 2:
                    deleteMovie(manager);
                    break;
                case 3:
                    updateMovie(manager);
                    break;
                case 4:
                    displayMovies(manager);
                    break;
                case 5:
                    searchMovie(manager);
                    break;
                case 6:
                    filterByRating(manager);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addMovie(MovieManager<Movie> manager) {
        int id = getIntInput("Nhập ID phim:\n");
        System.out.println("Nhập tiêu đề phim:");
        String title = scanner.nextLine();
        System.out.println("Nhập đạo diễn:");
        String director = scanner.nextLine();
        LocalDate releaseDate = getDateInput("Nhập ngày phát hành (dd-MM-yyyy):\n");
        double rating = getDoubleInput("Nhập rating:\n");

        Movie movie = new Movie(id, title, director, releaseDate, rating);
        manager.addMovie(movie);
        System.out.println("Phim đã được thêm thành công.");
    }

    private static void deleteMovie(MovieManager<Movie> manager) {
        int id = getIntInput("Nhập ID phim cần xóa:\n");
        boolean isDeleted = manager.deleteMovie(id);
        if (isDeleted) {
            System.out.println("Phim đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy phim muốn xóa !");
        }
    }

    private static void updateMovie(MovieManager<Movie> manager) {
        int id = getIntInput("Mời nhập id phim muốn sửa :\n");
        Movie movie = manager.findById(id);

        if (movie == null) {
            System.out.println("Không tìm thấy phim với id = " + id);
            return;
        }

        System.out.println("Nhập tiêu đề phim:");
        String title = scanner.nextLine();
        System.out.println("Nhập đạo diễn:");
        String director = scanner.nextLine();
        LocalDate releaseDate = getDateInput("Nhập ngày phát hành (dd-MM-yyyy):\n");
        double rating = getDoubleInput("Nhập rating:\n");

        movie.setTitle(title);
        movie.setDirector(director);
        movie.setReleaseDate(releaseDate);
        movie.setRating(rating);

        System.out.println("Cập nhật phim thành công !");
    }

    private static void displayMovies(MovieManager<Movie> manager) {
        List<Movie> movies = manager.getAllMovies();
        if (movies.isEmpty()) {
            System.out.println("Danh sách phim trống.");
        } else {
            System.out.println("Danh sách phim:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    private static void searchMovie(MovieManager<Movie> manager) {
        System.out.println("Nhập tiêu đề phim để tìm kiếm:");
        String keyword = scanner.nextLine();
        List<Movie> foundMovies = manager.searchByTitle(keyword);

        if (foundMovies.isEmpty()) {
            System.out.println("Không tìm thấy phim");
        } else {
            for (Movie movie : foundMovies) {
                System.out.println("Phim tìm thấy: " + movie);
            }
        }
    }

    private static void filterByRating(MovieManager<Movie> manager) {
        double minRating = getDoubleInput("Nhập rating tối thiểu để lọc:\n");
        List<Movie> filteredMovies = manager.filterByRating(minRating);

        System.out.println("Phim có rating lớn hơn " + minRating + ":");
        if (filteredMovies.isEmpty()) {
            System.out.println("Không có phim nào thỏa mãn.");
        } else {
            for (Movie movie : filteredMovies) {
                System.out.println(movie);
            }
        }
    }

    // --- Các hàm hỗ trợ nhập liệu an toàn bằng Try-Catch ---

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            }
        }
    }

    private static LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return LocalDate.parse(scanner.nextLine().trim(), DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Ngày tháng không hợp lệ. Vui lòng nhập theo định dạng dd-MM-yyyy!");
            }
        }
    }
}