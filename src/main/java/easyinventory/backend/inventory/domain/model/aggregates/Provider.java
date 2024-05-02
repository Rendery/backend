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
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private Integer phone ;
    private Long ruc ;
    private String email ;

    public Provider(String name, Integer phone, Long ruc, String email) {
        this.name = name;
        this.phone = phone;
        this.ruc = ruc;
        this.email = email;
    }

    public boolean isValidRuc(Long ruc) {
        if (ruc == null) throw new IllegalArgumentException("RUC is required") ;
        if (ruc.toString().length() != 11) throw new IllegalArgumentException("RUC must have 11 digits");
        return true;
    }

    public boolean isValidPhone(Integer phone) {
        if (phone == null) throw new IllegalArgumentException("Phone is required") ;
        if (phone.toString().length() != 9) throw new IllegalArgumentException("Phone must have 9 digits");
        return true;
    }


    public Provider() {}
}
