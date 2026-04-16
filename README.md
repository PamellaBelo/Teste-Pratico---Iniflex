# 🏭 Sistema de Funcionários - Teste Prático

Projeto Java desenvolvido como teste prático de programação, simulando o gerenciamento de funcionários de uma indústria.

---

## 📋 Sobre o Projeto

O sistema realiza operações sobre uma lista de funcionários em memória, como inserção, remoção, filtragem, agrupamento e cálculos salariais — utilizando recursos modernos do Java como Stream API, LocalDate e BigDecimal.

---

## 🗂️ Estrutura do Projeto

```
projeto-industria/
└── src/
    └── main/
        └── java/
            └── org.example/
                    ├── Pessoa.java        # Classe base com nome e data de nascimento
                    ├── Funcionario.java   # Estende Pessoa, adiciona salário e função
                    └── Principal.java     # Classe main com todas as operações
```


---

## ▶️ Como Executar

1. Clone o repositório:
```bash
https://github.com/PamellaBelo/Teste-Pratico---Iniflex.git
```

2. Abra o projeto na sua IDE (Eclipse, IntelliJ, NetBeans)

3. Execute a classe `Principal.java` 

A saída será exibida no console.

---

## 🧩 Funcionalidades Implementadas

| Item | Descrição |
|------|-----------|
| 3.1 | Inserção dos funcionários conforme tabela fornecida |
| 3.2 | Remoção do funcionário "João" |
| 3.3 | Impressão formatada (data `dd/MM/yyyy`, salário com `.` e `,`) |
| 3.4 | Aumento de 10% no salário de todos os funcionários |
| 3.5 | Agrupamento por função em `Map<String, List<Funcionario>>` |
| 3.6 | Impressão dos funcionários agrupados por função |
| 3.8 | Listagem de aniversariantes dos meses 10 (outubro) e 12 (dezembro) |
| 3.9 | Funcionário com maior idade (nome e idade em anos) |
| 3.10 | Lista de funcionários em ordem alfabética |
| 3.11 | Total da folha salarial |
| 3.12 | Quantidade de salários mínimos de cada funcionário (base: R$ 1.212,00) |

---

## 💻 Exemplo de Saída

```
=== 3.2 – Funcionário 'João' removido com sucesso. ===

=== 3.3 – Lista de Funcionários ===
  Nome: Maria      | Nascimento: 18/10/2000 | Salário: R$ 2.009,44 | Função: Operador
  Nome: Caio       | Nascimento: 02/05/1961 | Salário: R$ 9.836,14 | Função: Coordenador
  ...

=== 3.9 – Funcionário com Maior Idade ===
  Nome: Caio | Idade: 64 anos

=== 3.11 – Total dos Salários ===
  Total: R$ 51.786,82
```

---

## 🛠️ Tecnologias Utilizadas

- **Java** — linguagem principal
- **Stream API** — filtragem, agrupamento e ordenação de listas
- **LocalDate / Period** — manipulação de datas e cálculo de idade
- **BigDecimal** — precisão em cálculos monetários
- **Collections / Map** — agrupamento de dados

---
