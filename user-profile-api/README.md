# ByteBookshelf API Service

ByteBookshelf is a backend API service supporting a niche online bookstore specializing in technology books. 

This API provides **user** and **credit card** management functionalities to enhance the user experience, making it possible to securely create and update user profiles and store credit card information.

![Java](https://img.shields.io/badge/Technologies-Java-blue) ![Spring Boot](https://img.shields.io/badge/Technologies-Spring%20Boot-yellow) ![MySQL](https://img.shields.io/badge/Technologies-MySQL-orange) ![Maven](https://img.shields.io/badge/Technologies-Maven-lightgrey)


## Features

The ByteBookshelf API Service offers the following capabilities:
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
- [Contributing](#contributing)
- [Contact](#contact-)

---

## Technologies

- **Java**
- **Spring Boot**
- **MySQL**
- **Maven** (for dependency management)

## Endpoints

The ByteBookshelf API provides RESTful endpoints for user profile and credit card management.

### User Management

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

### Credit Card Management

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

## Installation

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

## Usage
With the API running, you can make requests to the endpoints as listed above. You can use tools like Postman to interact with the API and test each endpoint.

## Contributing
Feel free to submit issues or pull requests for improvements or bug fixes. You can also open issues to discuss potential changes or enhancements. All contributions are welcome to enhance the app’s features or functionality!

To contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b feat/your-feature-name
- Alternatively, for bug fixes:
   ```bash
   git checkout -b fix/your-bug-fix-name
3. Make your changes and run all tests before committing the changes and make sure all tests are passed.
4. After all tests are passed, commit your changes with descriptive messages:
   ```bash
   git commit -m 'add your commit message'
5. Push your changes to your forked repository:
   ```bash
   git push origin feat/your-feature-name.
6. Submit a pull request to the main repository, explaining your changes and providing any necessary details.

## Contact 🌐
If you have any questions or feedback, feel free to reach out at [mrodr.contact@gmail.com](mailto:mrodr.contact@gmail.com).
