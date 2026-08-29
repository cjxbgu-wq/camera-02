// class: Lcom/vcamor/vv/MainActivity$ae$ab;
package com.vcamor.vv;
public final class MainActivity$ae$ab implements eo0 {
    public final synthetic zm1 ap;
    public final synthetic zm1 aq;
    public final synthetic zm1 ar;
    public final synthetic zm1 as;

    public MainActivity$ae$ab(zm1 p1, zm1 p2, zm1 p3, zm1 p4)
    {
        this.ap = p1;
        this.aq = p2;
        this.ar = p3;
        this.as = p4;
        return;
    }

    public final Object ab(e93 p3, n40 p4)
    {
        zm1 v3_4;
        com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$23(this.ap, p3);
        if (!(p3 instanceof e93$ab)) {
            v3_4 = 0;
        } else {
            v3_4 = ((e93$ab) p3);
        }
        if (v3_4 != null) {
            if (!v3_4.ad()) {
                if ((!x31.ac(v3_4.ae(), com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$16(this.as))) && (!c93.ab.al(v3_4.ae()))) {
                    com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$20(this.aq, v3_4);
                    com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$14(this.ar, 1);
                }
            } else {
                com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$20(this.aq, v3_4);
                com.vcamor.vv.MainActivity.access$UpdateDialogHost$lambda$14(this.ar, 1);
            }
        }
        return g83.ab;
    }

    public bridge synthetic Object ad(Object p1, n40 p2)
    {
        return this.ab(((e93) p1), p2);
    }
}
