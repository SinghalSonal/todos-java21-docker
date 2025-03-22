package com.sonal.todos.dto;

import java.io.Serializable;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO implements Serializable {

    private static final long serialVersionUID = 1L; // Add this line

    private String id;
    private String title;
    private String description;
    private String priority;
    private boolean complete;
}