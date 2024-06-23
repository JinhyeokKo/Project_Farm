package farm.error.handler;

import farm.error.exception.CommentNotFoundException;
import farm.error.exception.InUsedUsernameException;
import farm.error.exception.MemberNotFoundException;
import farm.error.exception.MessageNotFoundException;
import farm.error.exception.NoPermissionException;
import farm.error.exception.PostNotFoundException;
import farm.error.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MemberNotFoundException.class, PostNotFoundException.class, CommentNotFoundException.class, MessageNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(RuntimeException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(NoPermissionException.class)
    protected ResponseEntity<Object> handleNoPermissionException(NoPermissionException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.FORBIDDEN.value());
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(InUsedUsernameException.class)
    protected ResponseEntity<Object> handleInUsedUsernameException(InUsedUsernameException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.CONFLICT.value());
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
