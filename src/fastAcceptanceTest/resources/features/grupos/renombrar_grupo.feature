# language: es
Característica: Renombrar grupo existente

  Regla: El nombre del grupo debe tener al menos 3 caracteres
    
    Escenario: Renombrar un grupo exitosamente
        Dado que el usuario tiene un grupo con nombre "Amigos"
        Cuando el usuario renombra el grupo a "Viaje"
        Entonces el grupo debería tener el nombre "Viaje"

