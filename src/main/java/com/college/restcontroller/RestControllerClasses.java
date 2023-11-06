package com.college.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.college.controller.LecturerController;
import com.college.controller.MainController;
import com.college.email.EmailSender;
import com.college.entities.Teacher;
import com.college.repository.TeacherRepo;
import com.twilio.http.Response;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class RestControllerClasses {

	@Autowired
	EmailSender e;

	@Autowired
	TeacherRepo tr;


	@PostMapping("/sendotp")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> sendotp(@RequestParam("email") String email,HttpSession session) {
		try {

			SecureRandom secureRandom = new SecureRandom();

			int min = 100000; // Minimum six-digit number
			int max = 999999; // Maximum six-digit number
			System.out.println("Working");
			if(tr.findByEmail(email)==null)
			{
				System.out.println("ERORR");
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("User not found");

			}

			int randomSixDigitNumber = secureRandom.nextInt(max - min + 1) + min;
			e.sendEmail(email,"OTP BY GJCM", "YOUR OTP IS "+randomSixDigitNumber);
			session.setAttribute("otp",randomSixDigitNumber);
			return ResponseEntity.status(HttpStatus.OK).body("OTP sent successfully");

		} catch (Exception e) {
			System.out.println("Error IN OTP");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}
		 
		
	}
}
