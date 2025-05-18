package com.thomarsthuvarangan.ums.Service;

import com.thomarsthuvarangan.ums.DTO.RequestDTO.StudentRequestDTO;
import com.thomarsthuvarangan.ums.DTO.ResponseDTO.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> RetrieveAllStudents();

    StudentResponseDTO GetById(Long id);

    String SaveStudent(StudentRequestDTO SRdto);

    String UpdateStudent(StudentRequestDTO SRdto,long id);

    String DeleteStudent(long id);




}
