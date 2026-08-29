// class: Lcom/vcamor/vv/utils/CompatCheck;
package com.vcamor.vv.utils;
public final class CompatCheck {
    public static final com.vcamor.vv.utils.CompatCheck ab;
    public static volatile boolean ac;
    public static volatile boolean ad;
    public static final String ae;
    public static final String af;
    public static final int ag;

    static CompatCheck()
    {
        com.vcamor.vv.utils.CompatCheck.ae = db0.ab(8412093630323282199);
        com.vcamor.vv.utils.CompatCheck.af = db0.ab(8412093565898772759);
        com.vcamor.vv.utils.CompatCheck.ab = new com.vcamor.vv.utils.CompatCheck();
        com.vcamor.vv.utils.CompatCheck.ag = 8;
        return;
    }

    public CompatCheck()
    {
        return;
    }

    public static synthetic org.json.JSONObject ae(com.vcamor.vv.utils.CompatCheck p0, android.content.Context p1, boolean p2, int p3, Object p4)
    {
        if ((p3 & 2) != 0) {
            p2 = 0;
        }
        return p0.ad(p1, p2);
    }

    private final native String nativeCompatCheck(android.content.res.AssetManager p0);

    public final void ab()
    {
        if ((!com.vcamor.vv.utils.CompatCheck.ac) && (!com.vcamor.vv.utils.CompatCheck.ad)) {
            try {
                System.loadLibrary(db0.ab(8412094884453732631));
                com.vcamor.vv.utils.CompatCheck.ac = 1;
                return;
            } catch (Throwable) {
                com.vcamor.vv.utils.CompatCheck.ad = 1;
            }
        }
        return;
    }

    public final org.json.JSONObject ac(android.content.Context p5)
    {
        x31.ah(p5, db0.ab(8412094824324190487));
        this.ab();
        if (com.vcamor.vv.utils.CompatCheck.ac) {
            try {
                String v5_9 = p5.getAssets();
                x31.ag(v5_9, db0.ab(8412094613870792983));
                String v5_1 = this.nativeCompatCheck(v5_9);
            } catch (String v5_2) {
                org.json.JSONObject v0_3 = new StringBuilder();
                v0_3.append(db0.ab(8412094549446283543));
                String v1_2 = v5_2.getMessage();
                if (v1_2 == null) {
                    v1_2 = v5_2.getClass().getSimpleName();
                }
                v0_3.append(v1_2);
                v0_3.append(db0.ab(8412094347582820631));
                v5_1 = v0_3.toString();
            }
            try {
                org.json.JSONObject v0_6 = new org.json.JSONObject(v5_1);
            } catch (Throwable) {
                v0_6 = new org.json.JSONObject().put(db0.ab(8412094334697918743), db0.ab(8412094300338180375)).put(db0.ab(8412094274568376599), db0.ab(8412094248798572823)).put(db0.ab(8412094223028769047), v5_1);
            }
            return v0_6;
        } else {
            String v5_8 = new org.json.JSONObject().put(db0.ab(8412094789964452119), db0.ab(8412094755604713751)).put(db0.ab(8412094729834909975), db0.ab(8412094704065106199));
            x31.ag(v5_8, db0.ab(8412094652525498647));
            return v5_8;
        }
    }

    public final org.json.JSONObject ad(android.content.Context p10, boolean p11)
    {
        x31.ah(p10, db0.ab(8412094205848899863));
        org.json.JSONObject v0_2 = this.ac(p10);
        mw1 v1_0 = v0_2.optString(db0.ab(8412094171489161495), db0.ab(8412094137129423127));
        w9.ab.ab(p10).edit().putString(db0.ab(8412094111359619351), v1_0).putString(db0.ab(8412094046935109911), v0_2.toString()).apply();
        if ((!x31.ac(v1_0, db0.ab(8412093995395502359))) && (!x31.ac(v1_0, db0.ab(8412093982510600471)))) {
            String v2_13 = new StringBuilder();
            v2_13.append(db0.ab(8412093935265960215));
            v2_13.append(v1_0);
            mk0.ab.ae(p10, nk0.ay, v2_13.toString(), eh1.ad(t53.ab(db0.ab(8412093896611254551), v0_2.toString())), p11);
        }
        return v0_2;
    }
}
