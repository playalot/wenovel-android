//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package szu.whale.wenote.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Base {
    private static final String TAG = "Base";
    private SharedPreferences preferences_com;
    private BaseSPUtil spUtil;

    public Base() {
    }

    protected SharedPreferences getBaseSharedPreferences(Context var1) {
        try {
            if(this.preferences_com == null) {
                this.preferences_com = this.getBaseSpUtil(var1).getSharedPreferences();
            }
        } catch (Exception var3) {
            Log.i("Base", "getSharedPreferences:" + var3.getMessage());
        }

        return this.preferences_com;
    }

    public BaseSPUtil getBaseSpUtil(Context var1) {
        if(this.spUtil == null) {
            this.spUtil = new BaseSPUtil(var1);
        }

        return this.spUtil;
    }
}
