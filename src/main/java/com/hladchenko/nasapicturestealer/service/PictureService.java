package com.hladchenko.nasapicturestealer.service;

import com.hladchenko.nasapicturestealer.dto.CameraDto;
import com.hladchenko.nasapicturestealer.dto.PhotoDto;
import com.hladchenko.nasapicturestealer.entity.Camera;
import com.hladchenko.nasapicturestealer.entity.Picture;
import com.hladchenko.nasapicturestealer.repository.CameraRepository;
import com.hladchenko.nasapicturestealer.repository.PictureRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

  private final CameraRepository cameraRepository;
  private final PictureRepository pictureRepository;

  public PictureService(CameraRepository cameraRepository, PictureRepository pictureRepository) {
    this.cameraRepository = cameraRepository;
    this.pictureRepository = pictureRepository;
  }

  public Iterable<Picture> savePhotos(PhotoDto[] photos) {
    for (PhotoDto photo : photos) {
      CameraDto cameraDto = photo.getCamera();
      if (cameraDto != null) {
        Camera camera = cameraRepository.findCameraByNasaId(cameraDto.getId())
            .orElseGet(() -> cameraRepository.save(cameraDto.toEntity()));
        Optional<Picture> pictureByNasaId = pictureRepository.findPictureByNasaId(photo.getId());
        if (pictureByNasaId.isEmpty()) {
          pictureRepository.save(photo.toEntity(camera.getId()));
        }
      }
    }
    return pictureRepository.findAll();
  }
}
