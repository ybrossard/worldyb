package com.home.date;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtils
{
 // Conversion d'une date du type Date vers le type String (on specifie le format de la chaine en sorite)
 public static String convertDateToString(Date theDate,String formatInitial)
 {
  SimpleDateFormat formatter = new SimpleDateFormat(formatInitial);
  return formatter.format(theDate);
 }

 // Conversion d'une date du type String vers le type Date (en spécifiant le format de la chaine en entree)
 public static Date convertStringToDate(String chaineDate,String formatInitial)
 {
  SimpleDateFormat formatter = new SimpleDateFormat(formatInitial);
  java.text.ParsePosition pos = new java.text.ParsePosition(0);
  Date dateConvertie = formatter.parse(chaineDate,pos);
  return dateConvertie;
 }

 // Conversion d'une date du type String vers le type String (en modifiant le format de date)
 public static String convertStringDateToStringDate(String chaineDate,String formatInitial,String formatFinal)
 {
  SimpleDateFormat formatEntree = new SimpleDateFormat(formatInitial);
  // Conversion en une date temporaire au format Date
  java.text.ParsePosition pos = new java.text.ParsePosition(0);
  Date dateConvertie = formatEntree.parse(chaineDate,pos);

  // Reconversion de la date en une chaine au format final
  SimpleDateFormat formatSortie = new SimpleDateFormat(formatFinal);
  return formatSortie.format(dateConvertie);
 }
}