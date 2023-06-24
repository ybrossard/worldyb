package com.home.ihm;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ecran
{
 public Ecran()
 {
 }

 // Permet de recuper les dimensions de l'ecran quelle que soit la resolution
 public static Dimension getDimensionEcran()
 {
  Toolkit toolkit=Toolkit.getDefaultToolkit();
  Dimension dimension=toolkit.getScreenSize();
  return dimension;
 }

 // Permet de recuperer l'abscisse du centre de l'ecran en fonction de la resolution
 // et de la largeur de la fenetre appelante de cette methode
 public static int getPositionFenetreX(int largeur)
 {
  Double positionX=new Double( getDimensionEcran().getWidth() / 2 );
  return ( positionX.intValue() - largeur / 2 );
 }

 // Permet de recuperer l'ordonnee du centre de l'ecran en fonction de la resolution
 // et de la hauteur de la fenetre appelante de cette methode
 public static int getPositionFenetreY(int hauteur)
 {
  Double positionY=new Double( getDimensionEcran().getHeight() / 2 );
  return ( positionY.intValue() - hauteur / 2 );
 }

// Permet d'afficher une fenetre au centre de l'ecran a la taille voulue
 public static void appliquerDimensions(JFrame fenetre,int largeur,int hauteur)
 {
  fenetre.setBounds(
                    Ecran.getPositionFenetreX(largeur),
                    Ecran.getPositionFenetreY(hauteur),
                    largeur,
                    hauteur
                   );
 }

 // Permet d'afficher une fenetre en plein ecran
 public static void appliquerPleinEcran(JFrame fenetre)
 {
  fenetre.setBounds(
                    0,
                    0,
                    new Double(getDimensionEcran().getWidth()).intValue(),
                    new Double(getDimensionEcran().getHeight()).intValue()
                   );
 }
}