package com.test;

import com.home.ascii.AsciiInformer;

import com.home.logs.Logs;

public class TestAscii
{
 public TestAscii()
 {
 }

 public static void main(String args [])
 {
  char theChar='Y';
  Logs.logsAll("Code ASCII de '" + theChar + "' : " + AsciiInformer.getAsciiCode(theChar));

  String theString=new String("Y");
  Logs.logsAll("Code ASCII de '" + theString + "' : " + AsciiInformer.getAsciiCode(theString));
 }
}