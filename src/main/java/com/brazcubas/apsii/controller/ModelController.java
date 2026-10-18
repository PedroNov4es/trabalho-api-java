package com.brazcubas.apsii.controller;

import com.brazcubas.apsii.model.ApiDtos;
import com.brazcubas.apsii.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints do catálogo de modelos preditivos.
 */
@RestController
@RequestMapping("/api/v1/models")
@Tag(name = "Models")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "List models")
    @GetMapping
    public ApiDtos.ModelsResponse list() {
        return modelService.listActive();
    }

    @Operation(
            summary = "Get model",
            description = "Retrieves the details of a model from the model catalog using its identifier.")
    @ApiResponse(responseCode = "200", description = "Model found successfully.")
    @ApiResponse(
            responseCode = "404",
            description = "Model not found. Error code: MODEL_NOT_FOUND.",
            content = @Content(schema = @Schema(implementation = ApiDtos.ErrorResponse.class)))
    @GetMapping("/{model_id}")
    public ApiDtos.ModelDetail get(
            @Parameter(name = "model_id", description = "Unique identifier of the model to retrieve.", required = true)
            @PathVariable("model_id") String modelId) {
        return modelService.get(modelId);
    }
}
