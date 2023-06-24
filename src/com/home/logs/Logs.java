package com.home.logs;

import com.home.date.DateJour;

import com.home.fichiers.Fichier;

import com.home.configuration.ConfigurationMgr;

import com.home.date.DateJour;

public class Logs
{
 // Format de la date du jour a inclure dans le fichier de logs
 public static final String FORMAT_DATE_LOGS = "dd/MM/yyyy - HH':'mm':'ss";

 public Logs()
 {
 }

 // Ecrit un message de log sur la sortie standard
 public static void writeLog(String messageLog)
 {
  // Recuperation de la date et de l'heure Systeme sous forme de String
  String dateSysteme = DateJour.getStringDateJour(FORMAT_DATE_LOGS);
  System.out.println(dateSysteme + " ==> " + messageLog);
 }

 public static void writeLogFile(String messageLog)
 {
  // Creation logique du fichier de log
  Fichier fichierLog = new Fichier(
                                   ConfigurationMgr.getParameterValue("CHEMIN_FICHIER_LOG")
                                   +
                                   ConfigurationMgr.getParameterValue("PREFIXE_FICHIER_LOG")
                                   +
                                   "_"
                                   +
                                   DateJour.getStringDateJour("ddMMyyyy")
                                   +
                                   ".log"
                                   ,false);
  if(!fichierLog.isFileExistsOnDisk())
  {
   fichierLog.creationFichier();
  }

  // Recuperation de la date et de l'heure Systeme sous forme de String
  String dateSysteme = DateJour.getStringDateJour(FORMAT_DATE_LOGS);
  fichierLog.appendDataInFile(dateSysteme + " ==> " + messageLog + "\n");
 }

 public static void logsAll(String messageLog)
 {
  writeLog(messageLog);
  writeLogFile(messageLog);
 }
}