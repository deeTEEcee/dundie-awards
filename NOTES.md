TODO:
1. Review Spring and this codebase.
2. Look through the code and understand it.
3. Write Notes on improvements. (Remember that they plan to add an endpoint)

### README+Code Notes
* Missing instructions on how to setup and run the application.
```
# https://docs.spring.io/spring-boot/docs/3.2.5/gradle-plugin/reference/htmlsingle/
./gradlew build
./gradlew bootRun # Defaults to port 3000. It probably finds main by scanning the application.

OR
# Example classpath: /Users/deeteecee/Projects/dundie_awards/build/classes/java/main
java -cp <list of all class paths with colon separation> com.ninjaone.dundie_awards.DundieAwardsApplication 


```

* Spring boot: 3.2.0
* Spring core: 6.1.1

Spring components:
* Controller+RequestMapping
* Entity
* Repository
* Service
* Component - The most generic
* Autowired
* Configuration

Spring startup workflow (starts at "DundieAwardsApplication.java")
* Loads application context and configuration
* Loads CommandLineRunner (DataLoader)

### Code Improvements

