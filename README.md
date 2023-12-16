# Pantry Planner
"Early Prototype: This is a glimpse into the future! Although it's currently a basic Dockerized Spring server with MongoDB accessible at localhost, we're actively developing powerful features. Keep an eye out for the upcoming beta version!" 👨🏽‍💻🌱

## Description

Pantry Planner is a web application that helps you manage your food stores, develop cooking recipes, create meal plans, and generate shopping lists. With Pantry Planner, you can keep track of your ingredients and recipes in one place, so you always know what you have and what you need to buy.

## Features

- Add, edit, and delte ingredients and recipes
- create and edit meal plans for the week
- Generate shopping lists based on meal plans
- Search for recipes by name or ingredient
- View recipe details, including ingredients, directions, and nutritional information
- Mark ingredients as "in stock" or "out of stock"
- View a dashboard with a summary of your food stores and upcoming meals

## Technologies Used

- Eclipse-Temurin Java 17 SDK
- Spring Boot
- MongoDB
- Gradle
- Docker

## How to Use

To use Pantry Planner, you can either run the application locally on your computer or access it online if its deployed to a server.

## Running Application Locally

- Install Docker and Docker Compose if you haven't already.
- clone the git repo into a directory on your local machine.
- In a linux terminal navigate to the root directory of the project and run the provide shell script gradle-docker.sh
- Following the build process now we can run `docker-compose up` to start the application and the database.
- Open a web browser and navigate to `http://localhost:8080 `

## Accessing the Application Online

If the application is deployed to a server, you can access it using a web browser. Contact the administrator of the server for the URL and login credentials.

## Contributing

We welcome contributions to Pantry Planner! If you encounter a bug or have a feature request, please open an issue on the project's issue tracker at [GitHub](https://github.com/DennisVargas/PantryPlanner/issues). When submitting an issue, please provide as much detail as possible, including steps to reproduce the problem.

If you'd like to contribute code, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test them thoroughly.
4. Commit your changes and push them to your fork.
5. Open a pull request to the main repository.

We'll review your changes and work with you to merge them into the main branch

Thank you for your interest in contributing to Pantry Planner!

## License

Pantry Planner is licensed under the MIT License. See [LICENSE](LICENSE) for details.

## Acknowledgments

Pantry Planner was developed by Dennis Vargas as a personal project to resolve the head ache of meal planning and food storage management.
  
