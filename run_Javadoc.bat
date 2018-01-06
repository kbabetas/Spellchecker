@Echo off

title: Javadocs by DirtyBits
cd

cd "src\main\java"

javadoc -encoding cp737 -d %~dp0\doc gr.aueb.dmst.dirtybits
pause