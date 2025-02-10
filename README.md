![logo](src/main/resources/statics/img/estancias.webp)
# Proyecto de Reservas de Estancias

## 📌 Descripción

Este proyecto es una aplicación de reservas de estancias desarrollada en **Java** utilizando **JDBC** y el **patrón DAO**. La base de datos utilizada es **MySQL**. Su propósito es gestionar la disponibilidad de estancias, permitiendo a los clientes reservar y administrar sus reservas de manera eficiente.

## 🏗️ Estructura del Proyecto

```css
src
└── main
    ├── java
    │   └── com
    │       └── backend
    │           └── estancias
    │               ├── entity
    │               │   ├── Casa.java
    │               │   ├── Cliente.java
    │               │   ├── Comentario.java
    │               │   └── Estancia.java
    │               ├── exception
    │               │   ├── EstanciaNotAvailableException.java
    │               │   └── ResourceNotFoundException.java
    │               ├── repository
    │               │   ├── CasaRepository.java
    │               │   ├── ClienteRepository.java
    │               │   ├── ComentarioRepository.java
    │               │   └── EstanciaRepository.java
    │               ├── service
    │               │   ├── imp
    │               │   │   ├── CasaServiceImpl.java
    │               │   │   ├── ClienteServiceImpl.java
    │               │   │   ├── ComentarioServiceImpl.java
    │               │   │   └── EstanciaServiceImpl.java
    │               │   ├── ICasaService.java
    │               │   ├── IClienteService.java
    │               │   ├── IComentarioService.java
    │               │   └── IEstanciaService.java
    │               └── EstanciasApplication.java
    └── resources
        ├── application.properties
        ├── static
        └── templates
            └── index.html
```

## ⚙️ Tecnologías Utilizadas

- **Lenguaje:** Java
- **Base de Datos:** MySQL
- **Patrón de Diseño:** DAO (Data Access Object)
- **Frameworks & Librerías:** JDBC
- **Gestión de Dependencias:** Maven

## 🚀 Instalación y Configuración

1. **Clonar el repositorio:**

   ```sh
   git clone https://github.com/CasseliLayza/Estancias_Java_Globant_DAO.git
   ```

2. **Configurar la base de datos en MySQL:**

   - Crear la base de datos `reservas_estancias`
   - Ejecutar el script SQL en `resources/db/schema.sql`

3. **Configurar el archivo:**

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/reservas_estancias
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

4. **Ejecutar la aplicación:**

   ```sh
   mvn spring-boot:run
   ```

## 📌 Funcionalidades Principales

✅ Registro y gestión de clientes.\
✅ Reservas de estancias con control de disponibilidad.\
✅ Gestión de casas y estancias disponibles.\
✅ Comentarios y valoraciones de los clientes.\
✅ Manejo de excepciones y validaciones personalizadas.

## 📜 Contribuciones

Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un **fork** del repositorio.
2. Crea una **rama** con tu nueva funcionalidad (`git checkout -b nueva-funcionalidad`).
3. Realiza un **commit** con tus cambios (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz un **push** a la rama (`git push origin nueva-funcionalidad`).
5. Abre un **pull request**.

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**. Puedes consultar más detalles en el archivo `LICENSE`.

---

📌 **Autor:** Casse\
📧 **Contacto:** [casseli.layza@gmail.com](mailto\:casseli.layza@gmail.com)\
🌐 **Sitio Web:** [linkedin.com/in/casseli-layza](https://www.linkedin.com/in/casseli-layza/)

