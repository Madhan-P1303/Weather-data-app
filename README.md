📌 Project Overview

This project processes and analyzes nearly two decades (1996–2016) of weather forecast data for Delhi.

The dataset includes:

Temperature

Humidity

Pressure

Heat Index

Weather Conditions

Date & Time

The application:

Transforms raw CSV data into structured format

Stores it in a MySQL database

Provides REST APIs to retrieve and analyze weather information

Built using:

Java 17

Spring Boot

Spring Data JPA

MySQL

OpenCSV

Maven

🏗 Architecture

The project follows a layered, modular architecture:

com.weather
│
├── controller        → REST Controllers
├── service           → Business logic
├── repository        → Data access layer
├── entity            → Database entities
└── config (optional) → Configuration classes

This ensures:

Clean separation of concerns

Maintainability

Scalability

Production-ready structure

⚙️ Technologies Used
Technology	Purpose
Spring Boot	Backend framework
Spring Data JPA	ORM layer
MySQL	Database
OpenCSV	CSV parsing
Lombok	Boilerplate reduction
Maven	Dependency management
🗄 Database Setup
1️⃣ Install MySQL

Ensure MySQL is installed and running.

2️⃣ Create Database
CREATE DATABASE weather_db;
3️⃣ Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/weather_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

server.port=8080
🚀 How To Run The Project
Step 1: Clone Repository
git clone <repository-url>
cd weather-project
Step 2: Build Project
mvn clean install
Step 3: Run Application
mvn spring-boot:run

OR run the main class from your IDE.

Server runs at:

http://localhost:8080
📥 Upload CSV Data
API Endpoint
POST /api/weather/upload
Using Postman:

Select POST

URL: http://localhost:8080/api/weather/upload

Go to Body

Select form-data

Key: file

Type: File

Upload CSV file

Send

If successful:

CSV uploaded and stored successfully!
📊 Available APIs
1️⃣ Get Weather by Date
GET /api/weather/date?date=1996-11-01

Optional sorting:

GET /api/weather/date?date=1996-11-01&sortBy=temperature

Returns:

Weather Condition

Temperature

Humidity

Pressure

2️⃣ Get Weather by Month
GET /api/weather/month?year=1996&month=11

Optional sorting:

GET /api/weather/month?year=1996&month=11&sortBy=humidity
3️⃣ Get Monthly Temperature Statistics
GET /api/weather/stats?year=1996&month=11

Returns:

{
  "min": 19.0,
  "median": 25.0,
  "max": 30.0
}
📈 Features Implemented

✔ CSV file transformation
✔ Batch database insertion (200,000+ records tested)
✔ Modular architecture
✔ Date-based filtering
✔ Month-based filtering
✔ Sorting functionality
✔ Monthly min / median / max temperature calculation
✔ Null handling for missing values (-9999)

 Data Handling Strategy

Date format parsed using: yyyyMMdd-HH:mm

Missing values (-9999) converted to null

Batch saving implemented for performance

Clean separation between controller and service layers

🔎 Sample Response
{
  "id": 1,
  "datetimeUtc": "1996-11-01T11:00:00",
  "weatherCondition": "Smoke",
  "temperature": 0.0,
  "humidity": 27.0,
  "pressure": 1010.0,
  "heatIndex": null
}
📦 Performance

Successfully processed ~200,752 records

Optimized using batch insert

MySQL indexing can be added for production scaling

🎯 Assessment Requirements Checklist
Requirement	Status
CSV Transformation	✅ Completed
Structured Storage	✅ Completed
Modular Code	✅ Completed
Date API	✅ Completed
Month API	✅ Completed
Min / Median / Max Temperature	✅ Completed
👨‍💻 Author

Madhan
Backend Developer

🏁 Conclusion

This project demonstrates:

Large dataset processing

REST API development

Database integration

Data analytics implementation

Clean software architecture

The application is production-ready and scalable for future enhancements.
