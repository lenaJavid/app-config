## Excersice For RBC Interview Process

### Lena Javid Khayati

####1- How to setup application:

##### Requirements:
* My SQL 5.6+
* Java 1.8
* Maven 3

A) Create a new database on My SQL with your preferred name.

B) We use Flyway plugin to run database migrations. First flyway db parameters should be configured to run sql migrations 
successfully. These parameters are used in pom.xml file. They can be set in settings.xml in the maven folder or by importing to maven command:

For example if you want to import them in the maven settings.xml:
```
    <db.url>jdbc:mysql://localhost:3306/rbc_document_db</db.url>
    		<db.user>root</db.user>
    		<db.password>password</db.password>
    		<flyway.prefix>rbc_</flyway.prefix>
```

C) Now run this command to run migration files:

```
mvn clean install
```

D) After a successful build we can run application:

```
mvn spring-boot:run
```

####2- Notices:
* The JSON configuragtion is saved as a Text column in db, but if it is possible to store them with JSON Data Type if we use MySQL 5.7+ or Postgres 9.4+.
* 