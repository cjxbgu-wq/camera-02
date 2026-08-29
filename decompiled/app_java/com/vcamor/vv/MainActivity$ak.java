// class: Lcom/vcamor/vv/MainActivity$ak;
package com.vcamor.vv;
public final class MainActivity$ak extends tx2 implements ur0 {
    public int aq;
    public final synthetic com.vcamor.vv.MainActivity ar;

    public MainActivity$ak(com.vcamor.vv.MainActivity p1, n40 p2)
    {
        this.ar = p1;
        super(2, p2);
        return;
    }

    public final Object ab(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.MainActivity$ak) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p2, n40 p3)
    {
        return new com.vcamor.vv.MainActivity$ak(this.ar, p3);
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.ab(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p5)
    {
        String v0_0 = z31.ad();
        com.vcamor.vv.MainActivity$ak$ab v1_1 = this.aq;
        String v2 = 0;
        int v3 = 1;
        if (v1_1 == null) {
            xc2.ac(p5);
            g83 v5_5 = hd0.ac();
            com.vcamor.vv.MainActivity$ak$ab v1_0 = new com.vcamor.vv.MainActivity$ak$ab(0);
            this.aq = 1;
            p5 = fi.ae(v5_5, v1_0, this);
            if (p5 == v0_0) {
                return v0_0;
            }
        } else {
            if (v1_1 != 1) {
                throw new IllegalStateException(db0.ab(8412128831875240215));
            } else {
                xc2.ac(p5);
            }
        }
        if ((p5 instanceof byte[])) {
            if (((byte[]) p5).length != 0) {
                v3 = 0;
            }
            if (v3 == 0) {
                String v0_6 = com.vcamor.vv.MainActivity.access$getActivationViewModel$p(this.ar);
                if (v0_6 != null) {
                    v2 = v0_6;
                } else {
                    x31.aw(db0.ab(8412128917774586135));
                }
                v2.bx(((byte[]) p5));
            }
        }
        return g83.ab;
    }
}
