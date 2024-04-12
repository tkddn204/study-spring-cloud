package net.rightpair.services.currency.exchange.exception;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {
    protected ErrorCode errorCode;
    protected BusinessLogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
