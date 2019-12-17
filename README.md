# Java Reading YAML Files

  
Java project with examples for reading YAML files.

  ## Getting Started
  
The project, done in Java 1.9 using IntelliJ 2019.3 and Maven, simply shows six ways of reading yaml files **only for reference**:

 - How to merge two yaml files into one class ... the second yaml file
   overlaps the values of the first yaml file.
 - Simple loading of yaml file into a class.
 - Load yaml file into an immutable class using builder (without
   setters).
 - Load the yaml file with properties that do not exist in the class.
 - Load Yaml into a JsonNode object.
 - Differences Between Two Yaml Files - Using Guava.

### Maven:

    <dependencies>  
        <dependency> 
            <groupId>com.fasterxml.jackson.core</groupId>  
            <artifactId>jackson-databind</artifactId>  
            <version>2.9.9</version>  
        </dependency> 
        <dependency>  
            <groupId>com.fasterxml.jackson.dataformat</groupId>  
            <artifactId>jackson-dataformat-yaml</artifactId>  
            <version>2.9.9</version>  
        </dependency> 
        <dependency> 
            <groupId>com.google.guava</groupId>  
            <artifactId>guava</artifactId>  
            <version>28.1-jre</version>  
        </dependency>
    </dependencies>  
    <build>  
        <plugins> 
            <plugin> 
                <groupId>org.apache.maven.plugins</groupId>  
                <artifactId>maven-compiler-plugin</artifactId>  
                <configuration> 
                    <source>1.8</source>  
                    <target>1.8</target>  
                </configuration> 
            </plugin> 
        </plugins>
    </build>



### Yaml Files

Location: /src/main/resources

|Yaml File  |Description  |
|--|--|
|useraccess.yaml| Used to simulate, for example, a default or remote yaml file. |
|useraccess local.yaml|Used to simulate, for example, a yaml file with values for overlay or location.|
|useraccess missing.yaml  | Used to simulate, for example, a yaml file that does not contain all the information the class expects. |


## Authors

-   **Fausto Branco** - _Initial work_ - [Git faustobranco](https://github.com/faustobranco)
