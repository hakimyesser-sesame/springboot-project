package com.sesame.demo.commun;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
public final class Outils {
    private Outils() { } // classe utilitaire : on ne la crée jamais avec new
    // Réduit les messages techniques de Spring : on ne garde que les
    // avertissements, pour bien lire nos propres messages.
    public static void silence() {
        Logger racine = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        racine.setLevel(Level.WARN);
    }
    // Renvoie la liste triée des beans de notre programme, par exemple
    // "[config, notificateur]". On retire les beans internes de Spring.
    public static String beans(ApplicationContext ctx) {
        return Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(nom -> !nom.startsWith("org.springframework"))
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }
}