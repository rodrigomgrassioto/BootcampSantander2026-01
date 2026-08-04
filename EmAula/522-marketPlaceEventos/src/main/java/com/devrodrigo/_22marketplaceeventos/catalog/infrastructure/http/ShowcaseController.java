package com.devrodrigo._22marketplaceeventos.catalog.infrastructure.http;

import com.devrodrigo._22marketplaceeventos.catalog.application.BrowseShowcaseUseCase;
import com.devrodrigo._22marketplaceeventos.catalog.application.dto.EventOutput;
import com.devrodrigo._22marketplaceeventos.catalog.domain.Event;
import com.devrodrigo._22marketplaceeventos.catalog.domain.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showcase")
public class ShowcaseController {
    private final BrowseShowcaseUseCase browseShowcaseUseCase;

    public ShowcaseController(BrowseShowcaseUseCase browseShowcaseUseCase) {
        this.browseShowcaseUseCase = browseShowcaseUseCase;
    }

    @GetMapping
    List<EventOutput> browseShowcase() {
        return browseShowcaseUseCase.execute();
    }
}
