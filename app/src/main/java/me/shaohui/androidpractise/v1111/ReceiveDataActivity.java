package me.shaohui.androidpractise.v1111;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.net.URL;
import java.util.ArrayList;
import me.shaohui.androidpractise.R;
import org.w3c.dom.Text;

public class ReceiveDataActivity extends AppCompatActivity {

    private TextView mTextView;

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        mTextView = (TextView) findViewById(R.id.text_view);
        mImageView = (ImageView) findViewById(R.id.image_view);

        String action = getIntent().getAction();
        String type = getIntent().getType();

        //if (TextUtils.equals(action, Intent.ACTION_SEND)) {
        //    if (TextUtils.equals(type, "text/plain")) {
        //        String text = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        //        mTextView.setText(text);
        //    } else if (type.startsWith("image/")) {
        //        Uri uri = getIntent().getParcelableExtra(Intent.EXTRA_STREAM);
        //        mImageView.setImageURI(uri);
        //    }
        //} else if (TextUtils.equals(action, Intent.ACTION_SEND_MULTIPLE)) {
        //    ArrayList<Uri> uris = getIntent().getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        //    mImageView.setImageURI(uris.get(0));
        //    mTextView.setText(uris.size());
        //}
    }
}
