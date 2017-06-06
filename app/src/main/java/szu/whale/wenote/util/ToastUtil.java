package szu.whale.wenote.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import szu.whale.wenote.R;


/**
 * Toast帮助类
 * @author statham
 * @date 2017/2/9 0009 18:02
 */
public class ToastUtil {

	private static LayoutInflater mInflater;
	private static Toast mToast;
	private static View mView;

	public static void showMsgShort(Context context, String msg) {

		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void showMsgShort(Context context, int msgId) {

		Toast.makeText(context, context.getText(msgId), Toast.LENGTH_SHORT).show();
	}

	public static void showMsgLong(Context context, String msg) {
		mInflater = LayoutInflater.from(context);
		mView = mInflater.inflate(R.layout.custom_toast, null);
		TextView textView = (TextView) mView.findViewById(R.id.text);
		textView.setText(msg);
		mToast = new Toast(context);
		mToast.setView(mView);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		mToast.setDuration(Toast.LENGTH_SHORT);
		mToast.show();
	}

}
