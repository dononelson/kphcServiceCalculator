package com.kaiser.controller.response;

import java.util.HashSet;
import java.util.Set;

public class RegionResult {
    private String region;
    private String environmentType;
    private Set<DateResult> dateResults;

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(final String environmentType) {
        this.environmentType = environmentType;
    }

    public Set<DateResult> getDateResults() {
        if (dateResults == null) {
            dateResults = new HashSet<>();
        }
        return dateResults;
    }

    public void setDateResults(final Set<DateResult> dateResults) {
        this.dateResults = dateResults;
    }

}
