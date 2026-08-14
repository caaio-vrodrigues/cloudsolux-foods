package com.cloudsolux.foods.finances_service.infra.expense.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.cloudsolux.foods.finances_service.infra.expense_item.entity.ExpenseItemEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode.Include;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Table(name="expense")
@Entity
@Getter
@Builder
public class ExpenseEntity {

  @Version
  private Long version;

  @Include
  @Id
  @Column(name="id")
  private Long id;

  @Column(name="purchase_date", nullable=false)
  private Instant purchaseDate;

  @Default
  @OneToMany(fetch=FetchType.LAZY, mappedBy="expense", cascade=CascadeType.ALL, orphanRemoval=true)
  private List<ExpenseItemEntity> items = new ArrayList<>();

  @Column(name="description", nullable=false)
  private String description;

  @Override
  public String toString() {
    return "Expense: ['id="+id+"', 'purchaseDate="+purchaseDate+"', 'description="+description+"']";
  }
}