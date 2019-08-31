all: maven

console: fclean maven
	java -jar swingy.jar console
	
gui: fclean maven
	java -jar swingy.jar gui

maven:
	clear
	mvn clean package

git: origin alt

origin:
	git push origin master

alt:
	git push alt master

clean:
	rm -Rf .settings
	rm -Rf .classpath
	rm -Rf .project
	rm -Rf .DS_Store
	rm -Rf .vscode
	rm -Rf bin

fclean: clean
	mvn clean
	rm -Rf swingy.jar
	rm -Rf ~/.m2;

re: fclean all