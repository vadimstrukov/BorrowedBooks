
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
    "kind",
    "id",
    "etag",
    "selfLink",
    "volumeInfo",
    "saleInfo",
    "accessInfo",
    "searchInfo"
})
@Entity
@Data
@Table(name = "BOOK")
public class Book implements Serializable {

    @JsonProperty("kind")
    public String kind;
    @JsonProperty("id")
    @Id
    public String id;
    @JsonProperty("etag")
    public String etag;
    @JsonProperty("selfLink")
    public String selfLink;
    @JsonProperty("volumeInfo")
    @OneToOne(cascade= CascadeType.ALL)
    public VolumeInfo volumeInfo;
    @JsonProperty("saleInfo")
    @OneToOne(cascade=CascadeType.ALL)
    public SaleInfo saleInfo;
    @JsonProperty("accessInfo")
    @OneToOne(cascade=CascadeType.ALL)
    public AccessInfo accessInfo;
}
