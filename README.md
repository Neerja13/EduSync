# EduSync

EduSync is your all-in-one solution for managing everyday college tasks like marking attendance, allotting or submitting assignments, and arranging exam seating—all in one place. 
It’s built to make life easier for students, teachers, and admins by replacing manual work with quick, automated systems. With QR-based attendance, deadline-based assignment uploads, and auto-generated seating plans, EduSync brings a modern touch to campus life. It’s powered by Java Spring Boot on the backend and React.js on the frontend, offering a smooth and secure experience for everyone.


## Features

- QR-Based Attendance with time and location validation

- Assignment Management with uploads, deadlines, and grading

- Exam Seating Planner for auto-generating seating arrangements

- Role-Based Access for admin, teachers, and students

- Notifications & Reports via email/SMS with optional analytics

- Clean, responsive UI with dark mode support

  
## Tech Stack

- Frontend: React.js, HTML CSS, BootStrap, GSAP

- Backend: Java, Spring Boot

- Database: MySQL

- Authentication: JWT, Spring Security

- Deployment: AWS, Github


# 🪑 Seating Arrangement & QR Attendance System - Spring Boot

This is a **Spring Boot-based REST API** application that allows teachers to:
- Generate a unique QR code-based session for attendance.
- Allow students to mark attendance by scanning the QR code.
- Create and retrieve class room seating arrangements.
- Use **Swagger UI** to test and explore all endpoints interactively.

---

## 🚀 Features

- ✅ Generate unique class sessions with QR code.
- ✅ Mark attendance using enrollment number and Gmail.
- ✅ Create class rooms with rows of seats.
- ✅ Retrieve class room layout by class number.
- ✅ Fully documented APIs using **Swagger UI**.
- ✅ MySQL integration for persistent storage.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.4.4**
- **MySQL**
- **Swagger (springdoc-openapi)**
- **ZXing** for QR Code generation

---

## 📦 Project Structure

├── controller
│ ├── AttendanceController.java
│ └── ClassRoomController.java
├── dto
│ ├── SessionRequest.java
│ └── AttendanceRequest.java
├── model
│ ├── Session.java
│ ├── Attendance.java
│ └── ClassRoom.java
├── repository
│ ├── SessionRepository.java
│ └── AttendanceRepository.java
├── service
│ └── ClassRoomService.java
├── util
│ └── QRCodeGenerator.java
└── resources
└── application.properties


---

## 🔧 Setup & Run

### ✅ 1. Clone the Repository

```bash
git clone https://github.com/your-username/seating-arrangement.git
cd seating-arrangement

✅ 2. Configure MySQL

Ensure MySQL is running, and update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/seating_arrangement
spring.datasource.username=root
spring.datasource.password=maheshvic123

    Tip: You can change port by editing server.port=9921

✅ 3. Build and Run the App

./mvnw spring-boot:run

or from your IDE (IntelliJ, VSCode)
🔍 API Documentation (Swagger)

Once the app is running, open:

http://localhost:9921/swagger-ui/index.html

Here you can test and explore all API endpoints directly.
📌 Sample API Usage
🔸 POST /api/generate-session

Request Body:

{
  "className": "CSE-A"
}

➡️ Generates a session ID + QR code (stored in /qrcodes/ folder).
🔸 POST /api/mark-attendance

Request Body:

{
  "sessionId": "generated-session-id",
  "enrollmentNumber": "123456",
  "gmail": "student@example.com"
}

➡️ Marks attendance for the given session.
🔸 POST /seating_arrangement/class_room/create/class_room

{
  "classNo": "CSE-A",
  "seatRow": [
    ["A1", "A2", "A3"],
    ["B1", "B2", "B3"]
  ]
}

➡️ Creates a seating layout for the class.
🔸 GET /seating_arrangement/class_room/get/class_room/{classNo}

➡️ Retrieves layout for a given class (e.g. "CSE-A")
📷 QR Code Output

QR codes for sessions are generated using ZXing and stored at:

/qrcodes/{session-id}.png

You can display them in your frontend or print for students to scan.
## Future Improvements
- Mobile app for on-the-go access

- AI insights for attendance and grading

- Integration with LMS platforms


## Acknowledgements

 - Thanks to the open-source community for providing libraries like React.js, Spring Boot, and more.

- Special thanks to our mentors and peers for their support and feedback during development.


## Authors

- [Mahesh04022004](https://github.com/Mahesh04022004)
- [Neerja13](https://github.com/Neerja13)

