package ru.kpfu.icmit.Yakovlev.pharmancy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "worker_seq",  allocationSize = 1)
public class Worker extends IdEntity{
    private String name;
    private String secName;
    private String phone;
    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToOne
    @JoinColumns(foreignKey = @ForeignKey(name = "fk_worker_shop"),
    value = {
            @JoinColumn(referencedColumnName = "id")
    })
    private Shop shop;
}
