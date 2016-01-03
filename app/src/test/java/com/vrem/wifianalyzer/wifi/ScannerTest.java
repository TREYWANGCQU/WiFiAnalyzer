/*
 *    Copyright (C) 2010 - 2015 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.vrem.wifianalyzer.wifi;

import android.net.wifi.WifiManager;
import android.os.Handler;

import com.vrem.wifianalyzer.MainContext;
import com.vrem.wifianalyzer.settings.Settings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScannerTest {
    @Mock private Handler handler;
    @Mock private Settings settings;
    @Mock private WifiManager wifiManager;

    private Scanner fixture;
    private WiFiData wifiData;

    @Before
    public void setUp() throws Exception {
        MainContext.INSTANCE.setSettings(settings);
        MainContext.INSTANCE.setHandler(handler);
        MainContext.INSTANCE.setWifiManager(wifiManager);
    }

    @Test
    public void testInitialPerformPeriodicScan() throws Exception {
        // execute
        fixture = new Scanner();
        // validate
        Scanner.PerformPeriodicScan performPeriodicScan = fixture.getPerformPeriodicScan();
        verify(handler).removeCallbacks(performPeriodicScan);
        verify(handler).postDelayed(performPeriodicScan, Scanner.DELAY_INITIAL);
    }

/*
    @Test
    public void testUpdate() throws Exception {
        // execute
        fixture.update();
        // validate
        verify(wifi).enable();
        verify(wifi).scan();
        verify(updateNotifier).update(wifiData);
    }

    @Test
    public void testScanInterval() throws Exception {
        // setup
        int expected = scanInterval * 10;
        // execute
        fixture.scanInterval(expected);
        // validate
        assertEquals(expected, fixture.performPeriodicScan().scanInterval());
    }

    @Test
    public void testPerformPeriodicScanRun() throws Exception {
        // setup
        Scanner.PerformPeriodicScan fixture = new Scanner.PerformPeriodicScan(scanner, handler, scanInterval);
        // execute
        fixture.run();
        // validate
        verify(scanner).update();
        verify(handler).removeCallbacks(fixture);
        verify(handler).postDelayed(fixture, scanInterval * Scanner.DELAY_INTERVAL);
    }

    @Test
    public void testGroupBy() throws Exception {
        // execute
        fixture.groupBy(GroupBy.CHANNEL);
        // validate
        verify(wifi).groupBy(GroupBy.CHANNEL);
    }

    @Test
    public void testHideWeakSignal() throws Exception {
        // execute
        fixture.hideWeakSignal(true);
        // validate
        verify(wifi).hideWeakSignal(true);
    }
*/
}