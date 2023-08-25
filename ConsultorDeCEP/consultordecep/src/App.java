import models.Address;

import java.util.Scanner;

import functionalities.AddressQuery;
import functionalities.JsonGenerator;

public class App {
    public static void main(String[] args) throws Exception {
         AddressQuery cepQuery = new AddressQuery();
         JsonGenerator generator = new JsonGenerator();
         Scanner input = new Scanner(System.in);
         System.out.println("Escreva o CEP que deseja consultar: ");
         String cep = input.nextLine();
         try {
            Address address = cepQuery.CepQuery(cep);
            System.out.println(address);
            generator.generate(address);
         } catch (RuntimeException e) {
        System.out.println(e.getMessage());
        System.out.println("Programa Finalizado.");
         }
         
         
    }
}
