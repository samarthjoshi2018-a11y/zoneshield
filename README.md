# ZoneShield

ZoneShield is a location-based security and monitoring system built using a microservices architecture. It enables users to create virtual zones (zoneshields), track movement in real time, and receive instant alerts when boundaries are breached. The system ensures continuous monitoring through distributed services and event-driven communication, providing reliable notifications and user control over security zones for enhanced personal safety and awareness across the platform ecosystem efficiently and securely.

---

#  System Architecture

ZoneShield follows a distributed microservices design:

- **API Gateway**
- **Service Registry (Eureka)**
- **User Service**
- **Auth Service (JWT based authentication)**
- **Email Service (Kafka Consumer)**
- **React Frontend (myapp)**
- **MySQL Database**
- **Apache Kafka (Event-driven communication)**

---

#  Tech Stack

- **Backend:** Spring Boot (Microservices)
- **Frontend:** React (myapp)
- **Database:** MySQL
- **Messaging Queue:** Apache Kafka
- **Service Discovery:** Eureka Server
- **Security:** JWT Authentication (via API Gateway)
- **Session Handling:** Cookies
- **Architecture:** Microservices

---

#  Microservices Overview

## 1. API Gateway
- Entry point for all requests
- Handles routing to microservices
- JWT authentication validation
- Cookie management for session tracking

---

## 2. Service Registry (Eureka)
- Registers and discovers all microservices
- Ensures dynamic service communication

---

## 3. User Service
Handles user-related operations:
- User registration
- Profile management
- Circle (zoneshield) creation & editing
- Setting trusted emails
- Timer configuration
- Zone activation/deactivation

---

## 4. Auth Service
- User login & authentication
- JWT token generation
- Token validation via API Gateway

---

## 5. Email Service
- Listens to Kafka events
- Sends email notifications
- Handles breach alerts logic

---

## 6. React Frontend (myapp)
User interface includes:
- Map-based circle drawing (zoneshield)
- Timer setup
- Trusted email configuration (3 emails)
- Start/Stop (Set/Unlock) zone monitoring
- Dashboard for alerts and status

---

#  Authentication Flow

1. User logs in via Auth Service
2. JWT token is generated
3. Token is passed via API Gateway
4. API Gateway validates JWT
5. Session maintained using cookies

---

#  ZoneShield Core Features

##  Basic Service

- User can create a zoneshield (circle on map)
- Edit or update zoneshield anytime
- Set a timer for monitoring
- Add **3 trusted email addresses**
- Activate zone monitoring ("Set")
- If user **breaches the zone:**
  - Email alerts sent to all trusted emails
  - System waits **5 minutes**
  - If still outside zone → sends alert again
- User can **unlock/disable monitoring anytime**

---

##  Premium Service (Coming Soon)

Includes all Basic features plus:

- AI-based movement pattern analysis
- Smart behavior detection
- Predictive alerts
- Advanced notification system
- Personalized security insights

---

#  zoneshield Flow (Kafka)

1. User breaches zoneshield
2. User Service publishes zoneshield to Kafka
3. Email Service consumes zoneshield
4. Email notifications sent to trusted emails
5. Timer logic triggers re-check every 5 minutes

---

#  Database

- MySQL used for:
  - User data
  - zoneshield data
  - Trusted emails
  - Session & configuration data

---

#  Key Workflow

1. User logs into system
2. Creates zoneshield on map
3. Sets trusted emails + timer
4. Activates zone monitoring
5. System continuously tracks location
6. On breach → Kafka event triggered
7. Email Service sends alerts
8. System rechecks every 5 minutes
9. User can unlock anytime

---

#  Future Scope

- Technology can be used in anroid application (Android/iOS)
- Can be used in IOT devices like smartwatches
- Real-time tracking dashboard improvements
  

---

#  Author

Samarth Joshi
