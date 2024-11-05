package live.thelocalhost.preplet_backend_v2.controller;


import live.thelocalhost.preplet_backend_v2.dto.UserDto;
import live.thelocalhost.preplet_backend_v2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserManager {

    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
        UserDto savedUser = userService.create(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
