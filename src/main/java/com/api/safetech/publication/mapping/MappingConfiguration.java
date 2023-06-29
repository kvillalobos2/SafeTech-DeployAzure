package com.api.safetech.publication.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("publicationMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PublicationMapper publicationMapper() {
        return new PublicationMapper();
    }
    @Bean
    public CommentMapper commentMapper() {
        return new CommentMapper();
    }
    @Bean
    public TagMapper tagMapper() { return new TagMapper();}
}
