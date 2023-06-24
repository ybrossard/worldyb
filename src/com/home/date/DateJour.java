package com.home.date;

import com.home.date.DateUtils;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class DateJour
{
 public DateJour()
 {
 }

 // Extraction de la date Systeme pour la concatener au nom du fichier TL de sortie
 public static String getStringDateForPostFixFile()
 {
  Calendar calendar = new GregorianCalendar();
  calendar.getTime();

  int dateJour=calendar.get(calendar.DATE);
  int moisJour=calendar.get(calendar.MONTH)+1;
  int anneeJour=calendar.get(calendar.YEAR);
  int heureJour=calendar.get(calendar.HOUR_OF_DAY);
  int minuteJour=calendar.get(calendar.MINUTE);
  int secondeJour=calendar.get(calendar.SECOND);

  return "_" + filtrageGauche(dateJour) + filtrageGauche(moisJour) + anneeJour + "_" + filtrageGauche(heureJour) + filtrageGauche(minuteJour) + filtrageGauche(secondeJour);
 }

 private static String filtrageGauche(int jourMois)
 {
  if(jourMois<10)
  {
   return "0" + jourMois;
  }
  else
  {
   return Integer.toString(jourMois);
  }
 }

 // Extraction de la date Systeme au format demande en argument
 public static String getStringDateJour(String formatDate)
 {
  Date dateCourante=new Date();
  String dateConvertie=DateUtils.convertDateToString(dateCourante,formatDate);
  return dateConvertie;
 }

 // Extraction de la date Systeme au format Date
 public static java.util.Date getDate()
 {
  java.util.Date theDate=new java.util.Date();
  return theDate;
 }
}