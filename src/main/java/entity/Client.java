package entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "client",cascade = CascadeType.ALL)
    private Station station;

    @Id
    @Column(name = "PK_Client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Cname")
    private String cname;

    @Column(name = "UserName")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Age")
    private String age;

    @Column(name = "Ccontact")
    private String contact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Station getStation(){return station;}

    public void setStation(Station station){this.station=station;}
}
