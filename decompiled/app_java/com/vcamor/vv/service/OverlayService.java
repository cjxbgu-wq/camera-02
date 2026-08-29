// class: Lcom/vcamor/vv/service/OverlayService;
package com.vcamor.vv.service;
public final class OverlayService extends android.app.Service {
    public static final com.vcamor.vv.service.OverlayService$ab bl;
    public static final int bm;
    public static final String bn;
    public static final String bo;
    public static final String bp;
    public static final String bq;
    public android.view.WindowManager ap;
    public android.content.SharedPreferences aq;
    public android.view.View ar;
    public android.view.View as;
    public android.widget.LinearLayout at;
    public android.widget.LinearLayout au;
    public android.widget.ImageButton av;
    public android.widget.ImageButton aw;
    public android.content.BroadcastReceiver ax;
    public android.widget.ImageButton ay;
    public android.content.BroadcastReceiver az;
    public volatile boolean ba;
    public int bb;
    public int bc;
    public boolean bd;
    public boolean be;
    public boolean bf;
    public java.util.List bg;
    public int bh;
    public final g60 bi;
    public int bj;
    public int bk;

    static OverlayService()
    {
        com.vcamor.vv.service.OverlayService.bn = db0.ab(8412122428079001879);
        com.vcamor.vv.service.OverlayService.bo = db0.ab(8412122363654492439);
        com.vcamor.vv.service.OverlayService.bp = db0.ab(8412122260575277335);
        com.vcamor.vv.service.OverlayService.bq = db0.ab(8412122148906127639);
        com.vcamor.vv.service.OverlayService.bl = new com.vcamor.vv.service.OverlayService$ab(0);
        com.vcamor.vv.service.OverlayService.bm = 8;
        return;
    }

    public OverlayService()
    {
        this.ba = 1;
        this.bc = 100;
        this.bg = iu.al();
        this.bh = -1;
        this.bi = h60.ab(hd0.ac());
        return;
    }

    public static synthetic g83 ab(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bi(p0);
    }

