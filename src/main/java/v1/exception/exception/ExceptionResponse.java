package v1.exception.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ExceptionResponse(
        String message,
        HttpStatus status
) {

}
