package com.sesame.librairie.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;

import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
class LivreValidationTest {
    private final Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();
    @Test
    void livreValideNeProduitAucuneErreur() {
        Livre livre = new Livre(null, "Candide", "Voltaire", 1759);
        assertTrue(validator.validate(livre).isEmpty());
    }
    @Test
    void titreVideEstRefuse() {
        Livre livre = new Livre(null, "", "Voltaire", 1759);
        Set<ConstraintViolation<Livre>> erreurs = validator.validate(livre);
        assertEquals(1, erreurs.size());
        assertEquals("Le titre est obligatoire",
                erreurs.iterator().next().getMessage());
    }
    @Test
    void anneeNegativeEstRefusee() {
        Livre livre = new Livre(null, "Candide", "Voltaire", -5);
        assertEquals(1, validator.validate(livre).size());
    }
}