package com.agile.project.models.UserComponents;

import com.agile.project.models.TeamComponents.Team;
import com.agile.project.models.TaskComponents.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data //Generates Getters and Setters
@Builder //Useful for Builder Design pattern
@NoArgsConstructor //makes the no argument constructor
@AllArgsConstructor // makes the all arguments constructor with the id,firstname...
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id //makes the id below recognized as the id for this user class
    @GeneratedValue(strategy = GenerationType.AUTO) //Makes it so that the id is autogenerated, using Auto makes the hibernate make the best decision for us
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false) //we use @Column only to specify table column properties not for validations.
    private String email;

    @Column(nullable = false) //There must be a password
    private String password; //there is a get password for the userDetails interface, but it is being handled using this

    @Enumerated(EnumType.ORDINAL) //We need users to have certain permissions by their role
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<Task>();

    //This is the join table for the users and the groups they are in
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_TEAM_MAPPING",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"), //name of column relative to this entity
            inverseJoinColumns = @JoinColumn(name = "team_id",referencedColumnName = "id") //name of column for the user entity
    )
    private Set<Team> teams = new HashSet<>();

    //The Following Override Methods are from the UserDetails interface that must be implemented
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //This Method returns the role of the user
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email; //we will reference users by their email since it must be unique
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

/*
When the application is run we will have in SQL:
    create table _user (
        id integer not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        role varchar(255),
        primary key (id)
    )
 */
