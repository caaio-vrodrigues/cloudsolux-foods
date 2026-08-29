package com.cloudsolux.foods.inventory_service.app.product.seeder;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Profile("dev")
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class ProductSeederList {
  
  @Default
  private List<ProductSeeder> seeds = List.of(
    ProductSeeder.builder().name("Orégano").model("Comum").brand("Da Roça").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Manjericão").model("Comum").brand("Da Roça").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductSeeder.builder().name("Azeite de Oliva").model("Extra Virgem").brand("Gallo").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductSeeder.builder().name("Açúcar").model("Refinado").brand("União").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Farinha de Trigo").model("Tipo 1").brand("Dona Benta").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Sal Refinado").model("Fino").brand("Cisal").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Café Torrado").model("Tradicional").brand("Pilão").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Arroz Branco").model("Tipo 1").brand("Camil").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Feijão Carioca").model("Tipo 1").brand("Camil").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Macarrão Espaguete").model("Gran Duro").brand("Adria").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Óleo de Soja").model("Refinado").brand("Soya").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductSeeder.builder().name("Leite Integral").model("Integral").brand("Piracanjuba").unitOfMeasure((UnitOfMeasure.LT)).build(),
    ProductSeeder.builder().name("Manteiga").model("Com Sal").brand("Italac").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductSeeder.builder().name("Queijo Mussarela").model("Fatiado").brand("Presidente").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductSeeder.builder().name("Presunto").model("Fatiado").brand("Sadia").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductSeeder.builder().name("Pão de Forma").model("Integal").brand("Pullman").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductSeeder.builder().name("Biscoito Recheado").model("Chocolate").brand("Bauducco").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Chocolate ao Leite").model("Barra").brand("Lacta").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductSeeder.builder().name("Suco de Laranja").model("Integral").brand("Del Valle").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductSeeder.builder().name("Refrigerante Cola").model("Lata").brand("Coca-Cola").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductSeeder.builder().name("Água Mineral").model("Sem Gás").brand("Crystal").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductSeeder.builder().name("Cerveja Pilsen").model("Lata").brand("Skol").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductSeeder.builder().name("Vinagre").model("Álcool").brand("Castelo").unitOfMeasure(((UnitOfMeasure.LT))).build(),
    ProductSeeder.builder().name("Molho de Tomate").model("Tradicional").brand("Pomarola").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductSeeder.builder().name("Maionese").model("Tradicional").brand("Hellmann's").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Mostarda").model("Amarela").brand("Hemmer").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductSeeder.builder().name("Ketchup").model("Tradicional").brand("Hemmer").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductSeeder.builder().name("Batata Palha").model("Crocante").brand("Yoki").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Farinha de Mandioca").model("Fina").brand("Yoki").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Fubá").model("Milho").brand("Yoki").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductSeeder.builder().name("Aveia em Flocos").model("Fina").brand("Quaker").unitOfMeasure(UnitOfMeasure.PCT).build()
  );
}