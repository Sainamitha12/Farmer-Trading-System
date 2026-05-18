# Farmer-Trading-System
Java Swing based Farmer Trading System using MySQL and JDBC

# Farmer Trading System

## Overview
Farmer Trading System is a Java-based desktop application developed using Java Swing, MySQL, and JDBC.  
The project is designed to create a direct interaction platform between farmers and consumers, reducing dependency on middlemen and improving communication and accessibility in agricultural trading.

The system allows farmers to publish crop details, manage product information, and communicate with consumers, while consumers can browse available crops, view farmer details, and access farming recommendations through an interactive graphical user interface.

---

## Objectives
- To provide a digital platform for farmers and consumers
- To simplify crop publishing and viewing processes
- To improve farmer–consumer communication
- To maintain crop and user information securely using MySQL database
- To provide useful agricultural recommendation resources

---

## Features
- User Registration and Login
- Secure Authentication System
- Crop Publishing Module
- Consumer Dashboard
- Crop Listing and Viewing
- Farmer–Consumer Communication
- Recommendation Module
- MySQL Database Connectivity
- Input Validation and Exception Handling
- Interactive GUI using Java Swing

---

## Technologies Used
- Java
- Java Swing
- JDBC
- MySQL
- Object-Oriented Programming (OOP)

---

## Software Requirements
- Java JDK 8 or above
- MySQL Server
- MySQL Workbench
- IDE (NetBeans / VS Code / Eclipse)

---

## Modules

### Registration Module
Allows users to register with personal details such as:
- Username
- Password
- First Name
- Last Name
- Mobile Number
- Country
- State
- District
- Gender

The registration details are securely stored in the MySQL database.

---

### Login Module
Provides secure authentication using username and password verification through JDBC database connectivity.

---

### Publish Crop Module
Farmers can publish crop details including:
- Crop Name
- Quantity
- Quantity Unit
- Price
- Price Unit
- Place
- Contact Information

The crop details are stored in the MySQL database and displayed in the consumer dashboard.

---

### Consumer Module
Consumers can:
- View available crops
- Access farmer details
- Browse crop information
- View quantity and pricing details

The module dynamically fetches crop data from the database using SQL queries.

---

### Communication Module
Provides a communication interface between farmers and consumers through a messaging system.

---

### Recommendation Module
Provides useful farming-related recommendation resources and agriculture websites for better farming practices and agricultural awareness.

---

## Database
The project uses MySQL database for storing:
- User Registration Details
- Crop Information
- Farmer Details

### Database Tables
- `farmer_registration`
- `crops1`

---

## Project Workflow
1. User Registration
2. Login Authentication
3. Crop Publishing by Farmers
4. Crop Data Storage in MySQL
5. Crop Viewing by Consumers
6. Communication Between Users
7. Access Farming Recommendations

---

## Project Structure

```text
Farmer-Trading-System
│
├── Communicate.java
├── Consumer.java
├── Home.java
├── Login.java
├── MyFrame.java
├── Publish.java
├── Recommendations.java
├── Registration.java
└── README.md
```

---

## Key Concepts Implemented
- Object-Oriented Programming (OOP)
- GUI Development using Java Swing
- JDBC Database Connectivity
- SQL Queries
- Event Handling
- Exception Handling
- User Authentication
- Database Management

---

## Project Screenshots

### Home Page
![Home Page](home_page.png)

### Login Page
![Login Page](login_page.png)

### Registration Page
![Registration Page](registration_page.png)

### Publish Crop Module
![Publish Crop](publish_crop.png)

### Consumer Dashboard
![Consumer Dashboard](consumer_dashboard.png)

### Communication Module
![Communication Module](communication.png)

### Recommendations Module
![Recommendations](recommendations.png)

---

## Future Improvements
- Online Payment Integration
- Real-time Chat System
- AI-based Crop Recommendations
- Mobile Application Support
- Cloud Database Integration
- Email Notification System

---

## Author
**Kuridi Chalapathi Sai Namitha**
