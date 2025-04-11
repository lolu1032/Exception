package v1.exception.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> exception(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();

        ExceptionResponse error = ExceptionResponse.builder()
                .status(errorCode.status())
                .message(errorCode.message())
                .build();

        return ResponseEntity
                .status(errorCode.status())
                .body(error);
    }
}
