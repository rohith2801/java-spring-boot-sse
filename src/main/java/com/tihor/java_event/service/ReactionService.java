package com.tihor.java_event.service;

import com.tihor.java_event.model.Reaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReactionService {
    private final List<Reaction> reactions;
    private SseEmitter sseEmitter;

    public String saveReaction(final Reaction reaction) throws IOException {
        reactions.add(reaction);
        sseEmitter.send(reactions);
//        sseEmitter.complete();
        return "";
    }

    public SseEmitter subscribe() {
        if (sseEmitter != null) {
            sseEmitter.complete();
        }

        sseEmitter = new SseEmitter();
        return sseEmitter;
    }
}
