package fr.android.androidexercises;

import junit.framework.Assert;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

/**
 * Unit test the Login Activity
 */
@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest {

    LoginActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void testNotLogged() throws Exception {
        // Given
        // When
        activity.notLogged();
        // Then
        Assertions.assertThat(activity.loginLayout).isVisible();
        Assertions.assertThat(activity.loggedText).isGone();
    }

    @Test
    public void testLogged() throws Exception {
        // When
        activity.logged();
        // Then
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void testMessage() throws Exception {
        // When
        activity.message(R.string.text_logged);
        // Then
        String textOfLatestToast = ShadowToast.getTextOfLatestToast();
        Assert.assertEquals(textOfLatestToast, "You are logged in.");
    }
}