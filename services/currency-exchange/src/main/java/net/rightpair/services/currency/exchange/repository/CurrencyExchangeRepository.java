package net.rightpair.services.currency.exchange.repository;

import net.rightpair.services.currency.exchange.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    Optional<CurrencyExchange> findFirstByFromAndTo(String from, String to);
}
