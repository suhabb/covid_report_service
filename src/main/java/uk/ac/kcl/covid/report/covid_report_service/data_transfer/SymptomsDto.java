package uk.ac.kcl.covid.report.covid_report_service.data_transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomsDto {

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("eye_pain")
    private String eyePain;

    @JsonProperty("chest_pain")
    private String chestPain;

    @JsonProperty("soar_throat")
    private String soarThroat;

    @JsonProperty("fever")
    private String fever;

    @JsonProperty("headache")
    private String headache;

    @JsonProperty("cough")
    private String cough;

    @JsonProperty("breathlessness")
    private String breathlessness;
}
