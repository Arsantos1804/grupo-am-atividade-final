# Projeto Final Música Deezer

##Projeto foi desenvolvido, baseado nas temáticas abordada ao longo dos módulos do Curso de Java.
Utilizamos parte de Orientação à Objetos, Spring Web, Banco de Dados para fazer o consumo da API Deezer.
Desenvolvemos a parte html, através do Thymeleaf com as paginas de cadastro, busca de música, login, lista de músicas.
O gerenciador de Banco de Dados utilizado foi o Postgres e as consultas podem ser realizadas através do Dbeaver, as informações que são salvas no Banco de Dados, de cadastro do usuário,(nome, e-mail, senha) que posteriormente são utilzados pelo login.
A parte da playlist que registra as músicas favoritadas pelo usuário.
A documentação pode ser consultada através do Swagger.
Funcionamento:
Após executar a aplicação o usuário pode se cadastrar através do link:
http://localhost:8080/registration
O usuário da Aplicação pode buscar a música ou artista desejado através do link:
http://localhost:8080/home
O usuário pode ouvir a música escolhida atravé do link:
http://localhost:8080/searchMusic?search=nomedoartistaoumusica
Ao clicar no botão sair o usuário é redirecionado para a página de login através do link:
http://localhost:8080/login

