# Employee Attendance Scheduler

This project is a system for managing and recording employee attendance and work shifts. It is built as part of a university course and demonstrates key concepts in relational databases, Java application development, and data modeling.

## Features

* Record employee arrivals and departures
* Plan and manage employee work schedules
* Store employment contracts and department information
* Use of DTOs for structured data transfer
* Integrated JPA for database access
* Designed with modular and scalable architecture

## Technologies Used

* Java 17+
* Spring Data JPA
* Maven
* PostgreSQL (or another SQL-based DBMS)
* HTML (for relation model visualization)

## Structure

```
src/
├── main/
│   ├── java/cz/cvut/fel/dbs/
│   │   ├── model/          # Entity classes (Employee, Attendance, etc.)
│   │   ├── Dto/            # Data Transfer Objects
│   │   └── config/         # JPA configuration
│   └── resources/          # Application configuration files
```

## Documentation

* `DBSDescription.pdf` – Full description of the database schema and project goals
* `RelationModel.html` – Visual ER diagram of the database
* Source code is documented using JavaDoc conventions

