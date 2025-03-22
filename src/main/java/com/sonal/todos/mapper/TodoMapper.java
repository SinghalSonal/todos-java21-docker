package com.sonal.todos.mapper;

import com.sonal.todos.dto.TodoDTO;
import com.sonal.todos.model.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    // All properties are mapped here except ID (it's ignored)
    @Mapping(target = "id", ignore = true)
    Todo toEntity(TodoDTO dto);

    TodoDTO toDTO(Todo entity);

    // map dto.isComplete to entity.completed AND map all other properties
    Todo updateEntity(TodoDTO dto, @MappingTarget Todo entity);
}
