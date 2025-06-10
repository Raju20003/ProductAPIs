package com.productdto.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productdto1 {

    @NotNull(message = "ID must not be null")
    @Min(value = 1, message = "Id must be at least 1")
    private int id;

    @NotNull(message = "Name must not be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull
    @Min(value = 1, message = "Price must be at least 1")
    private int price;
}