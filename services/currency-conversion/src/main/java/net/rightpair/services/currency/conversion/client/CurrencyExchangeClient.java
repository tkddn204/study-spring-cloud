package net.rightpair.services.currency.conversion.client;

import net.rightpair.services.currency.common.dto.CurrencyExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="currency-exchange", configuration = CurrencyExchangeClientConfig.class)
public interface CurrencyExchangeClient {
    @GetMapping("/currency/exchange")
    CurrencyExchangeResponse currencyExchange(@RequestParam String from, @RequestParam String to);
}
