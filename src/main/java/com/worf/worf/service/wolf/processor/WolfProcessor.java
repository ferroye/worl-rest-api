package com.worf.worf.service.wolf.processor;

import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WolfProcessor implements StageProcessor {
    Logger LOGGER = LoggerFactory.getLogger(WolfProcessor.class);

    @Override
    public void process(Game game) {
        LOGGER.info("Wolf's turn.");
    }
}
