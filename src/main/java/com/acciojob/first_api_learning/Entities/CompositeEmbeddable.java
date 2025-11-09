package com.acciojob.first_api_learning.Entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class CompositeEmbeddable implements Serializable {
    private Integer a;
    private Integer b;
}
