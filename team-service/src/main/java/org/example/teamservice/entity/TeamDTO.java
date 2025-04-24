package org.example.teamservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDTO {
    private Long id;
    private String teamName;
    private String country;
    private List<Driver> drivers;
}
