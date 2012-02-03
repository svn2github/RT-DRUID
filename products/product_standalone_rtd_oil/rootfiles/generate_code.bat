@echo off

if %3.==. goto help
goto run


:help
echo Insufficient parameters
echo Usage: code_generation.bat ^<RT-Druid_dir^> ^<oil_file^> ^<output_dir^>
goto end


:run
for /f %%a in ('dir /B %1\plugins\org.eclipse.equinox.launcher_*.jar') do @set jar_launcher=%%a 
java -jar %1\plugins\%jar_launcher% -data %3/workspace -application com.eu.evidence.rtdruid.oil.standalone.writer --inputFile %2 --outputDir %3 


:end
