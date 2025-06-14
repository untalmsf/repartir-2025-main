# language: es
Característica: Registrar gasto de usuario

  Regla: El gasto debe ser número positivo y con máximo dos decimales
    Escenario: Gasto válido con un decimal
        Dado que existe un usuario registrado con id "123" y correo "pedro@gmail.com"
        Cuando el usuario con id "123" registra un gasto de 150.5
        Entonces el gasto registrado debe ser 150.5