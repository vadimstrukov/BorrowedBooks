
package ee.strukov.books.api.model.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

@Entity
@Data
@Table(name = "VOLUMEINFO")
public class VolumeInfo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("authors")
    public String [] authors =  new String[10];
    @JsonProperty("publisher")
    public String publisher;
    @JsonProperty("publishedDate")
    public String publishedDate;
    @JsonProperty("description")
    @Column(columnDefinition = "LONGVARCHAR")
    public String description;
    @JsonProperty("pageCount")
    public Integer pageCount;
    @JsonProperty("printType")
    public String printType;
    @JsonProperty("categories")
    public String [] categories = new String[20];
    @JsonProperty("averageRating")
    public Integer averageRating;
    @JsonProperty("ratingsCount")
    public Integer ratingsCount;
    @JsonProperty("maturityRating")
    public String maturityRating;
    @JsonProperty("allowAnonLogging")
    public Boolean allowAnonLogging;
    @JsonProperty("contentVersion")
    public String contentVersion;
    @JsonProperty("imageLinks")
    @OneToOne(cascade=CascadeType.ALL)
    public ImageLinks imageLinks;
    @JsonProperty("language")
    public String language;
    @JsonProperty("previewLink")
    public String previewLink;
    @JsonProperty("infoLink")
    public String infoLink;
    @JsonProperty("canonicalVolumeLink")
    public String canonicalVolumeLink;
}
