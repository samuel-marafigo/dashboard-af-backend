# AF-Dashboard-backend

This is the backend project for the AF Dashboard application. It is built using Spring Boot and JDK 17.

The project aims to provide data processing and API services regarding the pharmaceutical assistance activities for the municipality of São José dos Pinhais.

This project uses public data obtained through the municipality's [transparency website](https://saudetransparente2.sjp.pr.gov.br).

The frontend for this project is available at: [https://github.com/samuel-marafigo/dashboard-af-frontend](https://github.com/samuel-marafigo/dashboard-af-frontend).

## Table of Contents

- Requirements
- Installation
- Running the Project
  - Running with Docker
  - Running without Docker
- Contributing
- License

## Requirements

- JDK 17
- Maven 3.6+
- Docker (optional, for running with Docker)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/samuel-marafigo/dashboard-af-backend.git
    cd dashboard-af-backend
    ```

2. Install dependencies and build the project:

    ```bash
    mvn clean install
    ```

## Running the Project

### Running with Docker

1. Ensure you have Docker installed on your machine.

2. Build and run the Docker container:

    ```bash
    docker-compose up --build
    ```

4. The application will start and be accessible at `http://localhost:8080`.

### Running without Docker

1. Start the application:

    ```bash
    mvn spring-boot:run
    ```

2. The application will start and be accessible at `http://localhost:8080`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.
