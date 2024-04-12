package net.rightpair.services.currency.common.dto;

import java.math.BigDecimal;

public record CurrencyConversionResponse(
        Long id,
        String from,
        String to,
        BigDecimal conversionMultiple,
        BigDecimal quantity,
        BigDecimal totalCalculatedAmount,
        String environment
) {
}
