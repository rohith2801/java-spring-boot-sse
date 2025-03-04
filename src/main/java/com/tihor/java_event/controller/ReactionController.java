package com.tihor.java_event.controller;

import com.tihor.java_event.model.Reaction;
import com.tihor.java_event.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/reactions")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService reactionService;

    @PostMapping
    public ResponseEntity<Void> saveReaction(@RequestBody Reaction reaction) throws Exception {
        reactionService.saveReaction(reaction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subscribe")
    public SseEmitter subscribe() {
        return reactionService.subscribe();
    }
}
