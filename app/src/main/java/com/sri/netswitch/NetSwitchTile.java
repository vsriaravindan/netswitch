package com.sri.netswitch;

import android.service.quicksettings.TileService;

/**
 * Quick Settings tile: one tap opens the SIM1 mobile network settings page
 * (same deep-link as the widget).
 *
 * Add it: pull down the shade twice -> pencil/edit icon -> drag "NetSwitch"
 * into the tiles. Works with zero permissions.
 */
public class NetSwitchTile extends TileService {

    @Override
    public void onClick() {
        startActivityAndCollapse(NetSwitchWidget.deepLinkIntent());
    }
}
