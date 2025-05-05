Team Member Names :

     Aiden Hammond
     	   Contributions :

	   Code implementation, ER Model, prelim.pdf, db_design.pdf, ddl.sql,
	   datasource.txt, readme.txt, queries.sql, perf.txt, security.txt, demo video,
	   working code for the web app, group member contribution form
	   	
     Ryan Hughes
     	  Contributions :
	  	ER Model, prelim.pdf, db_design.pdf, ddl.sql, datasource.txt, readme.txt
		Assisting with code implementation, queries.sql, perf.txt, security.txt,
		demo video, working code for web app, readme.txt, group member contribution
		form

Technologies Used : Java, Spring Boot, JDBC Connection, Docker, mySQL, Maven


spring.datasource.url=jdbc:mysql://localhost:33306/cs4370_final_project
spring.datasource.username=root
spring.datasource.password=mysqlpass

Database Name : cs4370_final_project

Database Username : root

Database Password : mysqlpass

Test Username/Password Pairs

     1)
	User:
	Pswd:

     2)
	User:
	Pswd:

     3)
	User:
	Pswd:



For the grader:

You will want to move the data.csv with you to the docker or wherever you're running the database!!
The data.sql file reads from the csv -- PLEASE do this. The site really does need a lot of data - this is a relatively small amount of data for this site!
The data.sql assumes that the data.csv file is at '/var/lib/mysql-files/data.csv'
IF YOU ARE STORING IT SOMEWHERE ELSE PLEASE UPDATE THE PATH!! It is at the top of the data.sql file.
Thank you & sorry for the hassle!


Also we've been running our code with:

mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8081'

I'd recommend doing the same