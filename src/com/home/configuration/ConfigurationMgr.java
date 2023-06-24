package com.home.configuration;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.home.logs.Logs;

public class ConfigurationMgr
{
 public ConfigurationMgr()
 {
 }

 // Permet d'extraire un parametre du fichier de configuration a l'aide du parametre CONF_DIR
 public static String getParameterValue(String nomParametre)
 {
  Properties proprietes=new Properties();
  try
  {
   File fichier = new File(System.getProperty("CONF_DIR"));
   FileInputStream inputStream = new FileInputStream(fichier);
   proprietes.load(inputStream);
   inputStream.close();
  } catch(IOException ioe)
  {
   Logs.writeLogFile("Erreur : Impossible de recuperer le parametre.");
  }
  return proprietes.getProperty(nomParametre);
 }
}