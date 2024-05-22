package auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
