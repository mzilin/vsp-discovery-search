package com.mariuszilinskas.vsp.discovery.search.dto;

import java.time.LocalDate;
import java.util.List;

public record MediaRequest(
        String contentId,
        String title,
        String type,
        LocalDate releaseDate,
        List<String> genres,
        List<String> castAndCrew,
        List<String> tags,
        String poster
) {}
