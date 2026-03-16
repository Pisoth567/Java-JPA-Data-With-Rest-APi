package co.istad.pisoth.fswd_sbapp.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank
        @Size(min = 1, max = 50)
        String name,

        @Positive
        @NotNull
        BigDecimal price,

        @Positive
        @NotNull
        @Min(1)
        @Max(500)
        Integer qty,

        String description,

        @Positive
        @NotNull
        Integer categoryId
) {
}
