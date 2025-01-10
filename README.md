Sensor API
Sensor API is a RESTful API for managing sensors, recording measurements, and analyzing weather-related data.

Features
Sensor Registration: Register unique sensors.
Measurement Recording: Record temperature and rainfall measurements for registered sensors.
Retrieve Measurements: Fetch all recorded measurements.
Count Rainy Days: Calculate the number of rainy days based on recorded data.

Technologies Used
Backend: Java, Spring Boot
Database: PostgreSQL
Testing: JUnit, Mockito

Installation and Setup
Prerequisites
Java 17+
Maven 3.8+
An IDE (e.g., IntelliJ IDEA)

Steps
Clone the repository:
git clone https://github.com/your-username/sensor-api.git
cd sensor-api
Install dependencies:
mvn install
Run the application:
mvn spring-boot:run
Access the application at:
http://localhost:8080

API Endpoints
1. Register a Sensor
2. Add a Measurement
3. Retrieve All Measurements
4. Count Rainy Days

Test Coverage
Controller Tests: Verify REST API behavior using MockMvc.
Service Tests: Mock service methods with Mockito.
