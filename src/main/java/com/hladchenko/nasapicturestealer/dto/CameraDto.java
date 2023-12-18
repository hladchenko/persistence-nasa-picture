package com.hladchenko.nasapicturestealer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hladchenko.nasapicturestealer.entity.Camera;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import lombok.Data;

@Data
public class CameraDto implements Serializable {

  private int id;
  private String name;
  @JsonProperty("rover_id")
  private int roverId;
  @JsonProperty("full_name")
  private String fullName;

  public Camera toEntity() {
    Camera camera = new Camera();
    camera.setName(name);
    camera.setNasaId(id);
    camera.setCreatedAt(Date.valueOf(LocalDate.now()));
    return camera;
  }
}
