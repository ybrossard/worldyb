package com.home.cryptography;

import com.home.logs.Logs;

public class Cryptograph
{
 public Cryptograph()
 {
 }

 // Methode qui permet le cryptage d'une chaine de caracteres
 public static String cryptStringToString(String chaine)
 {
  StringBuffer chaineCryptee=new StringBuffer();

  for(int i=0;i<chaine.length();i++)
  {
   char caractereCourant = chaine.substring(i,i+1).charAt(0);
   chaineCryptee.append(crypt(caractereCourant,i));
  }
  return chaineCryptee.toString();
 }

 // Methode qui permet d'effecuter le codage du caractere selon sa position dans la chaine
 private static char crypt(char caractere,int index)
 {
  return (char) (caractere + index);
 }

 // Methode qui permet le decryptage d'une chaine de caracteres
 public static String uncryptStringToString(String chaine)
 {
  StringBuffer chaineCryptee=new StringBuffer();

  for(int i=0;i<chaine.length();i++)
  {
   char caractereCourant = chaine.substring(i,i+1).charAt(0);
   chaineCryptee.append(uncrypt(caractereCourant,i));
  }
  return chaineCryptee.toString();
 }

 // Methode qui permet d'effecuter le codage du caractere selon sa position dans la chaine
 private static char uncrypt(char caractere,int index)
 {
  return (char) (caractere - index);
 }
}