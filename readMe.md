# Application
I have created a Kotlin Spring Boot application. The application can be run using Maven.

# Endpoint Design
I have created an endpoint to return details about the user's virtual cards and transaction details on each virtual card. The user's username and password are hard coded in the application properties file. A valid user's credentials can be input there. The endpoint design uses the MVC design pattern. Data to be fetched and returned is modeled in the model package. Business logic is contained in the service package and the endpoints are in the controller package. On the service layer we have an authentication service to log the user into extend's system and get a bearer token. The ClientCardAccessService contains business logic for fetching virtual card and transaction details.

# Test Design
I have created an integration test show output from the service layer. This test is commented out because it will require client credentials and also depends on the production extend api. Perhaps a better design of an integration test for these apis might use a sandbox environment where a test user exists and has test data that is stable.

# Manual Testing
The following url can be used for testing: http://localhost:8080/api/client/cardAccess once application.properties file is updated with a valid user's credentials.

