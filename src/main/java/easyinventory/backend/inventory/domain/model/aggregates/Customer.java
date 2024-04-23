package easyinventory.backend.inventory.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String birthday;

    private String email;

    private Integer phone;

    public Customer(String name, String lastName, String birthday, String email, Integer phone) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }

    public Customer() {}
}
