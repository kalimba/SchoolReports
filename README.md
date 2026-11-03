# SchoolReports

SchoolReports is a Java Swing desktop application for managing school information, recording student marks, and generating student reports as PDF files. It uses MySQL for data storage and iText for PDF generation.

## Features

- Login screen and administration for teacher accounts
- Student and class management
- Course and teacher assignment
- Student marks entry and updates
- Report calculations and PDF generation

## Requirements

- JDK 8 or a compatible JDK
- Apache NetBeans with Java SE support
- MySQL Server
- The database schema in [`sql/01_create_database.sql`](sql/01_create_database.sql)

The project uses the NetBeans Ant project format. Its runtime dependencies are included in `lib/`; see [Dependencies](#dependencies).

## Setup

1. Clone or download this repository.
2. Follow [DATABASE_SETUP.md](DATABASE_SETUP.md) to create the database and application user.
3. Set the database environment variables listed below.
4. In NetBeans, choose **File → Open Project** and select this repository folder.
5. Build and run the project from NetBeans.

### Database environment variables

The application reads its database connection details from these environment variables:

- `SCHOOLREPORTS_DB_URL` — JDBC URL, for example `jdbc:mysql://localhost:3306/school-reports`
- `SCHOOLREPORTS_DB_USER` — MySQL application user
- `SCHOOLREPORTS_DB_PASSWORD` — password for that user

For a local Windows PowerShell session, set example values as follows, replacing the password with your own:

```powershell
$env:SCHOOLREPORTS_DB_URL = "jdbc:mysql://localhost:3306/school-reports"
$env:SCHOOLREPORTS_DB_USER = "schoolreports_app"
$env:SCHOOLREPORTS_DB_PASSWORD = "replace-with-your-local-password"
```

Launch NetBeans from that terminal so it inherits the variables, or configure them in your IDE's launch environment. Use a dedicated database account rather than MySQL `root`. Never commit real passwords, production connection details, or database dumps containing personal information.

## Database schema

The starter schema is provided in [`sql/01_create_database.sql`](sql/01_create_database.sql). Review and test it with a disposable database before using real school records; verify that its tables and columns match the application's queries and your deployment requirements.

## Dependencies

The `lib/` directory contains the project's runtime JARs:

- MySQL Connector/J 5.1.39
- iText 5.5.4 modules
- JTattoo 1.6.11
- rs2xml

The project currently uses the legacy MySQL driver class `com.mysql.jdbc.Driver`. If upgrading Connector/J, update and test the driver configuration and connection URL together. Review dependency licenses and compatibility before redistribution or production use.

## Repository structure

- `src/` — Java source files and NetBeans `.form` GUI definitions
- `nbproject/` — NetBeans project configuration
- `sql/01_create_database.sql` — database schema
- `lib/` — runtime dependency JARs
- `DATABASE_SETUP.md` — database installation and configuration instructions
- `build.xml` — Ant build file
- `logo.jpg`, `logoVisible.png` — application image assets

## Security and privacy

SchoolReports handles student names, marks, and other school records. Use synthetic data for demonstrations. Do not publish real student records, report PDFs, database backups, or credentials. The application contains legacy SQL construction that should be reviewed and migrated to prepared statements before use with sensitive or production data. Protect database access and review account and password handling before deployment.
