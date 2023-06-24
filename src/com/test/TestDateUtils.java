package com.test;

import java.util.Date;
import com.home.date.DateUtils;

import com.home.logs.Logs;

public class TestDateUtils
{
 public TestDateUtils()
 {
 }

 public static void main(String[] args)
 {
  // Obtention de la date courante
  Date theDate = new Date();
  Logs.logsAll("Date : " + theDate.toString());

  // Converion de la date au format 'dd/MM/yyyy'
  String chaineDateConvertie=DateUtils.convertDateToString(theDate, "dd/MM/yyyy");
  Logs.logsAll("Date convertie en chaine : " + chaineDateConvertie);

  // Conversion de la date au format String en un objet Date
  Date dateConvertie=DateUtils.convertStringToDate(chaineDateConvertie,"dd/MM/yyyy");
  Logs.logsAll("Date reconvertie en date : " + dateConvertie);

  // Conversion d'une chaine date en chaine date (en modifiant le format)
  String chaineDateReconvetie=DateUtils.convertStringDateToStringDate(chaineDateConvertie,"dd/MM/yyyy","dd-MM-yyyy");
  Logs.logsAll("Date reconvertie en chaine (changement de format) : " + chaineDateReconvetie);
 }
}
