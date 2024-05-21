package br.com.tabela.tabelafipe.Menu;

import br.com.tabela.tabelafipe.Model.DataModel;
import br.com.tabela.tabelafipe.Model.GenericData;
import br.com.tabela.tabelafipe.Service.ConsumerApi;
import br.com.tabela.tabelafipe.Service.ConvertJson;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    ConsumerApi consumerApi = new ConsumerApi();
    ConvertJson convertJson = new ConvertJson();

    public void displayMenu() throws IllegalAccessException, JsonProcessingException {

        String menu = """
                *** OPÇÕES ***
                
                - Carro
                - Moto
                - Caminhão
                
                Digite uma das opções para consulta:
                """;
        System.out.println(menu);
        var option = scanner.nextLine();

        String address = "";

        if (option.toLowerCase().contains("carr")){
            address = BASE_URL + "carros/marcas";
        } else if (option.toLowerCase().contains("mot")) {
            address = BASE_URL + "motos/marcas";
        } else if (option.toLowerCase().contains("camin")) {
            address = BASE_URL + "caminhoes/marcas";
        }

        String json = consumerApi.getData(address);

        var breads = convertJson.getList(json, GenericData.class);

        breads
                .stream()
                .sorted(Comparator.comparing(GenericData::code))
                .forEach(bread -> System.out.println(
                        "Código: " + bread.code() +
                               " Marca: " + bread.description()
                ));

        System.out.println("Digite o nome abreviado da marca: ");
        String AbbreviationName = scanner.nextLine();

        breads
                .stream()
                .filter(bread -> bread.description().toLowerCase().contains(AbbreviationName))
                .forEach(bread -> System.out.println(
                "Código: " + bread.code() +
                        " Marca: " + bread.description()
        ));




    }
}
