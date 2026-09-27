package in.strikes.CRUDdemo.service;
import in.strikes.CRUDdemo.entity.Student;
import in.strikes.CRUDdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentrepository;

    public StudentService(StudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    public Student createStudent( Student studentreq) {

        Student student = studentrepository.save(studentreq);

        return studentreq;
    }

    public Student getId(Long id) {

        Optional<Student> student = studentrepository.findById(id);

        if(student.isPresent()) {
            return student.get();
        }

        return null;
    }

    public List<Student> getAllStudents() {

        List<Student> resp = studentrepository.findAll();

        return resp;
    }

    public Student update( Long id) {

        Student resp = studentrepository.findById(id).orElseThrow();

        resp.setAge(23);
        resp.setName("Aman");
        resp.setEmail("aman@gmail.com");
        resp.setId(id);
        resp.setRoll_no(4251);
        resp.setSubject("LDCO");

        return resp;

    }

    public void delete(Student todelete) {

        studentrepository.delete(todelete);

    }
}
