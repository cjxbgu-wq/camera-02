// class: Lcom/vcamor/vv/MainActivity$ab$ab$ab;
package com.vcamor.vv;
public final class MainActivity$ab$ab$ab extends tx2 implements ur0 {
    public int aq;
    public synthetic Object ar;

    public MainActivity$ab$ab$ab(n40 p2)
    {
        super(2, p2);
        return;
    }

    public final Object ab(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.MainActivity$ab$ab$ab) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p2, n40 p3)
    {
        com.vcamor.vv.MainActivity$ab$ab$ab v0_1 = new com.vcamor.vv.MainActivity$ab$ab$ab(p3);
        v0_1.ar = p2;
        return v0_1;
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.ab(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p5)
    {
        z31.ad();
        if (this.aq != 0) {
            throw new IllegalStateException(db0.ab(8412076102561747223));
        } else {
            xc2.ac(p5);
            try {
                java.nio.charset.Charset v1 = rr.ac;
                vc2$ab v0_3 = db0.ab(8412076192756060439).getBytes(v1);
                x31.ag(v0_3, db0.ab(8412076162691289367));
                vc2.ac(new String(a.b.N.n1(kk2.ab.ag(17, new byte[][] {v0_3}))), v1));
            } catch (g83 v5_6) {
                vc2.ac(xc2.ab(v5_6));
            }
            return g83.ab;
        }
    }
}
