
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
@Table(name = "IMAGELINKS")
public class ImageLinks implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @JsonProperty("smallThumbnail")
    @Column(columnDefinition = "LONGVARCHAR")
    private String smallThumbnail;
    @JsonProperty("thumbnail")
    @Column(columnDefinition = "LONGVARCHAR")
    private String thumbnail;
    @JsonProperty("medium")
    @Column(columnDefinition = "LONGVARCHAR")
    private String medium;

}
