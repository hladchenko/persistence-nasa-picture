package com.hladchenko.nasapicturestealer.repository;

import com.hladchenko.nasapicturestealer.entity.Camera;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CameraRepository extends CrudRepository<Camera, Integer> {

  Optional<Camera> findCameraByNasaId(Integer integer);
}
