package com.bookstore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Size(max = 50,message = "Tên quyền tối đa ký tự 50")
    @NotBlank(message = "Tên quyền không được để trống")
    @Column(name = "name", length = 50, nullable = false)
    private String name;


    @Size(max = 250, message = "Mô tô tả quyền tối đa 250 ký tự")
    @Column(name = "description",length = 250)

    private String description;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
               joinColumns = @JoinColumn(name = "role_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
