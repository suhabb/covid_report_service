package uk.ac.kcl.covid.report.covid_report_service.data_service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import uk.ac.kcl.covid.report.covid_report_service.domain.Symptoms;
import uk.ac.kcl.covid.report.covid_report_service.repository.ReportRepository;

import java.util.List;

@Service
public class ReportDataService {

    private ReportRepository reportRepository;

    private Environment environment;

    public ReportDataService(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    public List<Symptoms> findAll(){
        return this.reportRepository.findAll();
    }
}
