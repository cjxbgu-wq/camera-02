// class: Lcom/vcamor/vv/MainActivity$ae;
package com.vcamor.vv;
public final class MainActivity$ae extends tx2 implements ur0 {
    public int aq;
    public final synthetic zm1 ar;
    public final synthetic zm1 as;
    public final synthetic zm1 at;
    public final synthetic zm1 au;

    public MainActivity$ae(zm1 p1, zm1 p2, zm1 p3, zm1 p4, n40 p5)
    {
        this.ar = p1;
        this.as = p2;
        this.at = p3;
        this.au = p4;
        super(2, p5);
        return;
    }

    public final Object ab(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.MainActivity$ae) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p7, n40 p8)
    {
        return new com.vcamor.vv.MainActivity$ae(this.ar, this.as, this.at, this.au, p8);
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.ab(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p8)
    {
        String v0_0 = z31.ad();
        com.vcamor.vv.MainActivity$ae$ab v1_1 = this.aq;
        if (v1_1 == null) {
            xc2.ac(p8);
            w71 v8_7 = c93.ab.ai();
            com.vcamor.vv.MainActivity$ae$ab v1_0 = new com.vcamor.vv.MainActivity$ae$ab(this.ar, this.as, this.at, this.au);
            this.aq = 1;
            if (v8_7.ab(v1_0, this) == v0_0) {
                return v0_0;
            }
        } else {
            if (v1_1 == 1) {
                xc2.ac(p8);
            } else {
                throw new IllegalStateException(db0.ab(8412017944409592087));
            }
        }
        throw new w71();
    }
}
