// class: Lcom/vcamor/vv/receiver/StatusReceiver;
package com.vcamor.vv.receiver;
public final class StatusReceiver extends android.content.BroadcastReceiver {

    static StatusReceiver()
    {
        return;
    }

    public StatusReceiver()
    {
        return;
    }

    public void onReceive(android.content.Context p9, android.content.Intent p10)
    {
        x31.ah(p9, db0.ab(8412018056078741783));
        x31.ah(p10, db0.ab(8412018021719003415));
        String v3 = p10.getStringExtra(db0.ab(8412017991654232343));
        if (v3 != null) {
            jv1.ai(jv1.ab, p9, v3, 0, 4, 0);
            return;
        } else {
            return;
        }
    }
}
