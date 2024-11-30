package com.jpa.practice.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

//Adding this annotation here so all the DTOs can inherit this property
@JsonIgnoreProperties(ignoreUnknown = true)
public interface AppDTO extends Serializable {
}
