package com.dnslb.dnsloadblancer.RRDNS;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xbill.DNS.TextParseException;

@ControllerAdvice
public class ExeceptionHandling  {
    
    @ExceptionHandler(TextParseException.class)
    public ResponseEntity<Object> handleTextParseException(TextParseException ex) {
        return ResponseEntity
                .badRequest()
                .body("Invalid domain name or no records found: " + ex.getMessage());
    }
}
