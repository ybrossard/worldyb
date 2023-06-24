cls

REM Positionnement des variables d'environnement PATH et CLASSPATH

# Definition du repertoire de base du projet WorldYB
set PROJECT_DIRECTORY=D:\WorldYB

# Definition de la variable PATH pour pouvoir effectuer l'appel de java.exe
set PATH=C:\JBuilder8\jdk1.4\bin
set CLASSPATH=%PROJECT_DIRECTORY%\jar\home.jar;%PROJECT_DIRECTORY%\lib\mail.jar;%PROJECT_DIRECTORY%\lib\activation.jar

REM Lancement du programme de test TestStringUtils
java -classpath %CLASSPATH% -DCONF_DIR="D:\WorldYB\conf\main.properties" com.test.TestMail