package com.cloudsolux.foods.finances_service.infra.expense_item.entity;

import java.math.BigDecimal;

import com.cloudsolux.foods.finances_service.infra.expense.entity.ExpenseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
public class ExpenseItemEntity {

  @Version
  private Long version;
  
  @Include
  @Id
  @Column(name="id")
  private Long id;

  @Column(name="product_id", nullable=false)
	private Long productId;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="expense_id", nullable=false)
  private ExpenseEntity expense;

  @Column(name="price", nullable=false, precision=10, scale=2)
	private BigDecimal price;

  @Column(name="amount", nullable=false, precision=10, scale=2)
	private BigDecimal amount;

  @Override
  public String toString() {
    return "ExpenseItemEntity: ['id="+id+"', 'productId="+productId+"', 'price="+price+"', 'amount="+amount+"']";
  }
}