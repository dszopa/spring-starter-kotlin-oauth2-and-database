# Brainstormer-Backend

The backend for the **Brainstormer** project

# Features
- Spring OAuth2 Security
- Spring REST API creation
- Test & Real Database connections

# Running the Application
You can run the application in production mode by executing the gradle task 

```bootRun```

You can run the application in test mode, with a test database that is populated by schema.sql by executing the gradle task 

`bootRunTest`

Both of these tasks will spin up servers on `localhost:8080`

# TODO
- Plan out what is needed in terms of entities & database relations
- Provide an API to power `Brainstormer-Frontend` and `Brainstormer-Mobile`
