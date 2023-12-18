package com.hladchenko.nasapicturestealer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "pictures")
public class Picture implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private int sol;
  @Column(name = "nasa_id")
  private int nasaId;
  @Column(name = "img_src")
  private String imgSrc;
  @Column(name = "camera_id")
  private int cameraId;
  @Column(name = "created_at")
  private Date createdAt;
}
