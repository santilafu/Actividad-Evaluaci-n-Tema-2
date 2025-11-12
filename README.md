# 🎮 Proyecto: Gestión de juegos de una tienda de videojuegos

## 📘 Descripción general
Aplicación desarrollada en **Java 24** que gestiona el catálogo de una tienda de videojuegos siguiendo el patrón **Modelo-Vista-Controlador (MVC)**.  
Permite realizar **búsquedas de videojuegos** almacenados en una base de datos **MySQL**, mostrando los resultados en consola o mediante una **interfaz gráfica (Swing)** moderna y funcional.

Este proyecto pertenece a la **Unidad 2 - Acceso a Datos**, del módulo *Manejo de conectores y desarrollo de aplicaciones que gestionan información en bases de datos relacionales*.

---

## 🧩 Objetivos didácticos
- Comprender y aplicar el patrón **MVC** para separar responsabilidades.
- Conectarse a una base de datos **MySQL** mediante **JDBC**.
- Ejecutar **procedimientos almacenados** desde Java.
- Implementar una **gestión básica de transacciones** y control de excepciones.
- Mostrar los datos de forma legible y ordenada en una interfaz gráfica.

---

## 🧰 Tecnologías utilizadas

| Herramienta / Tecnología | Uso principal |
|--------------------------|----------------|
| **Java 24 (JDK)** | Lógica de aplicación y estructura MVC |
| **IntelliJ IDEA Ultimate** | Entorno de desarrollo (IDE) |
| **MySQL Workbench 9.5** | Creación y gestión de la base de datos |
| **MySQL Connector/J (9.5.0)** | Conector JDBC para la comunicación Java–MySQL |
| **Swing (javax.swing)** | Interfaz gráfica de usuario (GUI) |

---

## 🗃️ Estructura del proyecto

``````
TiendaVideojuegos/
├─ lib/
│ └─ mysql-connector-j-9.5.0.jar
├─ src/
│ ├─ es/tienda/modelo/
│ │ ├─ ConexionBD.java
│ │ └─ Videojuego.java
│ ├─ es/tienda/controlador/
│ │ └─ ControladorVideojuego.java
│ └─ es/tienda/vista/
│ ├─ VistaVideojuego.java
│ └─ VentanaVideojuegoBonita.java
├─ README.md
└─ TiendaVideojuegos.iml
``````


---

## 💾 Estructura de la base de datos (MySQL)

```sql
CREATE DATABASE IF NOT EXISTS dbgametop;
USE dbgametop;

CREATE TABLE IF NOT EXISTS tvideojuegos (
  idjuego INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(80) NOT NULL,
  anno INT NOT NULL,
  compania VARCHAR(80) NOT NULL,
  precio DECIMAL(8,2) NOT NULL,
  sinopsis TEXT,
  plataforma VARCHAR(40) NOT NULL
);

INSERT INTO tvideojuegos (nombre, anno, compania, precio, sinopsis, plataforma)
VALUES
('Civilization VI', 2016, 'Firaxis Games', 49.99, 'Estrategia por turnos donde construyes un imperio que resista el paso del tiempo.', 'PC'),
('The Legend of Zelda: Tears of the Kingdom', 2023, 'Nintendo', 69.99, 'Aventura épica de exploración en un vasto mundo abierto.', 'Nintendo Switch'),
('God of War Ragnarök', 2022, 'Santa Monica Studio', 59.99, 'Kratos y Atreus enfrentan el destino mientras se acerca el Ragnarök.', 'PS5'),
('Hollow Knight', 2017, 'Team Cherry', 14.99, 'Juego de acción y exploración con ambientación oscura y un arte impresionante.', 'PC'),
('Red Dead Redemption 2', 2018, 'Rockstar Games', 39.99, 'Aventura de mundo abierto ambientada en el ocaso del Salvaje Oeste.', 'PC');
```
## ⚙️ Procedimiento almacenado en MySQL
```sql
DELIMITER //
CREATE PROCEDURE nombrejuego(IN p_nombre VARCHAR(80))
BEGIN
  SELECT * FROM tvideojuegos
  WHERE nombre LIKE CONCAT('%', p_nombre, '%');
END//
DELIMITER ;
```
🔹 Este procedimiento permite realizar búsquedas parciales por nombre del videojuego.

Ejemplo:

CALL nombrejuego('war');

## 🧠 Funcionamiento del programa

🔹 Modelo (es.tienda.modelo)

Videojuego.java: clase que representa los atributos de cada juego (id, nombre, año, compañía, precio, sinopsis, plataforma).

ConexionBD.java: establece la conexión con MySQL y devuelve un objeto Connection.

🔹 Controlador (es.tienda.controlador)

ControladorVideojuego.java: ejecuta el procedimiento nombrejuego(?) usando CallableStatement, obtiene los resultados y devuelve una lista de objetos Videojuego.

🔹 Vista (es.tienda.vista)

VistaVideojuego.java: versión en consola que pide un nombre y muestra los resultados.

VentanaVideojuegoBonita.java: versión gráfica (GUI) con campo de búsqueda, botón y panel de resultados con formato visual agradable.

## 🖥️ Ejemplo de ejecución

Consola:

### 🎮 Bienvenido al sistema de gestión de la tienda de videojuegos 

Introduce el nombre (o parte del nombre) del videojuego que quieres buscar: war

📋 Resultados encontrados:

Videojuego {idjuego=3, nombre='God of War Ragnarök', año=2022, compañía='Santa Monica Studio', precio=59.99, sinopsis='Kratos y Atreus enfrentan el destino mientras se acerca el Ragnarök.', plataforma='PS5'}

Videojuego {idjuego=5, nombre='Red Dead Redemption 2', año=2018, compañía='Rockstar Games', precio=39.99, sinopsis='Aventura de mundo abierto ambientada en el ocaso del Salvaje Oeste.', plataforma='PC'}

Interfaz gráfica:

## 🧩 Patrón MVC aplicado

````
┌───────────────┐
│     VISTA     │ ← interacción con el usuario (consola o GUI)
└───────┬───────┘
        │
        ▼
┌───────────────┐
│  CONTROLADOR  │ ← ejecuta la lógica y llama a los modelos
└───────┬───────┘
        │
        ▼
┌───────────────┐
│    MODELO     │ ← conexión con la base de datos y clases de datos
└───────────────┘

````

## 🧾 Notas finales
No se sube la base de datos real, solo el script SQL.

El conector MySQL debe estar en la carpeta lib y añadido como librería.

El servidor MySQL debe estar en ejecución antes de lanzar la app.

Código probado en IntelliJ IDEA Ultimate 2025.1 con JDK 24 y MySQL 9.5.0.

## ✍️ Autor
Santiago Lafuente Hernández

Acceso a Datos – 2º DAM

Desarrollado y documentado con la ayuda técnica de ChatGPT para la organización del proyecto y redacción profesional.