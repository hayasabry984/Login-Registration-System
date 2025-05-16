# Login-Registration-System

This app uses Layered Architecture
________________________________________
Feature	--> Support

User API --> Spring Web

Database (Users, Roles, Tokens)	--> Spring Data JPA + PostgreSQL

Authentication & Security --> Spring Security + JWT

Password hashing --> via Spring Security (typically using BCrypt)

Email verification --> Spring Mail

Input validation --> Spring Validation

Secure secrets --> .env with java-dotenv

Rapid development	--> DevTools & Lombok

Testing	--> JUnit & Spring Boot Testing
________________________________________
- A RESTful API is a way for programs (like applications, or Postman) to communicate with backend server using the internet (HTTP)
________________________________________
Action --> HTTP Method--> URL Description

Register new user --> POST -->/api/auth/register --> Client sends user info to register

Login --> POST --> /api/auth/login --> Client sends email & password

Verify email --> GET --> /api/auth/verify --> Click link to verify account
________________________________________
- Authentication: Verifying who you are  Logging in with email + password
- Authorization: Checking what you can access  Can you delete a post? Can you view admin?
________________________________________
🧱 1. Controller Layer

Handles HTTP requests from the client (e.g., register, login).

Receives input, calls the service, sends back the response.
________________________________________
2. Service Layer
   
Contains business logic (e.g., register user, hash password, generate JWT, send email).

Performs the real "thinking" of the app.
________________________________________
3. Repository (Data Access) Layer

Interacts with the database using Spring Data JPA.

Saves, updates, deletes, and queries user data.
________________________________________
4. Model/Entity Layer

Defines the structure of your data (e.g., User class maps to the users table in the DB).

Represents your app’s data or database structure.
________________________________________
🔑 Summary:

Client → Controller → Service → Repository → Database
________________________________________
Flow :

Frontend or Postman -----> Your Spring Boot App (Server) (Embedded Tomcat Server) -----> Database (PostgreSQL)                       
________________________________________


The main entities (or actors):
1. Client: Enters email, password, etc., to register or log in.
________________________________________
2. Frontend simulation using postman: Sends HTTP requests (like register/login) to your backend.
________________________________________
3. Backend (Spring Boot app) Your Java application.
   
   . The backend is everything that runs on the server (all the backend layers, business logic, DB access, etc.).

   . Receives requests from the frontend.  (Controller Layer)

   . Handles business logic (registration, login, email verification). (Service Layer)

   . Validates input, encrypts passwords, creates JWT tokens. (Service Layer)

   . Talks to the database. (Repository Layer)

   . Sends responses back. (Controller Layer)
________________________________________
4. Server (Tomcat inside Spring Boot) The "engine" running your backend.

   . The server is part of the backend.

   . When you run your app Spring Boot Starts an embedded server by default it's called Tomcat

   . Listens for requests on http://localhost:8080 (this is your server's address during development ) using Embedded Tomcat server (automatically set up by Spring Boot)

   . Routes requests to your Java code (controllers). Using Controller Layer (@RestController)

   . Sends responses to the client. Using Spring Boot + your Controller's return values (like ResponseEntity)
________________________________________
5. Database (A PostgreSQL server you set up (e.g., authdb))

   . Stores user accounts (email, password hash, etc.).

   . Can store verification tokens, roles, etc.

   . Backend reads/writes data here using Spring Data JPA.
________________________________________
6. Database Client (pgAdmin or CLI):

   Tool for you, the developer to Let you manually view or manage database tables and data.
________________________________________
Client: Uses the system

Frontend: Sends user data to backend (Postman/UI)

Backend: Processes data, logic, talks to DB

Server (Tomcat): Runs the backend and serves API endpoints

Database: Stores persistent user data

DB Client: Lets you inspect/manage the DB

________________________________________

JWT (JSON Web Token)
A JWT is a compact, secure way to transmit user data (like user ID or roles) between client and server after login. It has 3 parts:

Header – contains token type and signing algorithm

Payload – contains user data (claims)

Signature – ensures the token is not tampered with

________________________________________

JWT_SECRET_KEY
The JWT_SECRET_KEY is used by the server to:

Sign the token when creating it

Verify the token when receiving it

If the token’s signature doesn’t match (e.g., someone changed the payload), it’s rejected.

________________________________________

How it works 

User logs in

Server verifies credentials and creates a JWT signed with JWT_SECRET_KEY

JWT is sent to the client

Client sends JWT with each request (usually in the Authorization header)

Server uses JWT_SECRET_KEY to verify and extract user info from the token
