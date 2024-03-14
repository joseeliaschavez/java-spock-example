package com.rangerforce.spockexample;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleJunitTest {
    @Test
    public void when_listOfStrings_then_Passes() {
        var list = List.of("Matthew", "Mark", "Luke", "John");

        assertThat(list.size()).isEqualTo(4);
    }

    @Disabled
    @Test
    public void when_listOfStrings_then_Fails() {
        var list = List.of("Matthew", "Mark", "Luke", "John");

        assertThat(list.size()).isEqualTo(3);
    }
}
