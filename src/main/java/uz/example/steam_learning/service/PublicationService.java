package uz.example.steam_learning.service;

import uz.example.steam_learning.model.User;
import uz.example.steam_learning.payload.PublicationRequest;
import uz.example.steam_learning.payload.PublicationResponse;

import java.util.List;

public interface PublicationService {
    PublicationResponse createPublication(PublicationRequest request, User user);
    List<PublicationResponse> getUserPublications(User user);
    PublicationResponse getPublicationById(Long id, User user);
    PublicationResponse updatePublication(Long id, PublicationRequest request, User user);
    void deletePublication(Long id, User user);

}
