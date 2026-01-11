package tranthuy.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import tranthuy.modules.Student;
import tranthuy.respository.StudentRepository;

@SpringBootApplication
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
}
