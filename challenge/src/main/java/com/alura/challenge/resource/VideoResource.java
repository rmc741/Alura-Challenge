package com.alura.challenge.resource;

import com.alura.challenge.dto.VideoDTO;
import com.alura.challenge.entity.Video;
import com.alura.challenge.exception.ObjectNotFoundException;
import com.alura.challenge.exception.apiError.ApiError;
import com.alura.challenge.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "videos")
public class VideoResource {

    private VideoService videoService;

    public VideoResource(VideoService videoService) {
        this.videoService = videoService;
    }


    @GetMapping
    public ResponseEntity<List<VideoDTO>> getAllVideos(){
        List<VideoDTO> videoList = videoService.getAllVideos().stream().map(obj -> new VideoDTO(obj)).collect(Collectors.toList());

        return new ResponseEntity<List<VideoDTO>>(videoList , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VideoDTO> getVideoById(@PathVariable Long id){
        VideoDTO video = new VideoDTO(videoService.getVideoById(id));
        return new ResponseEntity<VideoDTO>(video , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VideoDTO> creatVideo(@RequestBody @Valid VideoDTO videoDTO){
        Video postvideo = videoService.saveVideo(videoDTO);

        return new ResponseEntity<VideoDTO>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<VideoDTO> editVideo(@RequestBody @Valid VideoDTO video, @PathVariable Long id){
        Video videoEdit = videoService.editVideo(video, id);

        return new ResponseEntity<VideoDTO>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id){
        videoService.deleteVideo(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
