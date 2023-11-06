package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.entities.Student;
import com.college.entities.StudentData;
import com.college.entities.Teacher;
import com.college.repository.DataRepo;
import com.college.repository.TeacherRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class LecturerController {
	
	@Autowired
	DataRepo dr;
	TeacherRepo tr;
	
	@GetMapping(value="/studentdetails")
	public String studentdetails(Model model) {
		
		 List<StudentData> st = dr.findAll();
		 
		 model.addAttribute("student",st);
	
		return "studentdetails";
	}
	
	@GetMapping(value="/addstudent")
	public String addstudent(Model model,HttpSession session) {
		Teacher t = (Teacher)session.getAttribute("user");
		if(t.getEmail().equals("ashabr1984@gmail.com"))
		return "addstudent";
		else
			return"redirect:lecturerloginverify";
	}
	
	@PostMapping(value="/addstudentintodb" ,consumes = "application/x-www-form-urlencoded")
	public String addstudent(@ModelAttribute StudentData st,Model model) {
		
		System.out.println(st.toString());
		dr.save(st);
model.addAttribute("msg","Added");
		return "addstudent";
	}
	
	  @PostMapping("/fetch-student-data")
	    public String fetchStudentData(String selectedClass, Model model,HttpSession session) {
	        List<StudentData> studentDataList = dr.findByCls(Integer.parseInt(selectedClass));
	        model.addAttribute("studentDataList", studentDataList);
	        model.addAttribute("selectedClass", selectedClass);
	    	model.addAttribute("user",(Teacher)session.getAttribute("user"));
	        return "studentdetails";
	    }
	  
	  
	  @PostMapping("/fetch-student-data2")
	    public String fetchStudentData2(String selectedClass, Model model,HttpSession session) {
	        List<StudentData> studentDataList = dr.findByCls(Integer.parseInt(selectedClass));
	        model.addAttribute("studentDataList", studentDataList);
	        model.addAttribute("selectedClass", selectedClass);
	    	model.addAttribute("user",(Teacher)session.getAttribute("user"));
	        return "addmarks";
	    }
	  
	  
	  @PostMapping("/addmarks")
	    public String addmarks(@RequestParam("testname")String testname,@RequestParam("rollno")String rollno,@RequestParam("marks")int marks,Model model,HttpSession session) {
	       
		 StudentData st = dr.findByrollno(rollno);
	String sub = ((Teacher) session.getAttribute("user")).getSubject();
		if("t1".equals(testname)) {
			
			st.getTest1().put(sub,marks);
			dr.save(st);
			
		}
		else if("t2".equals(testname)) {
			
			st.getTest2().put(sub,marks);
			dr.save(st);
			
		}
		else if("e1".equals(testname))
		{
			st.getExam1().put(sub,marks);
			dr.save(st);
		}
		else {
			st.getExam2().put(sub,marks);
			dr.save(st);
		}

	        return"redirect:studentdetails";
	      
	    }
	  
	  @GetMapping(value="/addmarkslink")
	  public String addmarkslink() {
		  return"addmarks";
	  }
	  
	  @GetMapping(value="/updatestudent")
	  public String update(Model model) {
		  model.addAttribute("students",dr.findAll());
		  return "updatestudent";
	  }
	  
	  @PostMapping(value="/updatedata")
	  public String update(@ModelAttribute StudentData st,Model model){
		  
		  StudentData s = dr.findByrollno(st.getRollno());
		  model.addAttribute("student",s);
		 
//		return "redirect:updatestudent";
		  return "updatehtml";
	  }
	  
	  @PostMapping(value="/updatedb")
	  public String updatedb(@ModelAttribute StudentData u,Model model){
		  StudentData s = dr.findById(u.getId()).get();
		  
		  System.out.println("HELOOOOOOOO"+u.getRollno());
		  if(u.getRollno().equals("0")) {
			  dr.deleteById(u.getId());
			  return  "redirect:updatestudent";
		  }
		  
		  
		  
		  s.setName(u.getName());
		  s.setCls(u.getCls());
		  s.setEmail(u.getEmail());
		  s.setStream(u.getStream());
		  System.out.println("The  dfghjhgf"+u.getStream());
		  dr.save(s);
		  model.addAttribute("student",s);
		 model.addAttribute("msg","Student Details Updated");
//		return "redirect:updatestudent";
		 return "redirect:updatestudent";
	  }
	  
	  @GetMapping(value="/resetpassword")
	public String resetpassword() {
		  return "resetpassword";
	  }
	  
	  @PostMapping(value="/verifyotp")
	  public String updatePwd(@RequestParam("otp")int otp, Model model, HttpSession session) {
		  Integer aotp = (int) session.getAttribute("otp");
		  if(aotp == null)
			  return "lecturerlogin";
		  
		  if(aotp==otp)
		  {
			  
			  return "updatepassword";
		  }
		  
		  model.addAttribute("msg","Wrong OTP Try Again");
		  
		return "resetpassword";
		  
	  }
	  
  @GetMapping(value="/logout")
  public String logout(HttpSession session) {
	  session.setAttribute("user", null);
	  return"index";
  }
	 
  @GetMapping(value="/error")
  public String error(HttpSession session) {
	  return"index";
  }
	  
}
