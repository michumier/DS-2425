package adapters;

import google.maps.Coordinates;

public interface Adapter {
    Coordinates getCoordinates();   
    String shortClick();
    void longClick();
}
