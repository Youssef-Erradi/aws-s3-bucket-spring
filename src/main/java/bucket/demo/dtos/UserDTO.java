package bucket.demo.dtos;

import org.springframework.web.multipart.MultipartFile;

public record UserDTO(String fullName, MultipartFile image) {

}
