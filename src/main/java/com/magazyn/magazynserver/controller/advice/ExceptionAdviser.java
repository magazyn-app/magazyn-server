package com.magazyn.magazynserver.controller.advice;

import com.magazyn.magazynserver.exception.ItemTypeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdviser {

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = ItemTypeNotFoundException.class)
    protected ResponseEntity<Object> handleItemTypeNotFoundException(ItemTypeNotFoundException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
