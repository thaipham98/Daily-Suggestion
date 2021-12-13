# Daily-Suggestion

Daiy Suggestion is a web application made with Spring Boot framework, which suggests users funny things to do in the day given their preference and the current weather at their location.

## Usage

1. Open your terminal 

2. Clone this github repository
```bash
git clone https://github.com/thaipham98/Daily-Suggestion.git
```

3. Open the project with an IDE (IntelliJ preferred)

4. Start the application
```bash
 mvn spring-boot:run
```
or find the `DailySuggestionApplication` at `src/main/java/com/example/dailysuggestion/DailySuggestionApplication.java` then run the program.

5. After the server is hosted up, open a web browser and go to `localhost:8080/home`. This URL can change so make sure you go to the right port number.

6. Enjoy my application

7. Stop the application 
```bash
 mvn spring-boot:stop
```
or stop your running program

## Summary & Caveats
### Summary
The application is a class project. Specifically, it contains:
- All required basic concepts covered in class as stated by the professor.
- Some intermediate concepts covered in class as stated by the professor.
- Some advanced concepts that I did some researchs.
- An easy to use UI with handling of corner cases or invalid user inputs, HTTP error handling.
- Design separating API handlers from user-interaction handlers and helper functionalities.
- Preliminary unit tests.
- README and easy dependency installations.
### Caveats
The project can be improved given more time, for examples in some areas like:
- Robustness: More extensive testing and design to bring more OOP or other design patterns (MVC) to increase robustness and maintenance ease.
- Scalability: Currently, the application is simple with a few options for making a profile of an user. 
