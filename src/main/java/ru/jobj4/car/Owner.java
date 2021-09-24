package ru.jobj4.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
@AllArgsConstructor(
        staticName = "of"
)
@NoArgsConstructor
@Getter
@Setter
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany()
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "owner_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "car_id", nullable = false, updatable = false)})
    private List<Car> cars;

    public void addCar(Car car) {
        if (cars == null) {
            cars = new ArrayList();
        }
        cars.add(car);
    }

    public static Owner of(String name) {
        Owner owner = new Owner();
        owner.setName(name);
        return owner;
    }
}
