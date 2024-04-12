package net.rightpair.services.currency.exchange.controller;

import lombok.RequiredArgsConstructor;
import net.rightpair.services.currency.common.dto.CurrencyExchangeResponse;
import net.rightpair.services.currency.exchange.service.CurrencyExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency/exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping
    public ResponseEntity<CurrencyExchangeResponse> retrieveExchangeValue(
            @RequestParam String from,
            @RequestParam String to
    ) {
        return ResponseEntity.ok(currencyExchangeService.getCurrencyExchangeByFromAndTo(from, to));
    }
}
