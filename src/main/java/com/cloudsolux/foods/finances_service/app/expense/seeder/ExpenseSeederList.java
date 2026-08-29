package com.cloudsolux.foods.finances_service.app.expense.seeder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.context.annotation.Profile;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Profile("dev")
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public final class ExpenseSeederList {
  
  @Default
  private List<ExpenseSeeder> dtos = List.of(
    // ===== JANEIRO/2026 =====
    ExpenseSeeder.builder()
      .description("Compra de temperos e azeite - Janeiro/2026")
      .purchaseDate(Instant.parse("2026-01-05T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(10)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.00)).amount(BigDecimal.valueOf(8)).build(),
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(28.90)).amount(BigDecimal.valueOf(3)).build()
    ))
      .build(),
    ExpenseSeeder.builder()
      .description("Ingredientes para padaria - Janeiro/2026")
      .purchaseDate(Instant.parse("2026-01-12T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(20)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.50)).amount(BigDecimal.valueOf(15)).build(),
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(28.90)).amount(BigDecimal.valueOf(2)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Reposição de mantimentos - Janeiro/2026")
      .purchaseDate(Instant.parse("2026-01-20T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.50)).amount(BigDecimal.valueOf(10)).build(),
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(12)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(5)).build()
      ))
      .build(),

    // ===== FEVEREIRO/2026 =====
    ExpenseSeeder.builder()
      .description("Compra de azeite e temperos - Fevereiro/2026")
      .purchaseDate(Instant.parse("2026-02-02T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(29.50)).amount(BigDecimal.valueOf(5)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(12)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.00)).amount(BigDecimal.valueOf(10)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Insumos para produção - Fevereiro/2026")
      .purchaseDate(Instant.parse("2026-02-10T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(7.10)).amount(BigDecimal.valueOf(25)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.50)).amount(BigDecimal.valueOf(20)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Compra de ingredientes diversos - Fevereiro/2026")
      .purchaseDate(Instant.parse("2026-02-18T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(15)).build(),
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(28.90)).amount(BigDecimal.valueOf(3)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.00)).amount(BigDecimal.valueOf(6)).build()
      ))
      .build(),

    // ===== MARÇO/2026 =====
    ExpenseSeeder.builder()
      .description("Compra de azeite extra virgem - Março/2026")
      .purchaseDate(Instant.parse("2026-03-03T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(30.00)).amount(BigDecimal.valueOf(6)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.80)).amount(BigDecimal.valueOf(15)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Fornecimento de farinha e açúcar - Março/2026")
      .purchaseDate(Instant.parse("2026-03-11T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(30)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.90)).amount(BigDecimal.valueOf(18)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.20)).amount(BigDecimal.valueOf(8)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Temperos e condimentos - Março/2026")
      .purchaseDate(Instant.parse("2026-03-19T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(20)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.00)).amount(BigDecimal.valueOf(15)).build(),
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(10)).build()
      ))
      .build(),

    // ===== ABRIL/2026 =====
    ExpenseSeeder.builder()
      .description("Compra semanal de insumos - Abril/2026")
      .purchaseDate(Instant.parse("2026-04-01T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(7.10)).amount(BigDecimal.valueOf(22)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.50)).amount(BigDecimal.valueOf(12)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Reposição de azeite e orégano - Abril/2026")
      .purchaseDate(Instant.parse("2026-04-10T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(29.90)).amount(BigDecimal.valueOf(4)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(15)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.00)).amount(BigDecimal.valueOf(10)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Ingredientes para nova receita - Abril/2026")
      .purchaseDate(Instant.parse("2026-04-18T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(18)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.90)).amount(BigDecimal.valueOf(10)).build(),
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(28.90)).amount(BigDecimal.valueOf(2)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(6)).build()
      ))
      .build(),

    // ===== MAIO/2026 =====
    ExpenseSeeder.builder()
      .description("Compra de temperos frescos - Maio/2026")
      .purchaseDate(Instant.parse("2026-05-02T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.50)).amount(BigDecimal.valueOf(20)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(18)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Estoque de farinha e açúcar - Maio/2026")
      .purchaseDate(Instant.parse("2026-05-13T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(7.20)).amount(BigDecimal.valueOf(35)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(10.00)).amount(BigDecimal.valueOf(25)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Compra de azeite para produção - Maio/2026")
      .purchaseDate(Instant.parse("2026-05-22T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(30.50)).amount(BigDecimal.valueOf(6)).build(),
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(12)).build()
      ))
      .build(),

    // ===== JUNHO/2026 =====
    ExpenseSeeder.builder()
      .description("Insumos para início do mês - Junho/2026")
      .purchaseDate(Instant.parse("2026-06-03T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(6.80)).amount(BigDecimal.valueOf(25)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.50)).amount(BigDecimal.valueOf(15)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(8)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Compra de azeite e manjericão - Junho/2026")
      .purchaseDate(Instant.parse("2026-06-08T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(29.50)).amount(BigDecimal.valueOf(5)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.20)).amount(BigDecimal.valueOf(12)).build()
      ))
      .build(),
    ExpenseSeeder.builder()
      .description("Reposição geral de estoque - Junho/2026")
      .purchaseDate(Instant.parse("2026-06-12T10:00:00Z"))
      .expenseItemDTOList(List.of(
        ExpenseItemSeeder.builder().productId(5L).price(BigDecimal.valueOf(7.10)).amount(BigDecimal.valueOf(20)).build(),
        ExpenseItemSeeder.builder().productId(4L).price(BigDecimal.valueOf(9.90)).amount(BigDecimal.valueOf(10)).build(),
        ExpenseItemSeeder.builder().productId(3L).price(BigDecimal.valueOf(28.90)).amount(BigDecimal.valueOf(4)).build(),
        ExpenseItemSeeder.builder().productId(1L).price(BigDecimal.valueOf(4.50)).amount(BigDecimal.valueOf(10)).build(),
        ExpenseItemSeeder.builder().productId(2L).price(BigDecimal.valueOf(5.00)).amount(BigDecimal.valueOf(8)).build()
      ))
      .build()
  );
}