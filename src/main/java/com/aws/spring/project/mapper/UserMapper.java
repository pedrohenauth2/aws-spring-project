package com.aws.spring.project.mapper;

import com.aws.spring.project.Domain.User;
import com.aws.spring.project.rest.representation.UserRepresentation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserRepresentation> toRepresenation(List<User> user);
    User toDomain(UserRepresentation userRepresentation);

}