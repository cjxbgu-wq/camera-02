// class: Lcom/vcamor/vv/service/OverlayService$ae;
package com.vcamor.vv.service;
public final class OverlayService$ae extends android.content.BroadcastReceiver {
    public final synthetic com.vcamor.vv.service.OverlayService ab;

    public OverlayService$ae(com.vcamor.vv.service.OverlayService p1)
    {
        this.ab = p1;
        return;
    }

    public void onReceive(android.content.Context p3, android.content.Intent p4)
    {
        com.vcamor.vv.service.OverlayService v3_0;
        if (p4 == null) {
            v3_0 = 0;
        } else {
            v3_0 = p4.getAction();
        }
        if (x31.ac(v3_0, db0.ab(8412122101661487383))) {
            com.vcamor.vv.service.OverlayService.av(this.ab);
        }
        return;
    }
}
