package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import com.homedecor.rest.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUserId(Long userId);
	Optional<User> findByEmail(String email);
	//Optional<User> findByUserNameOrEmail(String username, String email);
	Optional<User> findByUserName(String username);
	public boolean existsByUserName(String username);
	public boolean existsByEmail(String email);
    User findByUserNameOrEmail(String userName, String email);

    List<User> findByRole(Role role);
}
