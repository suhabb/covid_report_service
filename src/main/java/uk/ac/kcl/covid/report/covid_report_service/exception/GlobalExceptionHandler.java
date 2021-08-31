package uk.ac.kcl.covid.report.covid_report_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.ac.kcl.covid.report.covid_report_service.error.ErrorDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> buildException(Exception exception){
        ErrorDto errorDto = new ErrorDto.Builder()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .setDescription("Error in operation")
                .setTitle("The service is down.Please try again later..")
                .build();
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
