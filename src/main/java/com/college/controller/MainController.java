package com.college.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.entities.Student;
import com.college.entities.StudentData;
import com.college.entities.Teacher;
import com.college.entities.Test;
import com.college.repository.AdminRepo;
import com.college.repository.DataRepo;
import com.college.repository.TeacherRepo;
import com.college.repository.TestRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	AdminRepo ar;
//	@Autowired
//	StudentRepo sr;
	@Autowired
	TeacherRepo tr;
	@Autowired
	TestRepo tstr;
	
	@Autowired
	DataRepo dr;
	
	
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/results")
	public String results() {
		return "rollno";
	}
	
	@GetMapping(value="/lecturerlogin")
	public String lecturerlogin(Model model,HttpSession session) {
		if(session.getAttribute("user")!=null)
		{
			model.addAttribute("Teacher",session.getAttribute("user"));
			return "lecturerdashboard";
		}
		return "lecturerlogin";
	}
	
	@GetMapping(value="/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}
	
	@GetMapping(value="/details")
	public String faculty() {
		return "faculty";
	}
	
	@GetMapping(value="/contact")
	public String contact() {
		return "contactus";
	}
	
//	
   @PostMapping(value="/lecturerloginverify")
	public String lecturerloginverify(Model model,@RequestParam("email")String email,@RequestParam("password")String password,HttpSession session) {
		if(session.getAttribute("user")!=null)
		{
			model.addAttribute("Teacher",session.getAttribute("user"));
			return "lecturerdashboard";
		}
			
	   Teacher t = tr.findByEmail(email);
	   
	   if(t==null) {
		   model.addAttribute("msg","USER WITH ABOVE MAIL ADDRESS DOES NOT EXIST");
		   return "lecturerlogin";
	   }
	   System.out.println(password+" "+t.getPassword());
	   if(t.getPassword().equals(password))
	   {
		
		   session.setAttribute("user", t);
			model.addAttribute("Teacher",session.getAttribute("user"));
		   return "lecturerdashboard";
	   }
	   if(t.getPassword()!=password)
	   {
		   model.addAttribute("msg","WRONG PASSWORD");
			 return "lecturerlogin";
	   }
	   
	   return "lecturerlogin";
	}
   
   
   @GetMapping(value="/lecturerloginverify")
	public String lecturerloginverify2(Model model,HttpSession session) {
		if(session.getAttribute("user")!=null)
		{
			model.addAttribute("Teacher",session.getAttribute("user"));
			model.addAttribute("msg","ONLY ADMIN USER CAN ADD STUDENTS");
			return "lecturerdashboard";
		}
			
//	   Teacher t = tr.findByEmail(email);
//	   
//	   if(t==null) {
//		   model.addAttribute("msg","USER WITH ABOVE MAIL ADDRESS DOES NOT EXIST");
//		   return "lecturerlogin";
//	   }
//	   System.out.println(password+" "+t.getPassword());
//	   if(t.getPassword().equals(password))
//	   {
//		   System.out.println("EROORRRR");
//		   session.setAttribute("user", t);
//			model.addAttribute("Teacher",session.getAttribute("user"));
//		   return "lecturerdashboard";
//	   }
//	   if(t.getPassword()!=password)
//	   {
//		   model.addAttribute("msg","WRONG PASSWORD");
//			 return "lecturerlogin";
//	   }
	   
	   return "lecturerlogin";
	}

   
  
   
   
//   @GetMapping(value="/add")
//   public String add() {
//	   Teacher t = new Teacher("ecnomics TEACHER","eco@gmail.com","123","ECONOMICS");
//	   try {
//		   tr.save(t);
//	   }
//	   catch(Exception e) {
//		 e.printStackTrace();
//	   }
//	   
//	   return "index";
//   }
   
   
  @PostMapping(value="/fetchresult")
   public String fetchresults(@RequestParam("rollno")String rollno,Model model) {
	   StudentData st = dr.findByrollno(rollno);
	   model.addAttribute("st",st);
//	   
//	  Set<String> subject = st.getTest1().keySet();
//	  ArrayList<String> subjects = new ArrayList<>();
//	   
//	   for(String st1 : subject) {
//		  subjects.add(st1);
//	   }
//	   
//	Collections.sort(subjects);
//	
//	
//	ArrayList<String> test1 = new ArrayList<>();
//	ArrayList<String> test2 = new ArrayList<>();
//	ArrayList<String> exam1 = new ArrayList<>();
//	ArrayList<String> exam2 = new ArrayList<>();
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	model.addAttribute("subjects",subjects);
//	
//	  
//	   
//	   return"index";
//	   
//   }
//   
//   public static ArrayList<String> helper(Map<String,Integer> map, ArrayList<String> subjects){
//	   
//	   ArrayList<String> score = new ArrayList<>();
//	   
//	   for(String st1 : subjects) {
//			  try {
//				  if(map.get(score) == null) {
//					  map.
//				  }
//					  
//					
//				 score.add(map.get(st1)+"");
//			  }
//			  catch(Exception e)
//			  {
//				  System.out.println("NO KEY");
//			  }
//		   }
//	   
//	   
//	   
   return "results";
//   }
  }
   
  @GetMapping(value="/kumar/add")
  public String teacher() {
	  return "teacher";
  }
  
   @PostMapping(value="/teacherintodb")
   public String saveteacher(@ModelAttribute Teacher t) {
	   tr.save(t);
	   return"index";
   }
}
