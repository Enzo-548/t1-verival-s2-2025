# 🧪 Testes Unitários — `StringReaderTest`

Este documento resume todos os **casos de teste implementados** na classe `StringReaderTest`, que valida o comportamento da classe `StringReader`.  
Os testes são escritos com **JUnit 5** e verificam o tratamento de valores nulos, vazios, caracteres inválidos e a soma de strings numéricas. *Importante
ressaltar que nem todos estes testes serviram para atingir a porcentagem total de cobertura, tem alguns redundantes pela falta de polimento do projeto, além
do buraco enorme em meus testes que faltou a forçação de overflow pois nao consegui fazer gerar um overflow em meus testes. Ainda sim, um vacuo enorme.*

---

## 🔸 1. Validação de Strings Nulas e Vazias

| Teste | Entrada (`stringA`, `stringB`) | Resultado Esperado | Descrição |
|-------|-------------------------------|--------------------|------------|
| `testDuasStringsNulas` | `null`, `null` | `false` | Nenhuma string deve ser nula. |
| `testStringANula` | `null`, `"123"` | `false` | `stringA` não pode ser nula. |
| `testStringBNula` | `"12"`, `null` | `false` | `stringB` não pode ser nula. |
| `testStringAVazia` | `""`, `"123"` | `false` | `stringA` não pode ser vazia. |
| `testStringBVazia` | `"456"`, `""` | `false` | `stringB` não pode ser vazia. |
| `testStringVaziaNaStringA` | `""`, `"1"` | `false` | `stringA` é vazia. |
| `testStringVaziaComEspacoNaStringA` | `" "`, `"1"` | `false` | `stringA` contém apenas espaço. |
| `testStringVaziaNaStringB` | `"1"`, `""` | `false` | `stringB` é vazia. |
| `testStringVaziaComEspacoNaStringB` | `"1"`, `" "` | `false` | `stringB` contém apenas espaço. |
| `testCaractereInvalidoNasDuasStrings` | `null`, `""` | `false` | Ambas inválidas. |

---

## 🔸 2. Validação de Caracteres Inválidos

| Teste | Entrada (`stringA`, `stringB`) | Resultado Esperado | Descrição |
|-------|-------------------------------|--------------------|------------|
| `testSomaBasicaComTermosDeMesmoTamanhoEmStringAComCaractereInvalido` | `"12a"`, `"456"` | `false` | Caractere inválido `'a'` em `stringA`. |
| `testSomaBasicaComTermosDeMesmoTamanhoEmStringBComCaractereInvalido` | `"12*"`, `"456"` | `false` | Caractere inválido `'*'` em `stringA`. |
| `testVerificaCaractereValidoParaStringAComCharMaiorQue56` | `"12a"`, `"34"` | `false` | Caractere maior que `'9'`. |
| `testVerificaCaractereValidoParaStringAComCharMenorQue48` | `"12*"`, `"34"` | `false` | Caractere menor que `'0'`. |
| `testVerificaCaractereValidoParaStringBComCharMaiorQue56` | `"12"`, `"34a"` | `false` | Caractere inválido em `stringB`. |
| `testVerificaCaractereValidoParaStringBComCharMenorQue48` | `"12"`, `"34*"` | `false` | Caractere inválido em `stringB`. |

---

## 🔸 3. Soma de Strings Numéricas

| Teste | Entrada (`stringA`, `stringB`) | Resultado Esperado | Descrição |
|-------|-------------------------------|--------------------|------------|
| `testSomaBasicaComUmDigito` | `"1"`, `"1"` | `"2"` | Soma simples de um dígito. |
| `testSomaBasicaComTermosDeMesmoTamanho` | `"123"`, `"456"` | `"579"` | Soma de números de mesmo tamanho. |
| `testSomaBasicaComTermosDeTamanhoDiferenteEmStringA` | `"1230"`, `"456"` | `"1686"` | `stringA` tem um dígito a mais. |
| `testSomaBasicaComTermosDeTamanhoDiferenteEmStringB` | `"123"`, `"4560"` | `"4683"` | `stringB` tem um dígito a mais. |
| `testSomaBasicaComCarry` | `"553"`, `"457"` | `"1010"` | Soma que gera transporte (carry). |

---

## 🔸 4. Resumo Geral

✅ **Total de testes:** 20  
🧩 **Categorias:**  
- 10 testes de validação de strings nulas/vazias  
- 6 testes de caracteres inválidos  
- 4 testes de soma válida  

⚙️ **Framework:** JUnit 5  
🧱 **Classe testada:** `StringReader`  
📊 **Objetivo:** Garantir que `verificaCaractereValido()` e `sumStrings()` funcionem corretamente para todos os casos-limite.
