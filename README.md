# Virtual Threads in Java

## Overview

This project is a demonstration of **Virtual Threads** in Java, a feature introduced to improve the scalability and performance of concurrent applications. Virtual threads are lightweight, managed by the JVM, and allow you to create a vast number of threads with minimal overhead, making them ideal for high-concurrency environments.

## Features

- **Demonstrates Virtual Threads**: Simple examples showing how to create and use virtual threads in Java.
- **Asynchronous Execution**: Examples of running tasks asynchronously using virtual threads.
- **Scalable Concurrency**: Showcases how virtual threads can be used to handle a large number of concurrent tasks efficiently.

## Installation

To run this project, you'll need to have Java 21 or higher installed on your machine.

### Prerequisites

- **Java 21 or higher**: Ensure you have the correct Java version installed.
  
### Installation Steps

1. **Clone the repository**:
    ```bash
    git clone https://github.com/username/virtual-threads-java.git
    ```
2. **Navigate to the project directory**:
    ```bash
    cd virtual-threads-java
    ```
3. **Compile the project**:
    ```bash
    javac VirtualThreadsExample.java
    ```
4. **Run the example**:
    ```bash
    java VirtualThreadsExample
    ```

## Usage

This project includes examples that illustrate how to create and manage virtual threads in Java.

### Example 1: Simple Virtual Thread

```java
Thread.ofVirtual().start(() -> {
    System.out.println("Running in a virtual thread: " + Thread.currentThread().getName());
});
