package com.mariuszilinskas.vsp.discovery.search.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(indexName = "mediaindex")
public class Media {

    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

//    @Field("type")
//    private ContentType type;

    @Field("releaseDate")
    private LocalDate releaseDate;

    @Field("releaseCountries")
    private List<String> releaseCountries;

    @Field("rating")
    private Double rating;

//    @Field("genres")
//    private List<Genre> genres;
//
//    @Field("cast")
//    private List<CastMember> cast;
//
//    @Field("directors")
//    private List<CrewMember> directors; // not applicable for series
//
//    @Field("writers")
//    private List<CrewMember> writers; // not applicable for series
//
//    @Field("creators")
//    private List<CrewMember> creators; // specific for series
//
//    @Field("crew")
//    private List<CrewMember> crew;

    @Field("availableCountries")
    private List<String> availableCountries;

    @Field("duration")
    private Integer duration; // duration in minutes, not applicable for series

//    @Field("tags")
//    private List<Tag> tags;

    @Field("thumbnail")
    private String thumbnail;

    @Field("poster")
    private String poster;

    @Field("contentUrl")
    private String contentUrl; // not applicable for series

//    @Field("seasons")
//    private List<Season> seasons; // specific for series

}
