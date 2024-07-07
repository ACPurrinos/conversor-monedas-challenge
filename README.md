# conversor-monedas-challenge
Conversor de Tipos de Cambio
Este proyecto implementa un conversor de tipos de cambio que permite convertir montos de una moneda a otra utilizando 
tasas de conversión actualizadas obtenidas a través de una API externa.

Características
Conversión entre las siguientes monedas:

Dólares (USD)
Pesos Argentinos (ARS)
Reales Brasileños (BRL)
Pesos Colombianos (COP)
Interfaz de usuario simple y amigable mediante la consola.

Uso de la API de ExchangeRate-API para obtener tasas de conversión en tiempo real.

Validación de montos ingresados para asegurar que sean valores positivos.

Requisitos Previos
Para ejecutar esta aplicación, asegúrate de tener instalado lo siguiente:

Java Development Kit (JDK) versión 11 o superior.
Acceso a Internet para realizar las consultas a la API de conversión de tipos de cambio.
Configuración
Clonar el Repositorio:

Configurar la Clave de la API:

Obtén una clave de acceso a la API de ExchangeRate-API desde su sitio web. Luego, 
configura esta clave en la clase Conversion.java en el campo clave:

java
Copiar código
String clave = "tu_clave_de_API";
Compilar y Ejecutar:

Desde la línea de comandos, compila y ejecuta la aplicación:

Uso
Al ejecutar la aplicación, se mostrará un menú con las siguientes opciones:

Convertir de Dólares a Pesos Argentinos.
Convertir de Pesos Argentinos a Dólares.
Convertir de Dólares a Reales Brasileños.
Convertir de Reales Brasileños a Dólares.
Convertir de Dólares a Pesos Colombianos.
Convertir de Pesos Colombianos a Dólares.
Salir de la aplicación.
Para cada opción, se te solicitará ingresar el monto que deseas convertir. Luego, la 
aplicación realizará la conversión utilizando la tasa de cambio actual y te mostrará el 
resultado.

Ejemplo de Interacción

¡Bienvenido al conversor de tipos de cambio!
Elija una opción:
1.- DOLARES ---> a PESOS ARGENTINOS.
2.- PESOS ARGENTINOS ---> a DOLARES.
3.- DÓLARES ---> a REALES BRASILEÑOS.
4.- REALES BRASILEÑOS ---> a DÓLARES.
5.- DÓLARES ---> a PESOS COLOMBIANOS.
6.- PESOS COLOMBIANOS ---> A DOLARES.
7.- SALIR

Ingrese su opción: 1
Ingrese el monto a convertir: 100
Usted eligió la opción 1: USD a ARS.
Monto a convertir: 100.0000
Tasa de conversión obtenida: 91.8250
Monto convertido: 9182.5000 ARS

¿Desea realizar otra conversión? (s/n): s

Elija una opción:
...
