package tranthuy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import tranthuy.modules.Student;
import tranthuy.service.StudentService;

@Controller
public class StudentViewController {

    @Autowired
    private StudentService studentService;

    // ================== DANH SÁCH ==================
    @GetMapping("/students")
    public String listStudents(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.trim().isEmpty()) {
            model.addAttribute("students", studentService.searchByName(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("students", studentService.getAllStudents());
        }
        return "students";
    }

    // ================== CHI TIẾT ==================
    @GetMapping("/students/{id}")
    public String studentDetail(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student-detail";
    }

    // ================== XÓA ==================
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // ================== SỬA ==================

    // Mở form sửa
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student-edit";
    }

    //  XỬ LÝ SUBMIT FORM SỬA 
    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }
    // API: GET ALL STUDENTS AS JSON
    @GetMapping("/students/api")
    @ResponseBody
    public ResponseEntity<List<Student>> getAllStudentsApi() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
