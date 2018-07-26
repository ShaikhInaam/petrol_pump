package entity;

import javax.persistence.*;

@Entity
@Table(name = "pump")
public class Pump {

    @ManyToOne
    @JoinColumn(name = "FK_Station")
    private Station station;

    @Id
    @Column(name = "PK_Pump")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Pname")
    private String name;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "Fueltype")
    private long fuelType;

    @Column(name = "idleFilling")
    private long idleFilling;


    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public long getFuelType() {
        return fuelType;
    }

    public void setFuelType(long fuelType) {
        this.fuelType = fuelType;
    }

    public long getIdleFilling() {
        return idleFilling;
    }

    public void setIdleFilling(long idleFilling) {
        this.idleFilling = idleFilling;
    }
}
