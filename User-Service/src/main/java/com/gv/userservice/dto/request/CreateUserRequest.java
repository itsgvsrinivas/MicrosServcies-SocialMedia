package com.gv.userservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class CreateUserRequest {
    @Positive(message = "The userId must be greater than zero")
    Long userId;

    @NotBlank(message = "The name text must not be null and must contain at least one non-whitespace character")
    @Size(min = 5, max = 40, message = "The name text must be at most 40 characters, and has at least one character")
    String name;

    @Positive(message = "The userId must be greater than zero")
    @Size(min = 1, max = 2, message = "The age text must be at most 2 characters, and has at least one character")
    String age;

    @NotBlank(message = "The mobile number text must not be null and must contain at least one non-whitespace character")
    @Size(min = 1, max = 10, message = "The mobile text must be at most 10 characters, and has at least 9 character")
    String mobileNumber;
}
