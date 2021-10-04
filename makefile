#
#makefile
#Matrix Class
#

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml
PKG = javatrix/

default: 
	@echo "usage: make target"
	@echo "example: make help"
	@echo "example: make targetlist"

targetlist:
	@echo "6 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile - compiles all classes"
	@echo "____________________ test - builds and runs all JUnit5 tests"
	@echo "____________________ chkstyle - checkstyle"
	@echo "____________________ help - displays simple help page"
	@echo "____________________ targetlist - displays avaliable targets"

help:
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make compile ; make test ; make chkstyle"

compile: $(PKG)Matrix.java $(PKG)MatrixTest.java $(JUNIT5_JAR) Testtrix.java
	javac -cp .:$(JUNIT5_JAR) javatrix/MatrixTest.java
	javac $(PKG)Matrix.java
	javac Testtrix.java

clean:
	rm -f $(PKG)*~
	rm -f $(PKG)Matrix*.class
	rm -f *~
	rm -f Testtrix.class

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path

chkstyle: $(PKG)Matrix.java $(CKSTYLE_XML)

	java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) $(PKG)Matrix.java

