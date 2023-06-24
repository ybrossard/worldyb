cls

REM Positionnement des variables d'environnement PATH et CLASSPATH

REM Definition du repertoire de base du projet WorldYB
set PROJECT_DIRECTORY=D:\WorldYB

REM Definition de la variable PATH pour pouvoir effectuer l'appel de java.exe
set PATH=C:\JBuilder8\jdk1.4\bin
set CLASSPATH=%PROJECT_DIRECTORY%\classes

REM Lancement du programme de test TestFichier
java -classpath %CLASSPATH% -DCONF_DIR="D:\WorldYB\conf\main.properties" com.test.TestFile