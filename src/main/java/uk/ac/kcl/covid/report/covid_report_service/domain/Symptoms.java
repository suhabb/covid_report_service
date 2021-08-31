package uk.ac.kcl.covid.report.covid_report_service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "covid_symptoms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptoms {


    @JsonIgnore
    @Field
    public String id;

    @JsonProperty("gender")
    @Field("gender")
    public String gender;

    @JsonProperty("eye_pain")
    @Field("eye_pain")
    public String eyePain;

    @JsonProperty("chest_pain")
    @Field("chest_pain")
    public String chestPain;

    @JsonProperty("soar_throat")
    @Field("soar_throat")
    public String soarThroat;

    @JsonProperty("fever")
    @Field("fever")
    public String fever;

    @JsonProperty("headache")
    @Field("headache")
    public String headache;

    @JsonProperty("cough")
    @Field("cough")
    public String cough;

    @JsonProperty("breathlessness")
    @Field("breathlessness")
    public String breathlessness;

}
