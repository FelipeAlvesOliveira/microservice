# Read Me
This project is used to study some microservice communication strategies.
At this project we can to see how to receive messages in a microservice communication.

# Getting Started

This project requires a RabbitMQ to receive async messages from senders.

# Install and Run RabbitMQ

One easy way to use RabbitMQ is using it docker image.

Pull the RabbitMQ Docker image: `docker pull rabbitmq`

Run the RabbitMQ Docker image: `docker run --rm -d --hostname my-rabbit --name rabbit-name -p 5671:5671 -p 5672:5672 rabbitmq`

# Build and Run the project image
Build docker image: `docker build --tag java-receiver-img .`

Run docker image: `docker run --rm --name java-receiver-container -d -p 8082:8082 java-receiver-img`