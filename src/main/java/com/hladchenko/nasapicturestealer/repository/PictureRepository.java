package com.hladchenko.nasapicturestealer.repository;

import com.hladchenko.nasapicturestealer.entity.Picture;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PictureRepository extends CrudRepository<Picture, Integer> {

  Optional<Picture> findPictureByNasaId(Integer integer);
}
