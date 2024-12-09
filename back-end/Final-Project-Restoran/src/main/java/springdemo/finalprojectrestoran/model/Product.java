package springdemo.finalprojectrestoran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
