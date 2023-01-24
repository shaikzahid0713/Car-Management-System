package com.jk.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPassword;


    @Column(nullable = false)
    private String userRole;

    public User (String userName, String userPassword, String userRole) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    @Override
    public boolean equals (Object o) {

        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass(this) != Hibernate.getClass(o) ) return false;
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode () {

        return getClass().hashCode();
    }

}
