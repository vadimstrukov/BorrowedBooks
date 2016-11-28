
package ee.strukov.books.api.model.book;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "identifier"
})
@Entity
@Data
@Table(name = "INDUSTRYIDENTIFIER")
public class IndustryIdentifier implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long id;
    @JsonProperty("type")
    public String type;
    @JsonProperty("identifier")
    public String identifier;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public VolumeInfo volumeInfo;
}
