package com.home.ihm;

import javax.swing.JFrame;

// Attention : Les eventuels traitements lances depuis cette fenetre
// doivent etre lances dans leur propre Thread.

public class Fenetre extends JFrame
{
 public Fenetre()
 {
 }

 public Fenetre(String titre, int largeur, int hauteur)
 {
  this.setTitle(" " + titre);
  this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  Ecran.appliquerDimensions(this,largeur,hauteur);
 }
}