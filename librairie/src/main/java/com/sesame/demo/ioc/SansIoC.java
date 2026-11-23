package com.sesame.demo.ioc;

import com.sesame.demo.commun.EmailNotificateur;
public class SansIoC {
    // L'employé du prêt (classe imbriquée, pour tout garder dans un fichier)
    static class EmpruntService {
        // PROBLÈME : le service fabrique lui-même son outil, avec new.
        // Il est collé à EmailNotificateur : impossible d'en changer.
        private final EmailNotificateur notificateur = new EmailNotificateur();
        void emprunter(String etudiant, String livre) {
            System.out.println("Emprunt enregistre : " + livre);
            notificateur.envoyer(etudiant, "Vous avez emprunte " + livre);
        }
    }
    public static void main(String[] args) {
        // On crée le service et on enregistre un emprunt
        new EmpruntService().emprunter("amine@sesame.tn", "Clean Code");
    }
}
