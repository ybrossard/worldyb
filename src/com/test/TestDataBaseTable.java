package com.test;

import com.home.configuration.ConfigurationMgr;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import com.home.databasetable.DataBaseTable;

import com.home.logs.Logs;

public class TestDataBaseTable
{
 public TestDataBaseTable()
 {
 }

 public static void main(String[] args)
 {
  Connection connexion=null;

  try
  {
   // Enregistrement du driver de la base de donnes
   Class.forName(ConfigurationMgr.getParameterValue("SGBD_DRIVER_SYBASE"));

   try
   {
    // Obtention d'une connexion aupres de la base de donnees DS_IDEE_INT
    connexion=DriverManager.getConnection(ConfigurationMgr.getParameterValue("SGBD_URL_DS_IDEE_INT"),ConfigurationMgr.getParameterValue("SGBD_USER_DS_IDEE_INT"),ConfigurationMgr.getParameterValue("SGBD_PWD_DS_IDEE_INT"));
    Logs.logsAll("Recuperation d'une connexion OK (" + connexion + ")");

    // Lancement d'un traitement sur la base de donnees
    DataBaseTable.updateDataBaseTable(connexion,"UPDATE CL_SR_ANNONCE SET USR_FULL_NAME='GESTMO' WHERE USR_FULL_NAME='Yann'","CL_SR_ANNONCE",true);

    // Lancement d'une suppression de table sur la base de donnees DS_IDEE_INT
    DataBaseTable.dropDataBaseTable(connexion,"TABLE_YB",true);

    // Creation d'une nouvelle table en base de donnees
    java.util.Hashtable structureTable = new java.util.Hashtable();
    structureTable.put("CHAMP1","VARCHAR(10)");
    structureTable.put("CHAMP2","VARCHAR(10)");
    DataBaseTable.createDataBaseTable(connexion,"TABLE_YB",structureTable,true);
   }
   catch(SQLException sqle)
   {
    Logs.logsAll("Erreur : Impossible d'interroger la base de donnees.");
   }
   finally /* Fermeture des différents objets */
   {
    try
    {
     if(connexion!=null) connexion.close();
    }
    catch(SQLException sqle)
    {
     Logs.logsAll("Erreur : Impossible de fermer la connexion.");
    }
   } /* Fin finally */
  }
  catch(ClassNotFoundException cnfe)
  {
   Logs.logsAll("Erreur : Impossible d'enregistrer le driver de la base de donnees.");
  }
 }
}