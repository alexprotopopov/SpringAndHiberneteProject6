package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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
    private int series;
@OneToOne(mappedBy = "userCar")//(fetch = FetchType.LAZY)
//    @MapsId
    private User carUser;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
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
