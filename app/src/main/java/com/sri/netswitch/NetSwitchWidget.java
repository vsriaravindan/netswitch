package com.sri.netswitch;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * One-tap shortcut widget: opens the SIM1 mobile network settings page
 * where the "Preferred network type" control lives (verified working on
 * Realme GT Neo 3 / Realme UI 4.0 / Android 13).
 *
 * This ROM (ColorOS/Realme) blocks WRITE_SECURE_SETTINGS and the modem
 * rejects the telephony API, so a programmatic flip is impossible without
 * root/Shizuku/accessibility. Deep-link is the maximum the platform allows.
 */
public class NetSwitchWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager mgr, int[] ids) {
        for (int id : ids) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            views.setTextViewText(R.id.status, "Opens the network mode page");
            views.setTextViewText(R.id.toggle, "Preferred network type");
            views.setOnClickPendingIntent(R.id.toggle, buildDeepLinkIntent(context));
            mgr.updateAppWidget(id, views);
        }
    }

    private PendingIntent buildDeepLinkIntent(Context context) {
        Intent intent = deepLinkIntent();
        return PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
    }

    /** Verified: lands on SIM1 detail page (with "Preferred network type") via CLEAR_TASK. */
    public static Intent deepLinkIntent() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(
                "com.android.settings",
                "com.android.settings.Settings$MobileNetworkActivity"));
        // CLEAR_TASK is essential: without it, an existing SIM-list task is
        // reused and the deep-link lands on the wrong page.
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }
}
