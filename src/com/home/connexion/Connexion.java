package com.home.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

import com.home.logs.Logs;

public class Connexion
{
 public Connexion()
 {
 }

 public static Connection getDataBaseConnexion(String driver,String url,String user,String password)
 {
  Connection connexion=null;

  try
  {
   Class.forName(driver);
   try
   {
    connexion=DriverManager.getConnection(url,user,password);
    Logs.writeLogFile("Connexion etable avec succes : " + connexion);
   }
   catch(java.sql.SQLException sqle)
   {
    Logs.writeLogFile("Erreur : Impossible d'etablir une connexion aupres de la base de donnees.");
   }
  }
  catch(java.lang.ClassNotFoundException cnfe)
  {
   Logs.writeLogFile("Erreur : Impossible d'enregistrer le driver de base de donnnes.");
  }
  return connexion;
 }
}