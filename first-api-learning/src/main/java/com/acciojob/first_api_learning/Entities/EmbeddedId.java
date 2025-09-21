package com.acciojob.first_api_learning.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//just for learning;
//create composite key using @EmbeddedId And @Embeddable
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmbeddedId {
    @jakarta.persistence.EmbeddedId
    private CompositeEmbeddable compositeEmbeddable;
}
