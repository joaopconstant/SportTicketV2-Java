# AP2-POO
Avaliação Parcial 2 - Programação Orientada a Objetos


### Requisitos para o projeto

 - [x] Refatore o código para evitar construção de mensagens por concatenação de strings. Utilize o  `StringBuilder`  no lugar;
 - [x] Refatore o código para substituir as informações de data por objetos da classe  `LocalDate`,  `LocalTime`  ou  `LocalDateTime`  conforme necessário;
 - [x] Implemente os métodos  `toString()`,  `equals()`  e  `hashCode()`  onde for necessário;
 - [x] Refatore organização do projeto:
	 - [x] Criar pacote  `dao`, responsável por armazenar as classes DAO;
	 - [x] Refatorar pacote  `cli`  para pacote  `programa`, responsável por armazenar as classes de operação do sistema;
	 - [x] Refatorar classe  `Cli.java`  para  `Gestor.java`;
	 - [x] Criar pacote  `util`, junto com classes para manipulação de arquivo e leitura de dados do usuário;
	 - [x] Criar um subpacote  `ingresso`  dentro do pacote  `entidades`, para armazenar as classes de ingressos;
	 - [x] Refatorar o código para a nova organização de pacotes;
 - [x] Mover da classe `Gestor.java` códigos de leitura de dados de usuário;
 - [x] Implementar classes `PartidaDAO.java` e `IngressoDAO.java`, que vão realizar as operações de armazenamento e controle dos dados de partidas e de ingressos, respectivamente;
 - [x] Possibilitar que a aplicação realize as seguintes operações, através de comandos por texto:
	 - [x] Operações de partida:
		-  Criar, excluir, editar e atualizar partidas;
		-   Listar todas as partidas;
		-   Exibir informações sobre uma partida específica;
	- [x] Operações de ingressos:
		-   Realiza a venda de um ingresso;
		-   Exibe o número de ingressos restantes para todas as partidas;
		-   Exibe o número de ingressos restantes para uma partida;
		-   Lista todos os ingressos vendiddos de uma partida;
		-   Exibe os dados do último ingresso vendido;
	- [x] O programa deve salvar automaticamente os dados em arquivos de texto.

 
