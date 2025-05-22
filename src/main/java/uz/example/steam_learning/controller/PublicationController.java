package uz.example.steam_learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.example.steam_learning.model.User;
import uz.example.steam_learning.payload.PublicationRequest;
import uz.example.steam_learning.payload.PublicationResponse;
import uz.example.steam_learning.security.CurrentUser;
import uz.example.steam_learning.service.PublicationService;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    // CREATE: Yangi publikatsiya qo'shish
    @PostMapping
    public ResponseEntity<PublicationResponse> createPublication(
            @RequestBody PublicationRequest request,
            @CurrentUser User currentUser) {
        PublicationResponse response = publicationService.createPublication(request, currentUser);
        return ResponseEntity.ok(response);
    }

    // READ: Foydalanuvchining barcha publikatsiyalarini olish
    @GetMapping
    public ResponseEntity<List<PublicationResponse>> getUserPublications(@CurrentUser User currentUser) {
        List<PublicationResponse> publications = publicationService.getUserPublications(currentUser);
        return ResponseEntity.ok(publications);
    }

    // READ: Bitta publikatsiyani olish (ID orqali)
    @GetMapping("/{id}")
    public ResponseEntity<PublicationResponse> getPublicationById(@PathVariable Long id,
                                                                  @CurrentUser User currentUser) {
        PublicationResponse response = publicationService.getPublicationById(id, currentUser);
        return ResponseEntity.ok(response);
    }

    // UPDATE: Publikatsiyani yangilash
    @PutMapping("/{id}")
    public ResponseEntity<PublicationResponse> updatePublication(@PathVariable Long id,
                                                                 @RequestBody PublicationRequest request,
                                                                 @CurrentUser User currentUser) {
        PublicationResponse response = publicationService.updatePublication(id, request, currentUser);
        return ResponseEntity.ok(response);
    }

    // DELETE: Publikatsiyani o'chirish
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublication(@PathVariable Long id,
                                               @CurrentUser User currentUser) {
        publicationService.deletePublication(id, currentUser);
        return ResponseEntity.ok().build();
    }
}
