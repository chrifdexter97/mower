# Quick Test:

the source code contains a valid input file named "input.txt" under the resources folder.

in order to run it, don't forget to add the correspondant arg:
``` 
--file /src/main/resources/input.txt
```
or
``` 
-f /src/main/resources/input.txt
```

# unit tests and manual quality gate

this project has been tested against sonar default quality gate and has 94% ut tests

In order to test sonar, a minimalist docker compose is located under **src/main/docker/docker-compose-sonar.yml**

to run it make sure u have a valid running docker environment then run:
``` 
docker-compose -f src/main/docker/docker-compose-sonar.yml up -d
``` 
setup a project named **LandMower** with a key holding the same name. setup an scan token then run:
``` 
mvn clean verify sonar:sonar -Dsonar.login=YOUR_TOKEN
``` 

This project has been configured to use **checkstyle** plugin for linting the project following **Sun Checks**. to validate it you can run:
``` 
mvn clean verify checkstyle:check
``` 
and to have a generated static web page report run:
``` 
mvn clean verify checkstyle:checkstyle
``` 
the report will be located under **target/reports/**.
