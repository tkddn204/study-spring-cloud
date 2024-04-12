package net.rightpair.services.currency.exchange.mapper;

import net.rightpair.services.currency.common.dto.CurrencyExchangeResponse;
import net.rightpair.services.currency.exchange.entity.CurrencyExchange;

public class CurrencyExchangeResponseMapper {
    public static CurrencyExchangeResponse map(CurrencyExchange currencyExchange, String env) {
        return new CurrencyExchangeResponse(
                currencyExchange.getId(),
                currencyExchange.getFrom(),
                currencyExchange.getTo(),
                currencyExchange.getConversionMultiple(),
                env
        );
    }
}
