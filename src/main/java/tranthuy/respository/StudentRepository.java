package tranthuy.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tranthuy.modules.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    List<Student> findByNameContainingIgnoreCase(String name);
}