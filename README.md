# My Hospital (backend)
The hospital management app is mainly used for maintaining any hospital’s functionalities and activities automatically.

# Proceso de Instalacion
1) Crear la base de datos MySQL
2) Al ejecutar el codigo fuente JAVA Spring se creara la estructura de las tablas de la base de datos y se realizara una carga inicial de datos.

En el archivo de configuracion: application-dev.properties se puede configurar para la creacion, actualizacion o validacion
Se recomienda ejecutar la 1era vez con la siguiente configuracion 
spring.jpa.hibernate.ddl-auto=create
Despues se debe cambiar este valor:
spring.jpa.hibernate.ddl-auto=update

Se puede cambiar el puerto del server con la configuracion siguiente
server.port=8080

Se debe establecer la url donde se encuentra creada la base de datos 
se sugiere el nombre de: my-hospital
spring.datasource.url=jdbc:mysql://localhost:3306/my-hospital?serverTimezone=UTC

Se debe establecer las credenciales del usuario con acceso a la base de datos MySql
spring.datasource.username=user
spring.datasource.password=password

El sitio cuenta con SWAGGER para poder realizar pruebas de los servicios rest
Se puede ingresar con url-server/my-hospital/api/swagger-ui.html
Ejemplo: http://localhost:8080/my-hospital/api/swagger-ui.html#/

La aplicacion esta habilitada para Cross Origin Requests
