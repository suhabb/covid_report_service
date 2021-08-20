package uk.ac.kcl.covid.report.covid_report_service.application_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.ac.kcl.covid.report.covid_report_service.data_service.SymptomsDataService;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.StatsDto;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.SymptomsDto;
import uk.ac.kcl.covid.report.covid_report_service.domain.Symptoms;
import uk.ac.kcl.covid.report.covid_report_service.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SymptomsApplicationService {

    public static final String YES = "Yes";
    private SymptomsDataService symptomsDataService;
    private Mapper mapper;

    public SymptomsApplicationService(Mapper mapper, SymptomsDataService symptomsDataService) {
        this.symptomsDataService = symptomsDataService;
        this.mapper = mapper;
    }

    public List<SymptomsDto> findAll() {
        List<Symptoms> symptomsList = this.symptomsDataService.findAll();
        return mapper.mapToSymptomsDtoList(symptomsList);
    }

    public StatsDto findAllWithStats() {
        List<Symptoms> symptomsList = this.symptomsDataService.findAll();
        List<SymptomsDto> symptomsDtoList = mapper.mapToSymptomsDtoList(symptomsList);
        long coughCount = symptomsDtoList.stream().collect(Collectors
                .groupingBy(SymptomsDto::getCough, Collectors.counting())).get(YES);
        long countBreathlessness = symptomsDtoList.stream().collect(Collectors
                .groupingBy(SymptomsDto::getBreathlessness, Collectors.counting())).get(YES);
        long countEyeCount = symptomsDtoList.stream().collect(Collectors
                .groupingBy(SymptomsDto::getEyePain, Collectors.counting())).get(YES);
        long countFever = symptomsDtoList.stream().collect(Collectors
                .groupingBy(SymptomsDto::getFever, Collectors.counting())).get(YES);
        long countSourThroat = symptomsDtoList.stream().collect(Collectors
                .groupingBy(SymptomsDto::getSoarThroat, Collectors.counting())).get(YES);
        long countHeadache = symptomsDtoList.stream().collect(Collectors
                .groupingBy(SymptomsDto::getHeadache, Collectors.counting())).get(YES);
        long countChestPain = symptomsDtoList.stream().collect(Collectors
                .groupingBy(SymptomsDto::getChestPain, Collectors.counting())).get(YES);
        return new StatsDto.StatsDtoBuilder()
                .setSoarThroatCount(countSourThroat)
                .setBreathlessnessCount(countBreathlessness)
                .setEyePainCount(countEyeCount)
                .setChestPainCount(countChestPain)
                .setFeverCount(countFever)
                .setHeadacheCount(countHeadache)
                .setCoughCount(coughCount)
                .setTotalPatients(symptomsDtoList.size())
                .setSymptomList(symptomsDtoList)
                .build();
    }
}
