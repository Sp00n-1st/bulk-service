package com.bulk.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bulk.service.dto.FailedResponse;
import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResponseEntityExceptionConfig extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {
    super.handleExceptionInternal(ex, body, headers, status, request);
    String msg = "";
    if (ex.getCause() != null) {
      msg = ex.getCause().getMessage();
    } else if (ex.getLocalizedMessage() != null) {
      msg = ex.getLocalizedMessage();
    }

    return ResponseEntity
        .status(status)
        .headers(headers)
        .body(body != null ? body
            : FailedResponse.builder()
                .code(status.value())
                .message(msg)
                .build());
  }

  @ExceptionHandler({
      Exception.class
  })
  protected ResponseEntity<Object> handleAnyOtherException(Exception ex, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    Object body = null;

    return this.handleExceptionInternal(ex, body, headers, status, request);
  }
}
