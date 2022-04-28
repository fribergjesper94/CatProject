# CatProject
Testing out Spring Boot with MongoDB and some standard CRUD-operations and custom exception handling.

This project is a microservice where i wanted to try out to persist data with mongoDB via an API.
I have also added RabbitMQ to the project. When you use the endpoint "/publish" you will send a message to the queue
and from the other project in the repository named "cat-project-rabbit-consumer" you can consume the messages from the queue provided by this microservice
