package smoke.channel_level;

import base.BaseTest;
import com.coretestautomation.domain.entities.offer.OfferType;
import com.coretestautomation.domain.steps.holders.StepsContainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Channel maintenance tests")
public class ChannelMaintenanceTests extends BaseTest {
    private static StepsContainer steps;
    private static String channelName;

    @BeforeAll
    public static void prepareData() {
        steps = new StepsContainer();
        channelName = "Demo";
    }

    @Test
    @DisplayName("Channel Maintenance Controls for Displaying Certified Partners - Offer Indicator drop downs")
    public void displayingCertifiedPartnersOfferIndicator_OR_T27() {
        steps.adminSteps.editChannel(channelName, OfferType.CASH_OFFER);

        boolean isChannelDisplayedInActiveInDropDown = steps.adminSteps.verifyChannelActiveInDropDown(channelName, OfferType.CASH_OFFER);
        assertTrue(isChannelDisplayedInActiveInDropDown, "Error! Channel is not displayed under CASH_OFFER in Active In Drop Down");

        boolean isChannelNotDisplayedInActiveInDropDown = steps.adminSteps.verifyChannelActiveInDropDown(channelName, OfferType.BRAND_OFFER);
        assertFalse(isChannelNotDisplayedInActiveInDropDown, "Error! Channel is displayed under BRAND_OFFER in Active In Drop Down");
    }
}
