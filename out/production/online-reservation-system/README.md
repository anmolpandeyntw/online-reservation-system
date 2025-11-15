# Online Reservation System (Java - Console)

## What is included
- Java console application source code (packages: database, models, services, ui)
- MySQL schema (schema.sql)
- Instructions to compile and run

## Requirements
- Java 11+
- MySQL server
- MySQL Connector/J (JDBC driver) on classpath

## Setup
1. Create the database:
   - Open MySQL and run `schema.sql` included in the project root.
2. Edit `src/database/DBConnection.java` and set the DB URL/username/password if needed.
3. Compile:
   ```
   javac -cp .:mysql-connector-java-8.0.33.jar src/**/*.java Main.java
   ```
   (On Windows use `;` instead of `:`)
4. Run:
   ```
   java -cp .:mysql-connector-java-8.0.33.jar Main
   ```
5. Demo credentials:
   - username: `demo`
   - password: `demo123`

## Notes
- The project is console-based for internship submission simplicity.
- You can enhance by adding password hashing, input validation, or a GUI later.
