package bucket.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import bucket.demo.dtos.UserDTO;
import bucket.demo.entities.User;
import bucket.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private UserRepository repository;
	private AwsS3Service s3Service;
	
	public User save(UserDTO userDto) {
		String imageUrl = s3Service.upload(userDto.image());
		User user = new User(null, userDto.fullName(), imageUrl);
		return repository.save(user);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

}
