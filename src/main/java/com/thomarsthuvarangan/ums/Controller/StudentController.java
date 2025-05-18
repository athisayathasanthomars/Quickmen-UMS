package com.thomarsthuvarangan.ums.Controller;

import com.thomarsthuvarangan.ums.DTO.RequestDTO.StudentRequestDTO;
import com.thomarsthuvarangan.ums.DTO.ResponseDTO.StudentResponseDTO;
import com.thomarsthuvarangan.ums.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(path="/get-all-students")
    private ResponseEntity<List<StudentResponseDTO>> RetrieveAllStudents(){
        return new ResponseEntity<>(
                studentService.RetrieveAllStudents(),HttpStatus.OK
        );
    }

    @GetMapping(path="/get-by-id/{id}")
    private ResponseEntity<StudentResponseDTO> GetById(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                studentService.GetById(id),HttpStatus.OK
        );
    }

    @PostMapping(path="/save-student")
    private ResponseEntity<String> SaveStudent(
            @Valid @RequestBody StudentRequestDTO SRdto
    ){
        return new ResponseEntity<>(
                studentService.SaveStudent(SRdto),
                HttpStatus.OK
        );
    }

    @PutMapping(path="/update/{id}")
    private ResponseEntity<String> UpdateStudent(
            @Valid @RequestBody StudentRequestDTO SRdto,@PathVariable long id
    ){
        return new ResponseEntity<>(
             studentService.UpdateStudent(SRdto,id),
             HttpStatus.OK
        );
    }

    @DeleteMapping(path="/delete/{id}")
    private ResponseEntity<String> DeleteStudent(
            @PathVariable long id
    ){
        return new ResponseEntity<>(
                studentService.DeleteStudent(id),
                HttpStatus.OK
        );
    }

}
