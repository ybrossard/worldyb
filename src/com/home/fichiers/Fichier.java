package com.home.fichiers;

import java.io.File;

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.home.logs.Logs;

public class Fichier
{
 // Attributs
 private String cheminFichier=null;
 private File fichier=null;

 // Creation d'un nouveau fichier avec possibilte de le creer physiquement sur le disque
 public Fichier(String cheminFichier,boolean creation)
 {
  this.cheminFichier=cheminFichier;
  if(creation)
  {
   try
   {
    fichier=new File(cheminFichier);
    fichier.createNewFile();
    Logs.writeLogFile("Fichier " + cheminFichier + " cree.");
   }
   catch(java.io.IOException ioe)
   {
    Logs.writeLogFile("Erreur : Fichier non cree.");
   }
  }
  else
  {
   fichier=new File(cheminFichier);
  }
 }

 // Creation du fichier au cas ou il ne le serait pas deja
 public void creationFichier()
 {
  try
  {
   this.fichier.createNewFile();
   Logs.writeLogFile("Fichier " + cheminFichier + " cree.");
  }
  catch(java.io.IOException ioe)
  {
   Logs.writeLogFile("Erreur : Impossible de creer le fichier.");
  }
 }

 // Retourne le chemin du fichier

 public String getCheminFichier()
 {
  return this.cheminFichier;
 }

 // Teste si le fichier existe physiquement sur le disque
 public boolean isFileExistsOnDisk()
 {
  boolean OK=false;

  if(this.fichier.exists())
  {
   OK=true;
  }
  return OK;
 }

 // Ecrit un flux de donnees dans le fichier en une seule fois
 public void ecrireFlux(String flux)
 {
  try
  {
   PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(this.cheminFichier)));
   out.println(flux);
   out.close();
  }
  catch(IOException ioe)
  {
   Logs.writeLogFile("Erreur : Impossible d'ecrire dans le fichier.");
  }
 }

 // Ecrit un flux de donnees en mode append dans le fichier texte
 public void appendDataInFile(String messageLog)
 {
  try
  {
   FileWriter accesseurFichier = new FileWriter(this.getCheminFichier(),true);
   accesseurFichier.write(messageLog);
   accesseurFichier.close();
   }
   catch(IOException ioe)
   {
    Logs.writeLogFile("Erreur : Impossible d'ecrire dans le fichier en mode append.");
   }
 }
}