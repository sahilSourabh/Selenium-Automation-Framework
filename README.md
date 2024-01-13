# Selenium Automation Framework

## Overview

Welcome to the Automation Framework Project repository! This project is designed to provide a robust and flexible automation framework for web application testing. It leverages popular tools such as Selenium, TestNG, Cucumber, Java, Streams, and more to streamline the testing process. The framework also incorporates advanced features like parallel execution of test cases, cross-browser testing, and the creation of Extent reports. Selenium Grid is employed to enhance parallel testing capabilities, and Apache POI is used for seamless integration with Excel for test data.

## Key Features

- **Selenium:** Powerful browser automation tool for controlling web browsers through programs.
- **TestNG:** Testing framework inspired by JUnit and NUnit, designed for testing needs.
- **Cucumber:** Behavior Driven Development (BDD) framework for writing acceptance tests.
- **Java Streams:** Functional programming features in Java for efficient data processing.
- **Listeners:** Customized event listeners to enhance test case monitoring and reporting.
- **Parallel Execution:** Execute test cases concurrently for faster results.
- **Cross-Browser Testing:** Test across multiple browsers to ensure compatibility.
- **Extent Reports:** Generate comprehensive HTML reports for test execution results.
- **Selenium Grid:** Scale your test execution by distributing tests on multiple machines.
- **Apache POI:** Simplify reading and writing Excel files, enabling seamless integration with test cases.
- **Chrome Dev Tools:** Integrate Chrome Developer Tools for advanced debugging and profiling.
- **BrowserStack Integration:** Extend cross-browser testing capabilities using BrowserStack.
- **Maven Integration:** Run your automation suite directly from the Maven terminal using simple commands.
- **CI/CD with Jenkins:** Automate your test suite using Jenkins for continuous integration and delivery.

## Getting Started

1. **Prerequisites:**
   - Ensure you have Java JDK installed.
   - Install Maven for project dependency management.
   - Set up Jenkins and configure the necessary plugins for CI/CD.

2. **Clone the Repository:**
   ```bash
   git clone https://github.com/sahilSourabh/Selenium-Automation-Framework.git
   cd Selenium-Automation-Framework
   ```

3. **Configure Dependencies:**
   - Update `pom.xml` with the required dependencies.

4. **Configure Test Environment:**
   - Update configuration files for browsers, Selenium Grid, and other settings.

5. **Execute Tests:**
   - Run test cases locally using the following Maven command:
     ```bash
     mvn clean test
     ```

6. **CI/CD with Jenkins:**
   - Create a Jenkins job, configure source code management, and set up build triggers.
   - Add build steps to execute Maven commands for the automation suite.

## Documentation

Detailed documentation on how to use each component, create and maintain test cases, and leverage the features provided by the framework can be found in the [Wiki](/wiki) section of this repository.

## Contributions

We welcome contributions from the community! If you find any issues, have feature requests, or want to contribute enhancements, please submit a pull request.

Happy testing! 🚀
