package in.strikes.CRUDdemo.controller;
import in.strikes.CRUDdemo.entity.Student;
import in.strikes.CRUDdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentservice;

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        Student studentresponse = studentservice.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentresponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResp = studentservice.getId(id);

         if(studentResp == null) {
             return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> AllStudents = studentservice.getAllStudents();

        if(AllStudents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AllStudents);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id) {
        Student updatedStudent = studentservice.update(id);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        Student todelete = studentservice.getId(id);

        if(todelete == null) {
            return ResponseEntity.notFound().build();
        }
        studentservice.delete(todelete);

        return ResponseEntity.ok("Deleted");
    }
}
