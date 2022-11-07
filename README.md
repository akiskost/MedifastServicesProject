# Medifast Services Project

---

A Java Web Full Stack Project for medical appointments. Connects to a database and manages entries.\
Functionality includes:
> - **Login \ Logout function with credentials**. Content not shown unless logged in
>
> - **Add/Modify/Search patient entries**
> - **Add/Modify/Search patient exam appointments**

### Technologies used
Database/Database Connectivity: MYSQL, JDBC, Tomcat 9\
Backend: JEE + JDBC, JSP, servlets | Architecture: Maven, DAO, SOA, DTO \
Frontend: HTML, CSS, Bootstrap, JavaScript

_Built on IntelliJ IDEA 2022.1.3 (Ultimate Edition), Build #IU-221.5921.22_

---
## Prequisities

**Database**\
MySQL Workbench 8.0.31\
Download: https://dev.mysql.com/downloads/workbench/

**IDEs**\
IntelliJ IDEA 2022.1.3 (Ultimate Edition), Build #IU-221.5921.22\
Download: https://www.jetbrains.com/idea/ \

Eclipse IDE for Enterprise Java and Web Developers Version: 2022-09 (4.25.0)\
Download: https://www.eclipse.org/downloads/

**Server**\
Apache Tomcat 9.0.62\
Download: https://tomcat.apache.org/download-90.cgi

**JDKs**\
JDK 8, JDK 11\
Download: https://aws.amazon.com/corretto/

---

## How to run
1. Install MySQLWorkbench and run the /resources/medifast_db.sql to build the database. 
2. Server Setup: Install Tomcat 9
   1. For IntelliJ : Add a local Tomcat 9 configuration. Add Project in Deployment (Build path)
   2. For Eclpise: Add a Tomcat 9 server, choose JDK 11 & run on server

---

### Notes

**Security notes:**\
-- An active user session via Login is required to show content across the website.\
-- When queries are executed, user session is not authorized. To be implemented in future versions.\
-- Hashing for password check is not implemented. To be added in future versions.\

---

### Credits