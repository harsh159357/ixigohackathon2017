package ixigo.invincible.takemethere.harsh.requesters;

import org.greenrobot.eventbus.EventBus;

import java.net.HttpURLConnection;

import ixigo.invincible.takemethere.harsh.controllers.HTTPOperationController;
import ixigo.invincible.takemethere.harsh.interfaces.BaseRequester;
import ixigo.invincible.takemethere.harsh.models.eventbus.EventObject;
import ixigo.invincible.takemethere.harsh.models.hotels.HotelsData_;
import ixigo.invincible.takemethere.harsh.models.placestovisit.PlacesToVisitData_;
import ixigo.invincible.takemethere.harsh.models.thingstodo.ThingsToDoData_;
import ixigo.invincible.takemethere.harsh.retrofit.APIResponse;

public class AnyOfTheseThingsToDoPlacesToVisitHotelsRequester implements BaseRequester {
    private String cityId;
    private String type;

    public AnyOfTheseThingsToDoPlacesToVisitHotelsRequester(String cityId, String type) {
        this.cityId = cityId;
        this.type = type;
    }

    @Override
    public void run() {
        APIResponse<Object> objectAPIResponse = null;
        switch (type) {
            case Types.HOTEL:
                objectAPIResponse = HTTPOperationController.getHotels(cityId);
                break;
            case Types.THINGS_TO_DO:
                objectAPIResponse = HTTPOperationController.getThingsToDo(cityId);
                break;
            case Types.PLACES_TO_VISIT:
                objectAPIResponse = HTTPOperationController.getPlacesToVisit(cityId);
                break;
            default:
                objectAPIResponse = HTTPOperationController.
                        getAnyOutOfTheseThingsToDoPlacesToVisitHotels(cityId, type);
        }
        if (objectAPIResponse != null) {
            if (objectAPIResponse.getResponseCode() == HttpURLConnection.HTTP_OK) {
                switch (type) {
                    case Types.HOTEL:
                        EventBus.getDefault().post(new EventObject(Events.GET_HOTELS_SUCCESSFUL, ((HotelsData_) objectAPIResponse.getResponse()).getData()));
                        break;
                    case Types.THINGS_TO_DO:
                        EventBus.getDefault().post(new EventObject(Events.GET_THINGS_TO_DO_SUCCESSFUL, ((ThingsToDoData_) objectAPIResponse.getResponse()).getData()));
                        break;
                    case Types.PLACES_TO_VISIT:
                        EventBus.getDefault().post(new EventObject(Events.GET_PLACES_TO_VISIT_SUCCESSFUL, ((PlacesToVisitData_) objectAPIResponse.getResponse()).getData()));
                        break;
                }
            } else {
                switch (type) {
                    case Types.HOTEL:
                        EventBus.getDefault().post(new EventObject(Events.GET_HOTELS_FAILED, null));
                        break;
                    case Types.THINGS_TO_DO:
                        EventBus.getDefault().post(new EventObject(Events.GET_THINGS_TO_DO_FAILED, null));
                        break;
                    case Types.PLACES_TO_VISIT:
                        EventBus.getDefault().post(new EventObject(Events.GET_PLACES_TO_VISIT_FAILED, null));
                        break;
                }

            }
        } else {
            EventBus.getDefault().post(new EventObject(Events.NO_INTERNET_CONNECTION, null));
        }
    }
}
