
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


@Entity
@Data
@Table(name = "BOOK")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long book_id;
    @JsonProperty("kind")
    public String kind;
    @JsonProperty("id")
    public String id;
    @JsonProperty("etag")
    public String etag;
    @JsonProperty("selfLink")
    public String selfLink;
    @JsonProperty("volumeInfo")
    @OneToOne(cascade= CascadeType.ALL)
    public VolumeInfo volumeInfo;
}
