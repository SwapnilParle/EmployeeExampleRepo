package com.dbConnection.DbConnection;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String Name;

    @Column
    private String email;

    @Column
    private String add;
}
