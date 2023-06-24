package com.test;

import com.home.commande.CommandeMgr;

import com.home.logs.Logs;

public class TestCommandeMgr
{
 public TestCommandeMgr()
 {
 }

 public static void main(String args[])
 {
  // Pas d'attente apres le lancement de la commande
  Logs.logsAll("Avant lancement de la calculatrice.");
  CommandeMgr.launchCommand("calc.exe",false);
  Logs.logsAll("Apres lancement de la calculatrice.");

  // Attente que le process lance se soit temrmine pour continuer la suite du traitement
  Logs.logsAll("Avant lancement de notepad.");
  CommandeMgr.launchCommand("notepad.exe",true);
  Logs.logsAll("Apres lancement de notepad.");
 }
}