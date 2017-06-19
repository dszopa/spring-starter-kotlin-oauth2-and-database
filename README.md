# Brainstormer-Backend

The backend for the **Brainstormer** project

# Features
- Spring OAuth2 Security
- Spring REST API creation
- Test & Real Database connections

# Running the Application

Running the application will start running the server and serve it on `localhost:8080`

#### Prod
You can run the application in production mode by executing the gradle task 

```bootRunProd```

#### Test
You can run the application in test mode, with a test database that is populated by schema.sql by executing the gradle task 

`bootRunTest`

The test database able to be accessed by going to `localhost:8080/console`

# TODO
- Plan out what is needed in terms of entities & database relations
- Provide an API to power `Brainstormer-Frontend` and `Brainstormer-Mobile`
