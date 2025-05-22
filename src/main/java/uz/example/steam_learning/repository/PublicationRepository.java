package uz.example.steam_learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.steam_learning.model.Publication;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByAuthorId(Long authorId);
}
