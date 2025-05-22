package uz.example.steam_learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.example.steam_learning.model.Publication;
import uz.example.steam_learning.model.User;
import uz.example.steam_learning.payload.PublicationRequest;
import uz.example.steam_learning.payload.PublicationResponse;
import uz.example.steam_learning.repository.PublicationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public PublicationResponse createPublication(PublicationRequest request, User user) {
        Publication publication = new Publication();
        publication.setTitle(request.getTitle());
        publication.setJournal(request.getJournal());
        publication.setYear(request.getYear());
        publication.setUrl(request.getUrl());
        publication.setAuthor(user);

        Publication saved = publicationRepository.save(publication);
        return mapToResponse(saved);
    }

    @Override
    public List<PublicationResponse> getUserPublications(User user) {
        return publicationRepository.findByAuthorId(user.getId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public PublicationResponse getPublicationById(Long id, User user) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found"));
        if (!publication.getAuthor().getId().equals(user.getId())) {
            throw new RuntimeException("Access denied");
        }
        return mapToResponse(publication);
    }

    @Override
    public PublicationResponse updatePublication(Long id, PublicationRequest request, User user) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found"));

        if (!publication.getAuthor().getId().equals(user.getId())) {
            throw new RuntimeException("Access denied");
        }

        publication.setTitle(request.getTitle());
        publication.setJournal(request.getJournal());
        publication.setYear(request.getYear());
        publication.setUrl(request.getUrl());

        Publication updated = publicationRepository.save(publication);
        return mapToResponse(updated);
    }

    @Override
    public void deletePublication(Long id, User user) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found"));

        if (!publication.getAuthor().getId().equals(user.getId())) {
            throw new RuntimeException("Access denied");
        }

        publicationRepository.delete(publication);
    }

    private PublicationResponse mapToResponse(Publication publication) {
        return new PublicationResponse(
                publication.getId(),
                publication.getTitle(),
                publication.getJournal(),
                publication.getYear(),
                publication.getUrl(),
                publication.getAuthor().getName()
        );
    }
}
