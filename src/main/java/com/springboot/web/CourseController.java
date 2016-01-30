package com.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.domain.Course;
import com.springboot.domain.Lesson;
import com.springboot.domain.Section;
import com.springboot.repository.CourseRepository;
import com.springboot.repository.SectionRepository;

/** This controller is used to perform Basic CURD operations..
 * @author RAJASHEKHAR
 *
 */
@Controller
public class CourseController {

	private CourseRepository courseRepo;
	
	private SectionRepository sectionRepo;
	

	@Autowired
	public void setCourseRepo(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	@Autowired
	public void setSectionRepo(SectionRepository sectionRepo) {
		this.sectionRepo = sectionRepo;
	}



	@RequestMapping("")
	public String root(){
		return "redirect:/courses";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "courses",method=RequestMethod.GET)
	public String getAllCourses(ModelMap model) {
		
		//getting all courses from CourseRepository Interface.
		List<Course> courses = courseRepo.findAll();
		model.put("courseList", courses);
		
        Course course = new Course();
		model.put("course", course);
		
		
		return "courses"; // returns a view, it adds the prefix and suffix by
						// @SpringBootApplication
	}
	
	@RequestMapping(value = "courses", method=RequestMethod.POST)
	public String saveCourse(@ModelAttribute Course course){
		courseRepo.save(course);
		return "redirect:/"; // it redirects to root directory.
	}
	

	
	/*When this method executes, we are creating new Course object and adding to model object. 
	 * So we can use it in the View. That is in the createCourse.html page.
    */	
	/**
	 * @param model
	 * @return
	 */
//	@RequestMapping( value = "createCourse", method=RequestMethod.GET)
//	public String createCourse(ModelMap model){
//		 Course course = new Course();
//		 
//		 model.put("course", course);
//		
//		
//		return "createCourse";
//	}
//	
	
	
	/**
	 * @param courseId
	 * @param model
	 * @return
	 */
	@RequestMapping(value= "courses/edit/{courseId}", method = RequestMethod.GET)
	public String editCourse(@PathVariable Long courseId, ModelMap model){
		
		Course course = courseRepo.findOne(courseId);
		
		if(course == null){
			return "redirect:/";
		}
		if(null!=course){
			System.out.println("Course is Found...."+course.getCourseName());
		}
		model.put("course", course);
		model.put("sections",course.getSections());
		
		   
		return "editCourse";
		
	}
	
	@RequestMapping(value= "courses/edit/createSection", method = RequestMethod.POST)
	public @ResponseBody Course createSection(@RequestParam Long courseId,@RequestParam  String sectionName,ModelMap model){
		
		Course course = courseRepo.findOne(courseId);
		
		Section section = new Section();
		section.setSectionName(sectionName);
		section.setCourse(course);
		course.getSections().add(section);
		Course savedCourse = courseRepo.save(course);
		   
		return savedCourse;
		
	}
	
	@RequestMapping(value= "courses/edit/createLesson", method = RequestMethod.POST)
	public @ResponseBody Course createLesson(@RequestParam Long courseId,@RequestParam  Long sectionId,
			                                                 @RequestParam  Integer lessonNumber,@RequestParam  String lessonName, ModelMap model){
		Course course = courseRepo.findOne(courseId);
		
		for(Section section : course.getSections()){
			if(section.getSectionId().equals(sectionId)){
				Lesson lesson = new Lesson();
				lesson.setLessonNumber(lessonNumber);
				lesson.setLessonName(lessonName);
				lesson.setSection(section);
				section.getLessons().add(lesson);
				sectionRepo.save(section);
				break;
			}
		}
		 
		
		   
		return course;
		
	}
	
	/**
	 * @param courseId
	 * @param lesson
	 * @return
	 */
	/*@RequestMapping(value = "courses/edit/{courseId}", method=RequestMethod.POST)
	public String saveLesson(@PathVariable Long courseId,@ModelAttribute Lesson lesson){
		// steps for bi directional mapping save operation
		Course course = courseRepo.findOne(courseId); // Load parent object and then Child object
		lesson.setCourse(course);// set the parent object in child
		course.getLessons().add(lesson); //Create a collection of child objects and then Set the collection of child objects on the parent
		courseRepo.save(course); //Save the parent
       
		return "redirect:/courses/edit/" +courseId; // 
	}*/

}
