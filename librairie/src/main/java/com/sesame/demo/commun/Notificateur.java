package com.sesame.demo.commun;

// Un "contrat" : tout notificateur sait envoyer un message à quelqu'un.
// L'interface dit CE QUE l'on fait, jamais COMMENT on le fait.
public interface Notificateur {
    void envoyer(String destinataire, String message);
}
