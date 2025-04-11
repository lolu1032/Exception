package v1.exception.test.exception;

import org.springframework.http.HttpStatus;
import v1.exception.exception.ErrorCode;

public enum CommonErrorCode implements ErrorCode {
    INVALID_INPUT("입력값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR("서버 내부 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);;

    private final String message;
    private final HttpStatus status;

    CommonErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public HttpStatus status() {
        return status;
    }
}
