A API foi feita com base no Framework Spring Boot, junto com o Hibernate para fazer a introdução das tabelas no banco de dados, que nesse caso, foi utilizado o Mysql com nome da tabela "BDMovies", configurado no "application.properties". Foi usado o padrão Rest, com comunicação via Http entre os métodos.

Os métodos por sua vez, são de gravar, listar, deletar, alterar e editar dados da entidade "Movie".

Para Rodar o projeto só rodar a classe "Application.java" , a partir dai o Spring Boot irá iniciar e após ele ter iniciado, só abrir o navegador com a porta 3337 e usar os caminhos presente no "MovieController" para cada método.

Foi criado os serviços de Login através do framework "Spring Security" para segurança e validação de dados. Na classe "LoginController" tem todos os métodos e o caminho para efetuar o login, caso não tenho login, o usuário irá ser encaminhado para página de registro, e depois efetuar a o registro, o usuário voltará para página de login.

*Tecnologias=> Spring Boot, Spring Security, Hibernate, Mysql, Rest e Maven.



Pacotes => Readme, controller, entity, loginService, repository e application;

Para rodar a aplicação=> Classe Application => Run as=> JavaApplication.

OBS: Ao baixar o projeto na IDE, clicar com botao direiro no projeto, depois em Maven e depois em update project.
