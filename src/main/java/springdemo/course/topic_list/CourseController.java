package springdemo.course.topic_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springdemo.topic_list.Topic;

import java.util.List;

@RestController
public class CourseController {

    CourseService courseService;

    CourseController(){}
    @Autowired
    CourseController(CourseService service)
    {
        courseService = service;
    }

    @RequestMapping("/topics/{id}/course")
    public List<Course> allCourse(@PathVariable String id){
        return courseService.getAllCourse();
    }

    @RequestMapping("topics/{topicId}/course/{courseId}")
    public Course getIndividualCourse(@PathVariable String courseId)
    {
        return courseService.getIndividualCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/course")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId , "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "topics/{topicId}/course/{courseId}")
    public void updateCourses(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId)
    {
        course.setTopic(new Topic(topicId , "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "topics/{topicId}/course/{courseId}}")
    public void deleteCourses(@PathVariable String courseId)
    {
        courseService.deleteCourse(courseId);
    }

}
