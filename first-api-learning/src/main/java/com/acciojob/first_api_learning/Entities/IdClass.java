package com.acciojob.first_api_learning.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.IdClass(CompositeIdClass.class)
class IdClass {
    @Id
    private Integer a;
    @Id
    private Integer b;
}
