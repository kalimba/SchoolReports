# MySQL database setup

Use this guide to create a local MySQL database for SchoolReports and configure the application to connect to it.

> **Schema note:** `sql/01_create_database.sql` provides a starter schema based on the tables and columns referenced by the application. Validate it against the application's queries and your requirements using a disposable database before entering real school records.

## 1. Install MySQL Server

1. Install and start MySQL Community Server 5.7 or 8.0.
2. Set a strong password for the MySQL administrative account.
3. Optionally install MySQL Workbench if you prefer a graphical interface for running SQL.

## 2. Create the database and tables

### MySQL Workbench

1. Connect to your local MySQL server.
2. Select **File → Open SQL Script**.
3. Open `sql/01_create_database.sql` from this repository.
4. Execute the script using the lightning-bolt button.
5. Refresh the **Schemas** panel and confirm that `school-reports` and its tables appear.

### MySQL command line

Open PowerShell or Command Prompt in the repository folder and run:

```powershell
mysql -u root -p < .\sql\01_create_database.sql
```

Enter the MySQL administrative password when prompted. The script creates the `school-reports` database and these tables:

- `teachers`
- `classes`
- `students`
- `courses`
- `test_quiz_works`
- `marks_report`
- `report`

## 3. Create a dedicated application user

Do not run the desktop application as MySQL `root`. Sign in as a MySQL administrator and create a user for the application. Replace the example password with a strong, unique password:

```sql
CREATE USER 'schoolreports_app'@'localhost'
  IDENTIFIED BY 'replace-with-a-strong-local-password';

GRANT SELECT, INSERT, UPDATE, DELETE
  ON `school-reports`.* TO 'schoolreports_app'@'localhost';
```

If the application and database run on separate machines, specify the appropriate trusted host instead of `localhost` and restrict network access to the database server.

## 4. Configure the application

Set the following environment variables in the same environment from which NetBeans launches the application. In Windows PowerShell:

```powershell
$env:SCHOOLREPORTS_DB_URL = "jdbc:mysql://localhost:3306/school-reports?useSSL=false&serverTimezone=UTC"
$env:SCHOOLREPORTS_DB_USER = "schoolreports_app"
$env:SCHOOLREPORTS_DB_PASSWORD = "replace-with-a-strong-local-password"
```

Start NetBeans from that PowerShell session, or configure equivalent variables in your IDE's launch configuration. An IDE that was already running may need to be restarted to inherit newly set variables.

The project uses MySQL Connector/J 5.1.39 and the legacy driver class name `com.mysql.jdbc.Driver`. Keep the driver and connection URL compatible. If you upgrade the connector, update and test the Java configuration as part of the upgrade.

## 5. Create initial school records

The schema script creates the database structure but does not insert sample teachers, classes, students, or marks. Use the application's administration screens to create initial records. If an administrator account is required before those screens can be used, determine the expected account table and password format from a trusted source; do not guess credentials or use a published default password.

## 6. Verify the database

Run these statements in Workbench or the MySQL command line:

```sql
USE `school-reports`;
SHOW TABLES;
DESCRIBE teachers;
DESCRIBE classes;
DESCRIBE students;
DESCRIBE courses;
DESCRIBE test_quiz_works;
DESCRIBE marks_report;
DESCRIBE report;
```

Build and launch the Java project. If the application reports an unknown column or missing table, compare the error with the corresponding SQL queries in `src/schoolreports/` and adjust the schema as appropriate.

## Security and privacy

The application handles student information. Use synthetic data for testing and demonstrations, and do not share real student records, report PDFs, database backups, or credentials. The application contains legacy SQL construction that should be reviewed and migrated to prepared statements before use with sensitive or production data. Limit database access to trusted users and hosts.
