package com.fskj.logindemo.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.fskj.logindemo.R;

/**
 * Created by Administrator on 2017/9/28 0028.
 */

public class LoginDialog extends Dialog {
    public LoginDialog(@NonNull Context context) {
        super(context, R.style.loading_dialog);
    }

    public LoginDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, R.style.loading_dialog);
    }

    protected LoginDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_dialog);

        setCanceledOnTouchOutside(false);//按空白处不能取消动画
        setCancelable(false);// 不可以用“返回键”取消
        /**
         * 设置Dialog的宽度为屏幕宽度的61.8%，高度为自适应
         */
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width= (int) (getScreenWidth()*0.618f);
        lp.height=lp.WRAP_CONTENT;
        getWindow().setAttributes(lp);
    }

    public int getScreenWidth () {
        WindowManager wm=getWindow().getWindowManager();
        DisplayMetrics outMetrics=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }
}
