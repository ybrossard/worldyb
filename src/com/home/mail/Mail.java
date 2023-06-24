package com.home.mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail
{
 // Attributs
 private String serveurMessagerie = null;
 private String adresseEmetteur = null;
 private String adresseDestinataire = null;
 private String sujetMessage = null;
 private String corpsMessage = null;
 private String fichierMessage = null;

 // Méthodes
 public Mail()
 {
 }

 public Mail(String serveurMessagerie, String adresseEmetteur, String adresseDestinataire, String sujetMessage, String corpsMessage, String fichierMessage)
 {
  this.serveurMessagerie = serveurMessagerie;
  this.adresseEmetteur = adresseEmetteur;
  this.adresseDestinataire = adresseDestinataire;
  this.sujetMessage = sujetMessage;
  this.corpsMessage = corpsMessage;
  this.fichierMessage = fichierMessage;
 }

 // Obtention d'une session sur le serveur de messagerie
 public Session getSession(String serveurMessagerie) throws Exception
 {
  // Get system properties
  java.util.Properties props = System.getProperties();

  // Setup mail server
  props.put("mail.smtp.host", serveurMessagerie);

  // Get session
  return Session.getDefaultInstance(props, null);
 }

 public void sendMail() throws Exception
 {
  String nomServeurMessagerie = this.serveurMessagerie;
  String adreseEmetteur = this.adresseEmetteur;
  String adresseRecepteur = this.adresseDestinataire;
  String sujetMessage = this.sujetMessage;
  String corpsMessage = this.corpsMessage;
  String fichierMessage = this.fichierMessage;

  // Define message
  MimeMessage message = new MimeMessage(this.getSession(serveurMessagerie));

  // Definition de l'adresse de l'emetteur du message
  message.setFrom(new InternetAddress(adreseEmetteur));

  // Definition de l'adresse du destinataire du message
  message.addRecipient(Message.RecipientType.TO,new InternetAddress(adresseRecepteur));

  // Definition du sujet du message
  message.setSubject(sujetMessage);

  // Definition du coprs du message
  message.setText(corpsMessage);

  // Ajout d'un fichier attache
  message.setFileName(this.fichierMessage);

  // Send message
  Transport.send(message);
  this.displayMessage();
 }

 public void displayMessage()
 {
  String time = null;
  java.util.Date theDate = new java.util.Date();
  java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
  time = formatter.format(theDate);

  System.out.println("\n");
  System.out.println("<message date=\"" + time + "\">");
  System.out.println(" <serveur-messagerie>" + this.serveurMessagerie + "</serveur-messagerie>");
  System.out.println(" <emetteur>" + this.adresseEmetteur + "</emetteur>");
  System.out.println(" <destinataire>" + this.adresseDestinataire + "</destinataire>");
  System.out.println(" <sujet>" + this.sujetMessage + "</sujet>");
  System.out.println(" <corps>" + this.corpsMessage + "</corps>");
  System.out.println(" <fichier>" + this.fichierMessage + "</fichier>");
  System.out.println("</message>");
 }
}