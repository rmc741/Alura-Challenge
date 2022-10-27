package com.alura.challenge.resource;

import com.alura.challenge.entity.Video;
import com.alura.challenge.exception.ObjectNotFoundException;
import com.alura.challenge.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

        return new ResponseEntity<List<Video>>(videoList , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id){
        Video video = videoService.getVideoById(id);
        return new ResponseEntity<Video>(video , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Video> creatVideo(@RequestBody @Valid Video video){
        Video postvideo = videoService.saveVideo(video);

        return new ResponseEntity<Video>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Video> editVideo(@RequestBody @Valid Video video, @PathVariable Long id){
        Video videoEdit = videoService.editVideo(video, id);

        return new ResponseEntity<Video>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id){
        videoService.deleteVideo(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
