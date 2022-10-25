package com.alura.challenge.service;

import com.alura.challenge.entity.Video;
import com.alura.challenge.exception.ObjectNotFoundException;
import com.alura.challenge.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private VideoRepository videoRepository;

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

    public Video saveVideo(Video video){
        Video videoSave = videoRepository.save(video);

        return videoSave;
    }

    public void deleteVideo(Long id){
        Video video = getVideoById(id);
        videoRepository.delete(video);

    }

    public Video editVideo(Video video, Long id){
        Video videoEdit = getVideoById(id);

        videoEdit.setTitle(video.getTitle());
        videoEdit.setDescription(video.getDescription());
        videoEdit.setUrl(video.getUrl());

        return videoRepository.save(videoEdit);
    }
}
