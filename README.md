## Java Spring Boot Security with Google and GitHub Login

This project demonstrates how to implement authentication using Google and GitHub in a Java Spring Boot application.

## Prerequisites

- Java 22 or later
- Maven
- A Google account with a registered OAuth 2.0 client ID and client secret
- A GitHub account with a registered OAuth 2.0 client ID and client secret

## Setup

### 1. Clone the Repository

```sh
git clone https://github.com/LinhDangDev/Java-Springboot-Security.git
cd Java-Springboot-Security
```

### 2. Configure OAuth 2.0 Credentials

**Google Login**

1. Go to the [Google Developers Console](https://console.developers.google.com/).
2. Create a new project or select an existing project.
3. Navigate to **Credentials** and create a new **OAuth 2.0 Client ID**.
4. Set the authorized redirect URIs to `http://localhost:8080/login/oauth2/code/google`.
5. Copy the **Client ID** and **Client Secret**.

**GitHub Login**

1. Go to your [GitHub Developer Settings](https://github.com/settings/developers).
2. Register a new **OAuth application**.
3. Set the authorization callback URL to `http://localhost:8080/login/oauth2/code/github`.
4. Copy the **Client ID** and **Client Secret**.

### 3. Update `application.properties`

Copy and paste the following properties into your `src/main/resources/application.properties` file:

```properties
# GitHub Login
spring.security.oauth2.client.registration.github.client-id=${GITHUB_OAUTH_CLIENT_ID}
spring.security.oauth2.client.registration.github.client-secret=${GITHUB_OAUTH_CLIENT_SECRET}

# Google Login
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_OAUTH_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_OAUTH_CLIENT_SECRET}
```

Alternatively, you can set these values in your environment variables or in a `.env` file.

### 4. Build and Run the Application

Use Maven to build and run the application:

```sh
mvn clean install
mvn spring-boot:run
```

### 5. Access the Application

Open your browser and go to `http://localhost:8080`. You should see options to log in with Google or GitHub.

## Additional Configuration

### Customize Redirect URIs

If you deploy the application to a different environment, ensure that the redirect URIs registered with Google and GitHub match the deployed URLs.

### Security Configuration

The security configurations can be found in the `src/main/java/com/bookstore/config/SecurityConfig.java` file. Customize it as per your security requirements.

