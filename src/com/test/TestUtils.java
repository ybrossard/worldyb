package com.test;

import com.home.utils.Utils;

import com.home.logs.Logs;

public class TestUtils
{
 public TestUtils()
 {
 }

 public static void main(String args[])
 {
  String chaineBoolean1 = Utils.convertBooleanToStringInteger(true);
  Logs.logsAll(chaineBoolean1);
  String chaineBoolean2 = Utils.convertBooleanToStringInteger(false);
  Logs.logsAll(chaineBoolean2);
 }
}