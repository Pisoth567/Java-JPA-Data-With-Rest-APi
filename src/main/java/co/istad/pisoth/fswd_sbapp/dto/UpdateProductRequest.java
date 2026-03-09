package co.istad.pisoth.fswd_sbapp.dto;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        BigDecimal price
) {
}
