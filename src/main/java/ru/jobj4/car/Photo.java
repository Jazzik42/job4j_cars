package ru.jobj4.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "photo")
@AllArgsConstructor(
        staticName = "of"
)
@NoArgsConstructor
@Getter
@Setter
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public static Photo of(String path, Car car) {
        Photo photo = new Photo();
        photo.setPath(path);
        photo.setCar(car);
        return photo;
    }
}
