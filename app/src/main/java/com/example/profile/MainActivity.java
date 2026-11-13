package com.example.profile;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btnTelegram = findViewById(R.id.imageView3);
        ImageView btnEmail = findViewById(R.id.imageView4);
        ImageView btnGitHub = findViewById(R.id.imageView5);
        ImageView btnSteam = findViewById(R.id.imageView6);
        ImageView btnVk = findViewById(R.id.imageView7);
        ImageView btnDiscord = findViewById(R.id.imageView8);

        btnTelegram.setOnClickListener(v -> openUrl("https://t.me/oulan1"));
        btnEmail.setOnClickListener(v -> openEmail("neketke24@gmail.com"));
        btnGitHub.setOnClickListener(v -> openUrl("https://github.com/oulan1"));
        btnSteam.setOnClickListener(v -> openUrl("https://steamcommunity.com/id/oulan1/"));
        btnVk.setOnClickListener(v -> openUrl("https://vk.com/neketke1"));
        btnDiscord.setOnClickListener(v -> copyDiscord("oulan1"));
    }

    private void openUrl(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Ссылка: " + url, Toast.LENGTH_SHORT).show();
        }
    }

    private void openEmail(String email) {
        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + email));
            startActivity(intent);
        } catch (Exception e) {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard != null) {
                clipboard.setPrimaryClip(ClipData.newPlainText("Email", email));
            }
            Toast.makeText(this, "Почта скопирована: " + email, Toast.LENGTH_LONG).show();
        }
    }

    private void copyDiscord(String username) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard != null) {
            clipboard.setPrimaryClip(ClipData.newPlainText("Discord", username));
        }
        Toast.makeText(this, "Discord ник скопирован: " + username, Toast.LENGTH_LONG).show();
    }
}