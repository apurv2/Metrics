package com.metrics.metrics.exceptionHandler;

import com.metrics.metrics.utils.MEUtils;
import javassist.tools.web.BadHttpRequest;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ErrorInfo handleException(Exception exception, HttpServletRequest request) {

        try {
            exception.printStackTrace();
            return new ErrorInfo(MEUtils.FAILURE, MEUtils.RESPONSE_EXCEPTION);
        } catch (Exception ex) {
            return new ErrorInfo(MEUtils.FAILURE, MEUtils.RESPONSE_EXCEPTION);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadHttpRequest.class)
    public ErrorInfo handleBadStudentException(Exception exception, HttpServletRequest request) {


        try {
            return new ErrorInfo(MEUtils.FAILURE, MEUtils.RESPONSE_EXCEPTION + "Invalid Arguments");
        } catch (Exception ex) {
            return new ErrorInfo(MEUtils.FAILURE, MEUtils.RESPONSE_EXCEPTION);
        }
    }
}
