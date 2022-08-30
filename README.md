# ESTÁGIO PROJETO CLOUD EXERCÍCIO Érico Panassol

## Exercício Prático: Controle de Estoque de Mercado 

**Instruções para o desenvolvimento**

O objetivo deste teste é avaliar sua capacidade de resolução de 
problemas, tomada de decisão e raciocínio lógico. Em outras palavras, 
queremos ver como você se sai colocando a mão na massa, aplicando suas 
habilidades ao caso de uso de um mercado, que está enfrentando diversos 
problemas em controlar o seu estoque e distribuir os itens nas prateleiras. 
Pedimos que você não use ferramentas que automatizem as funcionalidades 
requeridas, pois a ideia é avaliar suas habilidades de desenvolvimento. 
Entendemos que nem sempre é possível entregar o projeto perfeito no 
prazo combinado. Então, priorize bem a ordem na qual você desenvolve as 
funcionalidades do projeto, assim poderemos avaliar suas habilidades mesmo 
que o projeto não esteja 100% completo. 

## Descrição do Teste

Você deve escrever o código de um sistema de controle de estoque que precisa 
permitir o gerenciamento do estoque de um mercado. O gerenciamento implica em 
possibilitar a visualização, a inclusão, a exclusão e a edição de itens ao estoque. 
Cada item precisa ter nome, tipo, peso, volume, quantidade, setor (padaria, açougue etc.) 
e localização na prateleira. Cada prateleira pertence à um setor do mercado e tem uma 
capacidade máxima de volume e peso suportados. 

- Feature 1: Inclusão de novos itens no estoque. (você deverá criar uma lista 
  com os itens que desejar) 
- Feature 2: Alteração de itens. 
- Feature 3: Exclusão de itens. 
- Feature 4: Consulta de itens. 
- Feature 5: Consulta de itens por setor. 
- Feature 6: Consulta de itens por prateleira. 
- Feature 7: Consulta de prateleiras por setor. 
- Feature 8 (Opcional): Não permitir que o peso máximo da prateleira seja 
  ultrapassado. (você deverá definir o peso máximo) 
- Feature 9 (Opcional): Não permitir que o volume máximo da prateleira seja 
  ultrapassado. (você deverá definir o volume máximo) 
- Feature 10 (Opcional): Distribuir um novo item automaticamente na 
  prateleira, atentando para capacidade máxima da prateleira e dando 
  preferência em agrupar itens de um mesmo tipo na mesma prateleira. 
- Feature 11 (Opcional): Front-end que permita a realização das operações 
  elencadas nas Features 1-7 
  
## Ferramentas
  
No projeto nós usamos majoritariamente Flask para o backend e React para o 
frontend. Isso não significa que vamos priorizar implementações feitas nessas 
tecnologias. Você pode usar qualquer tecnologia que melhor lhe servir. Se você 
não tiver preferência por uma stack específica, sugerimos Flask e React. É importante 
que o backend e o frontend funcionem de forma desacoplada. Logo, você vai precisar criar 
APIs para que ocorra a interação entre eles.

## Qualidade de Projeto

Nós valorizamos desenvolvedores que dão atenção aos seguintes pontos: 

- Código limpo, coeso e performático 
- Documentação compreensiva 
- Gestão de dependências 
- Versionamento de código 
- Testes automatizados 
- Experiência de usuário


  
  
