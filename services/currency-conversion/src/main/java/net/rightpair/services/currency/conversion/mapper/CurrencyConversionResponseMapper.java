package net.rightpair.services.currency.conversion.mapper;

import net.rightpair.services.currency.common.dto.CurrencyConversionResponse;
import net.rightpair.services.currency.conversion.entity.CurrencyConversion;

public class CurrencyConversionResponseMapper {
    public static CurrencyConversionResponse map(CurrencyConversion currencyConversion, String env) {
        return new CurrencyConversionResponse(
                currencyConversion.getId(),
                currencyConversion.getFrom(),
                currencyConversion.getTo(),
                currencyConversion.getConversionMultiple(),
                currencyConversion.getQuantity(),
                currencyConversion.getTotalCalculatedAmount(),
                env
        );
    }
}
