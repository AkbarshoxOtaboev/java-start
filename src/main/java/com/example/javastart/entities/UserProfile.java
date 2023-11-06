package com.example.javastart.entities;

import com.example.javastart.utils.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.USERPROFILE)
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String profilePhoto;
    private String phone;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;
}
