package ru.jobj4.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "body")
@NoArgsConstructor
@Getter
@Setter
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public static Body of(String name) {
        Body body = new Body();
        body.setName(name);
        return body;
    }
}
