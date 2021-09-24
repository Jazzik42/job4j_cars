package ru.jobj4.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "announcement")
@NoArgsConstructor
@Getter
@Setter
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public static Announcement of(String description, User user, Car car, Owner owner) {
    Announcement announcement = new Announcement();
    announcement.setCar(car);
    announcement.setDescription(description);
    announcement.setOwner(owner);
    announcement.setUser(user);
    return announcement;
    }
}
