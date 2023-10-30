package com.hzyazilimci.libraryservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Library {

    @Id
    @Column(name = "library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ElementCollection // primitive veya @Embeddable olarak isaretli tipler icin kullanilabilir. Ara tablo yaratir. @Entity ile isaretli tipler icin kullanilmaz!
                       // ManyToMany bir tablo create eder.
    private List<String> bookIds;
}
