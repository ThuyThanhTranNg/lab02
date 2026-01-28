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
            // ✅ SỬA DÒNG NÀY: tìm theo ID hoặc tên
            model.addAttribute("students", studentService.searchByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("students", studentService.getAllStudents());
        }
        return "students";
    }

    // ================== THÊM ==================
    @GetMapping("/students/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-add";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
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
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student-edit";
    }

    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    // ================== API JSON ==================
    @GetMapping("/students/api")
    @ResponseBody
    public ResponseEntity<List<Student>> getAllStudentsApi() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
