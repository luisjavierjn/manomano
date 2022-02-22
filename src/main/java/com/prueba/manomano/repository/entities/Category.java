package com.prueba.manomano.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity(name = "CATEGORY")
public class Category {

    @Id
    @Column(name = "CATEGORIZATION_ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION")
    private String desc;
}
