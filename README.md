# Covid Testing Service

Covid Reporting service is traditional blocking service which return mock data of covid symptoms.

- Covid Report service runs on the port 8083
  `` http://localhost:8083``

## Prerequisites

What things you need to install the software and how to install them

```
- IntelliJ(Optional)
- JDK11
- Maven
- NoSqlbooster(Optional)
- Database
  - MongoDb  
  - Run the script for creating database and collection in mongodb
```
### Databse Scripts

  ```
    use covid_report_db;
    db.createCollection("covid_symptoms");
    db.covidInfo.createIndex({"id": 1 }, { unique: true } );
    
  ```
  ```
  Import the covid_symtoms.json from resources folder file to mongodb collection "covid_symptoms" :
  src/main/resources/db_mock_data/covid_symtoms.json
  
  ```
## Start the spring boot service from root folder of the project
  - mvn clean package
  - java -jar target/covid_report_service-0.0.1-SNAPSHOT.jar
   * ``(Or)``
  - mvn spring-boot:run
   * ``(Or)``
  - Can import in IntelliJ aand run as main application by adding the Main file

## API
  - http://localhost:8083/covid-reporting-service/reporting/all
  - http://localhost:8083/covid-reporting-service/reporting/all/stats
  

## Diagnostics

1. Check for jdk version as it requires JDK 11
      - <terminal>> java -version
2.  Check if mongo service is on
      - mongod --dbpath <your-path>/data/db
       
## Contributing

 - Suhail Mir
  
 ## References
  - https://start.spring.io/
  
 ## Dataset
  - Generate Mock Data from mockaroo
     ``https://www.mockaroo.com/``
