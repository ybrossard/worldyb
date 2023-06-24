package com.home.structuredonnees.file;

import java.util.Vector;

import com.home.logs.Logs;

public class FileTableau
{
 // Attributs
 String[] tableauChemins;
 int tailleFile;
 int indiceCourantFile;

 // Constructeur
 public FileTableau(int tailleMaxFile)
 {
  this.tailleFile = tailleMaxFile;
  tableauChemins = new String[this.tailleFile];
 }

 // Methodes
 public boolean fileVide()
 {
  if(this.indiceCourantFile == 0)
  {
   return true;
  }
  else
  {
   return false;
  }
 }

 public boolean filePleine()
 {
  if(this.indiceCourantFile == this.tailleFile)
  {
   return true;
  }
  else
  {
   return false;
  }
 }

 public void enfiler(String elementCourant)
 {
  if(!this.filePleine())
  {
   tableauChemins[this.indiceCourantFile] = new String(elementCourant);
   this.indiceCourantFile++;
  }
  else
  {
   Logs.writeLogFile("Erreur : La file est pleine.");
  }
 }

 public String defiler()
 {
  if(!this.fileVide())
  {
   String elementADefiler = tableauChemins[0];
   this.indiceCourantFile--;

   for(int i=0;i<this.indiceCourantFile;i++)
   {
    tableauChemins[i] = new String(tableauChemins[i+1]);
   }
   tableauChemins[this.indiceCourantFile]=null;
   return elementADefiler;
  }
  else
  {
   Logs.writeLogFile("Erreur : La file est vide.");
   return null;
  }
 }
}