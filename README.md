# ByteBookshelf API Service

ByteBookshelf is a backend API service supporting a niche online bookstore specializing in technology books. 

This API provides **user** and **credit card** management functionalities to enhance the user experience, making it possible to securely create and update user profiles and store credit card information.

![Java](https://img.shields.io/badge/Technologies-Java-blue) ![Spring Boot](https://img.shields.io/badge/Technologies-Spring%20Boot-yellow) ![MySQL](https://img.shields.io/badge/Technologies-MySQL-orange) ![Maven](https://img.shields.io/badge/Technologies-Maven-lightgrey)


### Features

The Geek Text API Service offers the following capabilities:
1. **User Profile Management** - Users can create, retrieve, update, and delete their profiles.
2. **Credit Card Management** - Users can add credit cards to their profiles for secure checkout.

---

### Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Endpoints](#endpoints)
    - [User Management](#user-management)
    - [Credit Card Management](#credit-card-management)
- [Installation](#installation)
- [Usage](#usage)

---

### Technologies

- **Java**
- **Spring Boot**
- **MySQL**
- **Maven** (for dependency management)

### Endpoints

The Geek Text API provides RESTful endpoints for user profile and credit card management.

#### User Management

1. **Create a User**
    - **Endpoint**: `/users`
    - **HTTP Method**: `POST`
    - **Description**: Adds a new user with username, password, and optional details (name, email, home address).
    - **Request Body**:
      ```json
      {
        "username": "string",
        "password": "string",
        "name": "string",
        "email": "string",
        "homeAddress": "string"
      }
      ```
    - **Response**: The created `User` object.

2. **Retrieve a User by Username**
    - **Endpoint**: `/users/{username}`
    - **HTTP Method**: `GET`
    - **Description**: Fetches a user by their username.
    - **Response**:
      ```json
      {
        "id": "integer",
        "username": "string",
        "password": "string",
        "name": "string",
        "email": "string",
        "homeAddress": "string"
      }
      ```

3. **Update a User**
    - **Endpoint**: `/users/{username}`
    - **HTTP Method**: `PUT`
    - **Description**: Updates all user fields except for email.
    - **Request Body**:
      ```json
      {
        "username": "string",
        "password": "string",
        "name": "string",
        "email": "string",
        "homeAddress": "string"
      }
      ```
    - **Response**: The updated `User` object (except email).

4. **Partial Update a User**
    - **Endpoint**: `/users/{username}`
    - **HTTP Method**: `PATCH`
    - **Description**: Allows partial updates on user fields.
    - **Request Body**: Partial `User` object with fields to update.
      ```json
      {
        "username": "string",
        "password": "string",
        "name": "string",
        "email": "string",
        "homeAddress": "string"
      }
      ```
      - **Response**: The updated `User` object (except email).

5. **Delete a User**
    - **Endpoint**: `/users/{username}`
    - **HTTP Method**: `DELETE`
    - **Description**: Deletes a user profile.

#### Credit Card Management

1. **Create a Credit Card for a User**
    - **Endpoint**: `/creditcards/{username}`
    - **HTTP Method**: `POST`
    - **Description**: Adds a credit card to a user’s profile.
    - **Request Body**:
      ```json
      {
        "cardNumber": "string",
        "cardHolderName": "string",
        "expirationDate": "string",
        "cvv": "string"
      }
      ```
    - **Response**: The created `CreditCard` object.

---

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mariarodr1136/ByteBookshelf.git
2. **Navigate to the project directory**:
    ```bash
   cd ByteBookshelf
3. **Install dependencies using Maven**:
    ```bash
   mvn clean install
4. **Configure MySQL Database in the application.properties file, setting the appropriate username, password, and database URL**


5. **Run the Application**:
    ```bash
   mvn spring-boot:run

### Usage
With the API running, you can make requests to the endpoints as listed above. You can use tools like Postman to interact with the API and test each endpoint.
