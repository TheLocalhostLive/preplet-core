package live.thelocalhost.preplet_backend_v2.repository;

import live.thelocalhost.preplet_backend_v2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