    public static synthetic boolean ac(ia2 p0, com.vcamor.vv.service.OverlayService p1, ia2 p2, ha2 p3, ha2 p4, ga2 p5, android.view.View p6, android.view.MotionEvent p7)
    {
        return com.vcamor.vv.service.OverlayService.cn(p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public static synthetic void ad(er0 p0, android.view.View p1)
    {
        com.vcamor.vv.service.OverlayService.cr(p0, p1);
        return;
    }

    public static synthetic g83 ae(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bg(p0);
    }

    public static synthetic g83 af(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.ba(p0);
    }

    public static synthetic void ag(com.vcamor.vv.service.OverlayService p0, int p1, android.view.View p2)
    {
        com.vcamor.vv.service.OverlayService.bq(p0, p1, p2);
        return;
    }

    public static synthetic g83 ah(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.be(p0);
    }

    public static synthetic void ai(er0 p0, android.view.View p1)
    {
        com.vcamor.vv.service.OverlayService.ca(p0, p1);
        return;
    }

    public static synthetic g83 aj(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bd(p0);
    }

    public static synthetic g83 ak(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bb(p0);
    }

    public static synthetic g83 al(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bf(p0);
    }

    public static synthetic g83 am(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bn(p0);
    }

    public static synthetic g83 an(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bh(p0);
    }

    public static synthetic g83 ao(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bc(p0);
    }

    public static synthetic g83 ap(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bk(p0);
    }

    public static synthetic g83 aq(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bo(p0);
    }

    public static synthetic g83 ar(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bm(p0);
    }

    public static synthetic g83 as(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bl(p0);
    }

    public static synthetic g83 at(com.vcamor.vv.service.OverlayService p0)
    {
        return com.vcamor.vv.service.OverlayService.bj(p0);
    }

    public static final synthetic void au(com.vcamor.vv.service.OverlayService p0, boolean p1)
    {
        p0.ba = p1;
        return;
    }

    public static final synthetic void av(com.vcamor.vv.service.OverlayService p0)
    {
        p0.cy();
        return;
    }

    public static final synthetic void aw(com.vcamor.vv.service.OverlayService p0)
    {
        p0.cz();
        return;
    }

    public static synthetic void ay(com.vcamor.vv.service.OverlayService p4, int p5, int p6, int p7, int p8, boolean p9, boolean p10, boolean p11, int p12, Object p13)
    {
        if ((p12 & 1) != 0) {
            p5 = p4.bb;
        }
        if ((p12 & 2) != 0) {
            p6 = p4.bc;
        }
        String v0 = 0;
        if ((p12 & 4) != 0) {
            int v7_1 = p4.aq;
            if (v7_1 == 0) {
                x31.aw(db0.ab(8412123093798932759));
                v7_1 = 0;
            }
            p7 = v7_1.getInt(db0.ab(8412123068029128983), 0);
        }
        if ((p12 & 8) != 0) {
            com.vcamor.vv.service.OverlayService v8_1 = p4.aq;
            if (v8_1 != null) {
                v0 = v8_1;
            } else {
                x31.aw(db0.ab(8412123042259325207));
            }
            p8 = v0.getInt(db0.ab(8412123016489521431), 0);
        }
        if ((p12 & 16) != 0) {
            p9 = 0;
        }
        if ((p12 & 32) != 0) {
            p10 = 0;
        }
        int v12_2;
        int v11_1;
        int v10_1;
        com.vcamor.vv.service.OverlayService v8_4;
        int v9_1;
        com.vcamor.vv.service.OverlayService v6_1;
        int v7_3;
        int v13_6;
        if ((p12 & 64) == 0) {
            v13_6 = p11;
            v12_2 = p10;
            v10_1 = p8;
            v11_1 = p9;
            v8_4 = p6;
            v9_1 = p7;
            v6_1 = p4;
            v7_3 = p5;
        } else {
            v13_6 = 0;
            v11_1 = p9;
            v12_2 = p10;
            v9_1 = p7;
            v10_1 = p8;
            v7_3 = p5;
            v8_4 = p6;
            v6_1 = p4;
        }
        v6_1.ax(v7_3, v8_4, v9_1, v10_1, v11_1, v12_2, v13_6);
        return;
    }

    public static final g83 ba(com.vcamor.vv.service.OverlayService p0)
    {
        p0.cc();
        return g83.ab;
    }

    public static final g83 bb(com.vcamor.vv.service.OverlayService p0)
    {
        p0.ct();
        return g83.ab;
    }

    public static final g83 bc(com.vcamor.vv.service.OverlayService p0)
    {
        p0.ck();
        return g83.ab;
    }

    public static final g83 bd(com.vcamor.vv.service.OverlayService p0)
    {
        p0.cu();
        return g83.ab;
    }

    public static final g83 be(com.vcamor.vv.service.OverlayService p0)
    {
        p0.cs();
        return g83.ab;
    }

    public static final g83 bf(com.vcamor.vv.service.OverlayService p0)
    {
        p0.bw();
        return g83.ab;
    }

    public static final g83 bg(com.vcamor.vv.service.OverlayService p1)
    {
        p1.db(-25);
        return g83.ab;
    }

    public static final g83 bh(com.vcamor.vv.service.OverlayService p0)
    {
        p0.dc();
        return g83.ab;
    }

    public static final g83 bi(com.vcamor.vv.service.OverlayService p1)
    {
        p1.db(25);
        return g83.ab;
    }

    public static final g83 bj(com.vcamor.vv.service.OverlayService p0)
    {
        p0.bt();
        return g83.ab;
    }

    public static final g83 bk(com.vcamor.vv.service.OverlayService p2)
    {
        p2.cd(0, -80);
        return g83.ab;
    }

    public static final g83 bl(com.vcamor.vv.service.OverlayService p2)
    {
        p2.cd(-80, 0);
        return g83.ab;
    }

    public static final g83 bm(com.vcamor.vv.service.OverlayService p0)
    {
        p0.ce();
        return g83.ab;
    }

    public static final g83 bn(com.vcamor.vv.service.OverlayService p2)
    {
        p2.cd(80, 0);
        return g83.ab;
    }

    public static final g83 bo(com.vcamor.vv.service.OverlayService p2)
    {
        p2.cd(0, 80);
        return g83.ab;
    }

    public static final void bq(com.vcamor.vv.service.OverlayService p0, int p1, android.view.View p2)
    {
        p0.cp(p1);
        return;
    }

    public static synthetic android.widget.ImageButton bz(com.vcamor.vv.service.OverlayService p6, int p7, int p8, int p9, int p10, er0 p11, int p12, Object p13)
    {
        if ((p12 & 8) != 0) {
            p10 = 0;
        }
        return p6.bx(p7, p8, p9, p10, p11);
    }

    public static final void ca(er0 p0, android.view.View p1)
    {
        p0.invoke();
        return;
    }

    public static final boolean cn(ia2 p2, com.vcamor.vv.service.OverlayService p3, ia2 p4, ha2 p5, ha2 p6, ga2 p7, android.view.View p8, android.view.MotionEvent p9)
    {
        float v8_0 = p9.getAction();
        if (v8_0 == 0) {
            p2.ap = p3.bj;
            p4.ap = p3.bk;
            p5.ap = p9.getRawX();
            p6.ap = p9.getRawY();
            p7.ap = 0;
        } else {
            if (v8_0 == 1) {
                if (!p7.ap) {
                    p3.co();
                }
            } else {
                if (v8_0 == 2) {
                    float v8_2 = (p9.getRawX() - p5.ap);
                    float v5_3 = (p9.getRawY() - p6.ap);
                    if ((!p7.ap) && ((Math.abs(v8_2) > 1090519040) || (Math.abs(v5_3) > 1090519040))) {
                        p7.ap = 1;
                    }
                    if (p7.ap) {
                        p3.bj = (p2.ap + ((int) v8_2));
                        p3.bk = (p4.ap + ((int) v5_3));
                        p3.cx();
                    }
                }
            }
        }
        return 1;
    }

    public static final void cr(er0 p0, android.view.View p1)
    {
        p0.invoke();
        return;
    }

    public final void ax(int p4, int p5, int p6, int p7, boolean p8, boolean p9, boolean p10)
    {
        this.bb = p4;
        this.bc = p5;
        android.content.SharedPreferences$Editor v0_1 = this.aq;
        if (v0_1 == null) {
            x31.aw(db0.ab(8412123231237886231));
            v0_1 = 0;
        }
        android.content.SharedPreferences$Editor v0_0 = v0_1.edit();
        if (p8 != null) {
            v0_0.putInt(db0.ab(8412123205468082455), p4);
        }
        if (p9) {
            v0_0.putInt(db0.ab(8412123166813376791), p5);
        }
        if (p10) {
            v0_0.putInt(db0.ab(8412123145338540311), p6);
            v0_0.putInt(db0.ab(8412123119568736535), p7);
        }
        v0_0.apply();
        bp2.ab.an(p4, p5, p6, p7);
        return;
    }

    public final android.view.View az()
    {
        android.widget.LinearLayout v1_27;
        android.widget.LinearLayout v8_1 = new android.widget.LinearLayout(this);
        v8_1.setOrientation(1);
        v8_1.setBackgroundColor(-299752926);
        v8_1.setPadding(6, 6, 6, 6);
        android.widget.Button v2_1 = this.bu(32);
        int v10 = this.bu(36);
        android.widget.LinearLayout v11_3 = new android.widget.LinearLayout(this);
        v11_3.setOrientation(0);
        v11_3.setGravity(16);
        if (!l01.ab.ab(this)) {
            v1_27 = h72.al;
        } else {
            v1_27 = h72.af;
        }
        android.widget.LinearLayout v1_31;
        android.widget.LinearLayout v1_28 = com.vcamor.vv.service.OverlayService.bz(this, v1_27, v2_1, -1, 0, new av1(this), 8, 0);
        this.ay = v1_28;
        v11_3.addView(v1_28);
        if (!by1.ab.ab(this)) {
            v1_31 = h72.ac;
        } else {
            v1_31 = h72.ae;
        }
        android.widget.LinearLayout v1_33 = com.vcamor.vv.service.OverlayService.bz(this, v1_31, v2_1, -1, 0, new nu1(this), 8, 0);
        this.av = v1_33;
        v11_3.addView(v1_33);
        v11_3.addView(com.vcamor.vv.service.OverlayService.bz(this, h72.ag, v2_1, -1, 0, new ou1(this), 8, 0));
        v11_3.addView(this.cq(db0.ab(8412123424511414551), v2_1, -5592406, new pu1(this)));
        v11_3.addView(this.cq(db0.ab(8412123415921479959), v2_1, -5592406, new qu1(this)));
        v11_3.addView(this.cq(db0.ab(8412123407331545367), v2_1, -12303292, new ru1(this)));
        v8_1.addView(v11_3);
        android.widget.LinearLayout v1_44 = new android.widget.LinearLayout(this);
        v1_44.setOrientation(1);
        v1_44.setPadding(0, this.bu(4), 0, 0);
        v1_44.setVisibility(8);
        this.au = v1_44;
        x31.ae(v1_44);
        this.bp(v1_44);
        v8_1.addView(this.au);
        android.widget.LinearLayout v1_1 = new android.widget.LinearLayout(this);
        v1_1.setOrientation(1);
        v1_1.setGravity(1);
        v1_1.setPadding(0, this.bu(4), 0, 0);
        v1_1.setVisibility(8);
        this.at = v1_1;
        android.widget.LinearLayout v11_1 = new android.widget.LinearLayout(this);
        v11_1.setOrientation(0);
        v11_1.setGravity(17);
        v11_1.addView(this.cq(db0.ab(8412123398741610775), v10, -3355444, new su1(this)));
        v11_1.addView(this.cq(db0.ab(8412123390151676183), v10, -10066330, new tu1(this)));
        v11_1.addView(this.cq(db0.ab(8412123381561741591), v10, -3355444, new uu1(this)));
        android.widget.LinearLayout v1_12 = this.aq;
        if (v1_12 == null) {
            x31.aw(db0.ab(8412123372971806999));
            v1_12 = 0;
        }
        android.widget.Button v2_10 = v10;
        android.widget.LinearLayout v1_17 = com.vcamor.vv.service.OverlayService.bz(this, this.cl(v1_12.getInt(db0.ab(8412123347202003223), 0)), v2_10, -5592406, 0, new vu1(this), 8, 0);
        this.aw = v1_17;
        x31.ae(v1_17);
        v11_1.addView(v1_17);
        android.widget.LinearLayout v1_18 = this.at;
        x31.ae(v1_18);
        v1_18.addView(v11_1);
        android.widget.LinearLayout v1_19 = this.at;
        x31.ae(v1_19);
        android.widget.LinearLayout$LayoutParams v3_4 = this.cq(db0.ab(8412123299957362967), v2_10, -12303292, new bv1(this));
        fv1 v4_4 = new android.widget.LinearLayout$LayoutParams(-2, -2);
        v4_4.gravity = 1;
        v1_19.addView(v3_4, v4_4);
        android.widget.LinearLayout v1_21 = new android.widget.LinearLayout(this);
        v1_21.setOrientation(0);
        v1_21.setGravity(17);
        v1_21.addView(this.cq(db0.ab(8412123291367428375), v2_10, -12303292, new cv1(this)));
        v1_21.addView(this.cq(db0.ab(8412123282777493783), v2_10, -10066330, new dv1(this)));
        v1_21.addView(this.cq(db0.ab(8412123274187559191), v2_10, -12303292, new ev1(this)));
        android.widget.LinearLayout$LayoutParams v3_14 = this.at;
        x31.ae(v3_14);
        v3_14.addView(v1_21);
        android.widget.LinearLayout v1_24 = this.at;
        x31.ae(v1_24);
        android.widget.Button v2_11 = this.cq(db0.ab(8412123265597624599), v2_10, -12303292, new fv1(this));
        android.widget.LinearLayout$LayoutParams v3_18 = new android.widget.LinearLayout$LayoutParams(-2, -2);
        v3_18.gravity = 1;
        v1_24.addView(v2_11, v3_18);
        v8_1.addView(this.at);
        return v8_1;
    }

    public final void bp(android.widget.LinearLayout p20)
    {
        p20.removeAllViews();
        int v6_4 = 4;
        if (!this.bg.isEmpty()) {
            java.util.Iterator v2_1 = this.bg.iterator();
            int v8 = 0;
            while (v2_1.hasNext()) {
                android.widget.LinearLayout$LayoutParams v9_6 = v2_1.next();
                int v10 = (v8 + 1);
                if (v8 < 0) {
                    iu.au();
                }
                int v11_2;
                android.widget.LinearLayout$LayoutParams v9_7 = ((com.vcamor.vv.service.OverlayService$ac) v9_6);
                if (v8 != this.bh) {
                    v11_2 = 0;
                } else {
                    v11_2 = 1;
                }
                android.widget.LinearLayout$LayoutParams v15_0;
                android.widget.LinearLayout v13_1 = new android.widget.LinearLayout(this);
                v13_1.setOrientation(0);
                v13_1.setGravity(16);
                v13_1.setPadding(v6_4, 2, v6_4, 2);
                if (v11_2 == 0) {
                    v15_0 = 0;
                } else {
                    v15_0 = 1157588480;
                }
                android.widget.LinearLayout$LayoutParams v15_5;
                v13_1.setBackgroundColor(v15_0);
                v13_1.setLayoutParams(new android.widget.LinearLayout$LayoutParams(this.bu(180), -2));
                int v4_7 = new android.widget.TextView(this);
                if (v11_2 == 0) {
                    android.widget.LinearLayout$LayoutParams v15_4 = new StringBuilder();
                    v15_4.append(32);
                    v15_4.append(v10);
                    v15_5 = v15_4.toString();
                } else {
                    v15_5 = db0.ab(8412123257007690007);
                }
                android.widget.LinearLayout$LayoutParams v15_6;
                v4_7.setText(v15_5);
                if (v11_2 == 0) {
                    v15_6 = -7829368;
                } else {
                    v15_6 = -1;
                }
                int v16;
                v4_7.setTextColor(v15_6);
                v4_7.setTextSize(2, 1093664768);
                v4_7.setLayoutParams(new android.widget.LinearLayout$LayoutParams(-2, -2));
                v13_1.addView(v4_7);
                if (v9_7.ac() != ic1.aq) {
                    v16 = 0;
                } else {
                    v16 = 1;
                }
                android.widget.LinearLayout$LayoutParams v15_10;
                int v4_11 = new android.widget.ImageView(this);
                if (v16 == 0) {
                    v15_10 = h72.ak;
                } else {
                    v15_10 = h72.ad;
                }
                android.widget.LinearLayout$LayoutParams v15_11;
                v4_11.setImageResource(v15_10);
                if (v11_2 == 0) {
                    v15_11 = -7829368;
                } else {
                    v15_11 = -1;
                }
                v4_11.setColorFilter(v15_11);
                v4_11.setScaleType(android.widget.ImageView$ScaleType.FIT_CENTER);
                v4_11.setPadding(this.bu(2), 0, 0, 0);
                v4_11.setLayoutParams(new android.widget.LinearLayout$LayoutParams(this.bu(14), this.bu(14)));
                v13_1.addView(v4_11);
                int v4_1 = new android.widget.TextView(this);
                int v6_0 = v9_7.ab();
                if (v6_0.length() > 16) {
                    android.widget.LinearLayout$LayoutParams v9_2 = new StringBuilder();
                    v9_2.append(vv2.dj(v6_0, 13));
                    v9_2.append(db0.ab(8412123248417755415));
                    v6_0 = v9_2.toString();
                }
                int v6_3;
                v4_1.setText(v6_0);
                if (v11_2 == 0) {
                    v6_3 = -10066330;
                } else {
                    v6_3 = -1;
                }
                v4_1.setTextColor(v6_3);
                v4_1.setTextSize(2, 1093664768);
                v6_4 = 4;
                v4_1.setPadding(4, 0, 0, 0);
                v4_1.setLayoutParams(new android.widget.LinearLayout$LayoutParams(0, -2, 1065353216));
                v13_1.addView(v4_1);
                v13_1.setOnClickListener(new wu1(this, v8));
                p20.addView(v13_1);
                v8 = v10;
            }
            return;
        } else {
            java.util.Iterator v2_3 = new android.widget.TextView(this);
            v2_3.setText(this.getString(b82.dg));
            v2_3.setTextColor(-7829368);
            v2_3.setTextSize(2, 1093664768);
            v2_3.setPadding(4, 4, 4, 4);
            p20.addView(v2_3);
            return;
        }
    }

    public final android.app.Notification br()
    {
        android.app.Notification v0_5 = new or1(this, db0.ab(8412122578402857239)).af(this.getString(b82.cn)).ae(this.getString(b82.cm)).aj(h72.ab).ai(-1).ah(1).ab();
        x31.ag(v0_5, db0.ab(8412122475323642135));
        return v0_5;
    }

    public final void bs()
    {
        if (android.os.Build$VERSION.SDK_INT >= 26) {
            mu1.ab();
            ku1.ab(((android.app.NotificationManager) this.getSystemService(android.app.NotificationManager)), lu1.ab(db0.ab(8412122681482072343), this.getString(b82.cl), 2));
        }
        return;
    }

    public final void bt()
    {
        int v0_0 = this.aq;
        android.widget.ImageButton v1_0 = 0;
        if (v0_0 == 0) {
            x31.aw(db0.ab(8412122990719717655));
            v0_0 = 0;
        }
        int v0_3 = ((v0_0.getInt(db0.ab(8412122964949913879), 0) + 1) % 3);
        com.vcamor.vv.service.OverlayService v2_1 = this.aq;
        if (v2_1 != null) {
            v1_0 = v2_1;
        } else {
            x31.aw(db0.ab(8412122917705273623));
        }
        v1_0.edit().putInt(db0.ab(8412122891935469847), v0_3).apply();
        bp2.ab.aw(v0_3);
        com.vcamor.vv.service.OverlayService.ay(this, 0, 0, 0, 0, 0, 0, 0, 127, 0);
        android.widget.ImageButton v1_4 = this.aw;
        if (v1_4 != null) {
            v1_4.setImageResource(this.cl(v0_3));
        }
        return;
    }

    public final int bu(int p2)
    {
        return ((int) ((((float) p2) * this.getResources().getDisplayMetrics().density) + 1056964608));
    }

    public final void bv()
    {
        this.cj(this.ar);
        this.ar = 0;
        return;
    }

    public final void bw()
    {
        this.cv();
        this.cw();
        this.cj(this.as);
        this.as = 0;
        this.av = 0;
        this.ay = 0;
        this.bd = 0;
        this.be = 0;
        this.cm();
        return;
    }

    public final android.widget.ImageButton bx(int p3, int p4, int p5, int p6, er0 p7)
    {
        android.widget.ImageButton v0_1 = new android.widget.ImageButton(this);
        v0_1.setBackgroundColor(p6);
        v0_1.setImageResource(p3);
        v0_1.setColorFilter(p5);
        v0_1.setScaleType(android.widget.ImageView$ScaleType.FIT_CENTER);
        v0_1.setPadding(this.bu(6), this.bu(6), this.bu(6), this.bu(6));
        xu1 v3_3 = new android.widget.LinearLayout$LayoutParams(p4, p4);
        v3_3.setMargins(2, 2, 2, 2);
        v0_1.setLayoutParams(v3_3);
        v0_1.setOnClickListener(new xu1(p7));
        return v0_1;
    }

    public final void cb()
    {
        int v0_0 = this.aq;
        String v1 = 0;
        if (v0_0 == 0) {
            x31.aw(db0.ab(8412125116728529175));
            v0_0 = 0;
        }
        int v0_1 = v0_0.getString(db0.ab(8412125090958725399), 0);
        int v2_1 = 0;
        if (v0_1 != 0) {
            try {
                boolean v3_1 = new org.json.JSONArray(v0_1);
                int v0_3 = new java.util.ArrayList();
                int v4 = v3_1.length();
                int v5 = 0;
            } catch (Exception) {
                this.bg = iu.al();
            }
            while (v5 < v4) {
                android.net.Uri v6_0 = v3_1.getJSONObject(v5);
                ic1 v7_2 = v6_0.optString(db0.ab(8412125043714085143), db0.ab(8412125022239248663));
                x31.ag(v7_2, db0.ab(8412124996469444887));
                ic1 v7_3 = ic1.valueOf(v7_2);
                String v9_2 = v6_0.getString(db0.ab(8412124932044935447));
                x31.ag(v9_2, db0.ab(8412124910570098967));
                android.net.Uri v6_2 = android.net.Uri.parse(v6_0.getString(db0.ab(8412124846145589527)));
                x31.ag(v6_2, db0.ab(8412124828965720343));
                v0_3.add(new com.vcamor.vv.service.OverlayService$ac(v9_2, v6_2, v7_3));
                v5++;
            }
            this.bg = v0_3;
        }
        int v0_6 = this.aq;
        if (v0_6 != 0) {
            v1 = v0_6;
        } else {
            x31.aw(db0.ab(8412124781721080087));
        }
        int v0_8 = db0.ab(8412124755951276311);
        if (this.bg.isEmpty()) {
            v2_1 = -1;
        }
        this.bh = v1.getInt(v0_8, v2_1);
        return;
    }

    public final void cc()
    {
        if (this.ba) {
            l01.ab.ae(this);
            this.cz();
            return;
        } else {
            android.widget.Toast.makeText(this, b82.dk, 0).show();
            return;
        }
    }

    public final void cd(int p11, int p12)
    {
        int v1_0 = this.aq;
        int v2_0 = 0;
        if (v1_0 == 0) {
            x31.aw(db0.ab(8412122844690829591));
            v1_0 = 0;
        }
        int v3_1 = (v1_0.getInt(db0.ab(8412122818921025815), 0) + p11);
        int v1_2 = this.aq;
        if (v1_2 != 0) {
            v2_0 = v1_2;
        } else {
            x31.aw(db0.ab(8412122793151222039));
        }
        com.vcamor.vv.service.OverlayService.ay(this, 0, 0, v3_1, (v2_0.getInt(db0.ab(8412122767381418263), 0) + p12), 0, 0, 1, 51, 0);
        return;
    }

    public final void ce()
    {
        com.vcamor.vv.service.OverlayService.ay(this, 0, 0, 0, 0, 0, 0, 1, 51, 0);
        return;
    }

    public final void cf()
    {
        android.widget.LinearLayout v0 = this.au;
        if (v0 != null) {
            this.bp(v0);
        }
        return;
    }

    public final void cg()
    {
        fi.ac(this.bi, 0, 0, new com.vcamor.vv.service.OverlayService$ad(this, 0), 3, 0);
        return;
    }

    public final void ch()
    {
        if (this.ax == null) {
            com.vcamor.vv.service.OverlayService$ae v0_2 = new com.vcamor.vv.service.OverlayService$ae(this);
            this.ax = v0_2;
            hh.ad(this, v0_2, new android.content.IntentFilter(db0.ab(8412123669324550423)));
            return;
        } else {
            return;
        }
    }

    public final void ci()
    {
        if (this.az == null) {
            com.vcamor.vv.service.OverlayService$af v0_2 = new com.vcamor.vv.service.OverlayService$af(this);
            this.az = v0_2;
            hh.ad(this, v0_2, new android.content.IntentFilter(db0.ab(8412123549065466135)));
            return;
        } else {
            return;
        }
    }

    public final void cj(android.view.View p3)
    {
        try {
            if (p3 != null) {
                int v0_0 = this.ap;
                if (v0_0 == 0) {
                    x31.aw(db0.ab(8412122741611614487));
                    v0_0 = 0;
                }
                v0_0.removeView(p3);
            }
        } catch (Exception) {
        }
        return;
    }

    public final void ck()
    {
        com.vcamor.vv.service.OverlayService.ay(this, ((this.bb + 90) % 360), 0, 0, 0, 1, 0, 0, 110, 0);
        return;
    }

    public final int cl(int p2)
    {
        if (p2 == 1) {
            return h72.aj;
        } else {
            if (p2 == 2) {
                return h72.ah;
            } else {
                return h72.ai;
            }
        }
    }

    public final void cm()
    {
        if (this.ar == null) {
            android.view.View v2_0 = this.bu(44);
            int v0_7 = new android.widget.TextView(this);
            v0_7.setText(db0.ab(8412124193310560535));
            v0_7.setTextColor(-1);
            v0_7.setTextSize(2, 1094713344);
            v0_7.setGravity(17);
            android.view.WindowManager$LayoutParams v1_4 = new android.graphics.drawable.GradientDrawable();
            v1_4.setShape(1);
            v1_4.setColor(-570464768);
            v0_7.setBackground(v1_4);
            v0_7.setLayoutParams(new android.view.ViewGroup$LayoutParams(v2_0, v2_0));
            v0_7.setOnTouchListener(new zu1(new ia2(), this, new ia2(), new ha2(), new ha2(), new ga2()));
            this.ar = v0_7;
            android.view.WindowManager$LayoutParams v1_8 = new android.view.WindowManager$LayoutParams(v2_0, v2_0, this.da(), 8, -3);
            v1_8.gravity = 8388659;
            if (!this.bf) {
                int v0_6 = this.getResources().getDisplayMetrics();
                this.bj = ((v0_6.widthPixels - v2_0) - 20);
                this.bk = ((v0_6.heightPixels - v2_0) - 100);
                this.bf = 1;
            }
            v1_8.x = this.bj;
            v1_8.y = this.bk;
            int v0_13 = this.ap;
            if (v0_13 == 0) {
                x31.aw(db0.ab(8412124180425658647));
                v0_13 = 0;
            }
            v0_13.addView(this.ar, v1_8);
            return;
        } else {
            return;
        }
    }

    public final void co()
    {
        if (this.as == null) {
            this.cb();
            this.bv();
            this.as = this.az();
            this.ch();
            this.ci();
            this.cg();
            android.view.WindowManager$LayoutParams v1_1 = new android.view.WindowManager$LayoutParams(-2, -2, this.da(), 8, -3);
            v1_1.gravity = 8388659;
            v1_1.x = this.bj;
            v1_1.y = this.bk;
            int v0_4 = this.ap;
            if (v0_4 == 0) {
                x31.aw(db0.ab(8412123729454092567));
                v0_4 = 0;
            }
            v0_4.addView(this.as, v1_1);
            return;
        } else {
            return;
        }
    }

    public final void cp(int p5)
    {
        if ((p5 >= null) && (p5 < this.bg.size())) {
            com.vcamor.vv.service.OverlayService$ac v0_4 = ((com.vcamor.vv.service.OverlayService$ac) this.bg.get(p5));
            this.bh = p5;
            long v1_0 = this.aq;
            if (v1_0 == 0) {
                x31.aw(db0.ab(8412124674346897687));
                v1_0 = 0;
            }
            long v1_10;
            v1_0.edit().putInt(db0.ab(8412124648577093911), p5).apply();
            long v1_6 = new android.content.Intent(db0.ab(8412124566972715287));
            v1_6.setPackage(this.getPackageName());
            v1_6.putExtra(db0.ab(8412124455303565591), p5);
            this.sendBroadcast(v1_6);
            db0.ab(8412124408058925335);
            db0.ab(8412124343634415895);
            if (v0_4.ac() != ic1.aq) {
                v1_10 = 8412124287799841047;
            } else {
                v1_10 = 8412124313569644823;
            }
            db0.ab(v1_10);
            db0.ab(8412124262030037271);
            v0_4.ab();
            this.cf();
        }
        return;
    }

    public final android.widget.Button cq(String p3, int p4, int p5, er0 p6)
    {
        android.widget.Button v0_1 = new android.widget.Button(this);
        v0_1.setText(p3);
        v0_1.setTextColor(-1);
        v0_1.setTextSize(2, 1095761920);
        v0_1.setBackgroundColor(p5);
        v0_1.setPadding(0, 0, 0, 0);
        v0_1.setMinWidth(p4);
        v0_1.setMinHeight(p4);
        yu1 v3_2 = new android.widget.LinearLayout$LayoutParams(p4, p4);
        v3_2.setMargins(2, 2, 2, 2);
        v0_1.setLayoutParams(v3_2);
        v0_1.setOnClickListener(new yu1(p6));
        return v0_1;
    }

    public final void cs()
    {
        int v0_0 = this.bd;
        this.bd = (v0_0 ^ 1);
        android.widget.LinearLayout v1_1 = this.at;
        if (v1_1 != null) {
            int v0_1;
            if (v0_0 != 0) {
                v0_1 = 8;
            } else {
                v0_1 = 0;
            }
            v1_1.setVisibility(v0_1);
        }
        return;
    }

    public final void ct()
    {
        by1.ab.ae(this);
        this.cy();
        return;
    }

    public final void cu()
    {
        android.widget.LinearLayout v0_0 = this.be;
        this.be = (v0_0 ^ 1);
        if (v0_0 == null) {
            this.cb();
            this.cf();
        }
        android.widget.LinearLayout v0_1 = this.au;
        if (v0_1 != null) {
            int v1_1;
            if (!this.be) {
                v1_1 = 8;
            } else {
                v1_1 = 0;
            }
            v0_1.setVisibility(v1_1);
        }
        return;
    }

    public final void cv()
    {
        Object v0_0 = this.ax;
        if (v0_0 != null) {
            try {
                this.unregisterReceiver(v0_0);
                Object v0_2 = vc2.ac(g83.ab);
            } catch (Object v0_5) {
                v0_2 = vc2.ac(xc2.ab(v0_5));
            }
            vc2.ab(v0_2);
        }
        this.ax = 0;
        return;
    }

    public final void cw()
    {
        Object v0_0 = this.az;
        if (v0_0 != null) {
            try {
                this.unregisterReceiver(v0_0);
                Object v0_2 = vc2.ac(g83.ab);
            } catch (Object v0_5) {
                v0_2 = vc2.ac(xc2.ab(v0_5));
            }
            vc2.ab(v0_2);
        }
        this.az = 0;
        return;
    }

    public final void cx()
    {
        android.view.View v0 = this.ar;
        if (v0 != null) {
            android.view.WindowManager$LayoutParams v1_0 = v0.getLayoutParams();
            x31.af(v1_0, db0.ab(8412124120296116503));
            android.view.WindowManager$LayoutParams v1_1 = ((android.view.WindowManager$LayoutParams) v1_0);
            v1_1.x = this.bj;
            v1_1.y = this.bk;
            int v2_1 = this.ap;
            if (v2_1 == 0) {
                x31.aw(db0.ab(8412123789583634711));
                v2_1 = 0;
            }
            v2_1.updateViewLayout(v0, v1_1);
        }
        return;
    }

    public final void cy()
    {
        boolean vtmp1 = by1.ab.ab(this);
        android.widget.ImageButton v1 = this.av;
        if (v1 != null) {
            int v0_2;
            if (!vtmp1) {
                v0_2 = h72.ac;
            } else {
                v0_2 = h72.ae;
            }
            v1.setImageResource(v0_2);
        }
        return;
    }

    public final void cz()
    {
        int v0_2;
        if (!l01.ab.ab(this)) {
            v0_2 = h72.al;
        } else {
            v0_2 = h72.af;
        }
        int v1_1;
        if (!this.ba) {
            v1_1 = -12303292;
        } else {
            v1_1 = -1;
        }
        android.widget.ImageButton v2 = this.ay;
        if (v2 != null) {
            v2.setImageResource(v0_2);
            v2.setColorFilter(v1_1);
        }
        return;
    }

    public final int da()
    {
        if (android.os.Build$VERSION.SDK_INT < 26) {
            return 2002;
        } else {
            return 2038;
        }
    }

    public final void db(int p13)
    {
        com.vcamor.vv.service.OverlayService.ay(this, 0, p82.al((this.bc + p13), 100, 400), 0, 0, 0, 1, 0, 93, 0);
        return;
    }

    public final void dc()
    {
        com.vcamor.vv.service.OverlayService.ay(this, 0, 100, 0, 0, 0, 1, 0, 93, 0);
        return;
    }

    public android.os.IBinder onBind(android.content.Intent p1)
    {
        return 0;
    }

    public void onCreate()
    {
        super.onCreate();
        int v0_13 = this.getSystemService(db0.ab(8412125533340356887));
        x31.af(v0_13, db0.ab(8412125503275585815));
        this.ap = ((android.view.WindowManager) v0_13);
        int v0_3 = w9.ab.ab(this);
        this.aq = v0_3;
        android.app.Notification v1_0 = 0;
        if (v0_3 == 0) {
            x31.aw(db0.ab(8412125228397678871));
            v0_3 = 0;
        }
        this.bb = v0_3.getInt(db0.ab(8412125202627875095), 0);
        int v0_7 = this.aq;
        if (v0_7 != 0) {
            v1_0 = v0_7;
        } else {
            x31.aw(db0.ab(8412125163973169431));
        }
        this.bc = v1_0.getInt(db0.ab(8412125138203365655), 100);
        this.cb();
        this.bs();
        if (android.os.Build$VERSION.SDK_INT >= 26) {
            this.startForeground(1001, this.br());
        }
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        this.cv();
        h60.ae(this.bi, 0, 1, 0);
        this.cj(this.ar);
        this.cj(this.as);
        return;
    }

    public int onStartCommand(android.content.Intent p1, int p2, int p3)
    {
        this.cm();
        return 1;
    }
}
