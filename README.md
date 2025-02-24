# SQA Test Task - REST API Testing

## Descripción

This project was developed as part of a test task requesting a test automation solution for {JSON} Placeholder, a free fake API for testing and prototyping, where the objective is to create a test suite for testing the following methods:

| Method  | Route                    |
|---------|--------------------------|
| GET     | `/posts`                 |
| GET     | `/posts/{id}`            |
| GET     | `/posts/{id}/comments`   |
| GET     | `/comments?postId={id}`  |
| POST    | `/posts`                 |
| PUT     | `/posts/{id}`            |
| PATCH   | `/posts/{id}`            |
| DELETE  | `/posts/{id}`            |

## Features

- API Automation Testing with Java.
- Layered Architecture (Core, Domain, Tests).
- Integration with TestNG and REST Assured testing tools.
- Critical path tests validations (positive and negative).
- Comments implemented for the understading of the code.
- Parallel Execution (4 Threads).
- Naming and Code Conventions: Oracle Code Conventions for Java, RestAssured/TestNG/Maven Documentation and Google Java Style Guide.

## Prerequisites

- Java 17 or higer.
- Maven 3.6.0 or higher.
- Git.

## Setup

1.  Clone the repository:

    ```bash
    git clone https://github.com/davidsates/sqa-test-task.git
    ```

2.  Navigate to the project folder:

    ```bash
    cd sqa-test-task
    ```

## Running the tests
- Run all the tests in the test suite:

    ```bash
    mvn test
    ```
- Running a Specific Test Set:

    Posts Test Set
    ```bash
    mvn test -Dtest=TestPosts
    ```

    Comments Test Set
    ```bash
    mvn test -Dtest=TestsComments
    ```

## Project Structure

    src
    ├── main
    │   └── java
    │       └── com
    │           └── david
    │               ├── core
    │               │   └── Base.java
    │               │     
    │               └── domain
    │                   ├── methods
    |                   |   └── APIMethods.java
    │                   └── models
    |                       ├── Comments.java
    |                       └── Posts.java    
    ├── test
    |    └── java
    │        └── com
    │            └── david
    │                └── tests
    │                    ├── TestComments.java
    │                    └── TestPosts.java
    ├── resources
    |   └── testng.xml
    ├── pom.xml
    └── README.md

* `src/main/java`: Contains the project's source code.
    * `core`: Contains the class for API configurations.
    * `domain`: Contains classes representing domain entities.
        * `methods`: Contains API Methods.
        * `models`: Contains Data Models.
* `src/test/java`: Contains the test source code.
    * `tests`: Contains the tests implemented.
* `src/test/resources`: Contains test resources.
* `pom.xml`: Maven configuration file.
* `README.md`: This file.

## Dependencies 

- RestAssured.
- TestNG.
- JSON Path.
- Jackson Databind.
- SLF4J Simple Provider.

You can find all the dependencies in the file pom.xml.

## Contributing

Contributions are welcome. Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or suggestions, feel free to contact me.