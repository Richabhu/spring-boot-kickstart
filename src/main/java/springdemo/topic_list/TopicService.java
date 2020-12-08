package springdemo.topic_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private TopicRepository topicRepository;


    TopicService() {
    }

    @Autowired
    public TopicService(TopicRepository repository)
    {
        topicRepository = repository;
    }
    /*
    private List<Course> topicsPresent =new ArrayList<>( Arrays.asList(
            new Course("1","dcfvgbhn","efrgbhnj"),
            new Course("2","dwefrgthy","3rtgyuj")
    ));
    */

    public List<Topic> getAllTopics(){
       // return topicsPresent;
        List<Topic> allTopic = new ArrayList<>();
        topicRepository.findAll().forEach(allTopic::add);
        return allTopic;
    }

    public Topic getIndividualList(String ids){

            System.out.println(ids);

            //return  topicsPresent.stream().filter(t->t.getId().equals(ids)).findFirst().get();
           // return topicRepository.findById(ids);

         //   return topicsPresent.get(ids);
        return getAllTopics().get(Integer.parseInt((ids)));

    }


    public void addTopic(Topic top) {
        //topicsPresent.add(top);
        topicRepository.save(top);
    }

    public void updateTopic(Topic top, String id) {
        /*for (int i=0;i<topicsPresent.size();i++){
            Course indTop = topicsPresent.get(i);
            if (id.equals(indTop.getId())){
                topicsPresent.set(i,top);
                return;

            }

        }*/
        topicRepository.save(top);
    }

    public void deleteTopic(String id) {
        //topicsPresent.removeIf(t->t.getId().equals(id));
        topicRepository.delete(getAllTopics().get(Integer.parseInt((id))));
    }
}
