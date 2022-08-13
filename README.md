# Proyecto de prueba: dummy-sample-rest-test

API Dummy Rest Examples
-----
El proyecto de pruebas automatizadas está implementado con la librería Serenity en su versión xxxxx utilizando el patrón
de diseño
ScreenPlay con las versiones actualizadas a Cucumber6 versión xxxxx para el proyecto de Dummy API Rest.

Se realizan validaciones a través de los diferentes endpoints relacionados con los
siguientes procesos:

+ **GET**: Consulta de todos los empleados *https://dummy.restapiexample.com/api/v1/employees*.
+ **GET**: Consulta de un empleado por medio del id de empleado *https://dummy.restapiexample.com/api/v1/employee/1*.
+ **POST**: Creación de un nuevo empleado *https://dummy.restapiexample.com/api/v1/create*.
+ **PUT**: Modificación de un empleado por medio del id de empleado *https://dummy.restapiexample.com/api/v1/update/21*.
+ **DELETE**: Eliminación de un empleado *https://dummy.restapiexample.com/api/v1/delete/2*.

El framework
---

### BDD

Se utiliza BDD como framework de automatización para la automatización de los escenarios de prueba, la idea es escribir
las pruebas antes de escribir el código fuente, pero en lugar de pruebas unitarias, lo que haremos será escribir pruebas
que verifiquen que el comportamiento del código es correcto desde el punto de vista de negocio. Tras escribir las
pruebas escribimos el código fuente de la funcionalidad que haga que estas pruebas pasen correctamente. Después se
refactoriza el código fuente. partimos de historias de usuario, siguiendo el modelo “Como [rol ]
quiero [ característica ] para que [los beneficios]”. A partir de aquí, en lugar de describir en 'lenguaje natural' lo
que tiene que hacer esa nueva funcionalidad, vamos a usar un lenguaje que nos va a permitir describir todas nuestras
funcionalidades de una misma forma, un lenguaje específico para BDD.

### Gherkin

Se utiliza Gherkin como lenguaje de desarrollo de las funcionalidades dado que es un lenguaje que es natural y por ende
es comprensible por humanos y por ordenadores, con el se define el comportamiento de la aplicación que se va a
automatizar. Se trata de un lenguaje fácil de leer, fácil de entender y fácil de escribir. Utilizar Gherkin permite
crear una documentación viva a la vez que automatizamos los tests, haciéndolo además con un lenguaje que puede entender
negocio.

La ventaja de Gherkin es que se empieza haciendo BDD y para ello sólo nos hace falta conocer 5 palabras con las que
construiremos sentencias con las que vamos a describir las funcionalidades:

- **Feature:** Indica el nombre de la funcionalidad que vamos a probar. Debe ser un título claro y explícito. Incluimos
  aquí una descripción en forma de historia de usuario: “Como [rol] quiero [característica] para que [los beneficios]”.
  Sobre esta descripción empezaremos a construir nuestros escenarios de prueba.
- **Scenario:** Describe cada escenario que vamos a probar.
- **Given:** Provee contexto para el escenario en que se va a ejecutar el test, tales como punto donde se ejecuta el
  test, o pre requisitos en los datos. Incluye los pasos necesarios para poner al sistema en el estado que se desea
  probar.
- **When:** Especifica el conjunto de acciones que lanzan el test. La interacción del usuario que acciona la
  funcionalidad que deseamos testear.
- **Then:** Especifica el resultado esperado en el test. Observamos los cambios en el sistema y vemos si son los
  deseados. Lo normal es probar distintos escenarios para comprobar una determinada funcionalidad. De esta forma vamos a
  pasar de nuestras historias de usuario a pruebas de comportamiento automatizables.

### Cucumber

Se utiliza cucumber como herramienta para para automatizar las pruebas en BDD. Cucumber nos va permitir ejecutar
descripciones funcionales en texto plano como pruebas de software automatizadas. Totalmente compatible con el lenguaje
Gherkin y traduce esas definiciones a código Java.

Compilador
---
Se crea el proyecto sobre Maven, es una herramienta de desarrollo de software que actúa como un sistema sólido de
gestión de dependencias, PENDIENTE.

### Nomenclatura en el desarrollo
---
Para el desarrollo de la automatización se utilizaron las siguientes formas de nomenclatura para cada uno de los
artefactos:
Variables: camelCase Funciones: camelCase Clases: PascalCase Paquetes: camelCase

- Camel Case: El nombre viene porque se asemeja a las dos jorobas de un camello, y se puede dividir en dos tipos:
    - Upper Camel Case, cuando la primera letra de cada una de las palabras es mayúscula. También denominado **Pascal
      Case**. Ejemplo: EjemploDeNomenclatura.
    - Lower Camel Case, igual que la anterior con la excepción de que la primera letra es minúscula. Ejemplo:
      ejemploDeNomenclatura. Es muy usada en los #hashTags de Twitter o en lenguajes como Java, PHP, C#…

