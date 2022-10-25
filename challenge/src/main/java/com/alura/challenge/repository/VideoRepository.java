package com.alura.challenge.repository;

import com.alura.challenge.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video , Long> {

    Optional<Video> findVideoById(Long id);
}
