# Global Dorm - Distributed Accommodation Finder

## Overview

**Global Dorm** is a distributed system designed to help international and exchange students find long-term accommodation (3+ months) in the UK. This application demonstrates advanced integration of RESTful web services, Service-Oriented Architecture (SOA), and cloud deployment principles, as required for the COMP30231 "Service-Centric and Cloud Computing" module at Nottingham Trent University.

---

## Table of Contents

- [Features](#features)
- [Skills & Technologies](#skills--technologies)
- [System Architecture](#system-architecture)
- [Cloud & Big Data Analysis](#cloud--big-data-analysis)
- [Sample Workflows](#sample-workflows)
- [Professional Development](#professional-development)
- [Extra Functionalities](#extra-functionalities)
- [Documentation & Demo](#documentation--demo)
- [License & Authorship](#license--authorship)

---

## Features

- **RESTful Orchestrator Service**  
  - Implements core REST endpoints for searching rooms, applying for rooms, cancelling applications, and viewing application history.
  - All communication is via JSON, with robust object serialization/deserialization using GSON.

- **Client Application**  
  - Text-based client supporting all RESTful endpoints, sending/receiving JSON data.
  - Uses Java’s `HttpRequestBuilder` for efficient HTTP requests.

- **NoSQL Data Storage**  
  - Room and application data stored in MongoDB.
  - Uses POJO mapping for seamless integration between database fields and JSON objects.

- **External Web Services Integration**  
  - **OSRM Distance Calculation API**: Checks room proximity to specific locations.
  - **Open Cage Geocoding API**: Geocodes addresses and postcodes to coordinates for OSRM queries.
  - **7Timer! Weather API**: Provides 7-day weather forecasts for accommodation listings.

- **Robust Error Handling**  
  - Basic error handling is implemented, with recommendations for using SLF4J loggers for enhanced debugging.

---

## Skills & Technologies

- **Programming Languages**: Java (recommended; platform-independent clients encouraged)
- **Frameworks & Libraries**: RESTful services, GSON (JSON serialization), MongoDB (NoSQL storage), POJO mapping
- **External APIs**: OSRM, Open Cage Geocoding, 7Timer! Weather
- **Cloud Services**: Azure, AWS S3, Google BigQuery (for analysis, backup, event streaming, and scalable deployment)
- **Service-Oriented Architecture**: Loose coupling between client and server, JSON as communication protocol
- **Big Data & Cloud**: Scalability, latency reduction, auto-scaling, security (encryption, HTTPS)

---

## System Architecture

- **Orchestrator Service**: Exposes REST endpoints, handles core business logic, integrates external APIs, manages MongoDB persistence.
- **Client**: Text-based, sends/receives JSON requests to Orchestrator, displays responses.
- **External Services**: APIs for distance, weather, and geocoding.
- **Database**: MongoDB for persistent storage of rooms and applications.
- **Cloud Integration**: Designed for hybrid cloud deployment, supporting scalability and data protection.

**Architecture Diagram (High-level):**
```
[ Client ] <--JSON--> [ Orchestrator REST API ] <--JSON--> [External APIs: OSRM, Weather, Geocoding]
                                    |
                                [ MongoDB ]
```

---

## Cloud & Big Data Analysis

### Cloud Migration & QoS

- **Hybrid Cloud Model**: Combines public and private clouds for cost-effective, secure hosting.
- **Scalability**: Auto-scaling on Azure VMs, peak time resource allocation, edge servers for latency reduction.
- **Security**: HTTPS, data encryption, compliance with data protection laws.
- **Latency & Redundancy**: Edge caching, multi-zone deployment for redundancy.

### Big Data - The 3 Vs

- **Volume**: MongoDB supports horizontal scaling, AWS S3 for backup/disaster recovery; designed for 10,000+ users and terabytes of data.
- **Velocity**: Azure Event Hubs and Functions for real-time data streaming and processing; handles thousands of concurrent interactions.
- **Variety**: Integration of structured (MongoDB), semi-structured (JSON), and unstructured (external APIs) data; Google BigQuery for querying diverse datasets.

---

## Sample Workflows

1. **Search for Rooms**  
   *Client sends JSON request to Orchestrator; Orchestrator returns room listings with geocoded distance and weather information.*

2. **Apply for Room**  
   *Client submits application via JSON; Orchestrator stores application, responds with status.*

3. **Check Application Status**  
   *Client requests application history; Orchestrator queries MongoDB and returns status (accepted, rejected, cancelled, pending).*

4. **External Data Enrichment**  
   *Orchestrator calls OSRM for distance, Open Cage for geocoding, 7Timer! for weather, returning enriched room data.*

---

## Professional Development

Completing this project develops and evidences:

- Technical expertise in RESTful web service integration, API consumption, and NoSQL databases.
- Skills in cloud migration, scalability, and distributed system design.
- Experience with real-time data processing and Big Data handling.
- Soft skills: project management, problem-solving, critical thinking, and technical documentation.
- Compliance with academic integrity and best practices in software engineering.

---

## Extra Functionalities

- Integration of three external APIs for enhanced user experience.
- Hybrid cloud deployment model for scalability and security.
- Recommendations for improved error handling (SLF4J), security (authentication, encryption), and UI enhancements (GUI or web client).
- Auto-scaling and edge caching for performance optimization.

---

## Documentation

- Comprehensive report included in repository, covering implementation, cloud migration analysis, and Big Data considerations.
- All code and documentation comply with academic integrity policies.

---

## License & Authorship

This project is submitted for COMP30231 coursework at NTU. All code is original unless otherwise stated, and all dependencies are properly attributed.

**Author:** [gilo9](https://github.com/gilo9)  
**Module:** Service-Centric and Cloud Computing (COMP30231), Nottingham Trent University
