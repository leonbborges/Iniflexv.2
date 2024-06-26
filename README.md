# Iniflexv.2
A aplicação se propõe a partir de uma base de dados disponibilzaado em uma tabela,
pegar esses dados e faz as seguintes tarefas:

– Inserir todos os funcionários, na mesma ordem e informações da tabela acima.<br/>
– Remover o funcionário “João” da lista.<br/>
– Imprimir todos os funcionários com todas suas informações, sendo que:<br/>
• informação de data deve ser exibido no formato dd/mm/aaaa;<br/>
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.<br/>
– Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.<br/>
– Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.<br/>
– Imprimir os funcionários, agrupados por função.<br/>
– Imprimir os funcionários que fazem aniversário no mês 10 e 12.<br/>
– Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.<br/>
– Imprimir a lista de funcionários por ordem alfabética.<br/>
– Imprimir o total dos salários dos funcionários.<br/>
– Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.<br/>

A base de dados original é essa:
![Tabela com os dados](src/main/resources/imagens/tabela.png)<br/>

essa tabela foi convertida em um json com na pode ser vistos na classe, [tabela em json](src/main/resources/demo.json)
e a partir disso pode ser feitos as diversas operações.

Lingaguem: foi usado o java na sua versão 22.01
<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java&theme=light" />
  </a>
</p>
Ferramenta: Intellij na sua versão 2024

o Fluxograma a seguir explica como foi o planejamento: 
<br/>
![Fluxograma](src/main/resources/imagens/planejamento.png)<br/>

e nessa versão foi adicionado a opção de historico, para ver a operaçoes que foram feitas!