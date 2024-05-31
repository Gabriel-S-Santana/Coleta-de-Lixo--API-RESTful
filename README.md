# API de Agendamento de Coleta de Lixo

Esta API RESTful foi criada com o objetivo de facilitar e otimizar o agendamento de coleta de lixo, utilizando tecnologias modernas e seguras.

## Tecnologias Utilizadas

- **Spring Boot**: Para a criação de uma aplicação stand-alone rápida e fácil de entender.
- **Spring Security + JWT**: Para garantir a segurança através de autenticação e autorização.
- **Hibernate**: Para a persistência de dados de forma eficiente.
- **Flyway**: Para o controle de versões do banco de dados.
- **Oracle Database**: Como sistema de gerenciamento de banco de dados robusto.

## Funcionalidades

- **Agendamento de Coleta**: Permite aos usuários agendar a coleta de lixo de acordo com a disponibilidade.
- **Autenticação de Usuários**: Protege o acesso à API através de tokens JWT.
- **Gerenciamento de Dados**: Utiliza o Hibernate para gerenciar os dados de forma eficaz.
- **Histórico de Alterações**: Mantém um registro de todas as alterações no banco de dados com o Flyway.

## Como Executar

```bash
# Clone este repositório
git clone [URL_DO_REPOSITORIO]

# Instale as dependências
mvn install

# Configure a conexão com o banco de dados oracle
application.properties

# Execute a aplicação
mvn spring-boot:run

Desenvolvido com ❤️ por Gabriel Santana
