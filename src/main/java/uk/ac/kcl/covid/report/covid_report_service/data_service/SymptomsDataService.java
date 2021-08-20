package uk.ac.kcl.covid.report.covid_report_service.data_service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import uk.ac.kcl.covid.report.covid_report_service.domain.Symptoms;
import uk.ac.kcl.covid.report.covid_report_service.repository.SymptomsRepository;

import java.util.List;

@Service
public class SymptomsDataService {

    private SymptomsRepository symptomsRepository;

    private Environment environment;

    public SymptomsDataService(SymptomsRepository symptomsRepository){
        this.symptomsRepository = symptomsRepository;
    }

    public List<Symptoms> findAll(){
        return this.symptomsRepository.findAll();
    }
}
