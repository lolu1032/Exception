package v1.exception.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import v1.exception.exception.CustomException;
import v1.exception.test.exception.CommonErrorCode;

@RestController
public class ExceptionController {

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
    @GetMapping("/test3")
    public String testWithExceptionHandler3() {
        try {
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
