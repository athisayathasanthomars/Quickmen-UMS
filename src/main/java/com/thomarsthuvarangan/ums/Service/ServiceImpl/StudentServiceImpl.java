package com.thomarsthuvarangan.ums.Service.ServiceImpl;

import com.thomarsthuvarangan.ums.DTO.RequestDTO.StudentRequestDTO;
import com.thomarsthuvarangan.ums.DTO.ResponseDTO.StudentResponseDTO;
import com.thomarsthuvarangan.ums.Entity.Student;
import com.thomarsthuvarangan.ums.ExceptionHandling.StudentsException;
import com.thomarsthuvarangan.ums.Repo.StudentRepo;
import com.thomarsthuvarangan.ums.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<StudentResponseDTO> RetrieveAllStudents() {
        //returns a list of records from db
        List<Student> studentList=studentRepo.findAll();

        if (studentList.isEmpty()) {
            throw new StudentsException("No students found in the system.");
        }

        //returns a list of StudentResponseDTO without accessing the entity object directly.
        List<StudentResponseDTO> students=new ArrayList<>();
        for(Student stu:studentList){
            students.add(new StudentResponseDTO(
                    stu.getId(),
                    stu.getName(),
                    stu.getEmail(),
                    stu.getCourse()
            ));
        }
        return students;
    }

    public StudentResponseDTO GetById(Long id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty()){
            throw new StudentsException("Student not Found!");
        }
        return new StudentResponseDTO(
                student.get().getId(),
                student.get().getName(),
                student.get().getEmail(),
                student.get().getCourse()
        );
    }

    public String SaveStudent(StudentRequestDTO SRdto) {
        Student student=new Student(
                SRdto.getName(),
                SRdto.getEmail(),
                SRdto.getCourse()
        );
        studentRepo.save(student);
        return student.getName()+" Details Saved.";
    }

    public String UpdateStudent(StudentRequestDTO SRdto, long id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty()){
            throw new StudentsException("Student not Found!");
        }
        student.get().setName(SRdto.getName());
        student.get().setEmail(SRdto.getEmail());
        student.get().setCourse(SRdto.getCourse());

        studentRepo.save(student.get());
        return student.get().getName()+" Details Updated.";
    }

    public String DeleteStudent(long id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty()){
            throw new StudentsException("Student not Found!");
        }
        studentRepo.delete(student.get());
        return student.get().getName()+" Deleted.";
    }
}
