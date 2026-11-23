package com.sesame.demo.commun;

// Une autre façon de réaliser le même contrat : envoi par SMS (simulé).
public class SmsNotificateur implements Notificateur {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[SMS] vers " + destinataire + " : " + message);
    }
}
