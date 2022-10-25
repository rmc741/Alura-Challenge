package com.alura.challenge.resource;

import com.alura.challenge.entity.Video;
import com.alura.challenge.exception.ObjectNotFoundException;
import com.alura.challenge.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "videos")
public class VideoResource {

    private VideoService videoService;

    public VideoResource(VideoService videoService) {
        this.videoService = videoService;
    }


    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos(){
        List<Video> videoList = videoService.getAllVideos();

        return ResponseEntity.ok().body(videoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id){
        Video video = videoService.getVideoById(id);
        return ResponseEntity.ok().body(video);
    }

    @PostMapping("add")
    public ResponseEntity<Video> creatVideo(@RequestBody Video video){
        Video postvideo = videoService.saveVideo(video);

        return ResponseEntity.ok().body(postvideo);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Video> editVideo(@RequestBody Video video,@PathVariable Long id){
        Video videoEdit = videoService.editVideo(video, id);

        return ResponseEntity.ok().body(videoEdit);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id){
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }

}
