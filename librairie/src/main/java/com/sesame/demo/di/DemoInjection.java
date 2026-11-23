package com.sesame.demo.di;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
public class DemoInjection {
    // 1) L'employé du prêt : il a besoin d'un notificateur
    static class EmpruntService {
        private final Notificateur notificateur;
        EmpruntService(Notificateur notificateur) { // dépendance injectée
            this.notificateur = notificateur;
        }
        void emprunter(String etudiant, String livre) {
            System.out.println("Emprunt enregistre : " + livre);
            notificateur.envoyer(etudiant, "Vous avez emprunte " + livre);
        }
    }
    // 2) Le guichet : il a besoin de l'employé du prêt
    static class EmpruntController {
        private final EmpruntService service;
        EmpruntController(EmpruntService service) { // dépendance injectée
            this.service = service;
        }
        void demander(String etudiant, String livre) {
            System.out.println("Requete recue : " + livre);
            service.emprunter(etudiant, livre);
        }
    }
    // 3) Le main joue le rôle de la direction : il crée et il relie
    public static void main(String[] args) {
        // D'abord l'outil, puis l'employé, puis le guichet
        Notificateur notificateur = new EmailNotificateur();
        EmpruntService service = new EmpruntService(notificateur);
        EmpruntController controller = new EmpruntController(service);
        controller.demander("amine@sesame.tn", "Clean Code");
    }
}
