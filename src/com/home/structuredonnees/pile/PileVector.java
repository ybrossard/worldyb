package com.home.structuredonnees.pile;

import java.util.Vector;

import com.home.logs.Logs;

public class PileVector
{
 // Attributs
 Vector tableauChemins;
 int tailleMaximale;

 // Constructeurs
 public PileVector()
 {
  this.tableauChemins = new Vector();
  this.tailleMaximale = -1;
 }

 public PileVector(int tailleMaxFile)
 {
  this.tailleMaximale = tailleMaxFile;
  this.tableauChemins = new Vector(this.tailleMaximale);
 }

 // Methodes
 public boolean pileVide()
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

 public boolean pilePleine()
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

 public void empiler(String elementCourant)
 {
  try
  {
   if(!this.pilePleine())
   {
    this.tableauChemins.add(elementCourant.toString());
   }
  }
  catch(java.lang.ArrayIndexOutOfBoundsException aioobe)
  {
   Logs.writeLogFile("Erreur : La pile est pleine.");
  }
 }

 public String depiler()
 {
  if(!this.pileVide())
  {
   String elementADepiler = this.tableauChemins.lastElement().toString();
   this.tableauChemins.remove(this.tableauChemins.size() - 1);
   return elementADepiler;
  }
  else
  {
   Logs.writeLogFile("Erreur : La pile est vide.");
   return null;
  }
 }
}