package com.aman.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "programTable")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Domain is mandatory")
    private String domain;

    @NotBlank(message = "Program Type is mandatory")
    private String programType;

    @NotNull(message = "Registrations Open status is mandatory")
    private Boolean registrationsOpen;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 500, message = "Description can be up to 500 characters long")
    private String description;

    @NotNull(message = "Placement Assurance status is mandatory")
    private Boolean placementAssurance;

    @NotBlank(message = "Image URL is mandatory")
    @URL(message = "Image URL must be valid")
    private String imageUrl;

    @NotBlank(message = "University Name is mandatory")
    private String universityName;

    @URL(message = "Faculty Profile URL must be valid")
    private String facultyProfile;

    @NotBlank(message = "Learning Hours and Duration are mandatory")
    private String learningHoursDuration;

    @NotBlank(message = "Certificate/Diploma information is mandatory")
    private String certificateDiploma;

    @NotBlank(message = "Eligibility Criteria is mandatory")
    private String eligibilityCriteria;
}
