package com.home.databasetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Hashtable;

import com.home.logs.Logs;

public class DataBaseTable
{
 public DataBaseTable()
 {
 }

 // Vidage d'une table de base de donnees dont le nom est passe en parametre (methode qui necessite une connexion deja ouverte)
 public static int flushDataBaseTable(Connection connexion,String nomTable,boolean ecritureLogsParDefaut)
 {
  PreparedStatement psDeleteTable=null;
  int statutOK=0;

  try
  {
   psDeleteTable=connexion.prepareStatement("delete from " + nomTable);
   statutOK=psDeleteTable.executeUpdate();
   if(ecritureLogsParDefaut)
   {
    Logs.writeLogFile("Vidage de la table " + nomTable + " : OK.");
   }
  }
  catch(SQLException sqle)
  {
   Logs.writeLogFile("ERREUR : Impossible de vider la table " + nomTable + ".");
  }
  finally
  {
   try
   {
    if(psDeleteTable!=null) psDeleteTable.close();
   }
   catch(SQLException sqle)
   {
    Logs.writeLogFile("ERREUR : Impossible de fermer la connexion a l'issue du vidage de la table " + nomTable + ".");
   }
  }
  return statutOK;
 }

 // Insertion d'enregistrements dans une table de base de donnees dont la requete est passee en parametres
 public static int insertDataBaseTable(Connection connexion,String requeteInsert,String nomTable,boolean ecritureLogsParDefaut)
 {
  PreparedStatement psInsertTable=null;
  int statutOK=0;

  try
  {
   psInsertTable=connexion.prepareStatement(requeteInsert);
   statutOK=psInsertTable.executeUpdate();
   if(ecritureLogsParDefaut)
   {
    Logs.writeLogFile("Insertion dans la table " + nomTable + " : OK.");
   }
  }
  catch(SQLException sqle)
  {
   Logs.writeLogFile("ERREUR : Impossible d'inserer dans la table " + nomTable + ".");
  }
  finally
  {
   try
   {
    if(psInsertTable!=null) psInsertTable.close();
   }
   catch(SQLException sqle)
   {
    Logs.writeLogFile("ERREUR : Impossible de fermer la connexion a l'issue de l'insertion dans la table " + nomTable + ".");
   }
  }
  return statutOK;
 }

 // Mise a jour d'enregistrements dans une table de base de donnees dont la requete est passee en parametres
 public static int updateDataBaseTable(Connection connexion,String requeteUpdate,String nomTable,boolean ecritureLogsParDefaut)
 {
  PreparedStatement psUpdateTable=null;
  int statutOK=0;

  try
  {
   psUpdateTable=connexion.prepareStatement(requeteUpdate);
   statutOK=psUpdateTable.executeUpdate();
   if(ecritureLogsParDefaut)
   {
    Logs.writeLogFile("Mise a jour de la table " + nomTable + " : OK.");
   }
  }
  catch(SQLException sqle)
  {
   Logs.writeLogFile("ERREUR : Impossible de mettre a jour la table " + nomTable + ".");
  }
  finally
  {
   try
   {
    if(psUpdateTable!=null) psUpdateTable.close();
   }
   catch(SQLException sqle)
   {
    Logs.writeLogFile("ERREUR : Impossible de fermer la connexion a l'issue de la mise a jour de la table " + nomTable + ".");
   }
  }
  return statutOK;
 }

 // Mise a jour d'une colonne (de type float) de valeur NULL a 0 dans la table dont le nom est passe en parametre (Attention, méthode non generique)
 public static int updateColumnToValue(Connection connexion,String nomTable,String nomColonne,String valeurInitiale,String valeurFinale,String critere,String codeRequete,boolean ecritureLogsParDefaut)
 {
  StringBuffer requeteUpdateColumn = new StringBuffer("update " + nomTable + " ");
  requeteUpdateColumn.append("set " + nomColonne + " = " + valeurFinale + " ");
  requeteUpdateColumn.append("where " + nomColonne + " = " + valeurInitiale + " ");
  requeteUpdateColumn.append(critere);

  PreparedStatement psUpdateColumn=null;
  int statutOK=0;

  try
  {
   psUpdateColumn=connexion.prepareStatement(requeteUpdateColumn.toString());
   statutOK=psUpdateColumn.executeUpdate();
   if(ecritureLogsParDefaut)
   {
    Logs.writeLogFile("Mise a jour de la colonne " + nomColonne + " de la table " + nomTable + " : OK.");
   }
  }
  catch(SQLException sqle)
  {
   Logs.writeLogFile("ERREUR : Impossible de mettre a jour la colonne " + nomColonne + " de la table " + nomTable + ".");
  }
  finally
  {
   try
   {
    if(psUpdateColumn!=null) psUpdateColumn.close();
   }
   catch(SQLException sqle)
   {
    Logs.writeLogFile("ERREUR : Impossible de fermer la connexion a l'issue de la mise a jour de la colonne " + nomColonne + " de la table " + nomTable + ".");
   }
  }
  return statutOK;
 }

 // Suppression d'une table de base de donnees dont le nom est passe en parametre
 public static int dropDataBaseTable(Connection connexion,String nomTable,boolean ecritureLogsParDefaut)
 {
  PreparedStatement psDropTable=null;
  int statutOK=0;

  try
  {
   psDropTable=connexion.prepareStatement("drop table " + nomTable);
   statutOK=psDropTable.executeUpdate();
   if(ecritureLogsParDefaut)
   {
    Logs.writeLogFile("Suppression de la table " + nomTable + " : OK.");
   }
  }
  catch(SQLException sqle)
  {
   Logs.writeLogFile("ERREUR : Impossible de supprimer la table " + nomTable + ".");
  }
  finally
  {
   try
   {
    if(psDropTable!=null) psDropTable.close();
   }
   catch(SQLException sqle)
   {
    Logs.writeLogFile("ERREUR : Impossible de fermer la connexion lors de la suppression de la table " + nomTable + ".");
   }
  }
  return statutOK;
 }

 // Creation d'une table de base de donnees dont le nom est passe en parametre
 public static int createDataBaseTable(Connection connexion,String nomTable,Hashtable structureTable,boolean ecritureLogsParDefaut)
 {
  // Construction du script de creation de la table
  StringBuffer requeteCreateTable = new StringBuffer("create table " + nomTable);
  requeteCreateTable.append("(");

  java.util.Enumeration enumeration = structureTable.keys();
  String key;

  while(enumeration.hasMoreElements())
  {
   key=enumeration.nextElement().toString();
   requeteCreateTable.append(key + " " + structureTable.get(key).toString());
   if(enumeration.hasMoreElements() == true) requeteCreateTable.append(",");
  }
  requeteCreateTable.append(")");

  PreparedStatement psCreateTable=null;
  int statutOK=0;

  try
  {
   psCreateTable=connexion.prepareStatement(requeteCreateTable.toString());
   statutOK=psCreateTable.executeUpdate();
   if(ecritureLogsParDefaut)
   {
    Logs.writeLogFile("Creation de la table " + nomTable + " : OK.");
   }
  }
  catch(SQLException sqle)
  {
   Logs.writeLogFile("ERREUR : Impossible de creer la table " + nomTable + ".");
  }
  finally
  {
   try
   {
    if(psCreateTable!=null) psCreateTable.close();
   }
   catch(SQLException sqle)
   {
    Logs.writeLogFile("ERREUR : Impossible de fermer la connexion a l'issue de la creation de la table " + nomTable + ".");
   }
  }
  return statutOK;
 }
}