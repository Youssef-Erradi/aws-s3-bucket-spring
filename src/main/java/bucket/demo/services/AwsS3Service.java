package bucket.demo.services;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AwsS3Service implements FileService{
	private AmazonS3Client s3Client;
	
	@Value("${s3.bucket.name}")
	private String bucketName;
	
	@Override
	public String upload(MultipartFile file) {
		String filename = UUID.randomUUID().toString() + "." +StringUtils.getFilenameExtension(file.getOriginalFilename());
		ObjectMetadata metaData = new ObjectMetadata();
		metaData.setContentLength(file.getSize());
		metaData.setContentType(file.getContentType());
		
		try {
			s3Client.putObject(bucketName, filename, file.getInputStream(), metaData);
		} catch (SdkClientException | IOException e) {
			e.printStackTrace();
		}
		
		return s3Client.getResourceUrl(bucketName, filename);
	}

}
