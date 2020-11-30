package com.gaan.liver.ui.ar;

import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.pojo.SensorXY;

import java.util.List;

public interface ArNavigator {
    void openDiscover();
    void openMessenger();
    void showItems(List<GetEventResponse> getEventResponseList);
    void setRangeOfView(SensorXY sensorXY);
    void handlerShowItemsError(Throwable throwable);
}
