package com.test;

import com.home.string.StringUtils;

import com.home.logs.Logs;

public class TestStringUtils
{
 public TestStringUtils()
 {
 }

 public static void main(String args[])
 {
  String [] chaineSplitee = StringUtils.splitString("Bleu|Blanc|Rouge","|");
  StringUtils.checkSplitString();

  String [] chaineSplitee2 = StringUtils.splitString("Jupiter-Uranus-Neptune","-");
  StringUtils.checkSplitString();

  String chaineExtraite = StringUtils.subString("<","<balise-xml>",">");
  Logs.logsAll(chaineExtraite);

  String chaineLeft = StringUtils.subStringLeft("Bleu|Blanc","|");
  Logs.logsAll(chaineLeft);

  String chaineRight = StringUtils.subStringRight("|","Bleu|Blanc");
  Logs.logsAll(chaineRight);

  String chaineDefaut = StringUtils.getStringOrDefaultValue("","Default Value");
  Logs.logsAll(chaineDefaut);
 }
}