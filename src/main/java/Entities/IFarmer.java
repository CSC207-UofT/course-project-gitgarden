package Entities;

public interface IFarmer extends IUser{

    void setPrefPrice(double prefPrice);

    void setPrefExposure(double prefExposure);

    void setPrefSpeed(double prefSpeed);

    void setPrefCarbon(double prefCarbon);

    double getPrefPrice();

    double getPrefExposure();

    double getPrefSpeed();

    double getPrefCarbon();
}
