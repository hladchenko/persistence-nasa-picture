package com.hladchenko.nasapicturestealer.controller;

import com.hladchenko.nasapicturestealer.dto.NasaDto;
import com.hladchenko.nasapicturestealer.dto.PhotosDto;
import com.hladchenko.nasapicturestealer.entity.Picture;
import com.hladchenko.nasapicturestealer.service.PictureService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/pictures")
@RestController
public class NasaController {

  private final PictureService pictureService;
  @Value("${url}")
  private String url;
  @Value("${key}")
  private String key;

  public NasaController(PictureService pictureService) {
    this.pictureService = pictureService;
  }

  @PostMapping("/steal")
  public Iterable<Picture> steal(@RequestBody NasaDto nasaDto) {
    URI nasaUri = UriComponentsBuilder
        .fromHttpUrl(url)
        .queryParam("sol", nasaDto.getSol())
        .queryParam("api_key", key)
        .build().toUri();
    RestTemplate restTemplate = new RestTemplate();
    PhotosDto photosDto = restTemplate.getForObject(nasaUri, PhotosDto.class);
    if (photosDto != null) {
      return pictureService.savePhotos(photosDto.getPhotos());
    }
    return null;
  }
}
