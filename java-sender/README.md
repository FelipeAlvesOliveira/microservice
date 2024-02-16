# Read Me
This project is used to study some microservice communication strategies.
At this project we can to see how to send messages in a microservice communication.

# Getting Started

This project requires a RabbitMQ to send async messages to consumers.

# Install and Run RabbitMQ

One easy way to use RabbitMQ is using it docker image.

Pull the RabbitMQ Docker image: `docker pull rabbitmq`

Run the RabbitMQ Docker image: `docker run --rm -d --hostname my-rabbit --name rabbit-name -p 5671:5671 -p 5672:5672 rabbitmq`

# Build and Run the project image
Build docker image: `docker build --tag java-sender-img .`

Run docker image: `docker run --rm --name java-sender-container -d -p 8081:8081 java-sender-img`