package com.optiva.charging.iot.rf;

import com.optiva.charging.openapi.internal.DummyAccountBalance;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.MapDataContext;
import org.kie.kogito.incubation.processes.LocalProcessId;
import org.kie.kogito.incubation.processes.ProcessIds;
import org.kie.kogito.incubation.processes.services.StraightThroughProcessService;

import java.util.Map;

@QuarkusTest
class JBPMWithDMNTest {
    @Inject
    AppRoot appRoot;

    @Inject
    StraightThroughProcessService processService;

    @Test
    void triggerSimpleJBPM() {
        DummyAccountBalance balance =
                new DummyAccountBalance().setType("Premium").setUnit("USD").setValue(10);
        MapDataContext ctx = MapDataContext.of(Map.of("balance", balance, "chargeUnit", 6f));

        LocalProcessId processId = appRoot.get(ProcessIds.class).get("simple");
        processService.evaluate(processId, ctx);

        Assertions.assertTrue(balance.getValue() > 4.5f);
        System.out.println();
    }
}
