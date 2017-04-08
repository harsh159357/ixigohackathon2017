package ixigo.invincible.takemethere.harsh.models.recommendations;


import java.util.ArrayList;

public class Data {
    private ArrayList<FlightData> flight;
    private ArrayList<FlightData> budget_Flight;

    public Data() {
    }

    public Data(ArrayList<FlightData> flight, ArrayList<FlightData> budget_Flight) {
        this.flight = flight;
        this.budget_Flight = budget_Flight;
    }

    public ArrayList<FlightData> getFlight() {
        return flight;
    }

    public void setFlight(ArrayList<FlightData> flight) {
        this.flight = flight;
    }

    public ArrayList<FlightData> getBudget_Flight() {
        return budget_Flight;
    }

    public void setBudget_Flight(ArrayList<FlightData> budget_Flight) {
        this.budget_Flight = budget_Flight;
    }
}
