# 🏥 Clinic Booking System

Clinic Booking System este o aplicație backend dezvoltată folosind **arhitectură de tip microservicii**, destinată gestionării clinicilor medicale și a programărilor pacienților.

Proiectul este realizat cu **Spring Boot**, **PostgreSQL**, **Docker** și respectă principiile **arhitecturii stratificate (Layered Architecture)**, fiind pregătit pentru **deployment în Cloud**.

## 👥 Autori
- Ioniță David
- Cursaru Violeta
- Flueraru Roxana
- Ursu Andreea

## 🎯 Scopul proiectului

Scopul acestui proiect este de a demonstra:
- utilizarea arhitecturii pe microservicii
- separarea clară a responsabilităților
- comunicarea prin REST API
- persistarea datelor folosind JPA / Hibernate
- containerizarea aplicației cu Docker
- pregătirea aplicației pentru deployment în Cloud

## 🧱 Arhitectura aplicației

Aplicația este compusă din **3 microservicii independente**:

### 🔐 auth-service
- gestionează autentificarea și securitatea
- folosește Spring Security
- poate fi extins cu JWT / OAuth2

### 🏥 clinic-service
- gestionează clinicile medicale
- permite creare și listare clinici
- expune endpoint-uri REST

### 📅 appointment-service
- gestionează programările pacienților
- fiecare programare este asociată unei clinici
- expune endpoint-uri REST

Fiecare microserviciu:
- rulează pe un port diferit
- este independent de celelalte
- poate fi scalat separat

## 🧩 Arhitectura stratificată (Layered Architecture)

Fiecare microserviciu respectă următoarele straturi:

- **Controller Layer**
  - gestionează request-urile HTTP
  - expune endpoint-uri REST (GET, POST)

- **Service Layer**
  - conține logica de business
  - face legătura între controller și repository

- **Repository Layer**
  - comunică direct cu baza de date
  - utilizează Spring Data JPA

- **Entity Layer**
  - mapează tabelele din baza de date PostgreSQL

### Fluxul unei cereri:
Client → Controller → Service → Repository → Database

## 🗄️ Persistența datelor

- Baza de date: **PostgreSQL**
- ORM: **Hibernate (JPA)**
- Tabelele sunt generate automat de Hibernate

Tabele principale:
- `clinics`
- `appointments`

## 📦 Containerizare cu Docker

Proiectul utilizează **Docker** pentru rularea bazei de date PostgreSQL într-un container.

### Avantaje Docker:
- mediu de rulare consistent
- ușor de configurat și mutat
- pregătit pentru rulare în Cloud

## 🐳 Rulare PostgreSQL cu Docker

```bash
docker run -d \
  --name clinic-postgres \
  -e POSTGRES_DB=clinic_booking_db \
  -e POSTGRES_USER=clinic_user \
  -e POSTGRES_PASSWORD=clinic_pass \
  -p 5432:5432 \
  postgres:15
```

## 🚀 Rulare locală a aplicației
1️⃣ Pornește baza de date (Docker)
Asigură-te că Docker rulează și containerul PostgreSQL este activ.

2️⃣ Pornește fiecare microserviciu
În folderul fiecărui serviciu:

```bash
.\mvnw spring-boot:run
```

Porturi implicite:
auth-service → 8081
clinic-service → 8082
appointment-service → 8083

## 🔗 Endpoint-uri principale
🏥 Clinic Service
GET /clinics – listare clinici
POST /clinics – creare clinică

📅 Appointment Service
GET /appointments – listare programări
POST /appointments – creare programare

## 🧪 Testare
Endpoint-urile pot fi testate folosind:

Postman
Browser (fetch API)
Swagger (opțional)

## ☁️ Deployment în Cloud
Aplicația este pregătită pentru deployment în Cloud folosind:

Docker
servicii precum AWS, Azure, Google Cloud, Railway sau Render

Pași generali de deployment:
containerizarea aplicației
configurarea variabilelor de mediu
rularea containerelor în Cloud
expunerea serviciilor prin URL public

## 🔐 Securitate
securitatea este gestionată prin auth-service
bazată pe Spring Security
ușor de extins cu JWT pentru autentificare între servicii

## ✅ Concluzie
Clinic Booking System este un proiect backend modern care demonstrează:
utilizarea microserviciilor
arhitectură stratificată
containerizare cu Docker
bune practici Spring Boot
pregătire pentru Cloud
Proiectul este extensibil și poate fi dezvoltat ulterior cu funcționalități suplimentare.
