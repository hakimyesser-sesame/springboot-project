package com.sesame.librairie.exception;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
@RestControllerAdvice
public class GestionnaireErreurs {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErreurApi> donneesInvalides(MethodArgumentNotValidException
                                                              ex) {
        Map<String, String> champs = new TreeMap<>();
        for (FieldError erreur : ex.getBindingResult().getFieldErrors()) {
            champs.put(erreur.getField(), erreur.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(new ErreurApi(400, "Données invalides", champs));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErreurApi> jsonIllisible(HttpMessageNotReadableException
                                                           ex) {
        return ResponseEntity.badRequest().body(new ErreurApi(400, "Corps de la requête illisible", Map.of()));
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErreurApi> typeInvalide(MethodArgumentTypeMismatchException
                                                          ex) {
        return ResponseEntity.badRequest().body(new ErreurApi(400, "Paramètre invalide : " + ex.getName(), Map.of()));
    }
}