// class: Lcom/vcamor/vv/MainActivity$aj$ab$ab$ab;
package com.vcamor.vv;
public final class MainActivity$aj$ab$ab$ab extends tx2 implements ur0 {
    public int aq;
    public final synthetic com.vcamor.vv.MainActivity ar;
    public final synthetic zm1 as;
    public final synthetic zm1 at;

    public MainActivity$aj$ab$ab$ab(com.vcamor.vv.MainActivity p1, zm1 p2, zm1 p3, n40 p4)
    {
        this.ar = p1;
        this.as = p2;
        this.at = p3;
        super(2, p4);
        return;
    }

    public final Object ab(g60 p1, n40 p2)
    {
        return ((com.vcamor.vv.MainActivity$aj$ab$ab$ab) this.create(p1, p2)).invokeSuspend(g83.ab);
    }

    public final n40 create(Object p4, n40 p5)
    {
        return new com.vcamor.vv.MainActivity$aj$ab$ab$ab(this.ar, this.as, this.at, p5);
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        return this.ab(((g60) p1), ((n40) p2));
    }

    public final Object invokeSuspend(Object p8)
    {
        z31.ad();
        if (this.aq != 0) {
            throw new IllegalStateException(db0.ab(8412053532508606743));
        } else {
            xc2.ac(p8);
            String v0_1 = kk2.ab;
            int v3_0 = new byte[][0];
            com.vcamor.vv.MainActivity$aj$ab.al(this.as, v0_1.ad(a.b.N.n1(v0_1.ag(18, v3_0))));
            if (com.vcamor.vv.MainActivity$aj$ab.ak(this.as)) {
                if (!android.provider.Settings.canDrawOverlays(this.ar)) {
                    g83 v8_21 = new StringBuilder();
                    v8_21.append(db0.ab(8412054339962458391));
                    v8_21.append(this.ar.getPackageName());
                    v8_21.append(db0.ab(8412054288422850839));
                    java.nio.charset.Charset v4_6 = rr.ac;
                    g83 v8_23 = v8_21.toString().getBytes(v4_6);
                    x31.ag(v8_23, db0.ab(8412054172458733847));
                    new String(a.b.N.n1(v0_1.ag(17, new byte[][] {v8_23}))), v4_6);
                    com.vcamor.vv.MainActivity.access$setHasOverlayPermission(this.ar, 1);
                }
                g83 v8_29 = new StringBuilder();
                v8_29.append(db0.ab(8412054112329191703));
                v8_29.append(this.ar.getPackageName());
                v8_29.append(db0.ab(8412054060789584151));
                java.nio.charset.Charset v4_13 = rr.ac;
                g83 v8_32 = v8_29.toString().getBytes(v4_13);
                x31.ag(v8_32, db0.ab(8412053923350630679));
                new String(a.b.N.n1(v0_1.ag(17, new byte[][] {v8_32}))), v4_13);
                if (x30.ab(this.ar, db0.ab(8412053863221088535)) != 0) {
                    g83 v8_4 = new StringBuilder();
                    v8_4.append(db0.ab(8412053751551938839));
                    v8_4.append(this.ar.getPackageName());
                    v8_4.append(db0.ab(8412053708602265879));
                    g83 v8_6 = v8_4.toString().getBytes(v4_13);
                    x31.ag(v8_6, db0.ab(8412053592638148887));
                    new String(a.b.N.n1(v0_1.ag(17, new byte[][] {v8_6}))), v4_13);
                    com.vcamor.vv.MainActivity.access$setHasCameraPermission(this.ar, 1);
                }
            }
            com.vcamor.vv.MainActivity$aj$ab.am(this.at, 0);
            try {
                return com.vcamor.vv.utils.CompatCheck.ae(com.vcamor.vv.utils.CompatCheck.ab, this.ar, 0, 2, 0);
            } catch (Throwable) {
                return g83.ab;
            }
        }
    }
}
