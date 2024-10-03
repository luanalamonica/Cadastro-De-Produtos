# Cadastro de Produtos de Mercado (Java + MySQL)

Este projeto é uma aplicação Java Swing que permite realizar o cadastro de produtos de mercado, armazenando-os em um banco de dados MySQL. A aplicação utiliza `JTable` para exibir os dados e oferece funcionalidades como inserção e consulta de produtos.

## Funcionalidades

- **Cadastro de Produtos**: O usuário pode inserir novos produtos, informando nome, categoria, quantidade e preço.
- **Consulta de Produtos**: Exibe todos os produtos cadastrados diretamente de uma tabela no banco de dados MySQL.
- **Interface Amigável**: A interface foi desenvolvida utilizando componentes Swing, como `JLabel`, `JTextField`, `JButton` e `JTable`, proporcionando uma experiência intuitiva.

## Tecnologias Utilizadas

- **Java (Swing)**: Para criação da interface gráfica (GUI).
- **MySQL**: Banco de dados relacional para armazenar os produtos cadastrados.
- **JDBC (Java Database Connectivity)**: Para realizar a conexão e interações com o banco de dados.

## Pré-requisitos

Antes de executar o projeto, você precisará ter instalado:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (versão 8 ou superior)
- [MySQL](https://www.mysql.com/downloads/) (ou qualquer outro banco de dados compatível com JDBC)
- [Connector/J](https://dev.mysql.com/downloads/connector/j/) (biblioteca JDBC para conectar o Java ao MySQL)

## Configuração do Banco de Dados

1. Crie um banco de dados no MySQL:
    ```sql
    CREATE DATABASE mercado_produtos;
    ```

2. Crie a tabela para armazenar os dados dos produtos:
    ```sql
    CREATE TABLE produtos (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100) NOT NULL,
        categoria VARCHAR(50),
        quantidade INT,
        preco DECIMAL(10, 2)
    );
    ```

3. Insira as informações de conexão no código Java:
    - No arquivo `src/ConnectionFactory.java`, configure o **usuário**, **senha** e **URL** do banco de dados:
    ```java
    public class ConnectionFactory {
        public Connection getConnection() {
            try {
                return DriverManager.getConnection(
                    "jdbc:mysql://localhost/mercado_produtos", "usuario", "senha");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    ```

## Instruções de Uso

### 1. Tela de Cadastro de Produtos

Na primeira tela, o usuário pode inserir os detalhes do produto:
- **Nome do Produto**
- **Categoria**
- **Quantidade**
- **Preço**

Ao preencher as informações, basta clicar em **Cadastrar** para salvar os dados no banco.

![Tela de Cadastro de Produtos](https://github.com/luanalamonica/Mercado-Cadastro-De-Produtos/blob/main/primeira%20tela.png?raw=true)

### 2. Confirmação de Cadastro

Após a inserção bem-sucedida, o sistema exibe uma mensagem de confirmação. Os dados são gravados no banco de dados MySQL.

![Dados inseridos com sucesso](https://github.com/luanalamonica/Mercado-Cadastro-De-Produtos/blob/main/segunda%20tela.png?raw=true)

## Como Executar o Projeto

1. Clone este repositório:
    ```bash
    git clone https://github.com/luanalamonica/Mercado-Cadastro-De-Produtos.git
    ```

2. Importe o projeto em sua IDE Java favorita (como IntelliJ IDEA ou Eclipse).

3. Compile e execute o projeto.

4. Utilize a interface gráfica para inserir e consultar os produtos.

## Estrutura do Projeto

- `src/` - Contém os arquivos Java do projeto.
  - **ConnectionFactory.java** - Responsável pela conexão com o banco de dados.
  - **ProdutoDAO.java** - Implementa as operações CRUD (Create, Read, Update, Delete) para a tabela de produtos.
  - **Main.java** - Inicializa a interface gráfica (telas) e integra as funcionalidades.
  
## Melhorias Futuras

- Implementar funcionalidades de **edição** e **exclusão** de produtos.
- Adicionar tratamento de erros e validação de dados nos formulários.
- Implementar filtros de pesquisa para facilitar a consulta de produtos.
- Desenvolver testes automatizados para as funcionalidades principais.

## Contribuições

Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades! Para contribuir, siga os passos:

1. Faça um _fork_ do projeto.
2. Crie uma nova _branch_ para suas alterações (`git checkout -b feature/nova-funcionalidade`).
3. Envie suas alterações para o repositório (`git push origin feature/nova-funcionalidade`).
4. Abra um _pull request_ para revisão.
