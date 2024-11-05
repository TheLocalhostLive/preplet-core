package live.thelocalhost.preplet_backend_v2.service;

import live.thelocalhost.preplet_backend_v2.dto.UserDto;
import live.thelocalhost.preplet_backend_v2.entity.User;
import live.thelocalhost.preplet_backend_v2.mapper.UserMapper;
import live.thelocalhost.preplet_backend_v2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    public UserDto create(UserDto userDto){
        User user = UserMapper.fromDto(userDto);
        User savedUser =userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }
}
