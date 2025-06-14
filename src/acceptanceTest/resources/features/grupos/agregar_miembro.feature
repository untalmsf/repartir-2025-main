# language: es

Característica: Agregar miembros a un grupo

  Regla: Un grupo puede sumar más miembros luego de su creación

    Escenario: Puedo agregar un miembro a un grupo ya existente
      Dado que el grupo "Viaje" existe con tres miembros
      Cuando el usuario agrega un nuevo miembro llamado "Pedro"
      Entonces el grupo "Viaje" debería tener cuatro miembros

    Escenario: No puedo agregar un miembro con nombre vacío
      Dado que el grupo "Amigos" existe con dos miembros
      Cuando el usuario intenta agregar un miembro sin nombre
      Entonces debería mostrarse un mensaje de error indicando que el nombre no puede estar vacío
