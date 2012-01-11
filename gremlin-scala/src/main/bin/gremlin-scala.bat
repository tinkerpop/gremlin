:: Windows launcher script for Gremlin Scala

@echo off


::cd ..\lib

::set LIBDIR=%CD%


set LIBDIR=..\lib


set OLD_CLASSPATH=%CLASSPATH%
set CP=


for %%i in (%LIBDIR%\*.jar) do call :concatsep %%i

:: cd ..\..\..\


set JAVA_OPTIONS=-Xms32M -Xmx512M


:: Launch the application

if "%1" == "" goto console

if "%1" == "-v" goto version



:console

set CLASSPATH=%CP%;%OLD_CLASSPATH%
java %JAVA_OPTIONS% %JAVA_ARGS% com.tinkerpop.gremlin.scala.console.Console
set CLASSPATH=%OLD_CLASSPATH%

set CLASSPATH=%OLD_CLASSPATH%
goto :eof



:version

set CLASSPATH=%CP%;%OLD_CLASSPATH%
java %JAVA_OPTIONS% %JAVA_ARGS% com.tinkerpop.gremlin.Version

set CLASSPATH=%OLD_CLASSPATH%
goto :eof



:concat

if %1 == %2 goto skip

SET strg=%strg% %1



:concatsep

if "%CP%" == "" (

set CP=%LIBDIR%\%1

)else (

set CP=%CP%;%LIBDIR%\%1

)



:skip
