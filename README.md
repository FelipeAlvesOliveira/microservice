# Read Me
This project is used to study some microservice communication strategies.
At this project we can to see how to send messages (with the java-sender) and how to receive (with the java-reciever) in a microservice communication.

# Getting Started

This project requires a RabbitMQ to send async messages to consumers.

# Install and Run RabbitMQ

One easy way to use RabbitMQ is using it docker image.

Pull the RabbitMQ Docker image: `docker pull rabbitmq`

# Build and Run the project images
Build docker images: `docker compose build`

Run docker images: `docker compose up`
