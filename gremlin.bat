:: Windows launcher script for Gremlin
@echo off

if "%1" == "" goto groovy

if "%1" == "-l" goto language

:groovy

cd %CD%\gremlin-groovy\target\

set TARGET=

for /f "tokens=*" %%a in ('dir /b /ad') do (
if exist "%%a\bin\gremlin-groovy.bat" set TARGET=%%a
)

cd %TARGET%\bin\
call gremlin-groovy.bat %*

goto :eof


:scala

cd %CD%\gremlin-scala\target\

set TARGET=

for /f "tokens=*" %%a in ('dir /b /ad') do (
if exist "%%a\bin\gremlin-scala.bat" set TARGET=%%a
)

cd %TARGET%\bin\
call gremlin-scala.bat %*

goto :eof


:language

if %2 == "groovy" (

goto groovy

)else (

goto scala

)

goto :eof
