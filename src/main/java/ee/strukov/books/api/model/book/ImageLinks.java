
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
    "smallThumbnail",
    "thumbnail"
})
@Entity
@Data
@Table(name = "IMAGELINKS")
public class ImageLinks implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long id;
    @JsonProperty("smallThumbnail")
    public String smallThumbnail;
    @JsonProperty("thumbnail")
    public String thumbnail;

}
