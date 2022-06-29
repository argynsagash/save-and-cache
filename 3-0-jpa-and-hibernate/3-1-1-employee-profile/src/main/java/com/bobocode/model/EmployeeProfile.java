package com.bobocode.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * todo:
 * - configure JPA entity
 * - specify table name: "employee_profile"
 * - configure not nullable columns: position, department
 *
 * - map relation between {@link Employee} and {@link EmployeeProfile} using foreign_key column: "employee_id"
 * - configure a derived identifier. E.g. map "employee_id" column should be also a primary key (id) for this entity
 */
@NoArgsConstructor
@Data
@Table(name = "employee_profile")
@Entity

public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne()
//  Общий первичный ключ
    @MapsId
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String department;
}
