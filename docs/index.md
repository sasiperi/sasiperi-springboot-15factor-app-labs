# [SasiPeri: 15 factor APPs](http://localhost:8080/v1/customer)

This is your newly scaffolded Spring Boot App, Good Luck!

To start build app & OCI image (buildpacks/paketo), run:

```sh
    
    mvn -pl :springboot-app-final -am spring-boot:run -Dspring-boot.run.profiles=local
    
```

To run the application
```sh
    mvn -pl :springboot-app-final -am spring-boot:build-image
```

To access API-Docs (swagger gui):  http://localhost:8086/v1/swagger-ui/index.html
To access raw openAPI spec:        http://localhost:8086/v1/v3/api-docs
