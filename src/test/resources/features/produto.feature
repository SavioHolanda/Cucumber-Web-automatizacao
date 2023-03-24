#language: pt
Funcionalidade: Cadastrar, alterar, consultar e excluir produto.

  Cenario: Cadastrar produto com sucesso
    Dado que o usuario logado no sistema
    E clique no botão Adicionar Produto
    Quando preenche Nome do produto, valor do produto e cores do produto
    E clique no botão Salvar
    Entao O produto sera cadastrado e o usuario sera direcionado a pagina de editar produto
    E aparecera  mensagem "Produto adicionado com sucesso"

  Esquema do Cenário: Cadastrar produto invalido
    Dado que o usuario logado no sistema
    E clique no botão Adicionar Produto
    Quando preenche "<Nome do produto>", <valor do produto> e "<cores do produto>"
    E clique no botão Salvar
    Entao o produto não sera cadastrado e o usuario será direcionado a pagina Lista de produtos
    E exibira a mensagem "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"
    Exemplos:
      | Nome do produto | valor do produto | cores do produto |
      | Iphone invalido | 000              | verde            |
      | Iphone ajustado | 700001           | azul             |