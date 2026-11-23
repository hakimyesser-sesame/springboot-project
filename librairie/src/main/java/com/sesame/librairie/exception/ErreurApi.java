package com.sesame.librairie.exception;

import java.util.Map;
public record ErreurApi(int statut, String message, Map<String, String> champs) {
}