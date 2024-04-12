package net.rightpair.services.currency.conversion.service;

import lombok.RequiredArgsConstructor;
import net.rightpair.services.currency.common.dto.CurrencyConversionResponse;
import net.rightpair.services.currency.conversion.entity.CurrencyConversion;
import net.rightpair.services.currency.conversion.mapper.CurrencyConversionResponseMapper;
import net.rightpair.services.currency.conversion.repository.CurrencyConversionRespository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

    private final Environment environment;
    private final CurrencyConversionRespository currencyConversionRespository;

    public CurrencyConversionResponse calculateCurrencyConversion(String from,
                                                                  String to,
                                                                  BigDecimal multiple,
                                                                  BigDecimal quantity) {
        var env = "%s : %s".formatted(environment.getProperty("server.port"), environment.getActiveProfiles()[0]);
        var totalCalculatedAmount = quantity.multiply(multiple).divide(BigDecimal.valueOf(100L), RoundingMode.CEILING);
        var savedCurrencyConversion = currencyConversionRespository.save(
                new CurrencyConversion(from, to, multiple, quantity, totalCalculatedAmount));
        return CurrencyConversionResponseMapper.map(savedCurrencyConversion, env);
    }
}
