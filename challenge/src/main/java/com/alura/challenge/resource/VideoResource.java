package com.alura.challenge.resource;

import com.alura.challenge.entity.Video;
import com.alura.challenge.exception.ObjectNotFoundException;
import com.alura.challenge.repository.VideoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "videos")
public class VideoResource {

    private VideoRepository videoRepository;

    public VideoResource(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos(){
        List<Video> videoList = videoRepository.findAll();

        return ResponseEntity.ok().body(videoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id){
        Video video = searchVideoById(id);
        return ResponseEntity.ok().body(video);
    }

    @PostMapping("add")
    public ResponseEntity<Video> creatVideo(@RequestBody Video video){
        Video postvideo = videoRepository.save(video);

        return ResponseEntity.ok().body(postvideo);
    }


    public Video searchVideoById(Long id){
        Optional<Video> video =  videoRepository.findById(id);
        return video.orElseThrow(() -> new ObjectNotFoundException("Video não encontrado"));
    }
}
