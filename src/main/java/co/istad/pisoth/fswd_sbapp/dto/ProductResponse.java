package co.istad.pisoth.fswd_sbapp.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String code,
        String name,
        BigDecimal price
) {
}
