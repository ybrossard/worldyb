package com.test;

import com.home.mail.Mail;

import com.home.logs.Logs;

public class TestMail
{
 public TestMail()
 {
 }

 public static void main(String args[])
 {
  Mail mail = new Mail(
                       "smtp.wanadoo.fr",
                       "ybrossard@wanadoo.fr",
                       "caroline.waron@wanadoo.fr",
                       "Piratage d'une autre messagerie.",
                       "Ce message demontre que l'on peut pirater une autre messagerie.",
                       "D:\\WorldYB\\conf\\Fichier.txt"
                      );
  try
  {
   mail.sendMail();
  }
  catch(java.lang.Exception exception)
  {
   Logs.logsAll("Erreur : Envoi du mail.");
  }
 }
}