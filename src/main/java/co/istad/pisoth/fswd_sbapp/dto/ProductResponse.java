package co.istad.pisoth.fswd_sbapp.dto;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductResponse(
        String code,
        String name,
        BigDecimal price,
        Integer qty,
        String description,
        Boolean isAvailable
) {
}
