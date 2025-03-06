package com.demo.java_event.service;

import com.demo.java_event.model.Reaction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReactionService {
    private List<Reaction> reactions = new ArrayList<>();
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
