set projectLocation=C:\Users\admin\MyWork\HYBRID_FRAMEWORK
cd %projectLocation%
set classpath=C:\Users\admin\apache-maven-3.6.3\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
