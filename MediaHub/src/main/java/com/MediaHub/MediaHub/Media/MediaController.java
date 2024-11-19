package com.MediaHub.MediaHub.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    @GetMapping("/{id}")
    public Media getMediaById(@PathVariable Long id) {
        return mediaService.getMediaById(id);
    }

    @PostMapping
    public Media createMedia(@RequestBody Media media) {
        return mediaService.createMedia(media);
    }

    @PutMapping("/{id}")
    public Media updateMedia(@PathVariable Long id, @RequestBody Media media) {
        return mediaService.updateMedia(id, media);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.ok("Media deleted successfully!");
    }
}
