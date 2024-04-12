package net.rightpair.services.currency.conversion.repository;

import net.rightpair.services.currency.conversion.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRespository extends JpaRepository<CurrencyConversion, Long> {
}
