package ru.jobj4.car;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor(
        staticName = "of"
)
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, updatable = false, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany()
    @JoinColumn(name = "user_id")
    private List<Car> cars;

    public void addCar(Car car) {
        if (cars == null) {
            cars = new ArrayList();
        }
        cars.add(car);
    }

    public static User of(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
