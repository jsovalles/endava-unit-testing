install:
	mvn clean install
test:
	mvn clean test
compile:
	mvn compile
exec:
	mvn exec:java -Dexec.mainClass="com.endava.tdd.Calculator"