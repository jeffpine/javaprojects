package br.com.jeffpine.forumhub.service;

import br.com.jeffpine.forumhub.dto.TopicRequest;
import br.com.jeffpine.forumhub.model.Course;
import br.com.jeffpine.forumhub.model.Topic;
import br.com.jeffpine.forumhub.model.User;
import br.com.jeffpine.forumhub.repository.CourseRepository;
import br.com.jeffpine.forumhub.repository.TopicRepository;
import br.com.jeffpine.forumhub.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public TopicService(TopicRepository topicRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    public void createTopic(TopicRequest topicRequest) {
        Topic topic = new Topic();
        topic.setTitle(topicRequest.getTitle());
        topic.setMessage(topicRequest.getMessage());
        topic.setCreatedAt(LocalDateTime.now());

        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        topic.setAuthor(user);

        Course course = courseRepository.findByName(topicRequest.getCourse()).orElseThrow(() -> new RuntimeException("Course not found"));
        topic.setCourse(course);

        topicRepository.save(topic);
    }

    public void updateTopic(Long id, TopicRequest topicRequest) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));

        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (!topic.getAuthor().getUsername().equals(username)) {
            throw new RuntimeException("You can only update your own topics");
        }

        topic.setTitle(topicRequest.getTitle());
        topic.setMessage(topicRequest.getMessage());
        topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));

        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (!topic.getAuthor().getUsername().equals(username)) {
            throw new RuntimeException("You can only delete your own topics");
        }

        topicRepository.delete(topic);
    }
}