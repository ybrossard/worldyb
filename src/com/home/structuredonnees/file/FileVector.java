package com.home.structuredonnees.file;

import java.util.Vector;

import com.home.logs.Logs;

public class FileVector
{
 // Attributs
 Vector tableauChemins;
 int tailleMaximale;

 // Constructeurs
 public FileVector()
 {
  this.tableauChemins = new Vector();
  this.tailleMaximale = -1;
 }

 public FileVector(int tailleMaxFile)
 {
  this.tailleMaximale = tailleMaxFile;
  this.tableauChemins = new Vector(this.tailleMaximale);
 }

 // Methodes
 public boolean fileVide()
 {
  if(this.tableauChemins.size() == 0)
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
  if(this.tableauChemins.size() == this.tailleMaximale)
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
  try
  {
   if(!this.filePleine())
   {
    this.tableauChemins.add(elementCourant.toString());
   }
  }
  catch(java.lang.ArrayIndexOutOfBoundsException aioobe)
  {
   Logs.writeLogFile("Erreur : La file est pleine.");
  }
 }

 public String defiler()
 {
  if(!this.fileVide())
  {
   String elementADefiler = this.tableauChemins.firstElement().toString();
   this.tableauChemins.remove(0);
   return elementADefiler;
  }
  else
  {
   Logs.writeLogFile("Erreur : La file est vide.");
   return null;
  }
 }
}