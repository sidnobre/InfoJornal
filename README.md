# jornal
Engenharia de Software (UFC-Quixadá) - Trabalho Final - Entrega do produto

Desenvolvimento de um software utilizando técnicas de engenharia de software.

Tomcat 7 + VRaptor4 + Hibernate + MySQL

OBS 1 >> Antes de executar o projeto deve ser alterado o arquivo src/META-INF/persistence.xml e atualizar as propriedades user e password para os correspondentes do seu MySQL.


OBS 2 >> Após executar o projeto pela primeira vez, devem ser adicionados os seguintes registros no banco de dados, que servem como parâmetros do sistema:

insert into papeis (descricao, nivel) values ('Leitor', 1000));
insert into papeis (descricao, nivel) values ('Jornalista', 2000));
insert into papeis (descricao, nivel) values ('Editor', 3000));

insert into usuarios (nome, email, login, senha) values ('Administrador do Sistema', 'admin@admin.sys', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'));

insert into usuarios_papeis values(1,1));
insert into usuarios_papeis values(1,2));
insert into usuarios_papeis values(1,3));

ALTERNATIVA:

Utilizar o executavel updateDBv2Fix:
  * GUI - Apenas executar o jar e informar login e senha do MySQL;
  * CLI - execute o comando como no exemplo "java -jar updateDBv2Fix.jar localhost:3306 root root".

OBS 3 >> Usuário e Senha do sistema: admin e admin
