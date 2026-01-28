package tranthuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranthuy.modules.Student;
import tranthuy.respository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }
    public List<Student> searchByKeyword(String keyword) {
    // nếu keyword là số → tìm theo ID
    if (keyword.matches("\\d+")) {
        Student student = repository.findById(Integer.parseInt(keyword)).orElse(null);
        return student != null ? List.of(student) : List.of();
    }
    // ngược lại → tìm theo tên
    return repository.findByNameContainingIgnoreCase(keyword);
}


    // ✅ THÊM SINH VIÊN
    public void save(Student student) {
        repository.save(student);
    }

    // ✅ UPDATE
    public void updateStudent(Student student) {
        repository.save(student);
    }

    // ✅ DELETE
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}
