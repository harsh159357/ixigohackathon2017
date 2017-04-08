package ixigo.invincible.takemethere.harsh.models.recommendations;


import java.util.ArrayList;

public class Data {
    private ArrayList<FlightData> flight;
    private ArrayList<FlightData> budget_flight;

    public Data() {
    }

    public Data(ArrayList<FlightData> flight, ArrayList<FlightData> budget_flight) {
        this.flight = flight;
        this.budget_flight = budget_flight;
    }

    public ArrayList<FlightData> getFlight() {
        return flight;
    }

    public void setFlight(ArrayList<FlightData> flight) {
        this.flight = flight;
    }

    public ArrayList<FlightData> getBudget_flight() {
        return budget_flight;
    }

    public void setBudget_flight(ArrayList<FlightData> budget_flight) {
        this.budget_flight = budget_flight;
    }
}
