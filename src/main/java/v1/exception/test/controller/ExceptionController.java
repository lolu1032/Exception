package v1.exception.test.controller;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import v1.exception.exception.CustomException;
import v1.exception.test.exception.CommonErrorCode;

import java.util.Locale;

@RestController
public class ExceptionController {

    private final MessageSource messageSource;

    public ExceptionController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/error")
    public ResponseEntity<String> throwError() {
        String errorMessage = messageSource.getMessage("error.test.notfound", null, Locale.getDefault());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @GetMapping("/error2")
    public ResponseEntity<String> throwError2() {
        Object[] args = new Object[]{"김철수", "욕설"};
        String errorMessage = messageSource.getMessage("error.test.banned", args, Locale.getDefault());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    //    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String> exception(IllegalArgumentException e) {
//        return ResponseEntity.badRequest().body("지역" + e.getMessage());
//    }
    @GetMapping("/test1")
    public String testWithExceptionHandler() {
        throw new IllegalArgumentException("예외 발생 - test1");
    }

    @GetMapping("/test2")
    public String testWithExceptionHandler2() {
        throw new CustomException(CommonErrorCode.INVALID_INPUT);
    }
//    @GetMapping("/test3")
//    public String testWithExceptionHandler3() {
//        try {
//        } catch (IllegalArgumentException e) {
//            throw e;
//        }
//    }
}
