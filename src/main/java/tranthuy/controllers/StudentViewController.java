package tranthuy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import tranthuy.service.StudentService;

@Controller
public class StudentViewController {

    @Autowired
    private StudentService studentService;

    // ✅ Danh sách + tìm kiếm sinh viên
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

    // ✅ Trang chi tiết sinh viên
    @GetMapping("/students/{id}")
    public String studentDetail(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student-detail";
    }
}
