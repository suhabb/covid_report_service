package uk.ac.kcl.covid.report.covid_report_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.kcl.covid.report.covid_report_service.application_service.SymptomsApplicationService;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.StatsDto;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.SymptomsDto;

import java.util.List;

@RestController
public class SymptomsController {

    private SymptomsApplicationService symptomsApplicationService;

    public SymptomsController(SymptomsApplicationService symptomsApplicationService) {
        this.symptomsApplicationService = symptomsApplicationService;
    }

    @GetMapping("/reporting/all")
    public ResponseEntity<List<SymptomsDto>> findAll() {
        List<SymptomsDto> symptomsDtoList = symptomsApplicationService.findAll();
        return ResponseEntity.ok(symptomsDtoList);
    }

    @GetMapping("/reporting/all/stats")
    public ResponseEntity<StatsDto> findAllStats() {
        StatsDto statsDto = symptomsApplicationService.findAllWithStats();
        return ResponseEntity.ok(statsDto);
    }

    @GetMapping("/reporting/sanity/check")
    public String sanity() {
        return "Covid Reporting Service: Ok";
    }


}
