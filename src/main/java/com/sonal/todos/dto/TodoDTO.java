package com.sonal.todos.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private String id;
    private String title;
    private String description;
    private String priority;
    private boolean isComplete;
}