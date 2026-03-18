package co.istad.pisoth.fswd_sbapp.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        @Positive(message = "Price cannot negative")
        BigDecimal price,
        @Positive(message = "Quantity must be less then 300 products")
        Integer qty,
        String description
){}