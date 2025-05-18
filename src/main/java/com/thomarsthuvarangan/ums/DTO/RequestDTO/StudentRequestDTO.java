package com.thomarsthuvarangan.ums.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private Long id;
    private String name;
    private String email;
    private String course;
}
