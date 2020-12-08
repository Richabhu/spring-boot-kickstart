package springdemo.topic_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicListController {

    TopicService topicService;

    TopicListController(){}
    @Autowired
    TopicListController(TopicService service)
    {
        topicService = service;
    }

    @RequestMapping("/topics")
    public List<Topic> allTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("topics/{id}")
    public Topic getIndTopic(@PathVariable String id)
    {
        return topicService.getIndividualList(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTopic(@RequestBody Topic top)
    {
        topicService.addTopic(top);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic top, @PathVariable String id)
    {
        topicService.updateTopic(top,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
    public void updateTopic(@PathVariable String id)
    {
        topicService.deleteTopic(id);
    }

}
