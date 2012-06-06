@echo off

if %1.==. goto help
goto run


:help
echo Insufficient parameters
echo Usage:  start_ant.sh ^<RT-Druid_dir^> ^[more ant options^]
echo Note: If you need to use special caracters like ^= and spaces,
echo       you have to protect them with a couple of ^"
echo       Example: start_ant.bat ^"-Dconf_output_dir=a a^"
goto end


:run
for /f "delims= tokens=1" %%c in ('dir /B /S /OD %1\plugins\org.eclipse.equinox.launcher_*.jar') do set jar_launcher=%%c

:: remove eclipse path from parameters
SHIFT

set WSOPT_set=
set WSOPT=
set all_params=

:compress
if %1.==. (goto :compress_end)

:: save all parameters
set all_params=%all_params% %1

:: check if the user already set -data parameter
if /I .-data==.%1 ( set WSOPT_set=true)

:: remove " characters
set param=%1
for /f "useback tokens=*" %%a in ('%param%') do ( set param=%%~a)

:: split parameter into 2 parts
set dir_out_prefix=%param:~0,18%
set dir_out_path=%param:~18%
:: if current parameter is the output dir, store the workspace path
if /I "-Dconf_output_dir="=="%dir_out_prefix%" ( set WSOPT=-data "%dir_out_path%/workspace" )

:: Shift %2 into %1
SHIFT
goto :compress

:compress_end

:: check if the user already set the workspace path
if /I "%WSOPT_set%"=="true" ( set WSOPT=)

@echo on
java -jar "%jar_launcher%" %WSOPT% -application org.eclipse.ant.core.antRunner %all_params%

:end