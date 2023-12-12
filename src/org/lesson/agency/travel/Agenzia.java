package org.lesson.agency.travel;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean stop= false;
        while(!stop){
            System.out.println("Insert new travel?(y/n)");
            String answer = scan.nextLine();
            switch (answer){
                case "y":
                    try {
                        System.out.print("Destinazione: ");
                        String destinazione = scan.nextLine();
                        LocalDate datePartenza = null;
                        while (datePartenza == null) {
                            System.out.println("Data di partenza (yyyy-mm-dd)");
                            String inputPartenza = scan.nextLine();
                            try {
                                datePartenza = LocalDate.parse(inputPartenza);
                            } catch (DateTimeParseException e) {
                                System.out.println("Formato non valido");
                            }
                        }
                        LocalDate dateArrivo = null;
                        while (dateArrivo == null) {
                            System.out.println("Data di ritorno (yyyy-mm-dd)");
                            String inputArrivo = scan.nextLine();
                            try {
                                dateArrivo = LocalDate.parse(inputArrivo);
                            } catch (DateTimeParseException e) {
                                System.out.println("Formato non valido");
                            }
                        }

                        Vacanza vacanza = new Vacanza(destinazione, datePartenza, dateArrivo);
                        System.out.println(vacanza);
                    }catch (IllegalArgumentException e){
                        System.out.println("Sorry invalid parameters: " + e.getMessage());
                    }
                case "n":
                     stop = true;
                    break;
                default:
                    System.out.println("invalid answer");
                    break;
                    }
        /*System.out.println("Data di partenza (yyyy-mm-dd)");



        System.out.println("Data di ritorno (yyyy-mm-dd)");

         */

        }




        scan.close();
    }
}
