package com.home.commande;

import com.home.configuration.ConfigurationMgr;

import com.home.structuredonnees.file.FileVector;

import java.io.File;

import com.home.logs.Logs;

public class TreeCommandeMgr extends CommandeMgr
{
 public TreeCommandeMgr()
 {
 }

 public static void launchTreeCommand()
 {
  String cheminBase=null;
  String commandeAppelSysteme=null;
  String commandeBase=null;
  String arguments=null;

  // Extraction des parametres du fichier d'entree

  cheminBase = ConfigurationMgr.getParameterValue("REPERTOIRE_ENTREE");
  Logs.writeLogFile("Chemin de base detecte   : '" + cheminBase + "'");

  commandeAppelSysteme = ConfigurationMgr.getParameterValue("COMMANDE_APPEL_SYSTEME");
  commandeBase = ConfigurationMgr.getParameterValue("COMMANDE_BASE");
  arguments = ConfigurationMgr.getParameterValue("ARGUMENTS");

  FileVector file = new FileVector();
  file.enfiler(cheminBase);

  // Traitement a proprement parler

  while(!file.fileVide())
  {
   // Extraction de la pile du chemin a traiter
   String cheminCourant=file.defiler();
   Logs.writeLogFile("Chemin courant : " + cheminCourant);

   // Preparation de la commande a executer
   String commande = commandeAppelSysteme + " " + commandeBase + " \"" + cheminCourant + arguments + "\"";

  // Execution de la commande a lancer
  launchCommand(commande,false); /* Methode heritee de la classe CommandeMgr */
  Logs.writeLogFile("Commande executee     : " + commande);

   // Exploration des sous-repertoires du repertoire courant
   File fichierAbstrait=new File(cheminCourant);
   String [] listeRepertoires = fichierAbstrait.list();

   // Enfilement des repertoires trouves dans la file
   for(int i=0;i<listeRepertoires.length;i++)
   {
    if(new File(cheminCourant + "\\" + listeRepertoires[i]).isDirectory())
    {
     file.enfiler(cheminCourant + "\\" + listeRepertoires[i]);
    }
   } /* Fin for */
   } /* Fin while */
 }
}