package com.test;

import com.home.fichiers.Fichier;

import com.home.logs.Logs;

public class TestFichier
{
 public TestFichier()
 {
 }

 public static void main(String[] args )
 {
  Fichier monFichier=new Fichier("c:\\temp\\MonFichier.txt",true);
  Logs.logsAll ("Test de l'existence du fichier : " + monFichier.isFileExistsOnDisk());
  monFichier.ecrireFlux("Bonjour, je m'appelle Yann.\nJ'ajoute une ligne dans le flux.");
 }
}