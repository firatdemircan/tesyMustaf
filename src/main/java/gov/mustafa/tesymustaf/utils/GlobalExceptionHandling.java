package gov.mustafa.tesymustaf.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>("Maalesef Kişi Bulunamadı",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TmoEntityNotFoundException.class)
    public ResponseEntity<String> handleTmoEntityNotFoundException(TmoEntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }


}
