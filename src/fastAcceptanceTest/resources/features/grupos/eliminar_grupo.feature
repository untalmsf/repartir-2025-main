# language: es
Característica: Eliminar grupo existente

  Regla: Eliminar grupo

    Escenario: Eliminar un grupo existente
      Dado que el usuario tiene un grupo con id 1
      Cuando el usuario elimina el grupo
      Entonces el grupo no debería existir

    Escenario: Intentar eliminar un grupo inexistente
      Dado que el usuario no tiene un grupo con id 2
      Cuando el usuario intenta eliminar el grupo 2
      Entonces debería ser informado que el grupo no existe
