/*
 * WiFi Analyzer
 * Copyright (C) 2017  VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.vrem.wifianalyzer.navigation.options;

import android.support.annotation.NonNull;

import com.vrem.wifianalyzer.BuildConfig;
import com.vrem.wifianalyzer.MainActivity;
import com.vrem.wifianalyzer.RobolectricUtil;
import com.vrem.wifianalyzer.navigation.NavigationMenu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LeftRightSwipeOnTouchListenerTest {
    private MainActivity mainActivity;
    private LeftRightSwipeOnTouchListener fixture;

    @Before
    public void setUp() {
        mainActivity = RobolectricUtil.INSTANCE.getActivity();
        fixture = new LeftRightSwipeOnTouchListener(mainActivity);
    }

    @Test
    public void testOnSwipeLeftAndRight() throws Exception {
        // execute & validate
        fixture.onSwipeLeft(mainActivity);
        validateSwipeRight(NavigationMenu.CHANNEL_RATING);
        // execute & validate
        fixture.onSwipeRight(mainActivity);
        validateSwipeRight(NavigationMenu.ACCESS_POINTS);
    }

    private void validateSwipeRight(@NonNull NavigationMenu expected) throws Exception {
        assertEquals(expected, mainActivity.getNavigationMenuView().getCurrentNavigationMenu());
        assertEquals(expected.ordinal(), mainActivity.getNavigationMenuView().getCurrentMenuItem().getItemId());
    }
}