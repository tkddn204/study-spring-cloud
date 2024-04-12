package net.rightpair.services.currency.common.dto;

import java.math.BigDecimal;

public record CurrencyExchangeResponse (
        Long id,
        String from,
        String to,
        BigDecimal conversionMultiple,
        String environment
) {
}
