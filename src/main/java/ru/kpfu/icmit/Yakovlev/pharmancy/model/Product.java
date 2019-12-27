package ru.kpfu.icmit.Yakovlev.pharmancy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "product_seq",  allocationSize = 1)
public class Product extends IdEntity {
    private String name;
    private Double price;
    private Integer count;
    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToOne
    @JoinColumns(foreignKey = @ForeignKey(name = "fk_product_shop"),
    value = {
            @JoinColumn(referencedColumnName = "id")
    })
    private Shop shop;
    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToOne
    @JoinColumns(foreignKey = @ForeignKey(name = "fk_product_supplier"),
    value = {
            @JoinColumn(referencedColumnName = "id")
    })
    private Supplier supplier;
    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToOne
    @JoinColumns(foreignKey = @ForeignKey(name = "fk_product_product_type"),
    value = {
            @JoinColumn(referencedColumnName = "id")
    })
    private Type type;
}
