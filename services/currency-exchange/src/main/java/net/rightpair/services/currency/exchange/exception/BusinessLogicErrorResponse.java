package net.rightpair.services.currency.exchange.exception;

public record BusinessLogicErrorResponse(
        String code,
        String message
) {
    public static BusinessLogicErrorResponse from(final String code, final String message) {
        return new BusinessLogicErrorResponse(code, message);
    }
}
