# language: es

Característica: Crear Grupo para repartir gastos

  Regla: Los grupos están compuestos por al menos dos miembros

    Escenario: No puedo crear un grupo con un único miembro
      Cuando el usuario intenta crear un grupo indicando un único miembro
      Entonces no debería crear el grupo con un único miembro

  Escenario: Puedo crear un grupo con dos o más miembros
      Cuando el usuario intenta crear un grupo indicando los miembros "Oscar" y "María"
      Entonces debería crear el grupo con dos o más miembros