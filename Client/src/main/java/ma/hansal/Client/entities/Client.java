package ma.hansal.Client.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private Float age;


    public Client(long id, String nom, float age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }
}