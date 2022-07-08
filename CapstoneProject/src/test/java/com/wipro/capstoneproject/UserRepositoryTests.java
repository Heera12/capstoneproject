package com.wipro.capstoneproject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.wipro.capstoneproject.entity.User;
import com.wipro.capstoneproject.repository.IUserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTests {

	@Autowired
	private IUserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUname("heera12");
		user.setFname("Nazeem");
		user.setUname("Heera");
		user.setEmail("nazeemshaik.12@gmail.com");
		user.setPassword("heera1212");
		User savedUser= repo.save(user);
		
		User existingUser = entityManager.find(User.class, savedUser.getUid());
		assertThat(existingUser.getEmail()).isEqualTo(user.getEmail());
		
	}
}
