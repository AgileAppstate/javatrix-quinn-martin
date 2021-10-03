#
#makefile
#

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml

default: 
	@echo "usage: make target"
	@echo "example: make help"
	@echo "example: make targetlist"

targetlist:
	@echo "6 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
	@echo "____________________ chkstyle - checkstyle"
	@echo "____________________ help - displays simple help page"
	@echo "____________________ targetlist - displays avaliable targets"

help:
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make compile ; make test ; make chkstyle"

compile: Matrix.java MatrixTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) MatrixTest.java
	javac Matrix.java
	javac Testtrix.java

clean:
	rm -f *~
	rm -f Matrix*.class
	rm -f Testtrix.class

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path

chkstyle: Matrix.java $(CKSTYLE_XML)

	java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) Matrix.java

