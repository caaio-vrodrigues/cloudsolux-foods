package com.cloudsolux.foods.finances_service.infra.expense_item.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Getter
@Builder
@Table(name="expense_item")
@Entity
public final class ExpenseItemEntity {
  
  @Include
  @Id
  @Column(name="id")
  private Long id;

  @Column(name="product_id", nullable=false)
	private Long productId;

  @Column(name="price", nullable=false)
	private BigDecimal price;

  @Column(name="amount", nullable=false)
	private BigDecimal amount;

  @Override
  public String toString() {
    return "ExpenseItemEntity: ['id="+id+"', 'productId="+productId+"', 'price="+price+"', 'amount="+amount+"']";
  }
}