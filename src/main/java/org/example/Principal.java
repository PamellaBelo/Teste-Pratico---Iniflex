package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat NUMBER_FORMATTER;

    static {
        NUMBER_FORMATTER = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        NUMBER_FORMATTER.setMinimumFractionDigits(2);
        NUMBER_FORMATTER.setMaximumFractionDigits(2);
    }

    private static void imprimirFuncionario(Funcionario f) {
        System.out.printf("  Nome: %-10s | Nascimento: %s | Salário: R$ %s | Função: %s%n",
                f.getNome(),
                f.getDataNascimento().format(DATE_FORMATTER),
                NUMBER_FORMATTER.format(f.getSalario()),
                f.getFuncao());
    }

    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria",   LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João",    LocalDate.of(1990,  5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio",    LocalDate.of(1961,  5,  2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel",  LocalDate.of(1988, 10, 14), new BigDecimal("19919.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice",   LocalDate.of(1995,  1,  5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor",  LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur",  LocalDate.of(1993,  3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura",   LocalDate.of(1994,  7,  8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,  5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena",  LocalDate.of(1996,  9,  2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios.removeIf(f -> f.getNome().equals("João"));
        System.out.println("=== 3.2 – Funcionário 'João' removido com sucesso. ===\n");

        System.out.println("=== 3.3 – Lista de Funcionários ===");
        for (Funcionario f : funcionarios) {
            imprimirFuncionario(f);
        }
        System.out.println();

        for (Funcionario f : funcionarios) {
            BigDecimal aumento = f.getSalario().multiply(new BigDecimal("1.10")).setScale(2, RoundingMode.HALF_UP);
            f.setSalario(aumento);
        }
        System.out.println("=== 3.4 – Salários atualizados com 10% de aumento. ===\n");

        Map<String, List<Funcionario>> porFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("=== 3.6 – Funcionários Agrupados por Função ===");
        porFuncao.forEach((funcao, lista) -> {
            System.out.println("  [" + funcao + "]");
            lista.forEach(f -> imprimirFuncionario(f));
        });
        System.out.println();

        System.out.println("=== 3.8 – Aniversariantes de Outubro (10) e Dezembro (12) ===");
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10
                        || f.getDataNascimento().getMonthValue() == 12)
                .collect(Collectors.toList());

        if (aniversariantes.isEmpty()) {
            System.out.println("  Nenhum funcionário faz aniversário nesses meses.");
        } else {
            aniversariantes.forEach(Principal::imprimirFuncionario);
        }
        System.out.println();

        System.out.println("=== 3.9 – Funcionário com Maior Idade ===");
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow();
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.printf("  Nome: %s | Idade: %d anos%n%n", maisVelho.getNome(), idade);

        System.out.println("=== 3.10 – Funcionários em Ordem Alfabética ===");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(Principal::imprimirFuncionario);
        System.out.println();

        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("=== 3.11 – Total dos Salários ===");
        System.out.printf("  Total: R$ %s%n%n", NUMBER_FORMATTER.format(totalSalarios));

        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("=== 3.12 – Salários em Quantidade de Salários Mínimos (R$ 1.212,00) ===");
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalarios = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("  %-10s → %s salários mínimos%n",
                    f.getNome(), NUMBER_FORMATTER.format(qtdSalarios));
        }
        System.out.println();
    }
}