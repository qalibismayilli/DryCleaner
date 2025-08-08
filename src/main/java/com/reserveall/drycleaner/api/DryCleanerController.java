package com.reserveall.drycleaner.api;

import com.reserveall.drycleaner.dto.dry_cleaner.request.DryCleanerRequestDto;
import com.reserveall.drycleaner.dto.dry_cleaner.response.DryCleanerResponseDto;
import com.reserveall.drycleaner.service.DryCleanerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/dryCleaner")
public class DryCleanerController {
    private final DryCleanerService dryCleanerService;

    public DryCleanerController(DryCleanerService dryCleanerService) {
        this.dryCleanerService = dryCleanerService;
    }

    @PostMapping("/createDryCleaner")
    public DryCleanerResponseDto createDryCleaner(DryCleanerRequestDto request, String userId){
        return dryCleanerService.createDryCleaner(request, userId);
    }
}
