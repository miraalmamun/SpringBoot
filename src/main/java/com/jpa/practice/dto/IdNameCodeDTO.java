package com.jpa.practice.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IdNameCodeDTO implements AppDTO{

    Integer id;
    String code;
    String name;
    private String sortOrderNum;
    boolean isRequestable;

    public IdNameCodeDTO(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public IdNameCodeDTO(Integer id, String code, String name, String sortOrderNum) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sortOrderNum = sortOrderNum;
    }
}
