package com.palominolabs.metrics.guice;

import io.dropwizard.metrics5.annotation.Gauge;

class InstrumentedWithGaugeParent {
    @Gauge(name = "gaugeParent", absolute = true)
    public String gaugeParent() {
        return "gaugeParent";
    }

    @Gauge(name = "gaugeParentPrivate", absolute = true)
    private String gaugeParentPrivate() {
        return "gaugeParentPrivate";
    }

    @Gauge
    public String justAGaugeFromParent() {
        return "justAGaugeFromParent";
    }
}
