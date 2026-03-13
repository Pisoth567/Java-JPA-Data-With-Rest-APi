package co.istad.pisoth.fswd_sbapp.dto;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        BigDecimal price,
        Integer qty,
        String description,
        Integer categoryId
) {
}
