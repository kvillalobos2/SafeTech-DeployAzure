package com.api.safetech.publication.api;
import com.api.safetech.publication.domain.service.TagService;
import com.api.safetech.publication.mapping.TagMapper;
import com.api.safetech.publication.resource.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Tag")
@RestController
@RequestMapping("/api/v1/tags")
@CrossOrigin

public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private TagMapper mapper;

    @Operation(summary = "Get Tags", description = "Get All Tags")
    @GetMapping
    public List<TagResource> getAllTags()
    {
        return mapper.toResource(tagService.getAll());
    }

    @Operation(summary = "Get Tag by Id", description = "Get Tag by Id")
    @GetMapping("{tagId}")
    public TagResource getTagById(@PathVariable Long tagId)
    {
        return mapper.toResource(tagService.getById(tagId));
    }

    @Operation(summary = "Create Tag", description = "Create Tag")
    @PostMapping("publications/{publicationId}")
    public TagResource createTag(@Valid @RequestBody CreateTagResource request, @PathVariable Long publicationId)
    {
        return mapper.toResource(tagService.create(mapper.toModel(request), publicationId));
    }

    @Operation(summary = "Update Tag", description = "Update Tag by Id ")
    @PutMapping("{tagId}")
    public TagResource updateTag(@PathVariable Long tagId, @Valid @RequestBody UpdateTagResource request)
    {
        return mapper.toResource(tagService.update(tagId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete Tag", description = "Delete Tag by Id")
    @DeleteMapping("{tagId}")
    public ResponseEntity<?> deleteTag(@PathVariable Long tagId)
    {
        return tagService.delete(tagId);
    }



}
