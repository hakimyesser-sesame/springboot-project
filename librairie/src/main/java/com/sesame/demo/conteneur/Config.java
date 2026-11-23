package com.sesame.demo.conteneur;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Cette classe décrit les beans : c'est la "liste des postes" de la direction
@Configuration
public class Config {
    // Poste 1 : le notificateur (e-mail)
    @Bean
    public Notificateur notificateur() {
        System.out.println("Creation de Notificateur");
        return new EmailNotificateur();
    }
    // Poste 2 : le service. Il demande un Notificateur en paramètre :
    // Spring le fournit (c'est l'injection).
    @Bean
    public EmpruntService empruntService(Notificateur notificateur) {
        return new EmpruntService(notificateur);
    }
    // Poste 3 : le contrôleur. Il demande le service en paramètre.
    @Bean
    public EmpruntController empruntController(EmpruntService empruntService) {
        return new EmpruntController(empruntService);
    }
}