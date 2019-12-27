package ru.kpfu.icmit.Yakovlev.pharmancy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "type_seq",  allocationSize = 1)
@Table(name = "product_type")
public class Type extends IdEntity{
    private String name;
    @Column(insertable = false, updatable = false)
    private Long count;
}
