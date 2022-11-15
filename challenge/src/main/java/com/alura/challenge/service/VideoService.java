package com.alura.challenge.service;

import com.alura.challenge.dto.VideoDTO;
import com.alura.challenge.entity.Video;
import com.alura.challenge.exception.ObjectNotFoundException;
import com.alura.challenge.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    public Video getVideoById(Long id){
        Optional<Video> videoOpt = videoRepository.findById(id);

        return videoOpt.orElseThrow(() -> new ObjectNotFoundException("Video não encontrado pelo id:" + id));
    }

    public List<Video> getVideoByTitle(String title){
        return videoRepository.findByTitleContaining(title);
    }

    public Video saveVideo(VideoDTO videoDTO){
        return videoRepository.save(new Video(videoDTO.getTitle(), videoDTO.getDescription() , videoDTO.getUrl()));
    }

    public void deleteVideo(Long id){
        Video video = getVideoById(id);
        videoRepository.delete(video);

    }

    public Video editVideo(VideoDTO videoDTO, Long id){
        Video videoEdit = getVideoById(id);

        videoEdit.setTitle(videoDTO.getTitle());
        videoEdit.setDescription(videoDTO.getDescription());
        videoEdit.setUrl(videoDTO.getUrl());

        return videoRepository.save(videoEdit);
    }
}
