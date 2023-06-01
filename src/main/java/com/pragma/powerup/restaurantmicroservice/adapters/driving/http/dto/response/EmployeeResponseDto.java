package com.pragma.powerup.restaurantmicroservice.adapters.driving.http.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Employee Response DTO")
public class EmployeeResponseDto {
    private Long id;
    @Schema(description = "Name", example = "Juan")
    private String name;
    @Schema(description = "Surname", example = "Gomez")
    private String surname;
    @Schema(description = "Email", example = "juangomez@example.com")
    private String mail;
    @Schema(description = "Cellphone Number", example = "+573001234567")
    private String phone;
    @Schema(description = "Identification Document Number", example = "1234567890")
    private String dniNumber;
    @Schema(description = "Date of Birth", example = "2000-02-20")
    private LocalDate dateOfBirth;
    private Long idRestaurant;
}