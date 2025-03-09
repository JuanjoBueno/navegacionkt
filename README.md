# Navegación en Compose con Contador

Este proyecto es una aplicación de ejemplo para implementar navegación y gestión de estado en Android utilizando Jetpack Compose. La aplicación cuenta con dos pantallas:
1. **Pantalla de contador**: Permite incrementar un contador con un botón y navegar a la pantalla de resultados.
2. **Pantalla de resultados**: Muestra el total de clics realizados en la pantalla de contador.

## Características

- **Contador**: Un contador que aumenta cada vez que se presiona un botón.
- **Navegación**: Navegación entre pantallas utilizando `NavHost` y `NavController`.
- **Gestión de Estado**: Uso de `ViewModel` y `StateFlow` para gestionar y compartir el estado del contador entre las pantallas.

## Estructura del Proyecto

### MainActivity

La actividad principal configura la interfaz de usuario de la aplicación y habilita la navegación a través de `AppNavigation`.

### ContadorViewModel

- **`ContadorViewModel`**: Un `ViewModel` que contiene un estado representado por un `StateFlow` para el contador. El método `increment()` incrementa el valor del contador.

### Pantallas

- **ContadorScreen**: Muestra el contador y un botón para incrementarlo. También tiene un botón para navegar a la pantalla de resultados.
- **ResultadoScreen**: Muestra el total de clics realizados, obteniendo el valor desde el `ViewModel`.

## Flujo de Navegación

1. Al iniciar la aplicación, se muestra la **Pantalla de Contador**.
2. El usuario puede presionar el botón "CLICS" para incrementar el contador.
3. El usuario puede navegar a la **Pantalla de Resultados** presionando el botón "INFORMAR".
4. La **Pantalla de Resultados** muestra el total de clics acumulados.

## Implementación

El código usa los siguientes componentes clave de Jetpack Compose:

- **NavController** y **NavHost** para manejar la navegación entre pantallas.
- **StateFlow** para gestionar el estado del contador de manera reactiva.
- **ViewModel** para almacenar y gestionar el estado entre cambios de configuración.
