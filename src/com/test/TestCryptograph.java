package com.test;

import com.home.cryptography.Cryptograph;

import com.home.logs.Logs;

public class TestCryptograph
{
 public TestCryptograph()
 {
 }

 public static void main(String[] args)
 {
  String motDePasse = "kenavo";
  String motDePasseCrypte = new String();
  String motDePasseDecrypte = new String();

  Logs.logsAll("Chaine a crypter : " + motDePasse);

  motDePasseCrypte = Cryptograph.cryptStringToString(motDePasse);
  Logs.logsAll("Chaine cryptee : " + motDePasseCrypte);

  motDePasseDecrypte = Cryptograph.uncryptStringToString(motDePasseCrypte);
  Logs.logsAll("Chaine decryptee : " + motDePasseDecrypte);

  Logs.logsAll("Cryptage de Yann Brossard : " + Cryptograph.cryptStringToString("Yann Brossard"));
  Logs.logsAll("Decryptage de Yann Brossard : " + Cryptograph.uncryptStringToString((Cryptograph.cryptStringToString("Yann Brossard"))));
 }
}