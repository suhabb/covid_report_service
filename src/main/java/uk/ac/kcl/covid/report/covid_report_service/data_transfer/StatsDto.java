package uk.ac.kcl.covid.report.covid_report_service.data_transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatsDto {

    @JsonProperty("eye_pain")
    private Long eyePain;

    @JsonProperty("chest_pain")
    private Long chestPain;

    @JsonProperty("soar_throat")
    private Long soarThroat;

    @JsonProperty("fever")
    private Long fever;

    @JsonProperty("headache")
    private Long headache;

    @JsonProperty("cough")
    private Long cough;

    @JsonProperty("breathlessness")
    private Long breathlessness;

    @JsonProperty("total_patients")
    private Long totalPatients;

    @JsonProperty("symptoms")
    private List<SymptomsDto> symptomsDtoList;

    private StatsDto(StatsDtoBuilder builder) {
        this.eyePain = builder.eyePain;
        this.breathlessness = builder.breathlessness;
        this.chestPain = builder.chestPain;
        this.soarThroat = builder.soarThroat;
        this.fever = builder.fever;
        this.headache = builder.headache;
        this.cough = builder.cough;
        this.fever = builder.fever;
        this.totalPatients = builder.totalPatients;
        this.symptomsDtoList = builder.symptomsDtoList;

    }

    public static class StatsDtoBuilder {

        private Long eyePain;
        private Long chestPain;
        private Long soarThroat;
        private Long fever;
        private Long headache;
        private Long cough;
        private Long breathlessness;
        private Long totalPatients;
        private List<SymptomsDto> symptomsDtoList;


        public StatsDtoBuilder setEyePainCount(long eyePain) {
            this.eyePain = eyePain;
            return this;
        }

        public StatsDtoBuilder setChestPainCount(long chestPain) {
            this.chestPain = chestPain;
            return this;
        }

        public StatsDtoBuilder setFeverCount(long fever) {
            this.fever = fever;
            return this;
        }

        public StatsDtoBuilder setHeadacheCount(long headache) {
            this.headache = headache;
            return this;
        }

        public StatsDtoBuilder setCoughCount(long cough) {
            this.cough = cough;
            return this;
        }

        public StatsDtoBuilder setSoarThroatCount(long soarThroat) {
            this.soarThroat = soarThroat;
            return this;
        }

        public StatsDtoBuilder setBreathlessnessCount(long breathlessness) {
            this.breathlessness = breathlessness;
            return this;
        }

        public StatsDtoBuilder setTotalPatients(long totalPatients) {
            this.totalPatients = totalPatients;
            return this;
        }

        public StatsDtoBuilder setSymptomList(List<SymptomsDto> symptomsDtos) {
            this.symptomsDtoList = symptomsDtos;
            return this;
        }

        public StatsDto build() {
            return new StatsDto(this);
        }
    }
}
