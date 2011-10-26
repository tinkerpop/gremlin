:: Windows launcher script for Gremlin
@echo off

cd %CD%\target\

set TARGET=

for /f "tokens=*" %%a in ('dir /b /ad') do (
if exist "%%a\bin\gremlin-scala.bat" set TARGET=%%a
)

cd %TARGET%\bin\
call gremlin-scala.bat %*
