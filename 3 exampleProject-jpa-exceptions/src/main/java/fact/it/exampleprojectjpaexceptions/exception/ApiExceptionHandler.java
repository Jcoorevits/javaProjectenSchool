package fact.it.exampleprojectjpaexceptions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        //Create Custom Response-object containing the exception-details
        HttpStatus notfound= HttpStatus.NOT_FOUND;
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                e.getMessage(),
                notfound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        //Return response entity
        return new ResponseEntity<>(apiExceptionErrorResponse, notfound);
    }
}
