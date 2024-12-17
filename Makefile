
srccompile:
	javac -d build -cp build src/*.java

tstcompile:
	javac -Xlint:deprecation -d build -cp build src/*.java tst/*.java

test:
	@# le @ pour masquer la sortie du script de la commande test
	@# lors de l execution de make test
	@for file in $(wildcard build/tec/Test*); do \
		class_name=$$(echo "$$file" | sed 's/build\/\|\.class//g' | sed 's/\//./g'); \
		echo  "..............Starting Test : $$class_name ..............\n"; \
		java -ea -cp build "$$class_name"; \
		echo  "..............Ending Text : $$class_name ? OK............\n"; \
	done
recette:
	java -ea -cp build/ Simple
test_collectFile:
	java -ea -cp build TestCollecteFile

recetteEstUn:
	java -ea -cp build/ SimpleCollecteEstUn
recetteAUn:
	java -ea -cp build/ SimpleCollecteAUn
caracteres:
	java -ea -cp build/ CaracteresMultiples

lancer:

clean:
	rm -rf build/*
