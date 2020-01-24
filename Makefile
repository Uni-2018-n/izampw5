SOURCE = src/*.java
ITEM = main

run : compile
	java MainClass
	make clean

compile : $(SOURCE)
	javac  -d ../izampw5/ $(SOURCE)

clean :
	-rm -rf *.class

compress: $(SOURCE)
	rm -r $(ITEM)
	mkdir final
	cp * final
