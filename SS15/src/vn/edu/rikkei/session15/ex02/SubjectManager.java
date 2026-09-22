package vn.edu.rikkei.session15.ex02;

import java.util.ArrayList;
import java.util.List;

public class SubjectManager<T extends Subject> {
    private List<T> subjects;

    public SubjectManager() {
        this.subjects = new ArrayList<>();
    }

    public void addSubject(T subject) {
        subjects.add(subject);
    }

    public boolean removeSubject(String code) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getCode().equals(code)) {
                subjects.remove(i);
                return true;
            }
        }
        return false;
    }

    public void displaySubjects() {
        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học hiện đang trống.");
            return;
        }
        for (T subject : subjects) {
            System.out.println(subject);
        }
    }

    public List<T> searchByName(String keyword) {
        List<T> result = new ArrayList<>();
        for (T subject : subjects) {
            if (subject.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(subject);
            }
        }
        return result;
    }

    public List<T> filterByCredits() {
        List<T> result = new ArrayList<>();
        for (T subject : subjects) {
            if (subject.getCredits() > 3) {
                result.add(subject);
            }
        }
        return result;
    }
}