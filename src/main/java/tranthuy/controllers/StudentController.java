package tranthuy.controllers;
import org.springframework.web.bind.annotation.RestController;
import tranthuy.modules.Student; // Đúng với cấu trúc thư mục của bạn
import tranthuy.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin 
public class StudentController {
    @Autowired
    private StudentService service;
    // Bai 1
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }
    //câu 2
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }
    @GetMapping("/students/search")
    public String search(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int page) {
        return "keyword=" + keyword + ", page=" + page;
    }
    //bài 3
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }
    //bài 4
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Thanh Thuy", 20);
    }
    //bài 5
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));
        return list;
    }
}
