package hiber.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String model;
    @Column
    private String series;

    public void setCarUser(User carUser) {
        this.carUser = carUser;
    }

    public long getId() {
        return id;
    }

    public User getCarUser() {
        return carUser;
    }

    @OneToOne(mappedBy = "userCar")
    private User carUser;

    public Car() {
    }

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(String series) {
        this.series = series;
    }

//    @Override
//    public String toString() {
//        return "Car{" +
//                "id=" + id +
//                ", model='" + model + '\'' +
//                ", series=" + series +
//                '}';
//    }
}
