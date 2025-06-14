# language: es
Característica: Eliminar grupo existente

  Regla: Eliminar grupo

    Escenario: Eliminar un grupo existente
      Dado que el usuario tiene un grupo con id 1
      Cuando el usuario elimina el grupo
      Entonces el grupo no debería existir