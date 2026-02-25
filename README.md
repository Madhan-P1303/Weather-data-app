**🌦 Weather Data Processing & Analytics API**

**📌 Project Overview**

This project processes nearly 20 years of Delhi weather forecast data from a CSV file and provides REST APIs to retrieve and analyze weather information.

**The dataset includes parameters such as:**

Temperature
Humidity
Pressure
Heat Index
Weather Condition

**The application:**

Transforms raw CSV data into structured format
Stores the processed data in a MySQL database
Provides APIs to retrieve and analyze weather details

**The system is built using:**

Java 17
Spring Boot
MySQL
JPA / Hibernate
OpenCSV

**🏗 Architecture**

The project follows a modular layered architecture:

controller  →  service  →  repository  →  database
**Packages:**
controller – REST API endpoints
service – Business logic
repository – Database access layer
entity – JPA entities

**⚙️ Setup & Run Instructions**
1️⃣ Clone the Repository
git clone https://github.com/Madhan-P1303/weather-api.git
cd weather-api
2️⃣ Create MySQL Database
CREATE DATABASE weather_db;
3️⃣ Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/weather_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
4️⃣ Run the Application

Using Maven:
mvn spring-boot:run
Or run the main class from your IDE.
Server runs at:
http://localhost:8080
📂 **CSV Upload**
Upload the CSV file using:
POST /api/weather/upload

**In Postman:**
Select Body
Choose form-data
Key = file
Type = File
Upload the CSV file
This will:
Parse CSV
Convert invalid values (-9999) to null
Store records in MySQL
<img width="740" height="327" alt="image" src="https://github.com/user-attachments/assets/71f2af16-5130-4e45-bc18-005257b424a5" />


**🌐 API Endpoints**
1️⃣ Get Weather by Date

**Retrieve weather details for a specific date:**

GET /api/weather/date?date=1996-11-01

**Returns:**

Weather condition
Temperature
Humidity
Pressure


**2️⃣ Get Weather by Month**

Retrieve weather details for a specific month:
GET /api/weather/month?year=1996&month=11
<img width="717" height="435" alt="image" src="https://github.com/user-attachments/assets/7f2b1726-733f-40fd-92aa-f934a690e632" />


**3️⃣ Get Monthly Temperature Statistics**

Retrieve minimum, median, and maximum temperature for a given month:
GET /api/weather/stats?year=1996&month=11
<img width="719" height="503" alt="image" src="https://github.com/user-attachments/assets/15fc9af9-c4da-4f01-9dc4-1439a59a03d9" />



**📊 Features Implemented**

CSV transformation and validation
Batch database insertion
Modular code structure
Date-based filtering
Month-based filtering
Sorting support
Min / Median / Max temperature calculation
Efficient data storage (200,000+ records tested)

**🛠 Technologies Used**

Java 17
Spring Boot
Spring Data JPA
MySQL
OpenCSV
Maven

**📎 Notes**

Large dataset (~200k+ records) successfully stored and tested.
Invalid temperature values (-9999) are handled as null.
Application follows clean architecture principles.

**👨‍💻 Author**

Madhan
madhan93454@gmail.com
