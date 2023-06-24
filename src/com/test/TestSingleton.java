package com.test;

import com.home.patterns.singleton.Singleton;
import com.home.logs.Logs;

public class TestSingleton
{
 public TestSingleton()
 {
 }

 public static void main(String args[])
 {
  Singleton s1 = Singleton.getInstance("Singleton YB");
  Singleton s2 = Singleton.getInstance("Singleton YB2");

  Logs.logsAll(("s1 : " + s1));
  Logs.logsAll("s2 : " + s2);

  Logs.logsAll("s1.getMessage() : " + s1.getMessage());
  Logs.logsAll("s2.getMessage() : " + s2.getMessage());

  Logs.logsAll("s1.getChampString() : " + s1.getChampString());
  Logs.logsAll("s2.getChampString() : " + s2.getChampString());

  Logs.logsAll("s1.getChampInt() : " + s1.getChampInt());
  Logs.logsAll("s2.getChampInt() : " + s2.getChampInt());
 }
}

