package com.test;

import com.home.structuredonnees.file.FileTableau;
import com.home.structuredonnees.file.FileVector;

import com.home.logs.Logs;

public class TestFile
{
 public TestFile()
 {
 }

 public static void main(String[] args)
 {
  // Test d'une File basee sur un tableau

  Logs.logsAll("Test d'une File basee sur un tableau");

  FileTableau file = new FileTableau(3);

  Logs.logsAll("File vide : " + file.fileVide());
  Logs.logsAll("File pleine : " + file.filePleine());

  Logs.logsAll("file.enfiler('Element 1 : Yann')");
  file.enfiler("Element 1 : Yann");

  Logs.logsAll("File vide : " + file.fileVide());
  Logs.logsAll("File pleine : " + file.filePleine());

  Logs.logsAll("file.enfiler('Element 2 : Caroline')");
  file.enfiler("Element 2 : Caroline");

  Logs.logsAll("File vide : " + file.fileVide());
  Logs.logsAll("File pleine : " + file.filePleine());

  Logs.logsAll("file.enfiler('Element 3 : Olivier')");
  file.enfiler("Element 3 : Olivier");

  Logs.logsAll("File vide : " + file.fileVide());
  Logs.logsAll("File pleine : " + file.filePleine());

  Logs.logsAll("file.defiler() : " + file.defiler());
  Logs.logsAll("file.defiler() : " + file.defiler());
  Logs.logsAll("file.defiler() : " + file.defiler());
  Logs.logsAll("file.defiler() : " + file.defiler());
  Logs.logsAll("file.defiler() : " + file.defiler());

  // Test d'une File basee sur un Vector()

  Logs.logsAll("Test d'une File basee sur un Vector()");

  FileVector fileV = new FileVector(3);

  Logs.logsAll("File vide : " + fileV.fileVide());
  Logs.logsAll("File pleine : " + fileV.filePleine());

  Logs.logsAll("fileV.enfiler('Element 1 : Yann')");
  fileV.enfiler("Element 1 : Yann");

  Logs.logsAll("File vide : " + fileV.fileVide());
  Logs.logsAll("File pleine : " + fileV.filePleine());

  Logs.logsAll("fileV.enfiler('Element 2 : Caroline')");
  fileV.enfiler("Element 2 : Caroline");

  Logs.logsAll("File vide : " + fileV.fileVide());
  Logs.logsAll("File pleine : " + fileV.filePleine());

  Logs.logsAll("fileV.enfiler('Element 3 : Olivier')");
  fileV.enfiler("Element 3 : Olivier");

  Logs.logsAll("File vide : " + fileV.fileVide());
  Logs.logsAll("File pleine : " + fileV.filePleine());

  Logs.logsAll("fileV.defiler() : " + fileV.defiler());
  Logs.logsAll("fileV.defiler() : " + fileV.defiler());
  Logs.logsAll("fileV.defiler() : " + fileV.defiler());
  Logs.logsAll("fileV.defiler() : " + fileV.defiler());
  Logs.logsAll("fileV.defiler() : " + fileV.defiler());
 }
}
