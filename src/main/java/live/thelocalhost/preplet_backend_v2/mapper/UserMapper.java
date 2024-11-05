package live.thelocalhost.preplet_backend_v2.mapper;

import live.thelocalhost.preplet_backend_v2.dto.UserDto;
import live.thelocalhost.preplet_backend_v2.entity.User;

public class UserMapper {
    public static UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getFirstName(),
                user.getEmail(),
                user.getRole()
        );
    }
    public static User fromDto(UserDto userDto){
        return new User(
            userDto.getId(),
            userDto.getFirstName(),
            userDto.getLastName(),
                userDto.getEmail(),
                userDto.getRole()
        );
    }
}
