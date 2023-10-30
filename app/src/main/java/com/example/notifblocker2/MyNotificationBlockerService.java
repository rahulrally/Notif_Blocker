// src/main/java/com/example/notifblocker2/MyNotificationBlockerService.java
package com.example.notifblocker2;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class MyNotificationBlockerService extends NotificationListenerService {

    private String keywords;

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (keywords != null && !keywords.isEmpty()) {
            String notificationText = sbn.getNotification().tickerText.toString();
            String[] keywordArray = keywords.split(",");

            for (String keyword : keywordArray) {
                if (notificationText.contains(keyword.trim())) {
                    // Cancel the notification
                    cancelNotification(sbn.getKey());
                    break;
                }
            }
        }
    }
}
