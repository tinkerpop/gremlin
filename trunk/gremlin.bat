:: Windows launcher script for Gremlin

if not "%JAVA_OPTIONS%" == "" goto gotOpts
set JAVA_OPTIONS=-Xms32M -Xmx512M
:gotOpts

java %JAVA_OPTIONS% %JAVA_ARGS% -cp target/gremlin-*-standalone.jar com.tinkerpop.gremlin.Console

:: TODO: return exit code
