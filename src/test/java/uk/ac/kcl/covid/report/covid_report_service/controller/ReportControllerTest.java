package uk.ac.kcl.covid.report.covid_report_service.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import uk.ac.kcl.covid.report.covid_report_service.application_service.ReportApplicationService;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.StatsDto;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.SymptomsDto;
import uk.ac.kcl.covid.report.covid_report_service.domain.Symptoms;
import uk.ac.kcl.covid.report.covid_report_service.mapper.Mapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
public class ReportControllerTest {

    private ReportApplicationService reportApplicationService = mock(ReportApplicationService.class);
    private Mapper mapper = new Mapper(new ObjectMapper());
    private ReportController reportController;

    @BeforeEach
    public void setUo() {
        reportController = new ReportController(reportApplicationService);
    }

    @Test
    public void given_uri_find_all_return_Response_ok() throws IOException {
        File resource = new ClassPathResource(
                "json/covid_all_stats.json").getFile();
        String mockAllJson = new String(Files.readAllBytes(resource.toPath()));
        List<Symptoms> symptomsList = mapToSymptomsList(mockAllJson);
        List<SymptomsDto> symptomsDtos = mapper.mapToSymptomsDtoList(symptomsList);
        when(reportApplicationService.findAll()).thenReturn(symptomsDtos);
        ResponseEntity<List<SymptomsDto>> actual = reportController.findAll();
        ResponseEntity<List<SymptomsDto>> expected = ResponseEntity.ok(symptomsDtos);
        Assertions.assertEquals(actual,expected);
    }

    @Test
    public void given_uri_find_all_return_stats_Response_ok() throws IOException {
        File resource = new ClassPathResource(
                "json/covid_all_stats.json").getFile();
        String mockAllJson = new String(Files.readAllBytes(resource.toPath()));
        List<Symptoms> symptomsList = mapToSymptomsList(mockAllJson);
        List<SymptomsDto> symptomsDtos = mapper.mapToSymptomsDtoList(symptomsList);
        StatsDto expectedStatsDto = new StatsDto.StatsDtoBuilder()
                .setTotalPatients(6)
                .setFeverCount(5)
                .setSoarThroatCount(1)
                .setChestPainCount(3)
                .setEyePainCount(1)
                .setSymptomList(symptomsDtos)
                .setHeadacheCount(3)
                .setCoughCount(5)
                .setBreathlessnessCount(1)
                .build();
        when(reportApplicationService.findAllWithStats()).thenReturn(expectedStatsDto);
        ResponseEntity<StatsDto> actual = reportController.findAllStats();
        ResponseEntity<StatsDto> expected = ResponseEntity.ok(expectedStatsDto);
        Assertions.assertEquals(actual,expected);
    }

    public List<Symptoms> mapToSymptomsList(String symptomsList) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(symptomsList,
                    new TypeReference<List<Symptoms>>(){});
        } catch (IOException exception) {
            log.debug("Json exception read value method", exception);
            throw new RuntimeException(exception);
        }
    }
}
