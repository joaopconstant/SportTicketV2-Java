# SportTicket V2

Esta versão do projeto inclui uma série de melhorias e novas funcionalidades em relação à versão anterior. Abaixo estão listadas as principais mudanças realizadas:

### Refatoração de Código

- Utilização do `StringBuilder` para construção de mensagens, substituindo concatenação de strings.
- Substituição das informações de data por objetos da classe `LocalDate`, `LocalTime` ou `LocalDateTime` conforme necessário.
- Implementação dos métodos `toString()`, `equals()` e `hashCode()` onde necessário.

### Reorganização do Projeto

- Criação do pacote `dao`, responsável por armazenar as classes DAO.
- Refatoração do pacote `cli` para `programa`, responsável por armazenar as classes de operação do sistema.
- Refatoração da classe `Cli.java` para `Gestor.java`.
- Criação do pacote `util`, junto com classes para manipulação de arquivo e leitura de dados do usuário.
- Criação de um subpacote `ingresso` dentro do pacote `entidades`, para armazenar as classes de ingressos.
- Reorganização do código para se adequar à nova estrutura de pacotes.

### Implementação de Novas Funcionalidades

- Implementação das classes `PartidaDAO.java` e `IngressoDAO.java`, responsáveis por realizar as operações de armazenamento e controle dos dados de partidas e ingressos, respectivamente.
- Adição de operações de partida, como criar, excluir, editar e atualizar partidas, listar todas as partidas e exibir informações sobre uma partida específica.
- Adição de operações de ingressos, como realizar a venda de um ingresso, exibir o número de ingressos restantes para todas as partidas, para uma partida específica, listar todos os ingressos vendidos de uma partida e exibir os dados do último ingresso vendido.
- Implementação da capacidade do programa de salvar automaticamente os dados em arquivos de texto.

### Outras Mudanças

- Remoção de códigos de leitura de dados de usuário da classe `Gestor.java`, movendo-os para classes apropriadas no pacote `util`.
- Atualização da documentação e dos comentários do código para refletir as mudanças realizadas.

### Licença

Este projeto é distribuído sob a licença [MIT](LICENSE), o que significa que você pode usá-lo livremente, inclusive para fins comerciais, desde que mantenha o aviso de direitos autorais.
