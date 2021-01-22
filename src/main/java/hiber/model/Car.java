package hiber.model;


import javax.persistence.*;

@Entity
public class Car {
    @GeneratedValue
    private String id;
    private String model;
    private int series;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;
    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }
}
