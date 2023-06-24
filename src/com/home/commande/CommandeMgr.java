package com.home.commande;

import java.lang.Runtime;
import java.lang.Process;

import com.home.logs.Logs;

public class CommandeMgr
{
 public CommandeMgr()
 {
 }

 public static int launchCommand(String commande,boolean attenteProcess)
 {
  Runtime runtime = Runtime.getRuntime();
  int exitVal = 0;

  try
  {
   // Lancement de la commande
   Process processus = runtime.exec(commande);
   Logs.writeLogFile("Commande " + commande + " lancee.");

   if(attenteProcess)
   {
    try
    {
     exitVal = processus.waitFor();
     Logs.writeLogFile("Valeur de retour du process " + commande + " : " + exitVal);
    }
    catch(java.lang.InterruptedException ie)
    {
     Logs.writeLogFile("Erreur : Impossible d'attendre la fin du processus lance.");
    }
   }
  }
  catch(java.io.IOException ioe)
  {
   Logs.writeLogFile("Erreur : Impossible de lancer la commande : " + commande +".");
  }
  return exitVal;
 }
}