// class: Lcom/vcamor/vv/MainActivity$ag;
package com.vcamor.vv;
public final class MainActivity$ag implements ur0 {
    public final synthetic boolean ap;
    public final synthetic e93$ab aq;
    public final synthetic boolean ar;
    public final synthetic zm1 as;
    public final synthetic zm1 at;

    public MainActivity$ag(boolean p1, e93$ab p2, boolean p3, zm1 p4, zm1 p5)
    {
        this.ap = p1;
        this.aq = p2;
        this.ar = p3;
        this.as = p4;
        this.at = p5;
        return;
    }

    public static synthetic g83 ab(e93$ab p0, zm1 p1)
    {
        return com.vcamor.vv.MainActivity$ag.ae(p0, p1);
    }

    public static synthetic g83 ac(e93$ab p0, zm1 p1, zm1 p2)
    {
        return com.vcamor.vv.MainActivity$ag.ah(p0, p1, p2);
    }

    public static final g83 ae(e93$ab p1, zm1 p2)
    {
        c93.ab.an(p1.ae());
        com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$14(p2, 0);
        return g83.ab;
    }

    public static final g83 ah(e93$ab p0, zm1 p1, zm1 p2)
    {
        com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$17(p1, p0.ae());
        com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$14(p2, 0);
        return g83.ab;
    }

    public final void ad(m10 p20, int p21)
    {
        db0.ab(8412127663644135703);
        if (((p21 & 3) == 2) && (p20.au())) {
            p20.bb();
            return;
        } else {
            if (q10.bi()) {
                q10.br(-411611518, p21, -1, db0.ab(8412127500435378455));
            }
            if (!this.ap) {
                e93$ab v14 = this.aq;
                zm1 v15_1 = this.ar;
                er0 v1_10 = this.as;
                int v2_7 = this.at;
                db0.ab(8412127165427929367);
                int v4_8 = xf2.ac(ia.ab.ae(), j5.ab.am(), p20, 0);
                db0.ab(8412126937794662679);
                int v5_5 = u00.ab(p20, 0);
                int v6_4 = p20.bf();
                int v3_8 = l10.af(p20, uj1.ab);
                int v7_4 = i10.ad;
                int v8_3 = v7_4.ab();
                db0.ab(8412126692981526807);
                if (p20.av() == null) {
                    u00.ad();
                }
                p20.at();
                if (!p20.an()) {
                    p20.bh();
                } else {
                    p20.am(v8_3);
                }
                int v8_4 = f93.ab(p20);
                f93.ac(v8_4, v4_8, v7_4.ad());
                f93.ac(v8_4, v6_4, v7_4.af());
                int v4_10 = v7_4.ac();
                if ((v8_4.an()) || (!x31.ac(v8_4.ag(), Integer.valueOf(v5_5)))) {
                    v8_4.bj(Integer.valueOf(v5_5));
                    v8_4.ao(Integer.valueOf(v5_5), v4_10);
                }
                f93.ac(v8_4, v3_8, v7_4.ae());
                db0.ab(8412126422398587159);
                db0.ab(8412126310729437463);
                p20.bt(-1231485365);
                db0.ab(8412125967132053783);
                int v3_0 = p20.bs(v14);
                int v4_0 = p20.ag();
                if ((v3_0 != 0) || (v4_0 == m10.ab.ab())) {
                    v4_0 = new ve1(v14, v1_10);
                    p20.bj(v4_0);
                }
                int v4_2 = ((er0) v4_0);
                p20.bi();
                g00 v16 = g00.ab;
                zm1 v0_1 = v1_10;
                boolean v17_1 = v15_1;
                zm1 v15_0 = v2_7;
                pi.ad(v4_2, 0, (v15_1 ^ 1), 0, 0, 0, 0, 0, 0, v16.ag(), p20, 805306368, 506);
                p20.bt(-1231473949);
                db0.ab(8412125812513231127);
                er0 v1_3 = p20.bs(v14);
                int v2_2 = p20.ag();
                if ((v1_3 != null) || (v2_2 == m10.ab.ab())) {
                    v2_2 = new we1(v14, v15_0, v0_1);
                    p20.bj(v2_2);
                }
                er0 v1_7 = ((er0) v2_2);
                p20.bi();
                pi.ad(v1_7, 0, (v17_1 ^ 1), 0, 0, 0, 0, 0, 0, v16.ah(), p20, 805306368, 506);
                p20.bq();
            }
            if (q10.bi()) {
                q10.bq();
            }
            return;
        }
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        this.ad(((m10) p1), ((Number) p2).intValue());
        return g83.ab;
    }
}
