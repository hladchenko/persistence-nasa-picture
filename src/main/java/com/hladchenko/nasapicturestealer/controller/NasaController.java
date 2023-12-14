package com.hladchenko.nasapicturestealer.controller;

import com.hladchenko.nasapicturestealer.dto.NasaDto;
import com.hladchenko.nasapicturestealer.service.NasaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pictures")
@RestController
public class NasaController {

  private final NasaService nasaService;

  public NasaController(NasaService nasaService) {
    this.nasaService = nasaService;
  }

  @PostMapping("/steal")
  public void steal(@RequestBody NasaDto nasaDto) {
    nasaService.steal(nasaDto.getSol());
  }
}
