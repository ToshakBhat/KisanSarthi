package com.example.kisansarthi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CaptureImageActivity extends AppCompatActivity {
    private ImageView imgView;
    private Button btnChange;
    private Uri imageUri;
    private ActivityResultLauncher<Uri> contract = registerForActivityResult(
            new ActivityResultContracts.TakePicture(),
            new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {
                    if (result) {
                        imgView.setImageURI(null);
                        imgView.setImageURI(imageUri);
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image);

        //String val = getIntent().getExtras().getString('Image');
        imgView = findViewById(R.id.imageView);
        btnChange = findViewById(R.id.captureButton);
        imageUri = createImageUri();
        //imgView.setImageResource(val);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
    }

    private void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        contract.launch(imageUri);
    }

    private Uri createImageUri() {
        File imageFile = new File(getApplicationContext().getFilesDir(), "camera_photo.png");
        return FileProvider.getUriForFile(
                getApplicationContext(),
                "com.example.kisansarthi.fileprovider",
                imageFile
        );
    }
}
