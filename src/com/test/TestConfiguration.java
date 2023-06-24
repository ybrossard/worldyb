package com.test;

import com.home.configuration.ConfigurationMgr;

import com.home.logs.Logs;

public class TestConfiguration
{
 public TestConfiguration()
 {
 }

 public static void main(String args[])
 {
  Logs.logsAll("Cle du parametre 'SGBD_DRIVER_ORACLE' : " + ConfigurationMgr.getParameterValue("SGBD_DRIVER_ORACLE"));
  Logs.logsAll("Cle du parametre 'SGBD_URL_EFUD' : " + ConfigurationMgr.getParameterValue("SGBD_URL_EFUD"));
  Logs.logsAll("Cle du parametre 'SGBD_USER_EFUD' : " + ConfigurationMgr.getParameterValue("SGBD_USER_EFUD"));
  Logs.logsAll("Cle du parametre 'SGBD_PWD_EFUD' : " + ConfigurationMgr.getParameterValue("SGBD_PWD_EFUD"));
 }
}