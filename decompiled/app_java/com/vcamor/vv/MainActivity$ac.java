// class: Lcom/vcamor/vv/MainActivity$ac;
package com.vcamor.vv;
public final class MainActivity$ac implements ur0 {
    public final synthetic com.vcamor.vv.MainActivity ap;
    public final synthetic zm1 aq;

    public MainActivity$ac(com.vcamor.vv.MainActivity p1, zm1 p2)
    {
        this.ap = p1;
        this.aq = p2;
        return;
    }

    public static synthetic g83 ab(com.vcamor.vv.MainActivity p0)
    {
        return com.vcamor.vv.MainActivity$ac.ad(p0);
    }

    public static final g83 ad(com.vcamor.vv.MainActivity p1)
    {
        com.vcamor.vv.MainActivity.access$setJustUpdatedVersion(p1, 0);
        return g83.ab;
    }

    public final void ac(m10 p14, int p15)
    {
        db0.ab(8412055052927029527);
        if (((p15 & 3) == 2) && (p14.au())) {
            p14.bb();
            return;
        } else {
            if (q10.bi()) {
                q10.br(-963284904, p15, -1, db0.ab(8412054833883697431));
            }
            p14.bt(-405099362);
            db0.ab(8412054494581281047);
            boolean v0_4 = p14.al(this.ap);
            int v1_4 = this.ap;
            int v2_1 = p14.ag();
            if ((v0_4) || (v2_1 == m10.ab.ab())) {
                v2_1 = new te1(v1_4);
                p14.bj(v2_1);
            }
            boolean v0_8 = ((er0) v2_1);
            p14.bi();
            pi.ad(v0_8, 0, (com.vcamor.vv.MainActivity.access$RestartDialogHost$lambda$7(this.aq) ^ 1), 0, 0, 0, 0, 0, 0, g00.ab.ad(), p14, 805306368, 506);
            if (q10.bi()) {
                q10.bq();
            }
            return;
        }
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        this.ac(((m10) p1), ((Number) p2).intValue());
        return g83.ab;
    }
}
