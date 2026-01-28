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

    // ✅ THÊM SINH VIÊN
    public Student addStudent(Student student) {
        return repository.save(student);
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
