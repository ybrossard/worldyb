package com.test;

import com.home.ihm.Fenetre;

import com.home.logs.Logs;

public class TestFenetre
{
 public TestFenetre()
 {
 }

 public static void main(String args[])
 {
  Fenetre fenetre = new Fenetre("Fenetre de test",400,300);
  fenetre.setVisible(true);
 }
}