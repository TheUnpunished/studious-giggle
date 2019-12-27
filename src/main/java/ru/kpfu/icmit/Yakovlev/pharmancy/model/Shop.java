package ru.kpfu.icmit.Yakovlev.pharmancy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "shop_seq", allocationSize = 1)
public class Shop extends IdEntity {
    private String name;
    private String address;
    @Column(insertable = false, updatable = false)
    private Long count;
    private String phone;
}
