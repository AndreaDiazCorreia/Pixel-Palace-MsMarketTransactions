package com.pixelpalace.msMarketTransactions.config;

import com.pixelpalace.msMarketTransactions.dto.ErrorDTO;
import com.pixelpalace.msMarketTransactions.dto.MessageDTO;
import com.pixelpalace.msMarketTransactions.exception.CategoryNotFoundException;
import com.pixelpalace.msMarketTransactions.exception.EmptyProductsException;
import com.pixelpalace.msMarketTransactions.exception.PlatformNotFoundException;
import com.pixelpalace.msMarketTransactions.exception.ProductNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundException(Exception e) {
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(PlatformNotFoundException.class)
    public ResponseEntity<?> platformNotFoundException(Exception e) {
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> categoryNotFoundException(Exception e) {
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(EmptyProductsException.class)
    public ResponseEntity<?> emptyProductsException(Exception e) {
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> capturandoValidaciones(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO(
                        "Se encontraron los siguientes errores en las validaciones: ",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
                )
        );
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> capturandoValidaciones(HttpMessageNotReadableException e) {
        MessageDTO errorDto = new MessageDTO(e.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> validationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO(
                        "Se encontraron los siguientes errores en las validaciones: ",
                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )
        );
    }
}

