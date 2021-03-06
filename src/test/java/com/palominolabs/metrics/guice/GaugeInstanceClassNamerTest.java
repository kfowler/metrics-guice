package com.palominolabs.metrics.guice;

import io.dropwizard.metrics5.Gauge;
import org.junit.jupiter.api.Test;

import static io.dropwizard.metrics5.MetricRegistry.name;
import static com.palominolabs.metrics.guice.DeclaringClassMetricNamer.GAUGE_SUFFIX;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GaugeInstanceClassNamerTest extends GaugeTestBase {
    @Override
    MetricNamer getMetricNamer() {
        return new GaugeInstanceClassMetricNamer();
    }

    @Test
    void aGaugeWithoutNameInSuperclass() {
        // named for the instantiated class
        final Gauge<?> metric =
                registry.getGauges().get(name(InstrumentedWithGauge.class, "justAGaugeFromParent",
                        GAUGE_SUFFIX));

        assertNotNull(metric);
        assertEquals("justAGaugeFromParent", metric.getValue());
    }
}
