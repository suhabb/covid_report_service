package uk.ac.kcl.covid.report.covid_report_service.application_service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import uk.ac.kcl.covid.report.covid_report_service.data_service.ReportDataService;
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
public class ReportApplicationServiceTest {

    private ReportDataService reportDataService = mock(ReportDataService.class);
    private Mapper mapper = new Mapper(new ObjectMapper());
    private ReportApplicationService reportApplicationService;

    @BeforeEach
    public void setUp() {
        this.reportApplicationService = new ReportApplicationService(mapper,reportDataService);
    }

    @Test
    public void give_mock_json_data_return_find_all() throws IOException {

        File resource = new ClassPathResource(
                "json/covid_all_stats.json").getFile();
        String mockAllJson = new String(Files.readAllBytes(resource.toPath()));
        List<Symptoms> symptomsList = mapToSymptomsList(mockAllJson);
        List<SymptomsDto> symptomsDtos = mapper.mapToSymptomsDtoList(symptomsList);
        when(reportDataService.findAll()).thenReturn(symptomsList);
        List<SymptomsDto> actualList = reportApplicationService.findAll();
        Assertions.assertEquals(actualList,symptomsDtos);
    }

    @Test
    public void give_mock_json_data_return_stats_list() throws IOException {

        File resource = new ClassPathResource(
                "json/covid_all_stats.json").getFile();
        String mockAllJson = new String(Files.readAllBytes(resource.toPath()));
        List<Symptoms> symptomsList = mapToSymptomsList(mockAllJson);
        List<SymptomsDto> symptomsDtos = mapper.mapToSymptomsDtoList(symptomsList);
        when(reportDataService.findAll()).thenReturn(symptomsList);
        StatsDto allWithStats = reportApplicationService.findAllWithStats();
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
        Assertions.assertEquals(expectedStatsDto,allWithStats);
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
