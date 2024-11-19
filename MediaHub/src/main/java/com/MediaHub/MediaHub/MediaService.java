package com.MediaHub.MediaHub;

import com.MediaHub.MediaHub.Media;
import com.MediaHub.MediaHub.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Media getMediaById(Long id) {
        return mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found with id: " + id));
    }

    public Media createMedia(Media media) {
        return mediaRepository.save(media);
    }

    public Media updateMedia(Long id, Media updatedMedia) {
        Media media = getMediaById(id);
        media.setTitle(updatedMedia.getTitle());
        media.setDescription(updatedMedia.getDescription());
        media.setCategory(updatedMedia.getCategory());
        return mediaRepository.save(media);
    }

    public void deleteMedia(Long id) {
        Media media = getMediaById(id);
        mediaRepository.delete(media);
    }
}
