package ru.jobj4.car;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany()
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.DETACH
    })
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "owner_id", nullable = false, updatable = false)})
    private List<Owner> owners;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "car")
    private List<Photo> photo;

    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark mark;

    public void addOwner(Owner owner) {
        if (owners == null) {
            owners = new ArrayList();
        }
        owners.add(owner);
    }

    public void addPhoto(Photo ph) {
        if (photo == null) {
            photo = new ArrayList();
        }
        photo.add(ph);
    }

    public static Car of(Body body, Mark mark) {
        Car car = new Car();
        car.setBody(body);
        car.setMark(mark);
        return car;
    }
}
