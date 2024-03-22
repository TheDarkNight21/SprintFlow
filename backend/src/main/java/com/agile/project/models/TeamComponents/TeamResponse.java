package com.agile.project.models.TeamComponents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {
    private Boolean success;
    private int count;
    private List<String> data; //String because the team name is all you need
}
