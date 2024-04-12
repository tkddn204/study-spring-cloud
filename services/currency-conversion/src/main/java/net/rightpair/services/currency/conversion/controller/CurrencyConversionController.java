package net.rightpair.services.currency.conversion.controller;

import lombok.RequiredArgsConstructor;
import net.rightpair.services.currency.common.dto.CurrencyConversionResponse;
import net.rightpair.services.currency.conversion.client.CurrencyExchangeClient;
import net.rightpair.services.currency.conversion.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency/conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    private final CurrencyExchangeClient currencyExchangeClient;

    @GetMapping
    public ResponseEntity<CurrencyConversionResponse> calculateCurrencyConversion(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal quantity
    ) {
        var multiple = currencyExchangeClient.currencyExchange(from, to).conversionMultiple();
        return ResponseEntity.ok(currencyConversionService.calculateCurrencyConversion(from, to, multiple, quantity));
    }
}
