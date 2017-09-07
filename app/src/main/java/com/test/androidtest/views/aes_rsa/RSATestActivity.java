package com.test.androidtest.views.aes_rsa;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.androidtest.R;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/30.
 */

public class RSATestActivity extends Activity {

    @InjectView(R.id.et_input_content)
    EditText etInputContent;
    @InjectView(R.id.btn_aes_encrypt)
    Button btnAesEncrypt;
    @InjectView(R.id.btn_aes_decrypt)
    Button btnAesDecrypt;
    @InjectView(R.id.tv_encrypt_content)
    TextView tvEncryptContent;
    @InjectView(R.id.tv_decrypt_content)
    TextView tvDecryptContent;
    @InjectView(R.id.tv_rsa_info)
    TextView tvRsaInfo;
    @InjectView(R.id.btn_rsa_create)
    Button btnRsaCreate;
    @InjectView(R.id.btn_rsa_encrypt_public)
    Button btnRsaEncryptPublic;
    @InjectView(R.id.btn_rsa_decrypt_public)
    Button btnRsaDecryptPublic;
    @InjectView(R.id.btn_rsa_encrypt_private)
    Button btnRsaEncryptPrivate;
    @InjectView(R.id.btn_rsa_decrypt_private)
    Button btnRsaDecryptPrivate;
    @InjectView(R.id.btn_rsa_verify)
    Button btnRsaVerify;

    private KeyPair pair;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa_test);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_aes_encrypt, R.id.btn_aes_decrypt,
            R.id.btn_rsa_encrypt_public, R.id.btn_rsa_decrypt_public,
            R.id.btn_rsa_encrypt_private, R.id.btn_rsa_decrypt_private,
            R.id.btn_rsa_create, R.id.btn_rsa_verify})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aes_encrypt:
                break;
            case R.id.btn_aes_decrypt:
                break;
            case R.id.btn_rsa_encrypt_public:
                encryptRSAPublic();
                break;
            case R.id.btn_rsa_decrypt_public:
                decryptRSAPublic();
                break;
            case R.id.btn_rsa_encrypt_private:
                encryptRSAPrivate();
                break;
            case R.id.btn_rsa_decrypt_private:
                decryptRSAPrivate();
                break;
            case R.id.btn_rsa_create:
                showKeypair();
                break;
            case R.id.btn_rsa_verify:
                showVerify();
                break;
        }
    }

    private void encryptRSAPublic() {
        String content = etInputContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            toast("输入内容不能为空");
            return;
        }
        if (null == pair) {
            toast("先生成非对称的RSA密钥对");
            return;
        }
        String encrypted = null;
        try {
            encrypted = RSAUtil.pubKeyEnc(content, getBase64encodeKey(pair.getPublic()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvEncryptContent.setText(encrypted);
    }

    private void decryptRSAPublic() {
        String content = tvEncryptContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            toast("解密内容不能为空");
            return;
        }
        if (null == pair) {
            toast("先生成非对称的RSA密钥对");
            return;
        }
        String decrypted = null;
        try {
            decrypted = RSAUtil.pubKeyDec(content, getBase64encodeKey(pair.getPublic()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvDecryptContent.setText(decrypted);
    }

    private void encryptRSAPrivate() {
        String content = etInputContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            toast("输入内容不能为空");
            return;
        }
        if (null == pair) {
            toast("先生成非对称的RSA密钥对");
            return;
        }
        String encrypted = null;
        try {
            encrypted = RSAUtil.privKeyEnc(content, getBase64encodeKey(pair.getPrivate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvEncryptContent.setText(encrypted);
    }

    private void decryptRSAPrivate() {
        String content = tvEncryptContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            toast("解密内容不能为空");
            return;
        }
        if (null == pair) {
            toast("先生成非对称的RSA密钥对");
            return;
        }
        String decrypted = null;
        try {
            decrypted = RSAUtil.privKeyDec(content, getBase64encodeKey(pair.getPrivate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvDecryptContent.setText(decrypted);
    }

    private void showVerify(){
        String content = tvEncryptContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            toast("解密内容不能为空");
            return;
        }
        if (null == pair) {
            toast("先生成非对称的RSA密钥对");
            return;
        }
        String sign = RSAUtil.sign(content, getBase64encodeKey(pair.getPrivate()));
        Log.e("sign", "签名:\r" + sign);
        boolean status = RSAUtil.verify(content, getBase64encodeKey(pair.getPublic()), sign);
        Log.e("sign", "状态:\r" + status);
    }

    private String getBase64encodeKey(Key key){
        return new String(Base64.encode(key.getEncoded(), Base64.DEFAULT));
    }

    private void showKeypair() {
        pair = RSAUtil.createKeyPairs();
        if (null != pair) {
            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();
            try {
                tvRsaInfo.setText(
                        "public key:" + new String(publicKey.getEncoded(), "UTF-8")
                                + new String(privateKey.getEncoded(), "UTF-8") + "\n" +
                                "Base64:\npublic key : "
                                + new String(Base64.encode(publicKey.getEncoded(), Base64.DEFAULT))
                                + "\nprivate key: "
                                + new String(Base64.encode(privateKey.getEncoded(), Base64.DEFAULT)));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
