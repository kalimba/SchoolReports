# SchoolReports

SchoolReports is a Java Swing desktop application for managing school information, entering student marks, and generating student reports. The project uses MySQL for data storage and iText for PDF report generation.

## Project status

This repository contains the Java source code, NetBeans GUI form files, project configuration, application images, and the runtime libraries that were included with the supplied project.

**Important:** The supplied archive did not include a MySQL database export. A starter schema has now been added under `sql/`, inferred from the SQL statements in the Java source. It has not been verified against the original database; follow `DATABASE_SETUP.md` and validate it before using real school records.

## Features visible in the supplied source

- Login screen
- Admin and teacher account screens
- Student and class management
- Course and teacher assignment
- Student marks entry and updates
- Report calculations and PDF report generation

## Requirements

- JDK 8 or a compatible JDK
- Apache NetBeans with Java SE support (the project uses the NetBeans Ant project format)
- MySQL Server
- The database created using the starter schema in `sql/01_create_database.sql` (subject to validation)

The included MySQL Connector/J is an old 5.1.39 driver. Consider upgrading it and testing compatibility before using this application in production.

## Open in NetBeans

1. Download or clone this repository.
2. In NetBeans, choose **File → Open Project**.
3. Select the folder containing this `README.md` and `build.xml`.
4. Allow NetBeans to load the project.
5. Configure the database environment variables described below.
6. Build and run the project from NetBeans.

The NetBeans project classpath uses `${basedir}/lib/...` references, so it resolves dependencies relative to the project folder rather than relying on machine-specific `E:\` or `G:\` paths.

## Database installation

Follow [DATABASE_SETUP.md](DATABASE_SETUP.md) to install MySQL, create the database and tables, create an application database user, and configure the application. The starter schema is in [`sql/01_create_database.sql`](sql/01_create_database.sql). Because the original database export was not included, verify the inferred schema against the original database before using real records.

## Database configuration

The application reads its connection details from environment variables. It no longer contains a hard-coded `root` account with an empty password.

Set these variables on the computer where the application will run:

- `SCHOOLREPORTS_DB_URL` — for example, `jdbc:mysql://localhost:3306/school-reports`
- `SCHOOLREPORTS_DB_USER` — a MySQL user with the required permissions
- `SCHOOLREPORTS_DB_PASSWORD` — that user's password

Use a dedicated database account rather than the MySQL root account. Do not commit real passwords, database dumps containing personal information, or production connection details.

On Windows PowerShell, you can set them for the current terminal session like this (replace the example values):

```powershell
$env:SCHOOLREPORTS_DB_URL = "jdbc:mysql://localhost:3306/school-reports"
$env:SCHOOLREPORTS_DB_USER = "schoolreports_app"
$env:SCHOOLREPORTS_DB_PASSWORD = "replace-with-your-local-password"
```

Then launch the application from that same terminal/IDE process so it inherits the variables.

## Dependencies

The `lib/` directory contains the runtime JARs supplied with the original project:

- MySQL Connector/J 5.1.39
- iText 5.5.4 modules
- JTattoo 1.6.11
- rs2xml

These dependencies are retained to keep the original NetBeans project classpath self-contained. Review each dependency's license and compatibility before redistributing the application.

## Repository contents

- `src/` — Java source files and NetBeans `.form` GUI definitions
- `nbproject/` — shared NetBeans project configuration
- `DATABASE_SETUP.md` — step-by-step MySQL installation and configuration
- `sql/01_create_database.sql` — inferred database schema
- `lib/` — runtime dependency JARs
- `logo.jpg`, `logoVisible.png` — application image assets
- `build.xml` — NetBeans Ant build file

Generated `build/` and `dist/` output, machine-specific `nbproject/private/` settings, and sample PDF reports from the supplied archive are intentionally excluded.

## Privacy and security notes

This application handles student names, marks, and other school records. Use synthetic data for demonstrations and screenshots. Do not publish real student records, report PDFs, database backups, passwords, or personal information.

The original source contains SQL statements assembled using string concatenation. Before deploying this application with real school data, review and replace these with `PreparedStatement` parameters to reduce SQL injection risk.

## License

No license has been added. Choose a license only after confirming that you own or have permission to publish the source code and bundled assets/dependencies. Without a license, GitHub users do not automatically receive permission to reuse, modify, or distribute the project.
