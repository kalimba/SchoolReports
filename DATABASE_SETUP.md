# MySQL database installation

This guide creates a fresh database for the SchoolReports application.

> **Schema compatibility notice:** The original project archive did not include
> a `.sql` export or database backup. `sql/01_create_database.sql` was assembled
> by examining table and column names referenced by the Java source. It is a
> starting schema, not a verified restoration of the original production
> database. Test it with a disposable database and compare it with the original
> database (if available) before importing real school records.

## 1. Install MySQL Server

1. Install MySQL Community Server 5.7 or 8.0 and start the MySQL service.
2. During setup, create a strong password for the MySQL administrative account.
3. Optionally install MySQL Workbench to run SQL scripts through a graphical interface.

## 2. Create the database and tables

### Option A — MySQL Workbench

1. Open MySQL Workbench and connect to your local MySQL server.
2. Select **File → Open SQL Script**.
3. Open `sql/01_create_database.sql` from this repository.
4. Click the lightning-bolt **Execute** button.
5. Refresh the **Schemas** panel. You should see `school-reports` and its tables.

### Option B — MySQL command line

Open PowerShell or Command Prompt in the project folder and run:

```powershell
mysql -u root -p < .\sql\01_create_database.sql
```

Enter the MySQL root password when prompted. The script creates the database
`school-reports` and its seven tables:

- `teachers`
- `classes`
- `students`
- `courses`
- `test_quiz_works`
- `marks_report`
- `report`

## 3. Create an application database user

Do not run the desktop application as MySQL `root`. Sign in to MySQL as an
administrator and execute the following, changing the example password:

```sql
CREATE USER 'schoolreports_app'@'localhost'
  IDENTIFIED BY 'replace-with-a-strong-local-password';

GRANT SELECT, INSERT, UPDATE, DELETE
  ON `school-reports`.* TO 'schoolreports_app'@'localhost';

FLUSH PRIVILEGES;
```

If the application and database run on different machines, create the account
for the appropriate trusted host instead of `localhost`, and restrict network
access to the database server.

## 4. Configure the Java application

The application reads its connection details from environment variables. In
Windows PowerShell, set them in the same terminal session from which NetBeans
will be launched:

```powershell
$env:SCHOOLREPORTS_DB_URL = "jdbc:mysql://localhost:3306/school-reports?useSSL=false&serverTimezone=UTC"
$env:SCHOOLREPORTS_DB_USER = "schoolreports_app"
$env:SCHOOLREPORTS_DB_PASSWORD = "replace-with-a-strong-local-password"
```

Then start NetBeans from that PowerShell session, or configure equivalent
environment variables in your IDE launch configuration. If NetBeans was
already running before you set the variables, close it and launch it again.

The project currently includes MySQL Connector/J 5.1.39 and uses its legacy
driver class name (`com.mysql.jdbc.Driver`). Keep the bundled driver and
connection URL compatible unless you deliberately upgrade the connector and
update/test the Java code together.

## 5. Add initial school data

The SQL script intentionally does not insert sample teachers, classes,
students, or marks. Use the application's account and administration screens
to create the initial records. If the login screen requires an administrator
record that cannot be created through the application, inspect the original
working database for its exact account table and password format; do not guess
or publish a default password.

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

Build and launch the Java project. If a query reports an unknown column or a
missing table, the original database schema differs from the inferred schema;
compare the error with the corresponding SQL in `src/schoolreports/` and update
the SQL script accordingly.

## Important security note

The legacy application constructs a number of SQL statements by concatenating
user-entered values. Before deploying it with real student data, migrate those
statements to `PreparedStatement` parameters, review account/password handling,
and restrict database access.
