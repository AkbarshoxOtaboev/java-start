package com.example.javastart.entities;

import com.example.javastart.utils.TableName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.POSTS)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private Integer likes;
    private Integer dislikes;
    private Date createdDate;
    private Date updatedDate;
}
