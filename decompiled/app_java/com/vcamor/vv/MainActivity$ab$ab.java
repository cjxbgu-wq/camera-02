// class: Lcom/vcamor/vv/MainActivity$ab$ab;
package com.vcamor.vv;
public final class MainActivity$ab$ab extends tx2 implements ur0 {
    public int aq;

    public MainActivity$ab$ab(n40 p2)
    {
        super(2, p2);
        return;
    }

    public final Object ab(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.MainActivity$ab$ab) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p1, n40 p2)
    {
        return new com.vcamor.vv.MainActivity$ab$ab(p2);
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.ab(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p5)
    {
        String v0_0 = z31.ad();
        com.vcamor.vv.MainActivity$ab$ab$ab v1_1 = this.aq;
        if (v1_1 == null) {
            xc2.ac(p5);
            g83 v5_5 = hd0.ac();
            com.vcamor.vv.MainActivity$ab$ab$ab v1_0 = new com.vcamor.vv.MainActivity$ab$ab$ab(0);
            this.aq = 1;
            if (fi.ae(v5_5, v1_0, this) == v0_0) {
                return v0_0;
            }
        } else {
            if (v1_1 != 1) {
                throw new IllegalStateException(db0.ab(8411879676527431959));
            } else {
                xc2.ac(p5);
            }
        }
        return g83.ab;
    }
}
