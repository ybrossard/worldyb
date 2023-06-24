package com.home.string;

import java.util.StringTokenizer;

import com.home.logs.Logs;

public class StringUtils
{
 // Attributs
 private static String [] chaineSplitee = null;

 public StringUtils()
 {
 }

 // Splite une chaine de caracteres selon le separateur passe en argument
 public static String [] splitString(String chaine, String separateur)
 {
  StringTokenizer stringTokenizer = new StringTokenizer(chaine,separateur);
  chaineSplitee = new String[stringTokenizer.countTokens()];

  int i=0;
  while(stringTokenizer.hasMoreTokens())
  {
   chaineSplitee[i] = stringTokenizer.nextToken();
   i++;
  }
  return chaineSplitee;
 }

 // Methode qui affiche le contenu de la chaine splitee (pour debuger)
 public static void checkSplitString()
 {
  for(int i=0;i<chaineSplitee.length;i++)
  {
   Logs.logsAll(chaineSplitee[i]);
  }
 }

 // Methode qui retourne la sous-chaine comprise entre les deux separateurs (les separateurs sont des String)
 public static String subString(String separateurDebut, String chaine, String separateurFin)
 {
  if(chaine.indexOf(separateurDebut) != -1 && chaine.indexOf(separateurFin) != -1)
  {
   String chaineTemporaire = chaine.substring(0,chaine.indexOf(separateurFin));
   return chaineTemporaire.substring(chaineTemporaire.indexOf(separateurDebut) + 1,chaineTemporaire.length());
  }
  else
  {
   return chaine;
  }
 }

 // Methode qui retourne la sous-chaine comprise entre les deux separateurs (les separateurs sont des char)
 public static String subString(char separateurDebut, String chaine, char separateurFin)
 {
  if(chaine.indexOf(separateurDebut) != -1 && chaine.indexOf(separateurFin) != -1)
  {
   String chaineTemporaire = chaine.substring(0,chaine.indexOf(separateurFin));
   return chaineTemporaire.substring(chaineTemporaire.indexOf(separateurDebut) + 1,chaineTemporaire.length());
  }
  else
  {
   return chaine;
  }
 }

 // Methode qui permet de retourner une sous-chaine extraite entre le debut
 // de celle-ci et le separateur de fin passe en argument de la methode (le separateur peut etre lui meme une chaine)
 public static String subStringLeft(String chaine, String separateurFin)
 {
  if(chaine.indexOf(separateurFin) != -1)
  {
   return chaine.substring(0,chaine.indexOf(separateurFin));
  }
  else
  {
   return chaine;
  }
 }

 // Methode qui permet de retourner une sous-chaine extraite entre le separateur de debut
 // passe en argument de la methode (le separateur peut etre lui meme une chaine) la fin de la chaine
 public static String subStringRight(String separateurDebut, String chaine)
 {
  if(chaine.indexOf(separateurDebut) != -1)
  {
   return chaine.substring(chaine.indexOf(separateurDebut) + 1,chaine.length());
  }
  else
  {
   return chaine;
  }
 }

 // Methode qui simule l'expression suivante ==> (A == B ? "C" : "D")
 // Elle retourne la valeur normale d'une chaine de caracteres ou une valeur par defaut si celle-ci est vide
 public static String getStringOrDefaultValue(String valeurChaine,String valeurDefaut)
 {
  if(valeurChaine.compareTo("") != 0)
  {
   return valeurChaine;
  }
  else
  {
   return valeurDefaut;
  }
 }
}