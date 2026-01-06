@echo off
echo.
echo [��Ϣ] ʹ��Jar��������Web���̡�
echo.

cd %~dp0
cd ../njpidc-admin/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% njpidc-admin.jar

cd bin
pause
