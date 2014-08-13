package com.swm.push;

import javapns.communication.ConnectionToAppleServer;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;

public class Pusher {
    // apns를 이용하기위한  Apple 에서 제공하는 서버, 포트
    private static final String HOST = "gateway.push.apple.com";
    private static final int PORT = 2195;
 
    private static String iPhoneID ; // 단말기토큰;
    private static String certi ; // 인증서(경로포함 가능);
    private static String passwd ; // 인증서암호; 
 
    public static void main(String args[]) throws Exception{
  
        try{
            // javaPNS 에서 제공하는 IOS push Msg를 만들어주는 클래스
            PushNotificationPayload pushPayload = new PushNotificationPayload();
            //Alert msg
            pushPayload.addAlert("aw");
            // Badge Count
            pushPayload.addBadge(1);
            
            // 커스텀 key:value
            // Custom dictionary 확인 !!
            pushPayload.addCustomDictionary("키", "value");

            PushNotificationManager push = new PushNotificationManager();
            BasicDevice device = new BasicDevice(iPhoneID);
  
            device.setDeviceId("iPhone");
  
            System.out.println("device = " + pushPayload);
            AppleNotificationServerBasicImpl appleServerImple =
             new AppleNotificationServerBasicImpl(certi, passwd, ConnectionToAppleServer.KEYSTORE_TYPE_PKCS12, HOST, PORT);
            push.initializeConnection(appleServerImple);
  
            push.sendNotification(device, pushPayload);
            push.stopConnection();
 
            // APNS Server 로 push 이후 return
            System.out.println("attempts :" + push.getRetryAttempts());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      }
}
