# Beauty Salon

Beauty Salon is a servlet based web application for bookings management at a beauty salon.
Created as a final study project for Epam Java Course.

## Project Description

1. The system implements beauty salon employees schedule. The roles are:
   * Guest
   * Client
   * Master
   * Admin
2. **Guest** can see the catalogue of services and salon masters list. Guest can sort that list by:
   * master's name
   * master's rating
   
   as well as filtering this list by:
   * specific master
   * specific service
3. **Client** (authorized user) can book specific service that is provided by master and specific timeslot.
4. **Admin** can:
   * see all bookings and change the timeslot
   * cancel booking
   * receive payments for the service
5. **Master** can see his own schedule (booked and free timeslots) and indicate that the service was provided.
6. After the service was provided, a client can leave a review. The review request comes to client's email the next dey after the service was provided.

## Tech requirements and constraints

1. The system is based on **Servlet API**, with Tomcat as servlet container.
2. Domain information is stored in a relational database (**MySQL**). Database access is based on **JDBC API** and connection pool. The use of any ORM frameworks was not allowed.
3. The system architecture represents the **MVC** pattern. The use of any MVC frameworks (a.e. Spring MVC) was not allowed. The use of Project Lombok was not allowed.
4. The system is multilingual:  
   * the interface can be switched between UA/EN languages 
   * both Latin and Cyrillic input can be stored in the database
   * dates are represented by **DateTime** library (Java8) 
5. Several design patterns were implemented in the system, such as Builder, Singleton, Listener.
6. Repeated request to the server protection is in place (Post/Redirect/Get).
7. System supports authentication and authorization, user rights distribution.
8. All passwords are encoded.
9. Logging is implemented using **Log4j** library.
10. Important pieces of code are covered with **JavaDoc** comments.
11. The system is covered with unit test using **JUnit** library.
12. Front end is based on the **JSP** pages with the use of **HTML**, **CSS**, **JS**, **Bootstrap** framework was used. 
13. JSP pages contain input validation, pagination, error handling messages, as well as **JSTL** library tags (including several custom tags).
14. The system supports work with sessions, filters and listeners.
15. **GitHub** was used for version control.

## Launch guide

1. Database folder contains **init.sql** file for you to be able to set database locally. Please add link with your database properties to the **app.properties** file in the connection.url parameter.