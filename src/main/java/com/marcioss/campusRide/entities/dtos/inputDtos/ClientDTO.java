package com.marcioss.campusRide.entities.dtos.inputDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    private Long id;

    @NotEmpty(message = "Field can't be empty")
    @Length(min = 5, max = 100, message = "this field can't have less than 5 or more than 100 characters")
    private String name;
    @Email
    @NotEmpty(message = "this Filed can't be empty")
    private String email;

    @NotEmpty(message = "Field password cant be empty.")
    private String password;
}

