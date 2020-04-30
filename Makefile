JC = javac
J = java
JFLAGS = -g


all:
	$(JC) $(JFLAGS) Main.java grafika/*.java $<

run:
	$(J) Main

fast-run:
	$(JC) $(JFLAGS) Main.java grafika/*.java $<
	$(J) Main

clean:
	rm -f *.class
	rm -f grafika/*.class
