package smoke.channel_level;

import base.BaseTest;
import com.coretestautomation.domain.entities.message.MessageType;
import com.coretestautomation.domain.entities.offer.OfferType;
import com.coretestautomation.domain.steps.containers.StepsContainer;
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
        steps.adminSteps
                .editChannelOfferType(channelName, OfferType.CASH_OFFER)
                .goToAddNewOffer();

        boolean isChannelDisplayedInActiveInDropDown = steps.adminSteps.verifyChannelActiveInDropDown(channelName, OfferType.CASH_OFFER);
        assertTrue(isChannelDisplayedInActiveInDropDown, "Error! Channel is not displayed under CASH_OFFER in 'Active In' Drop Down");

        boolean isChannelNotDisplayedInActiveInDropDown = steps.adminSteps
                .goToAddNewOffer()
                .verifyChannelActiveInDropDown(channelName, OfferType.BRAND_OFFER);
        assertFalse(isChannelNotDisplayedInActiveInDropDown, "Error! Channel is displayed under BRAND_OFFER in 'Active In' Drop Down");
    }

    @Test
    @DisplayName("Channel Maintenance Controls for Displaying Certified Partners - Message Drop Downs")
    public void displayingCertifiedPartnersOfferIndicator_OR_T28() {
        steps.adminSteps
                .editChannelMessageType(channelName, MessageType.CLICKABLE_BANNER_MESSAGE)
                .goToAddNewMessage();

        boolean isChannelsDisplayDropDown = steps.adminSteps.verifyChannelsDisplayDropDown(channelName, MessageType.STATIC_BANNER_MESSAGE);

        assertTrue(isChannelsDisplayDropDown, "Error! Channel is not displayed in 'Channels' Drop Down");
    }
}
