package com.hladchenko.nasapicturestealer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hladchenko.nasapicturestealer.entity.Picture;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PhotoDto implements Serializable {

  private int id;
  private int sol;
  @JsonProperty("img_src")
  private String imgSrc;
  private CameraDto camera;

  public Picture toEntity(int cameraId) {
    Picture picture = new Picture();
    picture.setCameraId(cameraId);
    picture.setNasaId(id);
    picture.setImgSrc(imgSrc);
    picture.setCreatedAt(Date.valueOf(LocalDate.now()));
    picture.setSol(sol);
    return picture;
  }
}
