package home.map.events.core.entity;

/**
 * Created by greg on 14.07.15.
 */



import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable public class Point implements Serializable {
    @Column
    private double longitude;
    @Column
    private double latitude;

    public Point(){}

    public Point(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
