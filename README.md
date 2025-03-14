# Microservices Project

This project contains several microservices for managing orders and payments. It is built using Spring Boot and provides REST APIs to handle orders and payments in an e-commerce application.

---

## Getting Started

To get started with this project, clone the repository and follow the instructions below to run the application locally.

### Prerequisites

- Java 17 or later
- Maven or Gradle
- Spring Boot
- Docker 

---

## Technologies Used

- **Spring Boot** (for backend development)
- **Spring Data JPA** (for database interactions)
- **Hibernate** (for object-relational mapping)
- **PostgreSQL** (used for storing data)
- **REST API** (for communication between services)
- **Spring Cloud** (for microservice communication)

---

## Services

### Order Service
The **Order Service** handles the creation and retrieval of orders.

#### Endpoints:
1. **POST /orders**: Create a new order.
   - **Request Body**:
     ```json
     {
       "customerId": 1,
       "orderTotal": 100.50,
       "status": "PENDING"
     }
     ```
   - **Response**: The newly created order with its ID.

2. **GET /orders/{orderId}**: Retrieve an order by its ID.
   - **Response**: The details of the order with the given ID.

3. **GET /orders**: Retrieve all orders.
   - **Response**: A list of all orders in the system.

---

### Payment Service
The **Payment Service** processes payments for orders. It supports creating and retrieving payment records.

#### Endpoints:
1. **POST /payments**: Create a new payment for an order.
   - **Request Body**:
     ```json
     {
       "orderId": 123,
       "amount": 50.75
     }
     ```
   - **Response**:
     - `200 OK`: The payment has been successfully processed.
     - `400 BAD REQUEST`: If there is an error during payment processing (e.g., invalid amount or order).

2. **GET /payments/{paymentId}**: Retrieve a payment by its ID.
   - **Response**:
     - `200 OK`: The payment record.
     - `404 NOT FOUND`: If the payment with the specified ID does not exist.

---

### Product Service
The **Product Service** retrieves product data from an external API (`https://fakestoreapi.com/products`).

#### Endpoints:
1. **GET /products**: Retrieve all products.
   - **Response**: A list of all products from the external API.
   - **Example Response**:
     ```json
     [
       {
         "id": 1,
         "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
         "price": 109.95,
         "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
         "category": "men's clothing",
         "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
         "rating": {
           "rate": 3.9,
           "count": 120
         }
       },
    
     ]
     ```

2. **GET /products/{id}**: Retrieve a product by its ID.
   - **Response**: The details of the product with the given ID.
   - **Example Response**:
     ```json
     {
       "id": 1,
       "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
       "price": 109.95,
       "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
       "category": "men's clothing",
       "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
       "rating": {
         "rate": 3.9,
         "count": 120
       }
     }
     ```

---
