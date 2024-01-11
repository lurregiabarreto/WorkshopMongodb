# Projeto: Projeto MongoDB com Spring Boot

## Curso: Programação Orientada a Objetos com Java
- Website: [EducandoWeb](http://educandoweb.com.br)
- Professor: Dr. Nelio Alves

## Capítulo: Projeto MongoDB com Spring Boot

### Objetivo Geral:
- Compreender as principais diferenças entre paradigma orientado a documentos e relacional.
- Implementar operações de CRUD.
- Refletir sobre decisões de design para um banco de dados orientado a documentos.
- Implementar associações entre objetos.
  - Objetos Aninhados
  - Referências
- Realizar consultas com Spring Data e MongoRepository.

## Instalação do MongoDB

### Checklist para Windows:
1. Acesse [MongoDB Download](https://www.mongodb.com) -> Download -> Community Server.
2. Baixe e instale com a opção "Complete".
3. Siga as instruções [aqui](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/) para configurar o ambiente MongoDB.
   - Crie a pasta \data\db.
   - Adicione ao PATH: C:\Program Files\MongoDB\Server\3.6\bin (ajuste para sua versão).
4. Teste no terminal: `mongod`.

## Instalação do Mongo Compass

- MongoDB Compass: [MongoDB Compass](https://www.mongodb.com/products/compass)

## Primeiro Commit - Projeto Criado

### ATUALIZAÇÃO
**ATENÇÃO: VERSÃO DO SPRING BOOT**
- 1.5.x: [Workshop-Spring-Boot-MongoDB](https://github.com/acenelio/workshop-spring-boot-mongodb)
- 2.x.x: [Workshop-SpringBoot2-MongoDB](https://github.com/acenelio/workshop-springboot2-mongodb)

**Erro Comum:** Arquivo corrompido do Maven (invalid LOC header).
- Recomendação: Apague os arquivos e deixe o Maven baixar novamente.

### Checklist:
1. File -> New -> Spring Starter Project.
   - Escolha apenas o pacote Web por enquanto.
2. Execute o projeto e teste: [http://localhost:8080](http://localhost:8080).
3. Se desejar alterar a porta padrão do projeto, inclua em `application.properties`: `server.port=${port:8081}`.

## Entidade User e Funcionalidade REST

### Checklist para Criar Entidades:
- Atributos básicos.
- Associações (inicialize coleções).
- Construtores (não inclua coleções no construtor com parâmetros).
- Getters e setters.
- hashCode e equals (implementação padrão: somente id).
- Serializable (padrão: 1L).

### Checklist:
1. Crie a classe User no subpacote domain.
2. No subpacote resources, crie uma classe UserResource e implemente nela o endpoint GET padrão:
   ```java
   @RestController
   @RequestMapping(value="/users")
   public class UserResource {
      @RequestMapping(method=RequestMethod.GET)
      public ResponseEntity<List<User>> findAll() {
         List<User> list = new ArrayList<>();
         User maria = new User("1001", "Maria Brown", "maria@gmail.com");
         User alex = new User("1002", "Alex Green", "alex@gmail.com");
         list.addAll(Arrays.asList(maria, alex));
         return ResponseEntity.ok().body(list);
      }
   }
   ```

## Conectando ao MongoDB com Repository e Service

### Referências:
- [Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- [Recursos NoSQL do Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-nosql.html)
- [Usuário e Senha Padrão MongoDB](https://stackoverflow.com/questions/38921414/mongodb-what-are-the-default-user-and-password)

### Checklist:
1. Adicione a dependência MongoDB em `pom.xml`:
   ```xml
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-mongodb</artifactId>
   </dependency>
   ```
2. Crie a interface UserRepository no pacote repository.
3. Crie a classe UserService no pacote services com um método `findAll`.
4. Adicione as anotações `@Document` e `@Id` em User indicando que se trata de uma coleção do MongoDB.
5. Refatore o código em UserResource, usando UserService para buscar os usuários.
6. Em `application.properties`, inclua os dados de conexão com o banco de dados MongoDB:
   ```
   spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
   ```
7. Inicie o MongoDB (`mongod`).
8. Use o MongoDB Compass para criar o banco de dados workshop_mongo e uma coleção user manualmente.
9. Teste o endpoint `/users`.
