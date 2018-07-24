package entity;

import javax.persistence.*;

@Entity
@Table(name = "station")
public class Station {

    @Id
    @Column(name = "PK_Station")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "FK_Client")
    private Client client;

    @Column(name = "NoOfPumps")
    private long noOfPumps;

    @Column(name = "TotalFuel")
    private long totalFuel;

    @Column(name = "PetrolRate")
    private long petrolRate;

    @Column(name = "DieselRate")
    private long dieselRate;

    @Column(name = "HiOctaneRate")
    private long hiOctaneRate;

    @Column(name = "Name")
    private String name;

    @Column(name = "Contact")
    private String contact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getNoOfPumps() {
        return noOfPumps;
    }

    public void setNoOfPumps(long noOfPumps) {
        this.noOfPumps = noOfPumps;
    }

    public long getTotalFuel() {
        return totalFuel;
    }

    public void setTotalFuel(long totalFuel) {
        this.totalFuel = totalFuel;
    }

    public long getPetrolRate() {
        return petrolRate;
    }

    public void setPetrolRate(long petrolRate) {
        this.petrolRate = petrolRate;
    }

    public long getDieselRate() {
        return dieselRate;
    }

    public void setDieselRate(long dieselRate) {
        this.dieselRate = dieselRate;
    }

    public long getHiOctaneRate() {
        return hiOctaneRate;
    }

    public void setHiOctaneRate(long hiOctaneRate) {
        this.hiOctaneRate = hiOctaneRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
