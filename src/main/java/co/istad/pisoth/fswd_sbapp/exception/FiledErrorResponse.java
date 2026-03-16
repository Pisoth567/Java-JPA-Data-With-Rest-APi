package co.istad.pisoth.fswd_sbapp.exception;

public record FiledErrorResponse(
        String filed,
        String reason
) {
}