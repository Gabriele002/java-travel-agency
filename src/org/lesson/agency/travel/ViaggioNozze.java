package org.lesson.agency.travel;

import java.time.LocalDate;
import java.util.ArrayList;


public class ViaggioNozze extends Vacanza {

    //ATTRIBUTI
     private String trattamenti;

    // COSTRUTTORI
    public ViaggioNozze(String destinazione, LocalDate partenza, LocalDate arrivo, String trattamenti) throws IllegalArgumentException {
        super(destinazione, partenza, arrivo);
        this.trattamenti=trattamenti;
    }

    //GET E SETTER

    //METODI

    @Override
    public String toString() {
        return "Viaggio di nozze: " + "\n " +
                "Destinazione: " + getDestinazione() + "\n " +
                "Partenza: " + getPartenza() + "\n "
                +"Ritorno: " + getArrivo() + "\n "
                +"Trattamenti selezionati: " + trattamenti + "\n"
                +"Durata del viaggio: " + calculateDaysBetween(getPartenza(),getArrivo()) + " giorni " + "\n";

    }
}
