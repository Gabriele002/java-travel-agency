package org.lesson.agency.travel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vacanza {

    //ATTRIBUTI
    private String destinazione;
    private LocalDate partenza;
    private LocalDate arrivo;
    // COSTRUTTORI

    public Vacanza(String destinazione, LocalDate partenza, LocalDate arrivo)throws IllegalArgumentException {
        validateDestinazione(destinazione);
        validatePartenza(partenza, arrivo);
        this.destinazione = destinazione;
        this.partenza = partenza;
        this.arrivo = arrivo;
    }


    //GET E SETTER

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getPartenza() {
        return partenza;
    }

    public void setPartenza(LocalDate partenza) {
        this.partenza = partenza;
    }

    public LocalDate getArrivo() {
        return arrivo;
    }

    public void setArrivo(LocalDate arrivo) {
        this.arrivo = arrivo;
    }

    //METODI

    private void validateDestinazione(String destinazione) throws IllegalArgumentException{
        if(destinazione == null || destinazione.isEmpty()){
            // name non è valido
            throw new IllegalArgumentException("Destinazione empty");
        }
    }

    private void validatePartenza(LocalDate partenza, LocalDate arrivo) throws IllegalArgumentException{
        if(partenza.isAfter(arrivo)|| partenza.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data non valida");
        }
    }

    public static long calculateDaysBetween(LocalDate partenza, LocalDate arrivo) {
        return ChronoUnit.DAYS.between(partenza, arrivo);
    }

    @Override
    public String toString() {
        return "Vacanza{" +
                "destinazione='" + destinazione + '\'' +
                ", partenza=" + partenza +
                ", arrivo=" + arrivo +
                " " +
                 "Giorni=" + calculateDaysBetween(partenza,arrivo) +
                '}';
    }
}





