package home.map.events.entity;

/**
 * Created by greg on 14.07.15.
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Point {
    @Column
    private double longitude;
    @Column
    private double latitude;

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
