**Student Management Web App**

Ứng dụng web quản lý sinh viên được xây dựng bằng Spring Boot và HTML/CSS theo mô hình MVC.

**Tính năng**
Thêm, sửa, xóa và xem thông tin sinh viên (CRUD)
Lưu trữ và quản lý dữ liệu với cơ sở dữ liệu
Giao diện đơn giản, dễ sử dụng
Backend được tổ chức theo các tầng Controller – Service – Repository

**Công nghệ sử dụng**
Backend: Spring Boot (Java)
Frontend: HTML, CSS (Thymeleaf)
Cơ sở dữ liệu: SQL Server
Quản lý mã nguồn: Git & GitHub
Triển khai: Docker

**Cấu trúc dự án**
src/main/java/com/example/demo/
├── controller
├── service
├── repository
├── entity
└── config

src/main/resources/
├── templates
├── static
└── application.properties
**Cài đặt và chạy**

1. Clone repository
git clone https://github.com/ThuyThanhTranNg/lab02.git
cd lab02
2. Chạy ứng dụng
./mvnw spring-boot:run

hoặc (Windows)

mvnw.cmd spring-boot:run
3. Truy cập
http://localhost:8080/students
