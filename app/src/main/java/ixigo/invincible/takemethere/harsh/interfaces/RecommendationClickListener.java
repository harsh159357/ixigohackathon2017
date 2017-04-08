package ixigo.invincible.takemethere.harsh.interfaces;

import ixigo.invincible.takemethere.harsh.models.recommendations.FlightData;

public interface RecommendationClickListener {
    void onImageViewClick(FlightData flightData);

    void onPlacesToVisitClick(FlightData flightData);

    void onThingsToDoClick(FlightData flightData);

    void onHotelsClick(FlightData flightData);
}
