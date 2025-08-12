package com.example.drycleaner.api;

import com.example.drycleaner.dto.dry_cleaner.request.DryCleanerRequestDto;
import com.example.drycleaner.dto.dry_cleaner.response.DryCleanerResponseDto;
import com.example.drycleaner.service.DryCleanerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/dryCleaner")
public class DryCleanerController {
    private final DryCleanerService dryCleanerService;

    public DryCleanerController(DryCleanerService dryCleanerService) {
        this.dryCleanerService = dryCleanerService;
    }

    @PostMapping("/createDryCleaner")
    public DryCleanerResponseDto createDryCleaner(@RequestBody DryCleanerRequestDto request){
        return dryCleanerService.createDryCleaner(request);
    }
}
