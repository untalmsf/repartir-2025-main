# language: es
Característica: Validar formato de correo de usuario

  Regla: El correo debe ser válido (contener "@" y ".")

    Escenario: Usuario con correo válido
        Dado que existe un usuario con id "1" y correo "ana@gmail.com"
        Cuando consulto ese usuario
        Entonces no debería haber error
    Escenario: Usuario con correo sin arroba
      Dado que existe un usuario con id "2" y correo "anamail.com"
      Cuando consulto ese usuario
      Entonces debería fallar con mensaje "Email inválido"

    Escenario: Usuario con correo sin punto
      Dado que existe un usuario con id "3" y correo "ana@mailcom"
      Cuando consulto ese usuario
      Entonces debería fallar con mensaje "Email inválido"