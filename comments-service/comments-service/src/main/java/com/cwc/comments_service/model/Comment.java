package com.cwc.comments_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_comment")
public class Comment {
    private Long postId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Lob  // This tells JPA that the field will hold a large object
    @Column(columnDefinition = "TEXT")  // Optional: Explicitly define the column type in the database // or do it on database ALTER TABLE t_comment MODIFY body TEXT;
    private String body;
}
