package org.sc.mvc.wsresponse;

import java.util.HashSet;
import java.util.Set;

public class StaffUtilizationResult {
    private Set<RegionResult> regionResults;

    public Set<RegionResult> getRegionResults() {
        if (regionResults == null) {
            regionResults = new HashSet<>();
        }
        return regionResults;
    }

    public void setRegionResults(final Set<RegionResult> regionResults) {
        this.regionResults = regionResults;
    }

}
