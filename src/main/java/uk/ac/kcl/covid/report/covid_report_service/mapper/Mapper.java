package uk.ac.kcl.covid.report.covid_report_service.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uk.ac.kcl.covid.report.covid_report_service.data_transfer.SymptomsDto;
import uk.ac.kcl.covid.report.covid_report_service.domain.Symptoms;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class Mapper {


    public ObjectMapper objectMapper;

    public Mapper(ObjectMapper mapper){
        this.objectMapper = mapper;
    }

    public List<SymptomsDto> mapToSymptomsDtoList(List<Symptoms> symptomsList) {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(symptomsList),
                    new TypeReference<List<SymptomsDto>>(){});
        } catch (IOException exception) {
            log.debug("Json exception read value method", exception);
            throw new RuntimeException(exception);
        }
    }
}
