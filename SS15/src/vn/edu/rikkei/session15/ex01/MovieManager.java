package vn.edu.rikkei.session15.ex01;

import java.util.ArrayList;
import java.util.List;

public class MovieManager<T extends Movie> {
    private List<T> movies;

    public MovieManager() {
        this.movies = new ArrayList<>();
    }

    // Thêm phim mới
    public void addMovie(T movie) {
        movies.add(movie);
    }

    // Tìm phim theo ID
    public T findById(int id) {
        for (T movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    // Xóa phim
    public boolean deleteMovie(int id) {
        T movie = findById(id);
        if (movie != null) {
            movies.remove(movie);
            return true;
        }
        return false;
    }

    // Lấy danh sách phim
    public List<T> getAllMovies() {
        return movies;
    }

    // Tìm kiếm phim theo tên
    public List<T> searchByTitle(String keyword) {
        List<T> result = new ArrayList<>();
        for (T movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    // Lọc phim theo rating
    public List<T> filterByRating(double minRating) {
        List<T> result = new ArrayList<>();
        for (T movie : movies) {
            if (movie.getRating() > minRating) {
                result.add(movie);
            }
        }
        return result;
    }
}