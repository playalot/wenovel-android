package szu.whale.wenote.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import szu.whale.wenote.R;


public class CustomProgressDialog extends ProgressDialog {
    private View view;
    
    public CustomProgressDialog(Context context) {
        super(context, R.style.theme_dialog_transparent);
        // TODO Auto-generated constructor stub
        view = View.inflate(context, R.layout.custom_progressdialog, null);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
        view = View.inflate(context, R.layout.custom_progressdialog, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);
    }

    public void setMessage(String Msg) {
        if (Msg == null || "".equals(Msg)) {
            Msg = "数据加载中";
        }
        TextView txt = (TextView) view.findViewById(R.id.tipTextView);
        if (txt != null) {
            txt.setText(Msg);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private interface BackTask {
        public void back();
    }
}
