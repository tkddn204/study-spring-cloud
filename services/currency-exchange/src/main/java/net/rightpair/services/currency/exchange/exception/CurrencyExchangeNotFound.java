package net.rightpair.services.currency.exchange.exception;

public class CurrencyExchangeNotFound extends BusinessLogicException {
    public CurrencyExchangeNotFound() {
        super(ErrorCode.CURRENCY_EXCHANGE_NOT_FOUND);
    }
}