Prácticas de automatización
---

### Documentación oficial Serenity Screenplay

- Writting User-centric tests using Serenity Screenplay
    - [Screenplay](https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay.html)
- Uso de version con Cucumber6 - [Cucumber 6](https://github.com/serenity-bdd/serenity-cucumber6)
- Un proyecto donde se ejemplifica el uso del patrón serenity
  [screenplay](http://thucydides.info/docs/serenity-staging/#_serenity_and_the_screenplay_pattern) con cucumber y
  gradle.

Los tests usan tareas (tasks), interacciones (interactions), preguntas (questions), elementos de páginas (
user_interface) y básicamente se tiene la siguiente estructura a nivel de proyecto de automatización.

+ **Model:**
  Son las clases necesarias para crear abstracciones de objetos complejos del negocio como lo son, por ejemplo:
  personas, entre otros y que son necesarios utilizarlos en cualquier otra parte del proyecto.
+ **Tasks:**
  La capa de las tareas contienen las acciones más comunes que se realizan en una determinada transacción como lo son
  los selects, clicks, input values, entre otros, estas tareas en conjunto representan unas operaciones para lograr
  evidenciar lo que se está probando, se pueden dar a entender como un conjunto de interacciones y es muy importante
  aplicar el principio de la responsabilidad única, eso quiere decir que una tarea es representada por una clase
  completa y esa misma clase no debe ser representada para 2 o más tareas.
+ **Interaction:**
  Las interacciones son las acciones propias que puede realizar un actor directamente sobre los elementos que va a
  interactuar, por ejemplo, diligenciar un campo, hacer clic en un botón, para esto Serenity por defecto en su librería
  tiene muchas de estas interacciones ya definidas. Cuando una interacción no está definida por Serenity, se debe
  realizar la lógica para poder construirla por ejemplo la selección de radio buttons.
+ **User_interface:**
  Page Objects y Page Elements. Mapean los objetos de la interfaz de usuario
+ **Questions:**
  Esta capa es la encargada de realizar las verificaciones o Asserts de las pruebas las cuales son el fin de estas, en
  estas verificaciones capturamos la información de la interfaz la cual es utilizada como el resultado obtenido de la
  prueba y finalmente lo comparamos contra un resultado esperado el cual se ha definido en la construcción del escenario
  de pruebas.
+ **Exceptions:**
  En esta capa se administran las excepciones que pueden ocurrir durante los posibles fallos que pueda tener el
  aplicativo que se está probando durante la ejecución de las pruebas, esto es muy importante porque al momento de
  generar el reporte de la ejecución de las pruebas dará más legibilidad en la lectura de los errores.
+ **Integrations:**
  Clases que permiten realizar las consultas correspondientes a la integración de aplicaciones terceras (No aplica para
  el presente proyecto).
+ **Util:**
  Es una capa la cual contiene clases que tienen métodos que pueden ser reusables dentro del proyecto y que puede ser
  utilizados en cualquier otra capa como por ejemplo los métodos de espera, una conexión a base de datos o una lectura
  de un archivo plano.

Herramienta de automatización utilizado
---
Se utiliza el IDE de IntelliJ idea para el desarrollo de la automatización. IntelliJ IDEA es un IDE inteligente y
sensible al contexto para trabajar con Java y otros lenguajes JVM como Kotlin, Scala y Groovy en todo tipo de
aplicaciones gracias a
sus potentes herramientas integradas, compatibilidad con JavaScript y tecnologías relacionadas, y compatibilidad
avanzada con marcos de trabajo populares como Spring, Spring Boot, Jakarta EE, Micronaut, Quarkus y Helidon. Además,
puede ampliar IntelliJ IDEA con complementos gratuitos desarrollados por JetBrains, lo que le permite trabajar con otros
lenguajes de programación, como Go, Python, SQL, Ruby o PHP (tomado de la web principal de IntelliJ).

Para comenzar
---

1. Revisar archivos base, verificar que los settings son compatibles con versiones del SO donde se ejecutara el
   proyecto (preferiblemente maven version 3.8.6, JDK 8 o mayor)
    ```
    POM.xml
    serenity.properties
    ```

2. En el presente proyecto no se debe tener en cuenta que como se está realizando una automarización a nivel de APIS,
   el paquete **"userinterface"** no estará presente en el actual proyecto.


**¿Cómo ejecutar las pruebas?**

1. Modificar la task **test** para incluir o excluir los runners en el archivo:

        pom.xml

   Para incluir test runners que deben ejecutarse, la lista de test runners esta ubicada en paquete

        java/com/restapiexample/dummy/runners

2. Ejecutar task de maven con comandos:

        ./mvn clean test --info (LINUX)
        mvn clean test --info (WINDOWS)

3. Para ejecutar un test en específico

        mvn test --tests NombreRunner --info
        Nota: el parámetro NombreRunner, es el nombre del runner de la prueba a ejecutar


