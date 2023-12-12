package org.lesson.agency.travel;

import java.time.LocalDate;

public class ViaggioGruppo extends Vacanza{

    //ATTRIBUTI
    private int numeroPartecipanti;
    private int etaMin;
    private int etaMax;

    // COSTRUTTORI
    public ViaggioGruppo(String destinazione, LocalDate partenza, LocalDate arrivo, int numeroPartecipanti, int etaMin, int etaMax) throws IllegalArgumentException {
        super(destinazione, partenza, arrivo);
        validateEta(etaMin,etaMax);
        this.numeroPartecipanti= numeroPartecipanti;
        this.etaMax = etaMax;
        this.etaMin = etaMin;
    }

    //GET E SETTER

    public int getNumeroPartecipanti() {
        return numeroPartecipanti;
    }

    public void setNumeroPartecipanti(int numeroPartecipanti) {
        this.numeroPartecipanti = numeroPartecipanti;
    }

    public int getEtaMin() {
        return etaMin;
    }

    public void setEtaMin(int etaMin) {
        this.etaMin = etaMin;
    }

    public int getEtaMax() {
        return etaMax;
    }

    public void setEtaMax(int etaMax) {
        this.etaMax = etaMax;
    }

    //METODI

    private void validateEta(int etaMin, int etaMax) throws IllegalArgumentException{
        if(etaMin <= 0 || etaMin>etaMax ){
            throw new IllegalArgumentException("Eta non valida");
        }
    }
    public String toString() {
        return "Viaggio di gruppo: " + "\n " +
                "Destinazione: " + getDestinazione() + "\n " +
                "Partenza: " + getPartenza() + "\n "
                +"Ritorno: " + getArrivo() + "\n "
                +"Durata del viaggio: " + calculateDaysBetween(getPartenza(),getArrivo()) + " giorni " + "\n"
                + "Fascia di eta: "+ getEtaMin() + "-" + getEtaMax();
    }
}

