package uk.ac.kcl.covid.report.covid_report_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.kcl.covid.report.covid_report_service.application_service.ReportApplicationService;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.StatsDto;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.SymptomsDto;

import java.util.List;

@RestController
public class ReportController {

    private ReportApplicationService reportApplicationService;

    public ReportController(ReportApplicationService reportApplicationService) {
        this.reportApplicationService = reportApplicationService;
    }

    @GetMapping("/reporting/all")
    public ResponseEntity<List<SymptomsDto>> findAll() {
        List<SymptomsDto> symptomsDtoList = reportApplicationService.findAll();
        return ResponseEntity.ok(symptomsDtoList);
    }

    @GetMapping("/reporting/all/stats")
    public ResponseEntity<StatsDto> findAllStats() {
        StatsDto statsDto = reportApplicationService.findAllWithStats();
        return ResponseEntity.ok(statsDto);
    }

    @GetMapping("/reporting/sanity/check")
    public String sanity() {
        return "Covid Reporting Service: Ok";
    }


}
