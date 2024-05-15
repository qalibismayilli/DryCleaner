package com.reserveall.drycleaner.service;

import com.reserveall.drycleaner.dto.ServiceDto;
import com.reserveall.drycleaner.dto.request.DryCleanerRequestDto;
import com.reserveall.drycleaner.dto.response.DryCleanerResponseDto;
import com.reserveall.drycleaner.dto.response.UserResponseDto;
import com.reserveall.drycleaner.model.DryCleaner;
import com.reserveall.drycleaner.model.User;
import com.reserveall.drycleaner.repository.DryCleanerRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class DryCleanerService {
    private final DryCleanerRepository dryCleanerRepository;
    private final UserService userService;


    public DryCleanerService(DryCleanerRepository dryCleanerRepository, UserService userService) {
        this.dryCleanerRepository = dryCleanerRepository;
        this.userService = userService;
    }

    @Transactional
    public DryCleanerResponseDto createDryCleaner(@NotNull DryCleanerRequestDto request, String userId) {
        User user = userService.getOriginalUserById(userId);

        DryCleaner dryCleaner = new DryCleaner(request.getName(),
                request.getLocation(),
                request.getDescription(),
                request.getServices().stream()
                        .map(serviceDto -> new com.reserveall.drycleaner.model.Service(serviceDto.getServiceName(),
                                serviceDto.getPrice())).toList(),
                user);

        dryCleanerRepository.save(dryCleaner);

        return new DryCleanerResponseDto(dryCleaner.getId(), dryCleaner.getName(),
                dryCleaner.getLocation(), dryCleaner.getDescription(),
                dryCleaner.getServices().stream()
                        .map(s -> new ServiceDto(s.getId(), s.getServiceName(), s.getPrice())).toList(),
                dryCleaner.getImages().stream().map(i -> i.getImageUrl()).toList(),
                new UserResponseDto(user.getId(), user.getUsername(), user.getRole(), user.getEmail()));
    }



}
