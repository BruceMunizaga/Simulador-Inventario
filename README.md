# Consideraciones antes de ejecutar el código

A continuación se explicará a detalle el como poder ejecutar correctamente el código en este repositorio
## Librerías

Debe tener de forma obligatoria las siguientes librerias en su IntelIJ:
- stdUCN-7.1.jar
  > Si no cumple con este requisito, el código no se ejecutará.

## Archivo CSV

En este codigo se leerá un archivo csv llamado "Inventario.csv".
> Si desea leer un archivo csv con distinto nombre deberá dirigirse a la clase SistemaImpl, linea 56 y cambiar el nombre de ruta del archivo. También en la misma clase deberá dirigirse a la linea 857 y cambiar la ruta del archivo para actualizar.


## Estructura del archivo CSV

Este código acepta sola una estructura del archivo para poder ser ejecutada:
- Si es un instrumento de cuerda, debe cumplir con la siguiente estructura en cada linea: [nombre],[tipo de cuerda],[numero de cuerdas],[material de construcción],[tipo],[código],[precio],[stock]

- Si es un instrumento de percusión, debe cumplir con la siguiente estructura en cada linea: [nombre],[tipo de percusión],[material de construcción],[altura (en metros)],[código],[precio],[stock]

- Si es un instrumento de viento, debe cumplir con la siguiente estructura en cada linea: [nombre],[material de construcción],[código],[precio],[stock]
> Si se ingresa alguno de estos tipos de instrumento en el archivo y no cumple con la estructura antes mencionada, el código no podrá ser ejecutado.

## Autores del código

Este código fue creado por Bruce Munizaga y Paolo Vera. Ambos integrantes del ramo Programación Avanzada.

