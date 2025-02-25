package com.aws.spring.project.rest;

import com.aws.spring.project.mapper.UserMapper;
import com.aws.spring.project.rest.representation.UserRepresentation;
import com.aws.spring.project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/findUser")
    @Operation(summary = "Retorna a lista de usuários", description = "Retorna todos os usuários no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de usuários",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserRepresentation.class)))
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<List<UserRepresentation>> findUser(@RequestParam Long id) {
       return ResponseEntity.ok(userMapper.toRepresenation(userService.findUsers(id)));
    }

    @PostMapping("/saveUser")
    @Operation(summary = "Salvar Usuário", description = "Salvar Usuário")
    @ApiResponse(responseCode = "201", description = "Usuário Criado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Void> saveUser(@RequestBody UserRepresentation userRepresentation) {
        userService.saveUser(userMapper.toDomain(userRepresentation));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
