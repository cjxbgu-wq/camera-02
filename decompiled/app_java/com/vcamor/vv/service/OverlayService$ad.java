// class: Lcom/vcamor/vv/service/OverlayService$ad;
package com.vcamor.vv.service;
public final class OverlayService$ad extends tx2 implements ur0 {
    public int aq;
    public final synthetic com.vcamor.vv.service.OverlayService ar;

    public OverlayService$ad(com.vcamor.vv.service.OverlayService p1, n40 p2)
    {
        this.ar = p1;
        super(2, p2);
        return;
    }

    public static synthetic void ab(com.vcamor.vv.service.OverlayService p0)
    {
        com.vcamor.vv.service.OverlayService$ad.am(p0);
        return;
    }

    public static final void am(com.vcamor.vv.service.OverlayService p0)
    {
        com.vcamor.vv.service.OverlayService.aw(p0);
        return;
    }

    public final Object al(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.service.OverlayService$ad) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p2, n40 p3)
    {
        return new com.vcamor.vv.service.OverlayService$ad(this.ar, p3);
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.al(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p4)
    {
        com.vcamor.vv.service.OverlayService v0_0 = z31.ad();
        gv1 v1_0 = this.aq;
        int v2 = 1;
        if (v1_0 == null) {
            xc2.ac(p4);
            gv1 v1_3 = this.ar;
            this.aq = 1;
            p4 = l01.ab.ad(v1_3, this);
            if (p4 == v0_0) {
                return v0_0;
            }
        } else {
            if (v1_0 != 1) {
                throw new IllegalStateException(db0.ab(8412121981402403095));
            } else {
                xc2.ac(p4);
            }
        }
        if (((Number) p4).intValue() == 0) {
            v2 = 0;
        }
        com.vcamor.vv.service.OverlayService.au(this.ar, v2);
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new gv1(this.ar));
        return g83.ab;
    }
}
