# Hostal Management System

Este es un proyecto de sistema de gestión para un hostal desarrollado en Java con una arquitectura de capas. Permite administrar las operaciones típicas de un hostal, como gestionar habitaciones, reservas, huéspedes y más.

## Características principales

- Arquitectura de capas: El proyecto sigue una arquitectura de capas que incluye paquetes para DAO, modelo, persistencia, servicios y vistas.
- JPA (Java Persistence API): Utilizamos JPA con EclipseLink como proveedor para la capa de persistencia, lo que nos permite mapear las entidades Java a la base de datos MySQL de manera eficiente.
- Modelado de datos: Hemos creado clases de modelo que representan entidades como habitaciones, huéspedes, reservas, etc., con atributos, constructores vacíos y métodos getter y setter.
- Interfaz de usuario: Para las vistas, hemos implementado una interfaz gráfica de usuario (GUI) utilizando la biblioteca Swing de Java para proporcionar una experiencia de usuario intuitiva.
