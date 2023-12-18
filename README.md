# BaseDeDatosRelacionales
Lógica de Validación de Datos:
La aplicación utiliza las siguientes estrategias para validar los datos ingresados por el usuario:
Fecha de Nacimiento:
Se valida que la fecha de nacimiento sea ingresada en el formato correcto.
Se utiliza una excepción para manejar errores relacionados con la conversión de la fecha.
Funcionalidades Implementadas:
* Crear un Nuevo Animal:
El usuario puede ingresar el nombre, tipo, fecha de nacimiento y el estado de adopción del animal. Se asigna automáticamente un ID único al crear cada animal.
* Buscar Animal por ID:
El usuario puede buscar un animal por su ID. Se han manejado excepciones para evitar resultados nulos durante la búsqueda.
* Eliminar Animal por ID:
El usuario puede eliminar un animal proporcionando su ID.
* Modificar Nombre del Animal por ID: El usuario puede actualizar el nombre de un animal proporcionando su ID.

Problemas y Soluciones:
Durante el desarrollo, se encontraron los siguientes problemas y se implementaron soluciones:

Formato de Fecha:

Problema: Convertir la fecha al formato SQL.
Solución: Se utilizó una clase SimpleDateFormat para formatear la fecha antes de almacenarla en la base de datos.
Excepciones en la Búsqueda:
Problema: Excepciones en la búsqueda que resultaban en valores nulos.
Solución: Se implementaron validaciones adicionales para evitar excepciones y mejorar la consistencia de la búsqueda.
Conclusiones:
La aplicación ha sido desarrollada siguiendo las mejores prácticas de programación orientada a objetos y diseño de patrones DAO para garantizar la modularidad y el mantenimiento fácil. La implementación de validaciones mejora la robustez de la aplicación, proporcionando una experiencia de usuario más sólida.
