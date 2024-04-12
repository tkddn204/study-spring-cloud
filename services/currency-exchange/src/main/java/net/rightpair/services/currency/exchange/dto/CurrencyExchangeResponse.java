package net.rightpair.services.currency.exchange.dto;

import net.rightpair.services.currency.exchange.entity.CurrencyExchange;

import java.math.BigDecimal;

public record CurrencyExchangeResponse (
        Long id,
        String from,
        String to,
        BigDecimal conversionMultiple,
        String environment
) {

    public static CurrencyExchangeResponse of(CurrencyExchange currencyExchange, String env) {
        return new CurrencyExchangeResponse(
                currencyExchange.getId(),
                currencyExchange.getFrom(),
                currencyExchange.getTo(),
                currencyExchange.getConversionMultiple(),
                env
        );
    }
}
