set PATH=C:\JBuilder8\jdk1.4\bin

del home.jar *.bak

cd ..\classes

jar cvf home.jar com

move home.jar ..\jar

cd ..\jar