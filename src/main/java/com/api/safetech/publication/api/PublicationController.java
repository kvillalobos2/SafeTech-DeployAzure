package com.api.safetech.publication.api;

import com.api.safetech.publication.domain.service.PublicationService;
import com.api.safetech.publication.mapping.PublicationMapper;
import com.api.safetech.publication.resource.CreatePublicationResource;
import com.api.safetech.publication.resource.PublicationResource;
import com.api.safetech.publication.resource.UpdatePublicationResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Publication")
@RestController
@RequestMapping("/api/v1/publications")
@CrossOrigin
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationMapper mapper;

    @Operation(summary = "Get Publications", description = "Get All Publications")
    @GetMapping
    public List<PublicationResource> getAllPublication()
    {
        return mapper.toResource(publicationService.getAll());
    }

    @Operation(summary = "Get Publication by Id", description = "Get Publication by Id")
    @GetMapping("{publicationId}")
    public PublicationResource getPublicationById(@PathVariable Long publicationId)
    {
        return mapper.toResource(publicationService.getById(publicationId));
    }

    @Operation(summary = "Create Publication", description = "Create Publication")
    @PostMapping("technicals/{technicalId}")
    public PublicationResource createPublication(@PathVariable Long technicalId, @Valid @RequestBody CreatePublicationResource request)
    {
        return mapper.toResource(publicationService.create(mapper.toModel(request), technicalId));
    }

    @Operation(summary = "Update Publication", description = "Update Publication by Id ")
    @PutMapping("{publicationId}")
    public PublicationResource updatePublication(@PathVariable Long publicationId, @Valid @RequestBody UpdatePublicationResource request)
    {
        return mapper.toResource(publicationService.update(publicationId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete Publication", description = "Delete Publication by Id")
    @DeleteMapping("{publicationId}")
    public ResponseEntity<?> deletePublication(@PathVariable Long publicationId)
    {
        return publicationService.delete(publicationId);
    }

    @Operation(summary = "Get Publication by technical Id", description = "Get Publication by technical Id")
    @GetMapping("technical/{technicalId}")
    public List<PublicationResource> getPublicationByTechnical(@PathVariable Long technicalId)
    {
        return mapper.toResource(publicationService.getByTechnicalId(technicalId));
    }



}
