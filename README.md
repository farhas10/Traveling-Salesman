# Traveling Salesman Problem Solver

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Contributions](https://img.shields.io/badge/contributions-welcome-brightgreen)

This project solves instances of the **Traveling Salesman Problem (TSP)** using Java. The TSP aims to find the shortest possible route that visits a set of points (cities) exactly once and returns to the origin city.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- **TSP Input Files**: The project includes a variety of input files in the `input/` directory that describe different TSP instances (e.g., Germany, USA).
- **Tour Management**: The `Tour.java` class is responsible for managing the tour, optimizing the path, and calculating distances.
- **Visualization**: The project may utilize `stdlib.jar` for graphical or command-line visualization of the solution.

## Project Structure

TravelingSalesman/
├── .classpath              # Eclipse-specific classpath configuration
├── .gitignore              # Git ignore file to exclude unnecessary files
├── .project                # Eclipse project configuration
├── stdlib.jar              # External library, possibly for visualization or utilities
├── input/                  # Directory containing input files (coordinates, test cases, etc.)
│   ├── bier127.txt
│   ├── circuit1290.txt
│   ├── germany15112.txt
│   ├── mona-100k.txt
│   ├── mona-20k.txt
│   ├── mona-50k.txt
│   ├── tsp0.txt
│   ├── tsp1.txt
│   ├── ...
├── src/                    # Source folder containing the Java code
│   ├── Point.java          # Represents a point in the tour
│   ├── Tour.java           # Main class to manage and optimize the TSP tour
│   ├── TourDriver.java     # Driver class to run the TSP algorithm
│   ├── TourTest.java       # Test class for validating the TSP solution

## License

This project is licensed under the MIT License.
