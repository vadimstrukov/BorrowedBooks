
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "country",
    "viewability",
    "embeddable",
    "publicDomain",
    "textToSpeechPermission",
    "epub",
    "pdf",
    "webReaderLink",
    "accessViewStatus",
    "quoteSharingAllowed"
})
@Entity
@Data
@Table(name = "ACCESSINFO")
public class AccessInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long id;
    @JsonProperty("country")
    public String country;
    @JsonProperty("viewability")
    public String viewability;
    @JsonProperty("embeddable")
    public Boolean embeddable;
    @JsonProperty("publicDomain")
    public Boolean publicDomain;
    @JsonProperty("textToSpeechPermission")
    public String textToSpeechPermission;
    @JsonProperty("epub")
    @OneToOne(cascade=CascadeType.ALL)
    public Epub epub;
    @JsonProperty("pdf")
    @OneToOne(cascade=CascadeType.ALL)
    public Pdf pdf;
    @JsonProperty("webReaderLink")
    public String webReaderLink;
    @JsonProperty("accessViewStatus")
    public String accessViewStatus;
    @JsonProperty("quoteSharingAllowed")
    public Boolean quoteSharingAllowed;
}
