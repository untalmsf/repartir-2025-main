# language: es
Característica: Renombrar grupo existente

  Regla: El nombre del grupo debe tener al menos 3 caracteres
    
    Escenario: Renombrar un grupo exitosamente
        Dado que el usuario tiene un grupo con nombre "Amigos"
        Cuando el usuario renombra el grupo a "Viaje"
        Entonces el grupo debería tener el nombre "Viaje"

    Escenario: Intentar renombrar un grupo a un nombre muy corto
        Dado que el usuario tiene un grupo con nombre "Pareja"
        Cuando el usuario renombra el grupo a "Yo"
        Entonces debería ser informado que el nuevo nombre debe tener al menos 3 caracteres

    Escenario: Intentar renombrar un grupo a un nombre nulo
        Dado que el usuario tiene un grupo con nombre "Estudio"
        Cuando el usuario renombra el grupo a ""
        Entonces debería ser informado que el nuevo nombre debe tener al menos 3 caracteres

