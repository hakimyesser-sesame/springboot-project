package com.sesame.demo.conteneur;

import com.sesame.demo.commun.Outils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class DemoConteneur {
    public static void main(String[] args) {
        Outils.silence();
        System.out.println("Demarrage du conteneur...");
        // 1) On DÉMARRE le conteneur avec la recette (Config).
        // Spring crée tous les beans dans cette seule ligne.
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(Config.class)) {
            System.out.println("Conteneur pret. Beans : " + Outils.beans(ctx));
            // 2) On DEMANDE un bean au conteneur (on ne fait pas new)
            EmpruntController controller = ctx.getBean(EmpruntController.class);
            controller.demander("amine@sesame.tn", "Clean Code");
        } // 3) À la fin du bloc, le conteneur est fermé automatiquement
    }
}