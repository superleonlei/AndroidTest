package com.test.androidtest.views.aes_rsa;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.androidtest.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.test.androidtest.R.id.tv_encrypt_content;

/**
 * Created by Administrator on 2017/8/30.
 */

public class AESTestActivity extends Activity {

    //32位
    private final String KEY = "b4212@7Dc8d985dA9%f&#0e3c35a209a";

    @InjectView(R.id.et_input_content)
    EditText etInputContent;
    @InjectView(R.id.btn_aes_encrypt)
    Button btnAesEncrypt;
    @InjectView(R.id.btn_aes_decrypt)
    Button btnAesDecrypt;
    @InjectView(tv_encrypt_content)
    TextView tvEncryptContent;
    @InjectView(R.id.tv_decrypt_content)
    TextView tvDecryptContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes_test);
        ButterKnife.inject(this);

        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.btn_aes_encrypt, R.id.btn_aes_decrypt})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_aes_encrypt:
                encrypt();
                break;
            case R.id.btn_aes_decrypt:
                decrypt();
                break;
        }
    }

    private void encrypt(){
        String content = etInputContent.getText().toString();
        if(TextUtils.isEmpty(content)){
            toast("内容不能为空");
            return;
        }
        try {
            String encrypted = AESUtil.encrypt(KEY, content);
            tvEncryptContent.setText(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void decrypt(){
        String content = tvEncryptContent.getText().toString();
        if(TextUtils.isEmpty(content)){
            toast("加密后内容不能为空");
            return;
        }
        try {
            String decrypted = AESUtil.decrypt(KEY, content);
            tvDecryptContent.setText(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
