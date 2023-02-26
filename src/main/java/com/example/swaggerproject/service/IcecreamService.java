package com.example.swaggerproject.service;


import com.example.swaggerproject.DTO.IcecreamDto;
import com.example.swaggerproject.entity.IcecreamEntity;
import com.example.swaggerproject.exceptionhandler.IcecreamRequestException;
import com.example.swaggerproject.repository.IcecreamRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class IcecreamService {
    private final IcecreamRepository icecreamRepository;


    public IcecreamService(IcecreamRepository icecreamRepository) {
        this.icecreamRepository = icecreamRepository;
    }


    public List<IcecreamEntity> getAllIcecreams() throws IcecreamRequestException {
        List<IcecreamEntity> icecreamEntities = icecreamRepository.findAll();
        if (icecreamEntities.isEmpty()){
            throw new IcecreamRequestException();
        }
        return icecreamEntities;

    }


    public IcecreamEntity getIcecreamByID(Long id) throws ClassNotFoundException {
        IcecreamEntity icecreamEntity = icecreamRepository.findById(id).orElseThrow(ClassNotFoundException::new);
        return icecreamEntity;


    }


    public IcecreamEntity addIcecream(IcecreamEntity icecreamEntity) {
        IcecreamEntity savedEntity = icecreamRepository.save(icecreamEntity);
        return savedEntity;




    }


    public IcecreamEntity updateIcecream(IcecreamEntity icecreamEntity) throws ChangeSetPersister.NotFoundException {
        IcecreamEntity icecreamEntity1 = icecreamRepository.findById(icecreamEntity.getId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        icecreamEntity1.setName(icecreamEntity.getName());
        icecreamEntity1.setFlavour(icecreamEntity.getFlavour());
        icecreamEntity1.setPrice(icecreamEntity.getPrice());
        IcecreamEntity save = icecreamRepository.save(icecreamEntity1);
        return save;

    }


    public IcecreamEntity deleteIcecream(Long id) {
        icecreamRepository.deleteById(id);


        return null;
    }


    public static IcecreamEntity fromDtoToEntity(IcecreamDto icecreamDto) {
        IcecreamEntity icecreamEntity = new IcecreamEntity();
        icecreamEntity.setId(icecreamDto.getId());
        icecreamEntity.setName(icecreamDto.getName());
        icecreamEntity.setFlavour(icecreamDto.getFlavour());
        icecreamEntity.setPrice(icecreamDto.getPrice());

        return icecreamEntity;
    }
    public static IcecreamDto fromEntityToDto(IcecreamEntity icecreamEntity) {
        IcecreamDto icecreamDto = new IcecreamDto();
        icecreamDto.setId(icecreamEntity.getId());
        icecreamDto.setName(icecreamEntity.getName());
        icecreamDto.setFlavour(icecreamEntity.getFlavour());
        icecreamDto.setPrice(icecreamEntity.getPrice());

        return icecreamDto;
    }

    public List<IcecreamDto> fromEntityListToDtoList(List<IcecreamEntity> entityList) {
        List<IcecreamDto> icecreamDtos = new ArrayList<>();
        for (IcecreamEntity entity : entityList) {
            IcecreamDto icecreamDto = new IcecreamDto();
            icecreamDto.setId(entity.getId());
            icecreamDto.setName(entity.getName());
            icecreamDto.setFlavour(entity.getFlavour());
            icecreamDto.setPrice(entity.getPrice());
            icecreamDtos.add(icecreamDto);
        }
        return icecreamDtos;
    }

}
