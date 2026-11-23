package com.sesame.demo.commun;

// Une façon de réaliser le contrat : envoi par e-mail (simulé).
public class EmailNotificateur implements Notificateur {
    @Override
    public void envoyer(String destinataire, String message) {
        // On affiche simplement le message dans la console
        System.out.println("[EMAIL] vers " + destinataire + " : " + message);
    }
}