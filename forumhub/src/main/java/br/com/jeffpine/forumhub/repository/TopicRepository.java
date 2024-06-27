package br.com.jeffpine.forumhub.repository;

import br.com.jeffpine.forumhub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
