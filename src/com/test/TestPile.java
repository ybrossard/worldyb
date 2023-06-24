package com.test;

import com.home.structuredonnees.pile.PileTableau;
import com.home.structuredonnees.pile.PileVector;

import com.home.logs.Logs;

public class TestPile
{
 public TestPile()
 {
 }

 public static void main(String[] args)
 {
  // Test d'une Pile basee sur un tableau

  Logs.logsAll("Test d'une Pile basee sur un tableau");

  PileTableau pile = new PileTableau(3);

  Logs.logsAll("Pile vide : " + pile.pileVide());
  Logs.logsAll("Pile pleine : " + pile.pilePleine());

  Logs.logsAll("pile.empiler('Element 1 : Yann')");
  pile.empiler("Element 1 : Yann");

  Logs.logsAll("Pile vide : " + pile.pileVide());
  Logs.logsAll("Pile pleine : " + pile.pilePleine());

  Logs.logsAll("pile.empiler('Element 2 : Caroline')");
  pile.empiler("Element 2 : Caroline");

  Logs.logsAll("Pile vide : " + pile.pileVide());
  Logs.logsAll("Pile pleine : " + pile.pilePleine());

  Logs.logsAll("pile.empiler('Element 3 : Olivier')");
  pile.empiler("Element 3 : Olivier");

  Logs.logsAll("Pile vide : " + pile.pileVide());
  Logs.logsAll("Pile pleine : " + pile.pilePleine());

  Logs.logsAll("pile.depiler() : " + pile.depiler());
  Logs.logsAll("pile.depiler() : " + pile.depiler());
  Logs.logsAll("pile.depiler() : " + pile.depiler());
  Logs.logsAll("pile.depiler() : " + pile.depiler());
  Logs.logsAll("pile.depiler() : " + pile.depiler());

  // Test d'une Pile basee sur un Vector()

  Logs.logsAll("Test d'une Pile basee sur un Vector()");

  PileVector pileV = new PileVector(3);

  Logs.logsAll("Pile vide : " + pileV.pileVide());
  Logs.logsAll("Pile pleine : " +pileV.pilePleine());

  Logs.logsAll("pileV.empiler('Element 1 : Yann')");
  pileV.empiler("Element 1 : Yann");

  Logs.logsAll("Pile vide : " + pileV.pileVide());
  Logs.logsAll("Pile pleine : " +pileV.pilePleine());

  Logs.logsAll("pileV.empiler('Element 2 : Caroline')");
  pileV.empiler("Element 2 : Caroline");

  Logs.logsAll("Pile vide : " + pileV.pileVide());
  Logs.logsAll("Pile pleine : " +pileV.pilePleine());

  Logs.logsAll("pileV.empiler('Element 3 : Olivier')");
  pileV.empiler("Element 3 : Olivier");

  Logs.logsAll("Pile vide : " + pileV.pileVide());
  Logs.logsAll("Pile pleine : " +pileV.pilePleine());

  Logs.logsAll("pileV.depiler() : " + pileV.depiler());
  Logs.logsAll("pileV.depiler() : " + pileV.depiler());
  Logs.logsAll("pileV.depiler() : " + pileV.depiler());
  Logs.logsAll("pileV.depiler() : " + pileV.depiler());
  Logs.logsAll("pileV.depiler() : " + pileV.depiler());
 }
}