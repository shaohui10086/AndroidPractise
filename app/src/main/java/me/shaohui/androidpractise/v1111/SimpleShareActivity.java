package me.shaohui.androidpractise.v1111;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import me.shaohui.androidpractise.R;

public class SimpleShareActivity extends AppCompatActivity {

    private String imagePath;

    private Uri imageUri = Uri.parse("content://media/external/images/media/37875");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_share);

        findViewById(R.id.btn_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //shareImage();
                shareText();
            }
        });
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 666);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            String[] selection = new String[] { MediaStore.Images.ImageColumns.DATA };
            if (data != null) {
                imageUri = data.getData();
                Cursor cursor = getContentResolver().query(imageUri, null, null, null, null);
                Log.i("TAG", cursor.getColumnIndex(selection[0]) + "");
                imagePath = cursor.getString(cursor.getColumnIndex(selection[0]));
                cursor.close();
                //Toast.makeText(this, imagePath, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveLocalImage() {

    }

    private void shareImage() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        share.setType("image/*");
        startActivity(Intent.createChooser(share, "分享试试"));
    }

    private void shareText() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_TEXT, "测试分享");
        share.setType("text/plain");
        startActivity(Intent.createChooser(share, "分享试试"));
    }

}
