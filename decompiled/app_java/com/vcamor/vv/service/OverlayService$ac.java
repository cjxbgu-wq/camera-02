// class: Lcom/vcamor/vv/service/OverlayService$ac;
package com.vcamor.vv.service;
public final class OverlayService$ac {
    public final String ab;
    public final android.net.Uri ac;
    public final ic1 ad;

    public OverlayService$ac(String p3, android.net.Uri p4, ic1 p5)
    {
        x31.ah(p3, db0.ab(8412121775243972887));
        x31.ah(p4, db0.ab(8412121753769136407));
        x31.ah(p5, db0.ab(8412121736589267223));
        this.ab = p3;
        this.ac = p4;
        this.ad = p5;
        return;
    }

    public final String ab()
    {
        return this.ab;
    }

    public final ic1 ac()
    {
        return this.ad;
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof com.vcamor.vv.service.OverlayService$ac)) {
                if (x31.ac(this.ab, ((com.vcamor.vv.service.OverlayService$ac) p5).ab)) {
                    if (x31.ac(this.ac, ((com.vcamor.vv.service.OverlayService$ac) p5).ac)) {
                        if (this.ad == ((com.vcamor.vv.service.OverlayService$ac) p5).ad) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public int hashCode()
    {
        return ((((this.ab.hashCode() * 31) + this.ac.hashCode()) * 31) + this.ad.hashCode());
    }

    public String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(db0.ab(8412121654984888599));
        v0_1.append(this.ab);
        v0_1.append(db0.ab(8412121586265411863));
        v0_1.append(this.ac);
        v0_1.append(db0.ab(8412121556200640791));
        v0_1.append(this.ad);
        v0_1.append(41);
        return v0_1.toString();
    }
}
