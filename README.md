## Documentation

Welcome to the Country Searcher Application, written by Stephan Ellenberger.

### How to run the application

If you'd like to compile your own version of this application, you can do so with:

```bash
mvn clean && mvn compile
```

To run the compiled application, run this command from the root directory:

```bash
mvn exec:java -Dexec.mainClass=org.countries.Main 
```

### Testing

To run the automated test suite, run the following command from the root directory:

```bash
mvn test
```

## Documentation

Thank you for taking the time to review my application and tech test.

I've used Maven for my package manager, jackson for deserialization, and JUnit for testing.  

The application is split into 4 main classes:

1. CountriesApplication -> Responsible for running the requirements of the tech test. It takes in CountriesClient using DI, with the sole purpose of mocking the API call during tests. 
2. CountriesClient -> responsible for making the request to the API, deserializing the response and casting it to Countries.
3. Countries -> responsible for storing the list of countries and providing methods to search the list.
4. Country -> Responsible for storing the data for a single country.

There are two other, smaller classes. 

1. Order -> An enum for the order of the lists. Either DESCENDING or ASCENDING
2. CountryName -> A class for the country name, as there were multiple attributes in the response for each country. I just stored the common name. 

The CountryApplication is called from the Main class. 

The requirements of the tech test are passed to the CountriesApplication class and the results are printed out to the console.

## Testing

I've used JUnit 5 for the testing of this application. Instructions on how to run the tests are above. 
