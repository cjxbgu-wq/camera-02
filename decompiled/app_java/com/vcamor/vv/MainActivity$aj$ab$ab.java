// class: Lcom/vcamor/vv/MainActivity$aj$ab$ab;
package com.vcamor.vv;
public final class MainActivity$aj$ab$ab extends tx2 implements ur0 {
    public int aq;
    public final synthetic com.vcamor.vv.MainActivity ar;
    public final synthetic zm1 as;
    public final synthetic zm1 at;

    public MainActivity$aj$ab$ab(com.vcamor.vv.MainActivity p1, zm1 p2, zm1 p3, n40 p4)
    {
        this.ar = p1;
        this.as = p2;
        this.at = p3;
        super(2, p4);
        return;
    }

    public final Object ab(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.MainActivity$aj$ab$ab) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p4, n40 p5)
    {
        return new com.vcamor.vv.MainActivity$aj$ab$ab(this.ar, this.as, this.at, p5);
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.ab(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p8)
    {
        String v0_0 = z31.ad();
        com.vcamor.vv.MainActivity$aj$ab$ab$ab v1_1 = this.aq;
        if (v1_1 == null) {
            xc2.ac(p8);
            g83 v8_6 = hd0.ac();
            com.vcamor.vv.MainActivity$aj$ab$ab$ab v1_0 = new com.vcamor.vv.MainActivity$aj$ab$ab$ab(this.ar, this.as, this.at, 0);
            this.aq = 1;
            if (fi.ae(v8_6, v1_0, this) == v0_0) {
                return v0_0;
            }
        } else {
            if (v1_1 != 1) {
                throw new IllegalStateException(db0.ab(8412011008037409047));
            } else {
                xc2.ac(p8);
            }
        }
        c93.ab.af();
        return g83.ab;
    }
}
