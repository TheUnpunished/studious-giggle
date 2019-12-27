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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "idGenerator", sequenceName = "supplier_seq",  allocationSize = 1)
public class Supplier extends IdEntity{
    private String name;
    @Column(insertable = false, updatable = false)
    private String count;
    private String phone;
    private String address;
}
