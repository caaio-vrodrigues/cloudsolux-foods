package com.cloudsolux.foods.inventory_service.app.product.seeder;

import java.util.List;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class ProductList {
  
  @Default
  private List<ProductDTOSeeder> seeds = List.of(
    ProductDTOSeeder.builder().name("Orégano").model("Comum").brand("Da Roça").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Manjericão").model("Comum").brand("Da Roça").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Azeite de Oliva").model("Extra Virgem").brand("Gallo").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Açúcar").model("Refinado").brand("União").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Farinha de Trigo").model("Tipo 1").brand("Dona Benta").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Sal Refinado").model("Fino").brand("Cisal").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Café Torrado").model("Tradicional").brand("Pilão").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Arroz Branco").model("Tipo 1").brand("Camil").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Feijão Carioca").model("Tipo 1").brand("Camil").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Macarrão Espaguete").model("Gran Duro").brand("Adria").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Óleo de Soja").model("Refinado").brand("Soya").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductDTOSeeder.builder().name("Leite Integral").model("Integral").brand("Piracanjuba").unitOfMeasure((UnitOfMeasure.LT)).build(),
    ProductDTOSeeder.builder().name("Manteiga").model("Com Sal").brand("Italac").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Queijo Mussarela").model("Fatiado").brand("Presidente").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Presunto").model("Fatiado").brand("Sadia").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Pão de Forma").model("Integal").brand("Pullman").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Biscoito Recheado").model("Chocolate").brand("Bauducco").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Chocolate ao Leite").model("Barra").brand("Lacta").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductDTOSeeder.builder().name("Suco de Laranja").model("Integral").brand("Del Valle").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductDTOSeeder.builder().name("Refrigerante Cola").model("Lata").brand("Coca-Cola").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductDTOSeeder.builder().name("Água Mineral").model("Sem Gás").brand("Crystal").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductDTOSeeder.builder().name("Cerveja Pilsen").model("Lata").brand("Skol").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Vinagre").model("Álcool").brand("Castelo").unitOfMeasure(((UnitOfMeasure.LT))).build(),
    ProductDTOSeeder.builder().name("Molho de Tomate").model("Tradicional").brand("Pomarola").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Maionese").model("Tradicional").brand("Hellmann's").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Mostarda").model("Amarela").brand("Hemmer").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Ketchup").model("Tradicional").brand("Hemmer").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductDTOSeeder.builder().name("Batata Palha").model("Crocante").brand("Yoki").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Farinha de Mandioca").model("Fina").brand("Yoki").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Fubá").model("Milho").brand("Yoki").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Aveia em Flocos").model("Fina").brand("Quaker").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Granola").model("Crocante").brand("Mãe Terra").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Mel").model("Puro").brand("Néctar").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Geleia de Morango").model("Tradicional").brand("Queensberry").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Manteiga de Amendoim").model("Cremosa").brand("Amendocrem").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Chocolate em Pó").model("Nescau").brand("Nestlé").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Achocolatado").model("Pronto").brand("Nescau").unitOfMeasure((UnitOfMeasure.LT)).build(),
    ProductDTOSeeder.builder().name("Creme de Leite").model("Tradicional").brand("Nestlé").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Leite Condensado").model("Tradicional").brand("Moça").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Gelatina").model("Morango").brand("Dr. Oetker").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Fermento em Pó").model("Químico").brand("Royal").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Fermento Biológico").model("Fresco").brand("Fleischmann").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Polpa de Tomate").model("Integral").brand("Elefante").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Extrato de Tomate").model("Concentrado").brand("Elefante").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Milho Verde").model("Em Conserva").brand("Pomarola").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Ervilha").model("Em Conserva").brand("Pomarola").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Atum em Lata").model("Ao Óleo").brand("Gomes da Costa").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductDTOSeeder.builder().name("Sardinha").model("Ao Óleo").brand("Gomes da Costa").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductDTOSeeder.builder().name("Palmito").model("Em Conserva").brand("Hemmer").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Azeitona Verde").model("Sem Caroço").brand("Rivoli").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Pimenta do Reino").model("Moída").brand("Kitano").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Cominho").model("Em Pó").brand("Kitano").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Paprica Doce").model("Em Pó").brand("Kitano").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Canela em Pó").model("Fina").brand("Kitano").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Noz-Moscada").model("Ralada").brand("Kitano").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Louro").model("Folhas").brand("Kitano").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Alho").model("Em Pó").brand("Kitano").unitOfMeasure((UnitOfMeasure.UN)).build(),
    ProductDTOSeeder.builder().name("Cebola Desidratada").model("Em Flocos").brand("Kitano").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Tempero Completo").model("Tradicional").brand("Arisco").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Caldo de Galinha").model("Tablete").brand("Knorr").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Caldo de Carne").model("Tablete").brand("Knorr").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Sazon").model("Amarelo").brand("Ajinomoto").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Shoyu").model("Molho").brand("Sakura").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductDTOSeeder.builder().name("Molho de Soja").model("Shoyo").brand("Kikkoman").unitOfMeasure(UnitOfMeasure.LT).build(),
    ProductDTOSeeder.builder().name("Catchup").model("Tradicional").brand("Quero").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Salsicha").model("Hot Dog").brand("Sadia").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Linguiça Toscana").model("Fresca").brand("Perdigão").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Bacon").model("Defumado").brand("Sadia").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Peito de Frango").model("Congelado").brand("Sadia").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Carne Moída").model("Acém").brand("Friboi").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Picanha").model("Bovina").brand("Friboi").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Costela").model("Suína").brand("Perdigão").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Filé de Tilápia").model("Congelado").brand("Copacol").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Camarão").model("Descascado").brand("Copacol").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Ovo Branco").model("Grande").brand("Granja").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Ovo Vermelho").model("Extra").brand("Granja").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Batata Inglesa").model("Lavada").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Cebola").model("Perlada").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Tomato").model("Italiano").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Alface").model("Crespa").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Banana").model("Prata").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Maçã").model("Fuji").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Laranja").model("Pera").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Limão").model("Tahiti").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Manga").model("Palmer").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Abacate").model("Avocado").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Morango").model("Orgânico").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Uva").model("Red Globe").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Melancia").model("Crimson").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Papaia").model("Formosa").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Coco").model("Seco").brand("Hortifruti").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Castanha de Caju").model("Torrada").brand("Cajunuts").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Amendoim").model("Torrado").brand("Santa Helena").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Pipoca").model("Microndas").brand("Yoki").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Salgadinho").model("Queijo").brand("Elma Chips").unitOfMeasure(UnitOfMeasure.PCT).build(),
    ProductDTOSeeder.builder().name("Barra de Cereal").model("Crocante").brand("Nutry").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Iogurte").model("Natural").brand("Danone").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Requeijão").model("Cremoso").brand("Catupiry").unitOfMeasure(UnitOfMeasure.UN).build(),
    ProductDTOSeeder.builder().name("Ricota").model("Fresca").brand("Presidente").unitOfMeasure(UnitOfMeasure.KG).build(),
    ProductDTOSeeder.builder().name("Parmesão Ralado").model("Fino").brand("Presidente").unitOfMeasure(UnitOfMeasure.PCT).build()
  );
}