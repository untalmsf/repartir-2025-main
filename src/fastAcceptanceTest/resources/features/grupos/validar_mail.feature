# language: es
Característica: Validar formato de correo de usuario

  Regla: El correo debe ser válido (contener "@" y ".")

    Escenario: Usuario con correo válido
        Dado que existe un usuario con id "1" y correo "ana@gmail.com"
        Cuando consulto ese usuario
        Entonces no debería haber error