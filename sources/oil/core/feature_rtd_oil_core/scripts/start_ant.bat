@echo off

if %1.==. goto help
goto run


:help
echo Insufficient parameters
echo Usage:  start_ant.sh ^<RT-Druid_dir^> ^[more ant options^]
goto end


:run
for /f %%a in ('dir /B %1\plugins\org.eclipse.equinox.launcher_*.jar') do @set jar_launcher=%%a 
java -jar %1\plugins\%jar_launcher% -application org.eclipse.ant.core.antRunner %2 %3 %4 %5 %6 %7 %8 %9

