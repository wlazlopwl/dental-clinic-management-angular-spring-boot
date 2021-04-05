package com.pawelwlazlo.dentalclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pawelwlazlo.dentalclinic.types.GenderType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Room implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "room")
    private List<Visit> visits;


}
