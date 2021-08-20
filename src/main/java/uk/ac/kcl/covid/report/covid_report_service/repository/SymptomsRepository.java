package uk.ac.kcl.covid.report.covid_report_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.ac.kcl.covid.report.covid_report_service.domain.Symptoms;

@Repository
public interface SymptomsRepository extends MongoRepository<Symptoms, String> {
}
