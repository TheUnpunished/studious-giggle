package ru.kpfu.icmit.Yakovlev.pharmancy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "purchase_seq",  allocationSize = 1)
public class Purchase extends IdEntity {
    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToOne
    @JoinColumns(foreignKey = @ForeignKey(name = "fk_purchase_product"),
    value = {
            @JoinColumn(referencedColumnName = "id")
    })
    private Product product;
    private Integer count;
    private Double totalPrice;
    private Date date;
}
