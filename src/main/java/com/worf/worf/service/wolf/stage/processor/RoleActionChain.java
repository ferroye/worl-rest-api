package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.ActionResponse;
import com.worf.worf.service.domain.role.Player;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleActionChain extends RoleActionProcessor {

    private List<RoleActionProcessor> roleActionProcessorList;

    public RoleActionChain(RoleActionProcessor seerProcessor,
                           RoleActionProcessor wolfProcessor,
                           RoleActionProcessor witchProcessor,
                           RoleActionProcessor voterProcessor) {
        this.roleActionProcessorList = Arrays.asList(
                seerProcessor,
                wolfProcessor,
                witchProcessor,
                voterProcessor);
    }

    @Override
    public ActionResponse process(Player source, Action action, Player target) {
        for (RoleActionProcessor roleActionProcessor : this.roleActionProcessorList) {
            roleActionProcessor.setGame(this.getGame());
            ActionResponse response = roleActionProcessor.process(source, action, target);
            if (response != null) {
                return response;
            }
        }
        return null;
    }
}
