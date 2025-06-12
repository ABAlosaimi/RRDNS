# Round Robin DNS 

## Overview
This project implements a Round Robin DNS using Java and Spring Boot. It provides a service to resolve IP addresses for a given domain name, leveraging caching for improved performance.

## Features
- **DNS Resolution**: Resolves A records for domain names using the `dnsjava` library.
- **Caching**: Uses Caffeine Cache to store DNS records temporarily for faster subsequent lookups.
- **REST API**: Exposes an endpoint to resolve domain names via HTTP requests.

## Project Structure
```
src/
  main/
    java/
      com/
        dnslb/
          dnsloadblancer/
            DnsloadblancerApplication.java
            RRDNS/
              Configs.java
              ExeceptionHandling.java
              RRDNSController.java
              RRDNSservice.java
  resources/
    application.properties
  test/
    java/
      com/
        dnslb/
          dnsloadblancer/
            DnsloadblancerApplicationTests.java
```

## Prerequisites
- Java 17 or higher
- Maven

## Setup
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd dnsloadblancer
   ```
3. Build the project:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints
### Resolve Domain
**GET** `/dns/resolve`

#### Parameters:
- `domain` (String): The domain name to resolve.

#### Example Request:
```bash
curl "http://localhost:8080/dns/resolve?domain=example.com"
```

#### Example Response:
```json
[
  {
    "name": "example.com.",
    "type": "A",
    "ttl": 300,
    "address": "93.184.216.34"
  }
]
```

## Configuration
### Cache Settings
The cache is configured in `Configs.java`:
- **Expiration Time**: 30 seconds
- **Maximum Size**: 100 entries

You can adjust these settings as needed.

## Technologies Used
- **Spring Boot**: Framework for building Java applications.
- **dnsjava**: Library for DNS resolution.
- **Caffeine Cache**: High-performance caching library.


## Author
Abdulrahman
