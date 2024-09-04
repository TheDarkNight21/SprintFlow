SprintFlow

Welcome to SprintFlow, a powerful project management and collaboration tool designed to streamline teamwork and project tracking. This platform helps teams stay organized, track progress, and manage tasks efficiently, enabling teams to focus on what matters most.

Overview

SprintFlow is built with a Java Spring backend and React TypeScript frontend. The backend is responsible for managing user authentication, project data, and team collaboration features, while the frontend offers an intuitive user interface to interact with the system.

Key Features

	•	Team Collaboration: Manage teams, join projects, and collaborate effectively.
	•	Task Management: Create and assign tasks, track progress, and set deadlines.
	•	User Authentication: Secure login, registration, and password management with Spring Security.
	•	Project Overview: Provides a clear overview of projects, tasks, and team activity.
	•	Responsive UI: Built with React and TypeScript for a smooth and user-friendly interface.

Getting Started

Backend Setup (Java Spring)

To set up the Java Spring backend, please ensure you configure the following environmental variables so the application.yml file works correctly:

	•	local_db_url: The URL to the database.
	•	local_db_username: The username for the database (usually postgres for local development).
	•	local_db_password: The password you set for your database.

Frontend Setup (React TypeScript)

The frontend is built using React and TypeScript for a modern and responsive interface. It handles user interactions, data visualization, and provides forms for login, registration, and project/task management.

Installation

1. Clone the repository

git clone https://github.com/yourusername/sprintflow.git
cd sprintflow

2. Backend Setup

	•	Make sure you have Java and Maven installed on your system.
	•	Navigate to the backend directory:

cd backend

	•	Set the required environment variables as mentioned above.
	•	Run the backend server:

mvn spring-boot:run

3. Frontend Setup

	•	Navigate to the frontend directory:

cd frontend

	•	Install dependencies:

npm install

	•	Start the frontend development server:

npm start

Once both the backend and frontend servers are running, open your browser and navigate to http://localhost:3000 to access SprintFlow.

Project Structure

Backend (Java Spring)

	•	AuthController.java: Handles user authentication, including login and registration.
	•	AuthenticationResponse.java: Provides a response structure for successful authentication.

Frontend (React TypeScript)

	•	login.tsx: Handles the user login functionality.
	•	register.tsx: Handles user registration.
	•	projects.tsx: Displays projects and manages user interaction with projects.
	•	forgotPassword.tsx: Provides functionality for users to reset their passwords.
	•	joinTeam.tsx: Enables users to join teams and collaborate on projects.

Environment Variables

To make sure the application runs properly, configure the following environment variables:

	•	Backend:
	•	local_db_url: URL of the database to connect to.
	•	local_db_username: Username for the database (commonly postgres in local setups).
	•	local_db_password: Password for the database.

Future Enhancements

We plan to implement the following features:

	•	Enhanced Reporting: Generate detailed project reports and activity summaries.
	•	Real-Time Notifications: Notify users of important project updates and deadlines.
	•	Task Dependencies: Introduce dependencies between tasks to improve project planning.
	•	Team Chat Integration: Enable team communication directly within the platform.

License

This project is licensed under the MIT License. See the LICENSE file for more details.
