package net.rightpair.services.currency.exchange.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    CURRENCY_EXCHANGE_NOT_FOUND("해당 currency exchange를 찾을 수 없습니다."),

    ;
    private final String message;
}
