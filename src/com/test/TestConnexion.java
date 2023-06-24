package com.test;

import com.home.connexion.Connexion;
import com.home.configuration.ConfigurationMgr;

import java.sql.Connection;

import com.home.logs.Logs;

public class TestConnexion
{
 public TestConnexion()
 {
 }

 public static void main(String args[])
 {
  Logs.logsAll("Etablissement d'une connexion aupres de la base de donnees : " + ConfigurationMgr.getParameterValue("SGBD_URL_EFUD"));
  Connection connexionOracle=Connexion.getDataBaseConnexion(
                                                            ConfigurationMgr.getParameterValue("SGBD_DRIVER_ORACLE"),
                                                            ConfigurationMgr.getParameterValue("SGBD_URL_EFUD"),
                                                            ConfigurationMgr.getParameterValue("SGBD_USER_EFUD"),
                                                            ConfigurationMgr.getParameterValue("SGBD_PWD_EFUD")
                                                           );
  Logs.logsAll("Connexion etablie : " + connexionOracle);

  Logs.logsAll("Etablissement d'une connexion aupres de la base de donnees : " + ConfigurationMgr.getParameterValue("SGBD_URL_DS_IDEE_INT"));
  Connection connexionSybase=Connexion.getDataBaseConnexion(
                                                            ConfigurationMgr.getParameterValue("SGBD_DRIVER_SYBASE"),
                                                            ConfigurationMgr.getParameterValue("SGBD_URL_DS_IDEE_INT"),
                                                            ConfigurationMgr.getParameterValue("SGBD_USER_DS_IDEE_INT"),
                                                            ConfigurationMgr.getParameterValue("SGBD_PWD_DS_IDEE_INT")
                                                           );
  Logs.logsAll("Connexion etablie : " + connexionSybase);

  try
  {
   connexionOracle.close();
   connexionSybase.close();
  }
  catch(java.sql.SQLException sqle)
  {
   Logs.logsAll("Erreur : Impossible de fermer la connexion.");
  }
 }
}