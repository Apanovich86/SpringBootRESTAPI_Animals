package program.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_animals")
@ToString
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200, nullable = false)
    private String animalName;

    @Column(length = 200, nullable = false)
    private String animalAge;

    @Column(nullable = false)
    private String kindAnimal;

}
