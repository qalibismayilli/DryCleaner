package com.example.drycleaner.service;

import com.example.drycleaner.dto.dry_cleaner.request.DryCleanerUpdateRequestDto;
import com.example.drycleaner.dto.service.response.ServiceResponseDto;
import com.example.drycleaner.dto.dry_cleaner.request.DryCleanerRequestDto;
import com.example.drycleaner.dto.dry_cleaner.response.DryCleanerResponseDto;
import com.example.drycleaner.model.DryCleaner;
import com.example.drycleaner.repository.DryCleanerRepository;
import com.example.drycleaner.service.user.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class DryCleanerService {
    private final DryCleanerRepository dryCleanerRepository;
    private final ServiceService serviceService;
    private final UserService userService;


    public DryCleanerService(DryCleanerRepository dryCleanerRepository, ServiceService serviceService, UserService userService) {
        this.dryCleanerRepository = dryCleanerRepository;
        this.serviceService = serviceService;
        this.userService = userService;
    }


    private static DryCleanerResponseDto convertToResponse(@NotNull DryCleaner dryCleaner){
        return new DryCleanerResponseDto(dryCleaner.getDryCleanerId(), dryCleaner.getDryCleanerName(),
                dryCleaner.getLocation(), dryCleaner.getDescription(),
                dryCleaner.getServices().stream()
                        .map(s -> new ServiceResponseDto(s.getServiceId(), s.getServiceName(),
                                s.getPrice(), s.getDiscount())).toList(),
                dryCleaner.getImages().stream().map(i -> i.getImageUrl()).toList(),
                dryCleaner.getUser().getUserId());
    }

    @Transactional
    public DryCleanerResponseDto createDryCleaner(@NotNull DryCleanerRequestDto request) {

        DryCleaner dryCleaner = dryCleanerRepository.save(
                DryCleaner.builder()
                        .dryCleanerName(request.getName())
                        .location(request.getLocation())
                        .description(request.getDescription())
                        .services(request.getServices().stream()
                                .map(serviceRequestDto ->
                                        com.example.drycleaner.model.Service.builder()
                                                .serviceName(serviceRequestDto.getServiceName())
                                                .price(serviceRequestDto.getPrice()).build()
                                ).toList())
                        .build()
        );

        return convertToResponse(dryCleaner);
    }

    @Transactional
    public DryCleanerResponseDto removeDryCleaner(UUID dryCleanerId){
        DryCleaner dryCleaner = dryCleanerRepository.findById(dryCleanerId).orElseThrow();
        dryCleanerRepository.delete(dryCleaner);
        return convertToResponse(dryCleaner);
    }

    @Transactional
    public DryCleanerResponseDto updateDryCleaner(@NotNull DryCleanerUpdateRequestDto request, UUID userId){
        //TODO: THIS userId CONFIGURATION IN AUTHORIZE
        DryCleaner fromDb = dryCleanerRepository.findDryCleanerByDryCleanerId(userId).orElseThrow();
        DryCleaner updatedDryCleaner = dryCleanerRepository.updateDryCleaner(request.getName(),
                request.getLocation(),request.getDescription(), fromDb.getDryCleanerId()).orElseThrow();
        return convertToResponse(updatedDryCleaner);
    }

    public List<DryCleanerResponseDto> getAllDryCleaners(){
        return dryCleanerRepository.findAll().stream().map(x -> convertToResponse(x)).toList();
    }

    public List<DryCleanerResponseDto> getDryCleanersByName(String dryCleanerName){
        return dryCleanerRepository.
                findDryCleanersByDryCleanerName(dryCleanerName).orElseThrow().stream().map(x -> convertToResponse(x)).toList();
    }

    public List<DryCleanerResponseDto> getDryCleanersByService(String serviceName){
        List<DryCleaner> dryCleaners = new ArrayList<>();
        serviceService.findServicesByName(serviceName).stream().map(s -> dryCleaners.add(s.getDryCleaner())).toList();

        return dryCleaners.stream().map(dc -> convertToResponse(dc)).toList();
    }

}
