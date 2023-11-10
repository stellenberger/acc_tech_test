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

