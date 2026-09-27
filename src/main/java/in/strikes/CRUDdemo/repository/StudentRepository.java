package in.strikes.CRUDdemo.repository;

import in.strikes.CRUDdemo.entity.Student;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {

}
