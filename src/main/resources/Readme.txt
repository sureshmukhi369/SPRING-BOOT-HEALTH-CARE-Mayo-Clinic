package com.practo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TimeSlotConfiguration {

    @Bean
    public TimeSlotManager timeSlotManager(){
        List<String> availableTimeSlots = new ArrayList<>();
        availableTimeSlots.add("10.15AM");
        availableTimeSlots.add("11.15AM");
        availableTimeSlots.add("12.15 PM");

        return new TimeSlotManager(availableTimeSlots);
    }

}
-----------------------------------------------------------------------------------------------------------

package com.practo.config;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeSlotManager {

    private List<String> availableTimeSlots;
    public TimeSlotManager(List<String> initialTimeSlots) {
        this.availableTimeSlots = initialTimeSlots;
    }

    public List<String> getAvailableTimeSlots() {
        return availableTimeSlots;
    }

    public void setAvailableTimeSlots(List<String> availableTimeSlots) {
        this.availableTimeSlots = availableTimeSlots;
    }
}
