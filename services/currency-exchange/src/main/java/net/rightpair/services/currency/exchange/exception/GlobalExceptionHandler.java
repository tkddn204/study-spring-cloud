package net.rightpair.services.currency.exchange.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<BusinessLogicErrorResponse> handleBusinessLogicException(final BusinessLogicException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest()
                .body(BusinessLogicErrorResponse.from(String.valueOf(e.getErrorCode()), e.getMessage()));
    }
}
