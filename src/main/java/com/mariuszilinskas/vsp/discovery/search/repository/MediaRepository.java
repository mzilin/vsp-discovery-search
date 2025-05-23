package com.mariuszilinskas.vsp.discovery.search.repository;

import com.mariuszilinskas.vsp.discovery.search.model.Media;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MediaRepository extends ElasticsearchRepository<Media, String> {
}
