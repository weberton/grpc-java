# 🔗 Unary API gRPC em Java

Este projeto é um exemplo prático de como implementar uma **Unary API** utilizando **gRPC** em Java. O objetivo é demonstrar como criar um serviço simples de calculadora que realiza operações de soma, utilizando o protocolo gRPC para comunicação eficiente entre cliente e servidor.

## 🛠 Tecnologias Utilizadas

- **Java 23**
- **gRPC**
- **Protobuf**
- **Maven**
- **IntelliJ IDEA** (recomendado para desenvolvimento)

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **JDK 23+** instalado
- **Maven** configurado
- **IntelliJ IDEA** ou outra IDE de sua preferência

### Passo a Passo

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/unary-api-grpc-java.git
   cd unary-api-grpc-java
2. Compile o projeto e gere as classes Protobuf:
  ```
    mvn clean compile
  ```
3. Inicie o servidor gRPC
4. Excute o cliente dentro do pacote client

📂 Estrutura do Projeto

unary-api-grpc-java/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── tech/aartedeprogramar/
│   │   │       ├── client/
│   │   │       ├── server/
│   │   │       └── services/
│   ├── main/proto/
│   │   └── calculadora.proto
├── pom.xml

client/: Contém a implementação do cliente gRPC.
server/: Contém a implementação do servidor gRPC.
services/: Contém o serviço CalculadoraServiceImpl.
calculadora.proto: Arquivo de definição do Protobuf.


