package com.home.xml;

import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class ParseurSAX
{
	// Attributs
 DefaultHandler handler = null;
 String cheminfichierXML = null;

	// Methodes
	public ParseurSAX(String cheminfichierXML,DefaultHandler handler)
	{
  this.cheminfichierXML = cheminfichierXML;
  this.handler = handler;
	}

 public void startParsing()
 {
  try
  {
   SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
   SAXParser saxParser = saxParserFactory.newSAXParser();
   saxParser.parse(this.cheminfichierXML, this.handler);
  }
  catch(org.xml.sax.SAXException saxException)
  {
   System.out.println("Erreur : SAXException.");
  }
  catch(javax.xml.parsers.ParserConfigurationException parserConfigurationException)
  {
   System.out.println("Erreur : Configuration du parseur.");
  }
  catch(java.io.IOException ioException)
  {
   System.out.println("Erreur : Entree / Sortie.");
  }
 }
}