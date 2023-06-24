package com.test;

import com.home.logs.Logs;

public class TestLogs
{
 public TestLogs()
 {
 }

 public static void main(String[] args)
 {
  Logs.writeLog("Ceci est un test de message de log");
  Logs.writeLogFile("Ceci est un test de message de log dans un fichier de log");
 }
}
