package com.sesame.demo.ioc;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
import com.sesame.demo.commun.SmsNotificateur;
public class AvecIoC {
    static class EmpruntService {
        // Le champ est du type INTERFACE : le service ignore si c'est
        // un e-mail ou un SMS. Et il ne fabrique rien lui-même.
        private final Notificateur notificateur;
        // L'outil est REÇU de l'extérieur, par le constructeur
        EmpruntService(Notificateur notificateur) {
            this.notificateur = notificateur;
        }
        void emprunter(String etudiant, String livre) {
            System.out.println("Emprunt enregistre : " + livre);
            notificateur.envoyer(etudiant, "Vous avez emprunte " + livre);
        }
    }
    public static void main(String[] args) {
        // C'est ICI que l'on choisit l'outil, pas dans le service
        EmpruntService parEmail = new EmpruntService(new EmailNotificateur());
        EmpruntService parSms = new EmpruntService(new SmsNotificateur());
        parEmail.emprunter("amine@sesame.tn", "Clean Code");
        parSms.emprunter("amine@sesame.tn", "Clean Code");
    }
}