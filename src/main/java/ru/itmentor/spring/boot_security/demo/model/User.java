package ru.itmentor.spring.boot_security.demo.model;

import lombok.*;

import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "sex")
    private String sex;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
 private Set<Role> roles = new HashSet<>();


//    public User() {
//    }
//    public User(int id, String username, String sex, String password, Set<Role> roles) {
//
//        this.id = id;
//        this.username = username;
//        this.sex = sex;
//        this.password = password;
//        this.roles = roles;
//    }
//
//
//    // Геттер для id
//    public int getId() {
//        return id;
//    }
//
//    // Сеттер для id
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    // Геттер для username
//    public String getUsername() {
//        return username;
//    }
//
//    // Сеттер для username
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    // Геттер для sex
//    public String getSex() {
//        return sex;
//    }
//
//    // Сеттер для sex
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    // Геттер для password
//    public String getPassword() {
//        return password;
//    }
//
//    // Сеттер для password
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    // Геттер для roles
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    // Сеттер для roles
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}

