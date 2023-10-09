package com.mirongdev.demoads;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.solodroid.ads.sdk.format.AdNetwork;
import com.solodroid.ads.sdk.format.BannerAd;
import com.solodroid.ads.sdk.format.InterstitialAd;
import com.solodroid.ads.sdk.format.NativeAd;
import com.solodroid.ads.sdk.format.NativeAdView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    AdNetwork.Initialize adNetwork;
    InterstitialAd.Builder interstitialAd;
    BannerAd.Builder bannerAd;
    LinearLayout bannerAdView;

    NativeAd.Builder nativeAd;
    NativeAdView.Builder nativeAdView;
    LinearLayout nativeAdViewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAds();
        loadInterstitialAd();

        bannerAdView = findViewById(R.id.banner_ad_view);
        bannerAdView.addView(View.inflate(this, com.solodroid.ads.sdk.R.layout.view_banner_ad, null));
        loadBannerAd();

        nativeAdViewContainer = findViewById(R.id.native_ad);
        setNativeAdStyle(nativeAdViewContainer);

        loadNativeAd();
    }

    private void initAds() {
        adNetwork = new AdNetwork.Initialize(this)
                .setAdStatus(Constant.AD_STATUS)
                .setAdNetwork(Constant.AD_NETWORK)
                .setBackupAdNetwork(Constant.BACKUP_AD_NETWORK)
                .setAdMobAppId(null)
                .setStartappAppId(Constant.STARTAPP_APP_ID)
                .setUnityGameId(Constant.UNITY_GAME_ID)
                .setAppLovinSdkKey("0")
                .setIronSourceAppKey(Constant.IRONSOURCE_APP_KEY)
                .setWortiseAppId(Constant.WORTISE_APP_ID)
                .setDebug(BuildConfig.DEBUG)
                .build();
    }

    private void loadInterstitialAd() {
        Log.d(TAG, "loadInterstitialAd()");
        interstitialAd = new InterstitialAd.Builder(this)
                .setAdStatus(Constant.AD_STATUS)
                .setAdNetwork(Constant.AD_NETWORK)
                .setBackupAdNetwork(Constant.BACKUP_AD_NETWORK)
                .setAdMobInterstitialId(Constant.ADMOB_INTERSTITIAL_ID)
                .setGoogleAdManagerInterstitialId(Constant.GOOGLE_AD_MANAGER_INTERSTITIAL_ID)
                .setFanInterstitialId(Constant.FAN_INTERSTITIAL_ID)
                .setUnityInterstitialId(Constant.UNITY_INTERSTITIAL_ID)
                .setAppLovinInterstitialId(Constant.APPLOVIN_INTERSTITIAL_ID)
                .setAppLovinInterstitialZoneId(Constant.APPLOVIN_INTERSTITIAL_ZONE_ID)
                .setIronSourceInterstitialId(Constant.IRONSOURCE_INTERSTITIAL_ID)
                .setWortiseInterstitialId(Constant.WORTISE_INTERSTITIAL_ID)
                .setInterval(Constant.INTERSTITIAL_AD_INTERVAL)
                .build(() -> {
                    Log.d(TAG, "onAdDismissed");
                });
    }

    private void showInterstitialAd() {
        interstitialAd.show(() -> {
            Log.d(TAG, "onAdShowed");
        }, () -> {
            Log.d(TAG, "onAdDismissed");
        });

    }

    public void interShow(View view) {
        startActivity(new Intent(getApplicationContext(), ShowActivity.class));
        showInterstitialAd();
        Log.d(TAG, "button pencet");
    }

    private void loadBannerAd() {
        bannerAd = new BannerAd.Builder(this)
                .setAdStatus(Constant.AD_STATUS)
                .setAdNetwork(Constant.AD_NETWORK)
                .setBackupAdNetwork(Constant.BACKUP_AD_NETWORK)
                .setAdMobBannerId(Constant.ADMOB_BANNER_ID)
                .setGoogleAdManagerBannerId(Constant.GOOGLE_AD_MANAGER_BANNER_ID)
                .setFanBannerId(Constant.FAN_BANNER_ID)
                .setUnityBannerId(Constant.UNITY_BANNER_ID)
                .setAppLovinBannerId(Constant.APPLOVIN_BANNER_ID)
                .setAppLovinBannerZoneId(Constant.APPLOVIN_BANNER_ZONE_ID)
                .setIronSourceBannerId(Constant.IRONSOURCE_BANNER_ID)
                .setWortiseBannerId(Constant.WORTISE_BANNER_ID)
                .setDarkTheme(false)
                .build();
    }

    private void loadNativeAd() {
        nativeAd = new NativeAd.Builder(this)
                .setAdStatus(Constant.AD_STATUS)
                .setAdNetwork(Constant.AD_NETWORK)
                .setBackupAdNetwork(Constant.BACKUP_AD_NETWORK)
                .setAdMobNativeId(Constant.ADMOB_NATIVE_ID)
                .setAdManagerNativeId(Constant.GOOGLE_AD_MANAGER_NATIVE_ID)
                .setFanNativeId(Constant.FAN_NATIVE_ID)
                .setAppLovinNativeId(Constant.APPLOVIN_NATIVE_MANUAL_ID)
                .setAppLovinDiscoveryMrecZoneId(Constant.APPLOVIN_BANNER_MREC_ZONE_ID)
                .setWortiseNativeId(Constant.WORTISE_NATIVE_ID)
                .setNativeAdStyle(Constant.NATIVE_STYLE)
                .setNativeAdBackgroundColor(R.color.colorNativeBackgroundLight, R.color.colorNativeBackgroundDark)
                .setPadding(0, 0, 0, 0)
                .setDarkTheme(false)
                .build();
    }



    private void setNativeAdStyle(LinearLayout nativeAdView) {
        switch (Constant.NATIVE_STYLE) {
            case "news":
                nativeAdView.addView(View.inflate(this, com.solodroid.ads.sdk.R.layout.view_native_ad_news, null));
                break;
            case "radio":
                nativeAdView.addView(View.inflate(this, com.solodroid.ads.sdk.R.layout.view_native_ad_radio, null));
                break;
            case "video_small":
                nativeAdView.addView(View.inflate(this, com.solodroid.ads.sdk.R.layout.view_native_ad_video_small, null));
                break;
            case "video_large":
                nativeAdView.addView(View.inflate(this, com.solodroid.ads.sdk.R.layout.view_native_ad_video_large, null));
                break;
            default:
                nativeAdView.addView(View.inflate(this, com.solodroid.ads.sdk.R.layout.view_native_ad_medium, null));
                break;
        }
    }


}