# Projeto Final Música Deezer

##Projeto foi desenvolvido, baseado nas temáticas abordadas ao longo dos módulos do Curso de Java.
Utilizamos parte de Orientação à Objetos, Spring Web, Banco de Dados para fazer o consumo da API Deezer.
Desenvolvemos a parte html, através do Thymeleaf com as páginas de cadastro, busca de música, login, lista de músicas.
O gerenciador de Banco de Dados utilizado foi o Postgres e as consultas podem ser realizadas através do Dbeaver, as informações que são salvas no Banco de Dados, de cadastro do usuário,(nome, e-mail, senha) que posteriormente são utilzados pelo login.
A documentação pode ser consultada através do Swagger.
Funcionamento:
Entrar com o e-mail e senha para o login através do link:
http://localhost:8080/login
Após executar a aplicação o usuário pode se cadastrar através do link:
http://localhost:8080/registration
O usuário da Aplicação pode buscar a música ou artista desejado através do link:
http://localhost:8080/home
O usuário pode ouvir a música escolhida atravé do link:
http://localhost:8080/searchMusic?search=nomedoartistaoumusica
ou através da página da própria busca pelo link:
http://localhost:8080/trackMusic?track={idDaMusica}
Ao clicar no botão sair o usuário é redirecionado para a página de login novamente através do link:
http://localhost:8080/login

