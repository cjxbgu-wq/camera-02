// class: Lcom/vcamor/vv/MainActivity$af;
package com.vcamor.vv;
public final class MainActivity$af implements ur0 {
    public final synthetic e93$ab ap;
    public final synthetic boolean aq;

    public MainActivity$af(e93$ab p1, boolean p2)
    {
        this.ap = p1;
        this.aq = p2;
        return;
    }

    public static synthetic g83 ab(e93$ab p0)
    {
        return com.vcamor.vv.MainActivity$af.ad(p0);
    }

    public static final g83 ad(e93$ab p1)
    {
        c93.ab.ag(p1);
        return g83.ab;
    }

    public final void ac(m10 p14, int p15)
    {
        db0.ab(8412018764748345623);
        if (((p15 & 3) == 2) && (p14.au())) {
            p14.bb();
            return;
        } else {
            if (q10.bi()) {
                q10.br(1621782528, p15, -1, db0.ab(8412018545705013527));
            }
            p14.bt(2004464188);
            db0.ab(8412018210697564439);
            boolean v0_4 = p14.bs(this.ap);
            int v1_4 = this.ap;
            int v2_1 = p14.ag();
            if ((v0_4) || (v2_1 == m10.ab.ab())) {
                v2_1 = new ue1(v1_4);
                p14.bj(v2_1);
            }
            boolean v0_8 = ((er0) v2_1);
            p14.bi();
            pi.ad(v0_8, 0, (this.aq ^ 1), 0, 0, 0, 0, 0, 0, g00.ab.af(), p14, 805306368, 506);
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
