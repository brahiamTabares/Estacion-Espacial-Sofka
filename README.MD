# NAVES

## Introduction

Este proyecto contiene los diferentes aplicativos para realizar una estacion espacial

## Tools
- java 11
- maven 3.8
- JSF
- JEE
- microstream (como base de datos)


## compile and build

La compilación y construcción se realiza mediante el siguiente comando

```shell
    mvn clean package
```

El comando genera un jar denominado  **EstacionEspacial-microbundle.jar** tipicamente en la carpeta target.


## Run

La ejecución de la aplicación se puede realizar mediante el comando

```shell    
java -jar target/EstacionEspacial-microbundle.jar --nocluster
```

Para ver una página de prueba acceda a la siguiente url en un navegador.

    http://localhost:8080/index.xhtml  

