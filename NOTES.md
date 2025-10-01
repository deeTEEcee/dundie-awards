TODO:
1. Review Spring and this codebase.
* Test each crud part
* Understand the strange model.addAttribute in index.
* Create data persistence with a db (sqlite?)

2. Look through the code and understand it.
3. Write Notes on improvements. (Remember that they plan to add an endpoint)

### README+Code Notes
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
* Missing instructions on how to setup and run the application.
```
# https://docs.spring.io/spring-boot/docs/3.2.5/gradle-plugin/reference/htmlsingle/
./gradlew build
./gradlew bootRun # Defaults to port 3000. It probably finds main by scanning the application.

OR
# Example classpath: /Users/deeteecee/Projects/dundie_awards/build/classes/java/main
java -cp <list of all class paths with colon separation> com.ninjaone.dundie_awards.DundieAwardsApplication 
```

General stuff:
* No visibility of organizations (at UI level or endpoint level)
* Error messages are too long, not short and descriptive.
* Data is not persistent but this is a test application for job candidates.
* No unit tests
* Controllers could be mapped better. Both are global root endpoints and not namespaced.
* Could use JsonProperty to specify custom names that don't directly match the variable name.

Minor:
* activityRepository might be used in a separate controller. If used by employees, then maybe under the context of a subfolder in the future.
* Might be better to import jakarta.persistence.<class name> instead of .*


Model validation:
* Employee - required fields, requires organization field. Otherwise, it fails on the main page.
  * When adding employee, validation is too long. It does say the body is missing but the message looks too long and is a "stack trace"
  * When adding employee, empty json was allowed.
    * This allows bad data to go through the system which our GET `/employees` fails to handle.
    * Error message could be be added for this case, telling us a user couldn't be added and why that was the case.
  * New/Update needs to be handled separately. If we require first and last name during inupt, they shouldn't both be required in update.
* Activity - ??
* Organization - ??

