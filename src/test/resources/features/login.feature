
  # language: pt
  Funcionalidade: : Realizar login

    Cenário:  Realizar Login com usuario valido
      Dado que estou na tela de login do sistema
      Quando preencho o usuario e senha
      E clico em Entrar
      Entao acesso a tela principal do sistema

    Cenario: Realizar Login com usuario invalido
      Dado que estou na tela de login do sistema
      Quando preencho o usuario e senha invalidos
      E clico em Entrar
      Entao apresenta uma mensagem "Falha ao fazer o login"
      E continua na tela de login

    Cenario: Realizar login com usuario com campo em branco
      Dado que estou na tela de login do sistema
      Quando preencho o usuario e senha em branco
      E clico em Entrar
      Entao apresenta uma mensagem "Falha ao fazer o login"
      E continua na tela de login