package com.home.utils;

public class Utils
{
 public Utils()
 {
 }

 // Methode qui retourne la representation entiere d'un boolean sous forme d'une chaine
 public static String convertBooleanToStringInteger(boolean b)
 {
  if(b)
  {
   return "1";
  }
  else
  {
   return "0";
  }
 }
}