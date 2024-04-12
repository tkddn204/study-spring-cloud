package net.rightpair.services.currency.exchange.service;

import lombok.RequiredArgsConstructor;
import net.rightpair.services.currency.common.dto.CurrencyExchangeResponse;
import net.rightpair.services.currency.exchange.exception.CurrencyExchangeNotFound;
import net.rightpair.services.currency.exchange.mapper.CurrencyExchangeResponseMapper;
import net.rightpair.services.currency.exchange.repository.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private final Environment environment;
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeResponse getCurrencyExchangeByFromAndTo(String from, String to) {
        var env = environment.getProperty("server.port");
        return currencyExchangeRepository.findFirstByFromAndTo(from, to)
                .map(ce -> CurrencyExchangeResponseMapper.map(ce, env))
                .orElseThrow(CurrencyExchangeNotFound::new);
    }
}
