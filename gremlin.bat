:: Windows launcher script for Gremlin
@echo off

set JAVA_OPTIONS=-Xms32M -Xmx512M

:: Launch the application
if "%1" == "" goto console
if "%1" == "-e" goto script
if "%1" == "-v" goto version

:console
java %JAVA_OPTIONS% %JAVA_ARGS% -cp target/gremlin-*-standalone.jar com.tinkerpop.gremlin.Console
goto :eof

:script

set strg=

FOR %%X IN (%*) DO (
CALL :concat %%X %1 %2
)

java %JAVA_OPTIONS% %JAVA_ARGS% -cp target/gremlin-*-standalone.jar com.tinkerpop.gremlin.ScriptExecutor %strg%
goto :eof

:version
echo Gremlin 0.5
goto :eof

:concat
if %1 == %2 goto skip
SET strg=%strg% %1
:skip
