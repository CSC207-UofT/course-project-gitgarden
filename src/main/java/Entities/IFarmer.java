package Entities;

import java.util.ArrayList;

public interface IFarmer {

    void setPrefPrice(double prefPrice);

    void setPrefExposure(double prefExposure);

    void setPrefSpeed(double prefSpeed);

    void setPrefCarbon(double prefCarbon);

    double getPrefPrice();

    double getPrefExposure();

    double getPrefSpeed();

    double getPrefCarbon();
}
