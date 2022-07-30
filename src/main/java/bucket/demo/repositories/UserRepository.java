package bucket.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bucket.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
