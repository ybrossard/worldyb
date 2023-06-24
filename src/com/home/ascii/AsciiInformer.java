package com.home.ascii;

public class AsciiInformer
{
 // Constructeur
 public AsciiInformer()
 {
 }

 // Recuperation du code Ascii d'un char passe en parametre
 public static int getAsciiCode(char caractere)
 {
  return caractere;
 }

 // Recuperation du code Ascii d'une String passe en parametre
 public static int getAsciiCode(String caractere)
 {
  char caractereChar=caractere.charAt(0);
  return caractereChar;
 }
}