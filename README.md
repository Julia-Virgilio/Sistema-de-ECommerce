# Trabalho-POO
Este projeto é o back-end simples, **com execução em terminal**, de um sistema de e-commerce, desenvolvido como parte da disciplina de Programação Orientada a Objetos. Ele foi projetado para gerenciar produtos, usuários e pedidos de uma "loja online", oferecendo funcionalidades básicas para adicionar, finalizar e listar produtos e pedidos, simulando o funcionamento de um e-commerce real.


## Instruções de execução:

1. Clone o repositório:
     ```bash
     git clone https://github.com/Julia-Virgilio/Trabalho-POO

2. Entre no diretório:
     ```bash
    cd Trabalho-POO

2. Compile o projeto:
    ```bash
    javac -d out classes/*.java app/Main.java

3. Execute o projeto:
     ```bash
    java -cp out app.Main

4. O código **criará automaticamente um administrador com nome e senha admin**. Faça login e utilize o programa.


## Uso e funcionalidades

- Serialize para persistência de dados: Os dados são serializados para garantir que as informações dos produtos, usuários e pedidos sejam mantidas mesmo após o fechamento do terminal, evitando a perda de dados.

- Menus personalizados:

    - Admin:
        - Pode criar novos produtos e usuários.
        - Pode receber relatórios sobre o produto com menor estoque e o pedido mais caro.
    - Customer:
        - Pode adicionar produtos ao carrinho de compras.
        - Pode visualizar o conteúdo do carrinho.
        - Pode finalizar a compra, realizando o pagamento.

- Autenticação de senhas: O sistema utiliza o algoritmo PBKDF2 (Password-Based Key Derivation Function 2) para garantir que as senhas dos usuários sejam armazenadas de forma segura, protegendo-as contra acessos não autorizados.

## Tecnologias utilizadas
- **Java 11+**
- **Hashing de senhas** (utilizando [PBKDF2 com HMAC-SHA1](https://www.baeldung.com/java-password-hashing))
- **Serialização de objetos** (Java built-in)

## Autor:
Desenvolvido por [Júlia Carvalho](https://github.com/Julia-Virgilio)
