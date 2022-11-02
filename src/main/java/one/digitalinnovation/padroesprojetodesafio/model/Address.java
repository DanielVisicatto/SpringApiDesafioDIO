package one.digitalinnovation.padroesprojetodesafio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Address {
    @Id
    private String zipCode;
    private String space;
    private String complement;
    private String neighborhood;
    private String state;

}
