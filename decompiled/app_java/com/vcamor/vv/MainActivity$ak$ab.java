// class: Lcom/vcamor/vv/MainActivity$ak$ab;
package com.vcamor.vv;
public final class MainActivity$ak$ab extends tx2 implements ur0 {
    public int aq;

    public MainActivity$ak$ab(n40 p2)
    {
        super(2, p2);
        return;
    }

    public final Object ab(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.MainActivity$ak$ab) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p1, n40 p2)
    {
        return new com.vcamor.vv.MainActivity$ak$ab(p2);
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.ab(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p3)
    {
        z31.ad();
        if (this.aq != 0) {
            throw new IllegalStateException(db0.ab(8412129123933016343));
        } else {
            xc2.ac(p3);
            String v0_2 = new byte[][0];
            return a.b.N.n4(kk2.ab.ag(5, v0_2));
        }
    }
}
