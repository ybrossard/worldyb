package com.home.patterns.singleton;

public class Singleton
{
 // Attributs
 private static Singleton instance = null;

 private static String message = null;
 private static String champString = null;
 private static int champInt = 0;

 // Constructeur prive pour ne pas pouvoir instancier la classe depuis l'exterieur
 private Singleton(String message)
 {
  // L'initialisation n'est effectuee qu'une seule fois ici
  this.message = message;
  this.champString = "J'initialise un deuxième champ.";
  this.champInt = 24091972;
 }

 // Permet de recuperer l'unique instance de la classe de la classe Singleton
 public static Singleton getInstance(String message)
 {
  if(instance == null)
  {
   instance = new Singleton(message);
  }
   return instance;
 }

 // Getters du Singleton

 public String getMessage()
 {
  return this.message;
 }

 public String getChampString()
 {
  return this.champString;
 }

 public int getChampInt()
 {
  return this.champInt;
 }
}