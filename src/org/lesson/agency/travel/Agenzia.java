package org.lesson.agency.travel;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList <String> trattamenti = new ArrayList<>();
        boolean stop = false;
        //lista vuota
        while (!stop) {
            System.out.println("Insert new travel?(y/n)");
            String answer = scan.nextLine();
            switch (answer) {
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

                        System.out.println("Che tipo di vacanza vuoi? 1-Viaggio di nozze 2-Viaggio di gruppo 3-Vacanza standard ");
                        String type = scan.nextLine();
                        switch (type) {
                            case "1":
                                System.out.println("Che trattamenti vuoi aggiungere? (Piscina,Spa,Massaggio)");
                                String trat = scan.nextLine();
                                ViaggioNozze viaggioNozze = new ViaggioNozze(destinazione, datePartenza, dateArrivo,trat);
                                System.out.println(viaggioNozze);
                                break;
                            case "2":
                                System.out.println("Quant ne sitt?: ");
                                int numeroPartecipanti = scan.nextInt();
                                System.out.println("Quant anni ha il piu` piccolo di vuoi?: ");
                                int etaMin = scan.nextInt();
                                System.out.println("Quant anni ha il piu` grande di vuoi?: ");
                                int etaMax = scan.nextInt();
                                System.out.println("Hai sbagliato ad inserire la fascia di eta");
                                ViaggioGruppo viaggioGruppo = new ViaggioGruppo(destinazione, datePartenza, dateArrivo, numeroPartecipanti, etaMin, etaMax);
                                System.out.println(viaggioGruppo);
                                break;
                            case  "3":
                                Vacanza vacanza = new Vacanza(destinazione, datePartenza, dateArrivo);
                                System.out.println(vacanza);
                                break;
                            default:
                                System.out.println("Invalid form");
                                break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Sorry invalid parameters: " + e.getMessage());
                    }
                case "n":
                    stop = true;
                    break;
            }
            scan.close();

            //BY MARCO DE CICCO GIUSEPPE MUSELLA LUIGI LALOE`
        }
    }
}
