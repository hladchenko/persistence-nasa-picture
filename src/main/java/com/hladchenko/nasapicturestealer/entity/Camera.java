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
@Table(name = "cameras")
public class Camera implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @Column(name = "nasa_id")
  private int nasaId;
  private String name;
  @Column(name = "created_at")
  private Date createdAt;
}
