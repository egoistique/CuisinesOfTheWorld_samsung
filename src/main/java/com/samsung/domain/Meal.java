
package com.samsung.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "meal")
    private List<Recipe> recipes;

    @ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(targetEntity = Type.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne(targetEntity = Time.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id")
    private Time time;

}