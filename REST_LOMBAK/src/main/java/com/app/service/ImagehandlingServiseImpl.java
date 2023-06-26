package com.app.service;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class ImagehandlingServiseImpl implements ImageHandlingService {
	
	@Autowired
	private EmployeeRepository empRepo;
	//how to access the property from aplication property file;SpEL:Spring Expression language
	
	@Value("${upload.location}")
	private String uploadFolder;
	
	//Add custom init method to check if folder exists,
	//if not create a new one!
	
	@PostConstruct
	public void myinit()
	{
		System.out.println("in init"+uploadFolder);
		
		File dir=new File(uploadFolder);
		if(dir.exists())
			System.out.println("folder already Exist!!!");
		else {
			dir.mkdirs(); //creating read file
			System.out.println("Created new folder");
		}
	}

	@Override
	public ApiResponse uploadImageToFolder(Long empId, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
