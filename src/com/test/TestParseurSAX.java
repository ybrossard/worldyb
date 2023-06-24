package com.test;

import com.home.xml.ParseurSAX;
import com.home.xml.HandlerTest;

import com.home.configuration.ConfigurationMgr;

public class TestParseurSAX
{
 public TestParseurSAX()
 {
 }

 public static void main(String args[])
 {
  HandlerTest handlerTest = new HandlerTest();
  ParseurSAX parseurSAX = new ParseurSAX(
                                         ConfigurationMgr.getParameterValue("CHEMIN_FICHIER_TEST_XML"),
                                         handlerTest
                                        );
  parseurSAX.startParsing();
 }
}