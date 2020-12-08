package springdemo.course.topic_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;


    CourseService() {
    }

    @Autowired
    public CourseService(CourseRepository repository)
    {
        courseRepository = repository;
    }
    /*
    private List<Course> topicsPresent =new ArrayList<>( Arrays.asList(
            new Course("1","dcfvgbhn","efrgbhnj"),
            new Course("2","dwefrgthy","3rtgyuj")
    ));
    */

    public List<Course> getAllCourse(){
       // return topicsPresent;
        List<Course> allTopic = new ArrayList<>();
        courseRepository.findAll().forEach(allTopic::add);
        return allTopic;
    }

    public Course getIndividualCourse(String ids){

            System.out.println(ids);

            //return  topicsPresent.stream().filter(t->t.getId().equals(ids)).findFirst().get();
           // return topicRepository.findById(ids);

         //   return topicsPresent.get(ids);
        return getAllCourse().get(Integer.parseInt((ids)));

    }


    public void addCourse(Course top) {
        //topicsPresen
        // t.add(top);
        courseRepository.save(top);
    }

    public void updateCourse(Course course) {
        /*for (int i=0;i<topicsPresent.size();i++){
            Course indTop = topicsPresent.get(i);
            if (id.equals(indTop.getId())){
                topicsPresent.set(i,top);
                return;

            }

        }*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //topicsPresent.removeIf(t->t.getId().equals(id));
        courseRepository.delete(getAllCourse().get(Integer.parseInt((id))));
    }
}
