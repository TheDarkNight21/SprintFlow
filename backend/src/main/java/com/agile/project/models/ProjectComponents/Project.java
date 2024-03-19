package com.agile.project.models.ProjectComponents;

import com.agile.project.models.TaskComponents.Task;
import com.agile.project.models.TeamComponents.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data //Generates Getters and Setters
@Builder //Useful for Builder Design pattern
@NoArgsConstructor //makes the no argument constructor
@AllArgsConstructor // makes the all arguments constructor with the id,firstname...
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Makes it so that the id is autogenerated, using Auto makes the hibernate make the best decision for us
    private Integer id;
    private String name;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<Task>();
//    private int points;

    @ManyToOne(fetch = FetchType.LAZY) //lazy loading the relationship with the user
    @JoinColumn(name = "team_id")
    private Team team;

}
