package com.example.swaggerproject.controller;


import com.example.swaggerproject.DTO.IcecreamDto;
import com.example.swaggerproject.entity.IcecreamEntity;
import com.example.swaggerproject.exceptionhandler.IcecreamRequestException;
import com.example.swaggerproject.service.IcecreamService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ICECREAM")
public class IcecreamController {

    private final IcecreamService icecreamService;

    public IcecreamController(IcecreamService icecreamService) {
        this.icecreamService = icecreamService;
    }

    @GetMapping("/get-all-icecreams")
    public List<IcecreamDto> getAllIcecreams() throws IcecreamRequestException {
        List<IcecreamEntity> allIcecreams = icecreamService.getAllIcecreams();
        List<IcecreamDto> icecreamDtos = icecreamService.fromEntityListToDtoList(allIcecreams);
        return icecreamDtos;
    }


    @GetMapping("/get-icecream-by-id")
    public IcecreamDto getIcecreamByID(@RequestParam Long id) throws ClassNotFoundException {
        IcecreamEntity icecreamEntity = icecreamService.getIcecreamByID(id);
        IcecreamDto icecreamDto = IcecreamService.fromEntityToDto(icecreamEntity);
        return icecreamDto;
    }

    @PostMapping("/add-icecream")
    public IcecreamEntity addIcecream(@Valid @RequestBody IcecreamDto icecreamDto) {
        IcecreamEntity icecreamEntity = IcecreamService.fromDtoToEntity(icecreamDto);
        IcecreamEntity icecreamEntity1 = icecreamService.addIcecream(icecreamEntity);
        return icecreamEntity1;


    }


    @PostMapping("/update-icecream")
    public IcecreamEntity updateIcecream(@RequestBody IcecreamDto icecreamDto) throws ChangeSetPersister.NotFoundException {
        IcecreamEntity icecreamEntity = IcecreamService.fromDtoToEntity(icecreamDto);
        IcecreamEntity icecreamEntity1 = icecreamService.updateIcecream(icecreamEntity);
        return icecreamEntity1;


    }


    @DeleteMapping("/delete-icecream")
    public IcecreamEntity deleteIcecream(@RequestParam Long id) {
        icecreamService.deleteIcecream(id);


        return null;
    }


}
