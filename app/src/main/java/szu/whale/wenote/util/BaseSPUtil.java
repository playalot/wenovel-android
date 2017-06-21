//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package szu.whale.wenote.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import szu.whale.wenote.util.encryption.AESEncryption;

public class BaseSPUtil {
    private Editor editor;
    private Context context;
    private SharedPreferences sp;

    public BaseSPUtil(Context var1) {
        this.context = var1;
    }

    public BaseSPUtil(SharedPreferences var1) {
        this.sp = var1;
    }

    protected String getSpName() {
        return BaseConstants.ConfigSP;
    }

    protected void getEditor() {
        this.getEditor(this.getSpName());
    }

    protected void getEditor(String var1) {
        try {
            if(this.editor == null) {
                this.editor = this.getSharedPreferences().edit();
            }
        } catch (Exception var3) {
            ;
        }

    }

    public SharedPreferences getSharedPreferences() {
        if(this.sp == null) {
            this.sp = this.context.getSharedPreferences(this.getSpName(), 0);
        }

        return this.sp;
    }

    public void putBoolean(String var1, boolean var2) {
        if(!StringUtils.isEmpty(var1)) {
            try {
                this.getEditor();
                if(this.editor == null) {
                    return;
                }

                this.editor.putBoolean(var1, var2);
            } catch (Exception var4) {
                ;
            }

        }
    }

    public void putString(String var1, String var2) {
        if(!StringUtils.isEmpty(var1)) {
            try {
                this.getEditor();
                if(this.editor == null) {
                    return;
                }

                this.editor.putString(var1, var2);
            } catch (Exception var4) {
                ;
            }

        }
    }

    public void putFloat(String var1, float var2) {
        if(!StringUtils.isEmpty(var1)) {
            try {
                this.getEditor();
                if(this.editor == null) {
                    return;
                }

                this.getEditor();
                if(this.editor == null) {
                    return;
                }

                this.editor.putFloat(var1, var2);
            } catch (Exception var4) {
                ;
            }

        }
    }

    public void putInt(String var1, int var2) {
        if(!StringUtils.isEmpty(var1)) {
            try {
                this.getEditor();
                if(this.editor == null) {
                    return;
                }

                this.editor.putInt(var1, var2);
            } catch (Exception var4) {
                ;
            }

        }
    }

    public void putLong(String var1, long var2) {
        if(!StringUtils.isEmpty(var1)) {
            try {
                this.getEditor();
                if(this.editor == null) {
                    return;
                }

                this.editor.putLong(var1, var2);
            } catch (Exception var5) {
                ;
            }

        }
    }

    public void commit() {
        try {
            this.getEditor();
            if(this.editor == null) {
                return;
            }

            this.editor.commit();
        } catch (Exception var2) {
            ;
        }

    }

    public Boolean getBoolean(String var1, Boolean var2) {
        try {
            return StringUtils.isEmpty(var1)?var2:Boolean.valueOf(this.getSharedPreferences().getBoolean(var1, var2.booleanValue()));
        } catch (Exception var4) {
            return var2;
        }
    }

    public static boolean getBoolean(SharedPreferences var0, String var1, Boolean var2) {
        return var0 != null && !StringUtils.isEmpty(var1)?var0.getBoolean(var1, var2.booleanValue()):var2.booleanValue();
    }

    public int getInt(String var1, int var2) {
        try {
            return StringUtils.isEmpty(var1)?var2:this.getSharedPreferences().getInt(var1, var2);
        } catch (Exception var4) {
            return var2;
        }
    }

    public static int getInt(SharedPreferences var0, String var1, int var2) {
        return var0 != null && !StringUtils.isEmpty(var1)?var0.getInt(var1, var2):var2;
    }

    public float getFloat(String var1, int var2) {
        try {
            return StringUtils.isEmpty(var1)?(float)var2:this.getSharedPreferences().getFloat(var1, (float)var2);
        } catch (Exception var4) {
            return (float)var2;
        }
    }

    public static float getFloat(SharedPreferences var0, String var1, int var2) {
        return var0 != null && !StringUtils.isEmpty(var1)?var0.getFloat(var1, (float)var2):(float)var2;
    }

    public long getLong(String var1, int var2) {
        try {
            return StringUtils.isEmpty(var1)?(long)var2:this.getSharedPreferences().getLong(var1, (long)var2);
        } catch (Exception var4) {
            return (long)var2;
        }
    }

    public static long getLong(SharedPreferences var0, String var1, int var2) {
        return var0 != null && !StringUtils.isEmpty(var1)?var0.getLong(var1, (long)var2):(long)var2;
    }

    public String getString(String var1, String var2) {
        return StringUtils.isEmpty(var1)?var2:this.getSharedPreferences().getString(var1, var2);
    }

    public static String getString(SharedPreferences var0, String var1, String var2) {
        return var0 != null && !StringUtils.isEmpty(var1)?var0.getString(var1, var2):var2;
    }

    public void putString_AES(String var1, String var2) {
        if(!StringUtils.isEmpty(var1)) {
            try {
                String var3 = AESEncryption.AESencrypt(var2, (String)null);
                this.putString(var1, var3);
            } catch (Exception var4) {
                this.putString(var1, var2);
            }

        }
    }

    public String getString_AES(String var1, String var2) {
        if(StringUtils.isEmpty(var1)) {
            return var2;
        } else {
            String var3 = null;

            try {
                var3 = this.getString(var1, var2);
                if(StringUtils.isEmpty(var3)) {
                    return var3;
                } else {
                    String var4 = AESEncryption.AESdecrypt(var3, (String)null);
                    return var4;
                }
            } catch (Exception var5) {
                return var3;
            }
        }
    }

    public static String getString_AES(SharedPreferences var0, String var1, String var2) {
        if(var0 != null && !StringUtils.isEmpty(var1)) {
            String var3 = null;

            try {
                var3 = var0.getString(var1, var2);
                if(StringUtils.isEmpty(var3)) {
                    return var3;
                } else {
                    String var4 = AESEncryption.AESdecrypt(var3, (String)null);
                    return var4;
                }
            } catch (Exception var5) {
                return var3;
            }
        } else {
            return var2;
        }
    }
}
