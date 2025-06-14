# language: es
Característica: Registrar gasto de usuario

  Regla: El gasto debe ser número positivo y con máximo dos decimales

  Escenario: Gasto válido con un decimal
    Dado que existe un usuario registrado con id "123" y correo "pedro@gmail.com"
    Cuando el usuario con id "123" registra un gasto de 150.5
    Entonces el gasto registrado debe ser 150.5

  Escenario: Gasto válido con dos decimales
    Dado que existe un usuario registrado con id "124" y correo "maria@mail.com"
    Cuando el usuario con id "124" registra un gasto de 20.75
    Entonces el gasto registrado debe ser 20.75

  Escenario: Gasto con más de dos decimales
    Dado que existe un usuario habilitado con id "125" y correo "luis@mail.com"
    Cuando el usuario con id "125" intenta registrar un gasto de 10.123
    Entonces debería mostrarse el error "Solo se permiten hasta 2 decimales"

  Escenario: Gasto negativo
    Dado que existe un usuario habilitado con id "456" y correo "pedro@gmail.com"
    Cuando el usuario con id "456" intenta registrar un gasto de -50
    Entonces debería mostrarse el error "El monto del gasto debe ser positivo"

  Escenario: Gasto no numérico
    Dado que existe un usuario habilitado con id "789" y correo "pedro@gmail.com"
    Cuando el usuario con id "789" intenta registrar un gasto de "abc"
    Entonces debería mostrarse el error "El monto ingresado debe ser un número positivo"
