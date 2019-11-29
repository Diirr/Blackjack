JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(KFLAGS) $*.java

CLASSES = \
	CardDeck.java \
	GameMaster.java \
	Language.java \
	Play.java 

default: classes

classes: $(CLASSES:.java=.class)

clean: 
	$(RM) *.class

