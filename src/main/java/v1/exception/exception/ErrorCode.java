package v1.exception.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String message();
    HttpStatus status();
}
