package com.test;

import com.home.commande.TreeCommandeMgr;

import com.home.logs.Logs;

public class TestTreeCommandeMgr
{
 public TestTreeCommandeMgr()
 {
 }

 public static void main(String args[])
 {
  // Lancement d'une commande dans toute une arborescence
  TreeCommandeMgr.launchTreeCommand();
 }
}