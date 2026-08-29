// class: Lcom/vcamor/vv/MainActivity$al;
package com.vcamor.vv;
public final class MainActivity$al extends android.content.BroadcastReceiver {
    public final synthetic com.vcamor.vv.MainActivity ab;

    public MainActivity$al(com.vcamor.vv.MainActivity p1)
    {
        this.ab = p1;
        return;
    }

    public void onReceive(android.content.Context p4, android.content.Intent p5)
    {
        String v0_3;
        p4 = 0;
        if (p5 == 0) {
            v0_3 = 0;
        } else {
            v0_3 = p5.getAction();
        }
        if (x31.ac(v0_3, db0.ab(8412018975201743127))) {
            int v5_1 = p5.getIntExtra(db0.ab(8412018863532593431), -1);
            if (v5_1 >= 0) {
                String v0_4 = com.vcamor.vv.MainActivity.access$getVideoListVM$p(this.ab);
                if (v0_4 != null) {
                    p4 = v0_4;
                } else {
                    x31.aw(db0.ab(8412018816287953175));
                }
                p4.be(v5_1);
            }
        }
        return;
    }
}
