package com.home.structuredonnees.pile;

import java.util.Vector;

import com.home.logs.Logs;

public class PileTableau
{
 // Attributs
 String[] tableauChemins;
 int taillePile;
 int indiceCourantPile;

 // Constructeur
 public PileTableau(int tailleMaxPile)
 {
  this.taillePile = tailleMaxPile;
  tableauChemins = new String[this.taillePile];
 }

 // Methodes
 public boolean pileVide()
 {
  if(this.indiceCourantPile == 0)
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
  if(this.indiceCourantPile == this.taillePile)
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
  if(!this.pilePleine())
  {
   tableauChemins[this.indiceCourantPile] = new String(elementCourant);
   this.indiceCourantPile++;
  }
  else
  {
   Logs.writeLogFile("Erreur : La Pile est pleine.");
  }
 }

 public String depiler()
 {
  if(!this.pileVide())
  {
   this.indiceCourantPile--;
   String elementADepiler = tableauChemins[this.indiceCourantPile];
   tableauChemins[this.indiceCourantPile]=null;
   return elementADepiler;
  }
  else
  {
   Logs.writeLogFile("Erreur : La pile est vide.");
   return null;
  }
 }
}