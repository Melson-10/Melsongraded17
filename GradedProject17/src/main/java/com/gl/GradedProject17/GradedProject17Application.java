package com.gl.GradedProject17;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.GradedProject17.Model.AppService;
import com.gl.GradedProject17.Model.AppUser;


@SpringBootApplication
public class GradedProject17Application implements CommandLineRunner{
	@Autowired
	AppService service;
	public static void main(String[] args) {
		SpringApplication.run(GradedProject17Application .class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Set<String> authadmin=new HashSet<>();
		authadmin.add("admin");
		
		Set<String> authUser=new HashSet<>();
		authUser.add("user");
		
		PasswordEncoder e1= new BCryptPasswordEncoder();
		
		AppUser appAdmin= new AppUser(1,"admin","admin",e1.encode("adminpass"),authadmin);
		service.add(appAdmin);
		AppUser appUser= new AppUser(2,"user","user",e1.encode("userpass"),authUser);
		service.add(appUser);
		
	}
	
	
	
}
