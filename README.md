Java, springboot, and MySQL are used for this project. 
springboot initializer creates template with Gradle option. 

- interface to use CRUD repository : Springboot writes SQL behind the scene. (Create, Read, Update, Delete)
- Fund class with @Validation to ensure input data is met conditions.
- Contollers specifies web address routers depending on HTTP type(Get and POST)
- One-to-Many relationship between Fund and asset Class: one-to-many annotation creates foreign key to asset class table. 
