# t1-verival-s2-2025
## Chosen Kata - Sum Strings as numbers ##

Given the string representations of two integers, return the string representation of the sum of those integers.

For example:

sumStrings('1','2') // => '3'

A string representation of an integer will contain no characters besides the ten numerals "0" to "9".

I have removed the use of BigInteger and BigDecimal in java

Python: your solution need to work with huge numbers (about a milion digits), converting to int will not work.
## COMO RODAR?
Ja ta "Rodado", esse código foi dirigido pro estudo dos casos de teste + da cobertura de código, então não desenvolvido,
como um sistema a ser rodado, então fique bem vindo a analisar os casos de teste e rodar ele no codespaces para ver como funciona, além de ver a
cobertura no codecov abaixo.
## CONTRIBUIÇÕES
### código:

 Classe StringReader -> CHATGPT(elaboracao do exercicio), Enzo SP(Elaboração do método verificacaracterevalido());

 Testes -> CHATGPT(leves ajustes nos casos de teste, caso de teste dos caracteres nulos), Enzo SP(todos, com exceções, os casos de testes);

### planejamento:
 Casos de teste -> Enzo SP;

 Metodologia de testes(escolha) -> Enzo SP;

#### Tecnicas de teste por contrato
 Neste kata foi utilizado de teste por contrato interno, ITC, para detecção de erros durante a elaboração dos testes e testes por contratos externos ou 
 ETC, num arquivo de testes separados afins de maximizar o coverage do código. Não foi utilizada Design by Contract de forma extensiva, poderia dizer que
 esta implicito no código, na forma que os testes operam, mas não há nenhum documento em específico com as especificações.

### automação:
 Grande junta com o CHATGPT, me ensinando a fazer release e usar o actions, e Enzo SP por pacientemente fazer tudo que precisar pra conquistar a
 bem dita badge do codecov;

 ### documentação:
 CHATGPT -> Resumo dos casos de teste do arquivo StringReaderTest.java em uma forma textual com os inputs e resultados esperados em tests.md;
 
 Enzo SP -> README completo e um textinho mixuruca em italico em tests.md como auto critica, acontece, esperando grandes observações deste trabalho em.

<a href="https://codecov.io/github/Enzo-548/t1-verival-s2-2025"> 
 <img src="https://codecov.io/github/Enzo-548/t1-verival-s2-2025/graph/badge.svg?token=BXVPXK0AOU"/> 
 </a>
