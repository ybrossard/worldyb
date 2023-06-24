package com.home.xml;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import com.home.logs.Logs;

public class HandlerTest extends DefaultHandler
{
 // Constantes (liste des balises du fichier 'application.xml')

 public static final String USER = "user";
 public static final String PASSWORD = "password";

 String saveStartBalise = null;
 String saveEndBalise = null;

 // Methodes
 public HandlerTest()
 {
 }

 // Méthodes evenementielles
 public void startDocument()
 {
  Logs.logsAll("Debut du chargement de l'application.");
 }

 public void endDocument()
 {
  Logs.logsAll("Fin du chargement de l'application.");
 }

 public void startElement(String uri, String localName, String tagName, Attributes attributes)
 {
  this.saveStartBalise = tagName;
  Logs.logsAll("<" + tagName + ">");
 }

 public void endElement(String uri, String localName, String tagName)
 {
  this.saveEndBalise = tagName;
  Logs.logsAll("</" + tagName + ">");
 }

 public void characters(char[] ch, int start, int length)
 {
  Logs.logsAll(new String(ch,start,length));
 }
}