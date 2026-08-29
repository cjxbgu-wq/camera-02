// class: Lcom/vcamor/vv/MainActivity;
package com.vcamor.vv;
public final class MainActivity extends hz {
    public static final int $stable = 8;
    private a0 activationViewModel;
    private final b1 cameraPermissionLauncher;
    private en cameraViewModel;
    private re3 controller;
    private final zm1 hasCameraPermission$delegate;
    private final zm1 hasOverlayPermission$delegate;
    private final zm1 isFloatingWindowRunning$delegate;
    private final zm1 justUpdatedVersion$delegate;
    private final b1 overlayPermissionLauncher;
    private boolean pickingVideo;
    private android.content.SharedPreferences prefs;
    private t43 transformVM;
    private hc3 videoListVM;
    private final b1 videoPickerLauncher;
    private final com.vcamor.vv.MainActivity$al videoSwitchReceiver;

    static MainActivity()
    {
        return;
    }

    public MainActivity()
    {
        b1 v0_0 = Boolean.FALSE;
        this.hasCameraPermission$delegate = gr2.aj(v0_0, 0, 2, 0);
        this.hasOverlayPermission$delegate = gr2.aj(v0_0, 0, 2, 0);
        this.isFloatingWindowRunning$delegate = gr2.aj(v0_0, 0, 2, 0);
        this.justUpdatedVersion$delegate = gr2.aj(0, 0, 2, 0);
        this.videoSwitchReceiver = new com.vcamor.vv.MainActivity$al(this);
        b1 v0_7 = this.registerForActivityResult(new a9(), new re1(this));
        x31.ag(v0_7, db0.ab(8412016492710646039));
        this.cameraPermissionLauncher = v0_7;
        b1 v0_10 = this.registerForActivityResult(new b0(), new ie1(this));
        x31.ag(v0_10, db0.ab(8412016359566659863));
        this.overlayPermissionLauncher = v0_10;
        b1 v0_13 = this.registerForActivityResult(new a7(), new je1(this));
        x31.ag(v0_13, db0.ab(8412016226422673687));
        this.videoPickerLauncher = v0_13;
        return;
    }

    private final void RestartDialogHost(m10 p26, int p27)
    {
        oz v4_0;
        er0 v3_5 = p26.ar(-576623134);
        db0.ab(8412015045306667287);
        if ((p27 & 6) != 0) {
            v4_0 = p27;
        } else {
            oz v4_2;
            if (!v3_5.al(this)) {
                v4_2 = 2;
            } else {
                v4_2 = 4;
            }
            v4_0 = (v4_2 | p27);
        }
        if (((v4_0 & 3) == 2) && (v3_5.au())) {
            v3_5.bb();
            oe1 v21 = v3_5;
            boolean v2_1 = v21.ay();
            if (v2_1) {
                v2_1.ab(new qe1(this, p27));
            }
        } else {
            if (q10.bi()) {
                q10.br(-576623134, v4_0, -1, db0.ab(8412014499845820695));
            }
            boolean v2_5 = this.getJustUpdatedVersion();
            if (v2_5) {
                v3_5.bt(1770220900);
                db0.ab(8412014212083011863);
                oz v4_4 = v3_5.ag();
                oz v6_6 = m10.ab;
                if (v4_4 == v6_6.ab()) {
                    v4_4 = gr2.aj(Boolean.FALSE, 0, 2, 0);
                    v3_5.bj(v4_4);
                }
                oz v4_6 = ((zm1) v4_4);
                v3_5.bi();
                v3_5.bt(1770223813);
                db0.ab(8412014057464189207);
                int v5_1 = v3_5.al(this);
                int v7_4 = v3_5.ag();
                if ((v5_1 != 0) || (v7_4 == v6_6.ab())) {
                    v7_4 = new pe1(this, v4_6);
                    v3_5.bj(v7_4);
                }
                int v7_6 = ((er0) v7_4);
                v3_5.bi();
                v21 = v3_5;
                _f.ab(v7_6, qz.ae(1942388378, 1, new com.vcamor.vv.MainActivity$ab(this, v4_6), v3_5, 54), 0, qz.ae(-963284904, 1, new com.vcamor.vv.MainActivity$ac(this, v4_6), v3_5, 54), 0, g00.ab.ae(), qz.ae(1120656117, 1, new com.vcamor.vv.MainActivity$ad(v2_5, v4_6), v3_5, 54), 0, 0, 0, 0, 0, 0, 0, v21, 1772592, 0, 16276);
                if (!q10.bi()) {
                } else {
                    q10.bq();
                }
            } else {
                if (q10.bi()) {
                    q10.bq();
                }
                boolean v2_3 = v3_5.ay();
                if (v2_3) {
                    v2_3.ab(new oe1(this, p27));
                    return;
                }
            }
        }
        return;
    }

    private static final g83 RestartDialogHost$lambda$10$lambda$9(com.vcamor.vv.MainActivity p0, zm1 p1)
    {
        if (!com.vcamor.vv.MainActivity.RestartDialogHost$lambda$7(p1)) {
            p0.setJustUpdatedVersion(0);
        }
        return g83.ab;
    }

    private static final g83 RestartDialogHost$lambda$11(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        p0.RestartDialogHost(p2, c92.ab((p1 | 1)));
        return g83.ab;
    }

    private static final g83 RestartDialogHost$lambda$5(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        p0.RestartDialogHost(p2, c92.ab((p1 | 1)));
        return g83.ab;
    }

    private static final boolean RestartDialogHost$lambda$7(zm1 p0)
    {
        return ((Boolean) p0.getValue()).booleanValue();
    }

    private static final void RestartDialogHost$lambda$8(zm1 p0, boolean p1)
    {
        p0.setValue(Boolean.valueOf(p1));
        return;
    }

    private final void UpdateDialogHost(m10 p27, int p28)
    {
        le1 v21_0;
        er0 v3_8 = p27.ar(1401976760);
        db0.ab(8412013902845366551);
        if (((p28 & 1) == 0) && (v3_8.au())) {
            v3_8.bb();
            v21_0 = v3_8;
            boolean v2_8 = v21_0.ay();
            if (v2_8) {
                v2_8.ab(new ne1(this, p28));
                return;
            }
        } else {
            if (q10.bi()) {
                q10.br(1401976760, p28, -1, db0.ab(8412013018082103575));
            }
            v3_8.bt(81040216);
            db0.ab(8412012734614262039);
            boolean v2_14 = v3_8.ag();
            oz v4_9 = m10.ab;
            int v7_1 = 0;
            if (v2_14 == v4_9.ab()) {
                v2_14 = gr2.aj(Boolean.FALSE, 0, 2, 0);
                v3_8.bj(v2_14);
            }
            long v11_3 = ((zm1) v2_14);
            v3_8.bi();
            v3_8.bt(81042368);
            db0.ab(8412012579995439383);
            boolean v2_17 = v3_8.ag();
            if (v2_17 == v4_9.ab()) {
                v2_17 = gr2.aj(0, 0, 2, 0);
                v3_8.bj(v2_17);
            }
            long v13_9 = ((zm1) v2_17);
            v3_8.bi();
            v3_8.bt(81044495);
            db0.ab(8412012425376616727);
            boolean v2_19 = v3_8.ag();
            if (v2_19 == v4_9.ab()) {
                v2_19 = gr2.aj(0, 0, 2, 0);
                v3_8.bj(v2_19);
            }
            int v10_8 = ((zm1) v2_19);
            v3_8.bi();
            v3_8.bt(81047024);
            db0.ab(8412012270757794071);
            boolean v2_21 = v3_8.ag();
            if (v2_21 == v4_9.ab()) {
                v2_21 = gr2.aj(e93$af.ab, 0, 2, 0);
                v3_8.bj(v2_21);
            }
            zm1 v12_0;
            oz v9_6 = ((zm1) v2_21);
            v3_8.bi();
            v3_8.bt(81050294);
            db0.ab(8412012116138971415);
            int v5_0 = v3_8.ag();
            if (v5_0 != v4_9.ab()) {
                v12_0 = v13_9;
            } else {
                v12_0 = v13_9;
                oz v8_0 = new com.vcamor.vv.MainActivity$ae(v9_6, v10_8, v11_3, v12_0, 0);
                v3_8.bj(v8_0);
                v5_0 = v8_0;
            }
            int v5_1 = ((ur0) v5_0);
            v3_8.bi();
            zh0.ad(g83.ab, v5_1, v3_8, 6);
            if ((com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$13(v11_3)) && (com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$19(v10_8) != null)) {
                long v15_0 = com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$19(v10_8);
                x31.ae(v15_0);
                boolean v2_2 = v9_6;
                oz v9_0 = v15_0.ad();
                int v5_2 = com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$22(v2_2);
                if ((v5_2 instanceof e93$ad)) {
                    v7_1 = ((e93$ad) v5_2);
                }
                oz v8_1;
                e93$ad v16 = v7_1;
                int v5_4 = (com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$22(v2_2) instanceof e93$ag);
                boolean v2_4 = (com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$22(v2_2) instanceof e93$ae);
                if ((v16 == null) && (v5_4 == 0)) {
                    v8_1 = 0;
                } else {
                    v8_1 = 1;
                }
                if ((v9_0 != null) || ((v8_1 == null) && (!v2_4))) {
                    oz v6_3;
                    if (v9_0 == null) {
                        v6_3 = b82.e8;
                    } else {
                        v6_3 = b82.e4;
                    }
                    int v10_0;
                    if (v9_0 == null) {
                        v10_0 = b82.e1;
                    } else {
                        v10_0 = b82.e3;
                    }
                    int v14 = v10_0;
                    v3_8.bt(81089848);
                    db0.ab(8412011961520148759);
                    int v10_2 = v3_8.ad(v9_0);
                    long v13_1 = v3_8.ag();
                    if ((v10_2 != 0) || (v13_1 == v4_9.ab())) {
                        v13_1 = new me1(v9_0, v11_3);
                        v3_8.bj(v13_1);
                    }
                    oz v4_4 = ((er0) v13_1);
                    v3_8.bi();
                    v21_0 = v3_8;
                    _f.ab(v4_4, qz.ae(1621782528, 1, new com.vcamor.vv.MainActivity$af(v15_0, v8_1), v3_8, 54), 0, qz.ae(-411611518, 1, new com.vcamor.vv.MainActivity$ag(v9_0, v15_0, v8_1, v11_3, v12_0), v3_8, 54), 0, qz.ae(1849961732, 1, new com.vcamor.vv.MainActivity$ah(v6_3), v3_8, 54), qz.ae(-1314218939, 1, new com.vcamor.vv.MainActivity$ai(v14, v15_0, v16, v5_4, v2_4), v3_8, 54), 0, 0, 0, 0, 0, 0, 0, v21_0, 1772592, 0, 16276);
                    if (!q10.bi()) {
                    } else {
                        q10.bq();
                    }
                } else {
                    com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$14(v11_3, 0);
                    if (q10.bi()) {
                        q10.bq();
                    }
                    boolean v2_11 = v3_8.ay();
                    if (v2_11) {
                        v2_11.ab(new le1(this, p28));
                        return;
                    }
                }
            } else {
                le1 v21_1 = v3_8;
                if (q10.bi()) {
                    q10.bq();
                }
                boolean v2_13 = v21_1.ay();
                if (v2_13) {
                    v2_13.ab(new ke1(this, p28));
                }
            }
        }
        return;
    }

    private static final boolean UpdateDialogHost$lambda$13(zm1 p0)
    {
        return ((Boolean) p0.getValue()).booleanValue();
    }

    private static final void UpdateDialogHost$lambda$14(zm1 p0, boolean p1)
    {
        p0.setValue(Boolean.valueOf(p1));
        return;
    }

    private static final String UpdateDialogHost$lambda$16(zm1 p0)
    {
        return ((String) p0.getValue());
    }

    private static final void UpdateDialogHost$lambda$17(zm1 p0, String p1)
    {
        p0.setValue(p1);
        return;
    }

    private static final e93$ab UpdateDialogHost$lambda$19(zm1 p0)
    {
        return ((e93$ab) p0.getValue());
    }

    private static final void UpdateDialogHost$lambda$20(zm1 p0, e93$ab p1)
    {
        p0.setValue(p1);
        return;
    }

    private static final e93 UpdateDialogHost$lambda$22(zm1 p0)
    {
        return ((e93) p0.getValue());
    }

    private static final void UpdateDialogHost$lambda$23(zm1 p0, e93 p1)
    {
        p0.setValue(p1);
        return;
    }

    private static final g83 UpdateDialogHost$lambda$25(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        p0.UpdateDialogHost(p2, c92.ab((p1 | 1)));
        return g83.ab;
    }

    private static final g83 UpdateDialogHost$lambda$26(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        p0.UpdateDialogHost(p2, c92.ab((p1 | 1)));
        return g83.ab;
    }

    private static final g83 UpdateDialogHost$lambda$28$lambda$27(boolean p0, zm1 p1)
    {
        if (p0 == null) {
            com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$14(p1, 0);
        }
        return g83.ab;
    }

    private static final g83 UpdateDialogHost$lambda$29(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        p0.UpdateDialogHost(p2, c92.ab((p1 | 1)));
        return g83.ab;
    }

    public static final synthetic void access$RestartDialogHost(com.vcamor.vv.MainActivity p0, m10 p1, int p2)
    {
        p0.RestartDialogHost(p1, p2);
        return;
    }

    public static final synthetic boolean access$RestartDialogHost$lambda$7(zm1 p0)
    {
        return com.vcamor.vv.MainActivity.RestartDialogHost$lambda$7(p0);
    }

    public static final synthetic void access$RestartDialogHost$lambda$8(zm1 p0, boolean p1)
    {
        com.vcamor.vv.MainActivity.RestartDialogHost$lambda$8(p0, p1);
        return;
    }

    public static final synthetic void access$UpdateDialogHost(com.vcamor.vv.MainActivity p0, m10 p1, int p2)
    {
        p0.UpdateDialogHost(p1, p2);
        return;
    }

    public static final synthetic void access$UpdateDialogHost$lambda$14(zm1 p0, boolean p1)
    {
        com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$14(p0, p1);
        return;
    }

    public static final synthetic String access$UpdateDialogHost$lambda$16(zm1 p0)
    {
        return com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$16(p0);
    }

    public static final synthetic void access$UpdateDialogHost$lambda$17(zm1 p0, String p1)
    {
        com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$17(p0, p1);
        return;
    }

    public static final synthetic void access$UpdateDialogHost$lambda$20(zm1 p0, e93$ab p1)
    {
        com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$20(p0, p1);
        return;
    }

    public static final synthetic void access$UpdateDialogHost$lambda$23(zm1 p0, e93 p1)
    {
        com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$23(p0, p1);
        return;
    }

    public static final synthetic a0 access$getActivationViewModel$p(com.vcamor.vv.MainActivity p0)
    {
        return p0.activationViewModel;
    }

    public static final synthetic en access$getCameraViewModel$p(com.vcamor.vv.MainActivity p0)
    {
        return p0.cameraViewModel;
    }

    public static final synthetic re3 access$getController$p(com.vcamor.vv.MainActivity p0)
    {
        return p0.controller;
    }

    public static final synthetic android.content.SharedPreferences access$getPrefs$p(com.vcamor.vv.MainActivity p0)
    {
        return p0.prefs;
    }

    public static final synthetic t43 access$getTransformVM$p(com.vcamor.vv.MainActivity p0)
    {
        return p0.transformVM;
    }

    public static final synthetic hc3 access$getVideoListVM$p(com.vcamor.vv.MainActivity p0)
    {
        return p0.videoListVM;
    }

    public static final synthetic b1 access$getVideoPickerLauncher$p(com.vcamor.vv.MainActivity p0)
    {
        return p0.videoPickerLauncher;
    }

    public static final synthetic void access$setHasCameraPermission(com.vcamor.vv.MainActivity p0, boolean p1)
    {
        p0.setHasCameraPermission(p1);
        return;
    }

    public static final synthetic void access$setHasOverlayPermission(com.vcamor.vv.MainActivity p0, boolean p1)
    {
        p0.setHasOverlayPermission(p1);
        return;
    }

    public static final synthetic void access$setJustUpdatedVersion(com.vcamor.vv.MainActivity p0, String p1)
    {
        p0.setJustUpdatedVersion(p1);
        return;
    }

    public static final synthetic void access$setPickingVideo$p(com.vcamor.vv.MainActivity p0, boolean p1)
    {
        p0.pickingVideo = p1;
        return;
    }

    public static synthetic g83 ag(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        return com.vcamor.vv.MainActivity.RestartDialogHost$lambda$5(p0, p1, p2, p3);
    }

    public static synthetic g83 ah(com.vcamor.vv.MainActivity p0, zm1 p1)
    {
        return com.vcamor.vv.MainActivity.RestartDialogHost$lambda$10$lambda$9(p0, p1);
    }

    public static synthetic void ai(com.vcamor.vv.MainActivity p0, Boolean p1)
    {
        com.vcamor.vv.MainActivity.cameraPermissionLauncher$lambda$0(p0, p1);
        return;
    }

    public static synthetic g83 aj(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        return com.vcamor.vv.MainActivity.RestartDialogHost$lambda$11(p0, p1, p2, p3);
    }

    public static synthetic g83 ak(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        return com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$26(p0, p1, p2, p3);
    }

    public static synthetic g83 al(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        return com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$25(p0, p1, p2, p3);
    }

    public static synthetic g83 am(com.vcamor.vv.MainActivity p0, int p1, m10 p2, int p3)
    {
        return com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$29(p0, p1, p2, p3);
    }

    public static synthetic void an(com.vcamor.vv.MainActivity p0, android.net.Uri p1)
    {
        com.vcamor.vv.MainActivity.videoPickerLauncher$lambda$3(p0, p1);
        return;
    }

    public static synthetic g83 ao(boolean p0, zm1 p1)
    {
        return com.vcamor.vv.MainActivity.UpdateDialogHost$lambda$28$lambda$27(p0, p1);
    }

    public static synthetic void ap(com.vcamor.vv.MainActivity p0, androidx.activity.result.ActivityResult p1)
    {
        com.vcamor.vv.MainActivity.overlayPermissionLauncher$lambda$1(p0, p1);
        return;
    }

    private static final void cameraPermissionLauncher$lambda$0(com.vcamor.vv.MainActivity p1, Boolean p2)
    {
        p1.setHasCameraPermission(p2.booleanValue());
        if (!p2.booleanValue()) {
            db0.ab(8412011355929760023);
            db0.ab(8412011300095185175);
        }
        return;
    }

    private final void continueOnCreate()
    {
        x30.ai(this, this.videoSwitchReceiver, new android.content.IntentFilter(db0.ab(8412015711026598167)), 4);
        this.setHasOverlayPermission(android.provider.Settings.canDrawOverlays(this));
        int v1_1 = this.getApplicationContext();
        x31.ag(v1_1, db0.ab(8412015599357448471));
        this.controller = new re3(v1_1);
        int v2_2 = this.getApplication();
        x31.ag(v2_2, db0.ab(8412015483393331479));
        this.cameraViewModel = ((en) new androidx.lifecycle.az(this, new fn(v2_2)).ac(en));
        oz v0_11 = ((hc3) new androidx.lifecycle.az(this).ac(hc3));
        this.videoListVM = v0_11;
        if (v0_11 == null) {
            x31.aw(db0.ab(8412015397493985559));
            v0_11 = 0;
        }
        int v2_4 = this.cameraViewModel;
        if (v2_4 == 0) {
            x31.aw(db0.ab(8412015345954378007));
            v2_4 = 0;
        }
        v0_11.ba(v2_4);
        oz v0_16 = ((t43) new androidx.lifecycle.az(this).ac(t43));
        this.transformVM = v0_16;
        if (v0_16 == null) {
            x31.aw(db0.ab(8412015277234901271));
            v0_16 = 0;
        }
        int v2_10 = this.cameraViewModel;
        if (v2_10 == 0) {
            x31.aw(db0.ab(8412015225695293719));
            v2_10 = 0;
        }
        oz v0_20;
        v0_16.av(v2_10.ay());
        if (x30.ab(this, db0.ab(8412015156975816983)) != 0) {
            v0_20 = 0;
        } else {
            v0_20 = 1;
        }
        this.setHasCameraPermission(v0_20);
        kz.ac(this, 0, qz.ac(1881295196, 1, new com.vcamor.vv.MainActivity$aj(this)), 1, 0);
        return;
    }

    private static final void overlayPermissionLauncher$lambda$1(com.vcamor.vv.MainActivity p0, androidx.activity.result.ActivityResult p1)
    {
        p0.setHasOverlayPermission(android.provider.Settings.canDrawOverlays(p0));
        return;
    }

    private final void setFloatingWindowRunning(boolean p2)
    {
        this.isFloatingWindowRunning$delegate.setValue(Boolean.valueOf(p2));
        return;
    }

    private final void setHasCameraPermission(boolean p2)
    {
        this.hasCameraPermission$delegate.setValue(Boolean.valueOf(p2));
        return;
    }

    private final void setHasOverlayPermission(boolean p2)
    {
        this.hasOverlayPermission$delegate.setValue(Boolean.valueOf(p2));
        return;
    }

    private final void setJustUpdatedVersion(String p2)
    {
        this.justUpdatedVersion$delegate.setValue(p2);
        return;
    }

    private static final void videoPickerLauncher$lambda$3(com.vcamor.vv.MainActivity p5, android.net.Uri p6)
    {
        if (p6 != null) {
            String v0 = 0;
            try {
                ic1 v1_3 = p5.getContentResolver().getType(p6);
            } catch (Exception) {
                v1_3 = 0;
            }
            if ((v1_3 == null) || (sv2.be(v1_3, db0.ab(8412011192721002775), 0, 2, 0) != 1)) {
                ic1 v1_1 = ic1.ap;
            } else {
                v1_1 = ic1.aq;
            }
            String v2_2 = p5.videoListVM;
            if (v2_2 != null) {
                v0 = v2_2;
            } else {
                x31.aw(db0.ab(8412011162656231703));
            }
            android.content.ContentResolver v5_1 = p5.getContentResolver();
            x31.ag(v5_1, db0.ab(8412011111116624151));
            v0.am(p6, v1_1, v5_1);
        }
        return;
    }

    public void attachBaseContext(android.content.Context p3)
    {
        x31.ah(p3, db0.ab(8412016093278687511));
        super.attachBaseContext(c81.ab.af(p3));
        return;
    }

    public final boolean getHasCameraPermission()
    {
        return ((Boolean) this.hasCameraPermission$delegate.getValue()).booleanValue();
    }

    public final boolean getHasOverlayPermission()
    {
        return ((Boolean) this.hasOverlayPermission$delegate.getValue()).booleanValue();
    }

    public final String getJustUpdatedVersion()
    {
        return ((String) this.justUpdatedVersion$delegate.getValue());
    }

    public final boolean isFloatingWindowRunning()
    {
        return ((Boolean) this.isFloatingWindowRunning$delegate.getValue()).booleanValue();
    }

    public void onCreate(android.os.Bundle p10)
    {
        super.onCreate(p10);
        ah0.ac(this, 0, 0, 3, 0);
        this.prefs = w9.ab.ab(this);
        ta1 v2_1 = ge1.ab(this.getPackageManager().getPackageInfo(this.getPackageName(), 0));
        android.content.SharedPreferences$Editor v0_2 = this.prefs;
        if (v0_2 == null) {
            x31.aw(db0.ab(8412016058918949143));
            v0_2 = 0;
        }
        int v7_0 = v0_2.getLong(db0.ab(8412016033149145367), 0);
        if ((v7_0 != 0) && (v7_0 != v2_1)) {
            this.setJustUpdatedVersion(db0.ab(8412015955839734039));
        }
        if (v7_0 != v2_1) {
            android.content.SharedPreferences$Editor v0_8 = this.prefs;
            if (v0_8 == null) {
                x31.aw(db0.ab(8412015930069930263));
                v0_8 = 0;
            }
            v0_8.edit().putLong(db0.ab(8412015904300126487), v2_1).apply();
        }
        vc2.ac(g83.ab);
        android.content.SharedPreferences$Editor v0_15 = kk2.ab;
        v0_15.ensureLoaded(this);
        a.b.N.n12(this.getApplicationContext());
        ta1 v2_3 = new byte[][0];
        a.b.N.n7(v0_15.ag(0, v2_3));
        android.content.SharedPreferences$Editor v0_16 = this.getApplicationContext();
        x31.ag(v0_16, db0.ab(8412015826990715159));
        c93.ab.aj(v0_16);
        this.activationViewModel = ((a0) new androidx.lifecycle.az(this).ac(a0));
        this.continueOnCreate();
        fi.ac(wa1.ab(this), 0, 0, new com.vcamor.vv.MainActivity$ak(this, 0), 3, 0);
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        try {
            this.unregisterReceiver(this.videoSwitchReceiver);
        } catch (Exception) {
        }
        return;
    }

    public void onResume()
    {
        super.onResume();
        if (!this.pickingVideo) {
            int v0_2 = this.activationViewModel;
            if (v0_2 == 0) {
                x31.aw(db0.ab(8412011806901326103));
                v0_2 = 0;
            }
            v0_2.bt();
            return;
        } else {
            this.pickingVideo = 0;
            return;
        }
    }

    public final void requestCameraPermission()
    {
        this.cameraPermissionLauncher.ab(db0.ab(8412011721001980183));
        return;
    }

    public final void requestOverlayPermission()
    {
        b1 v1_2 = db0.ab(8412011609332830487);
        android.net.Uri v2_3 = new StringBuilder();
        v2_3.append(db0.ab(8412011394584465687));
        v2_3.append(this.getPackageName());
        this.overlayPermissionLauncher.ab(new android.content.Intent(v1_2, android.net.Uri.parse(v2_3.toString())));
        return;
    }

    public final void startFloatingWindow()
    {
        if (this.getHasOverlayPermission()) {
            int v0_3 = new android.content.Intent(this, com.vcamor.vv.service.OverlayService);
            if (android.os.Build$VERSION.SDK_INT < 26) {
                this.startService(v0_3);
            } else {
                he1.ab(this, v0_3);
            }
            this.setFloatingWindowRunning(1);
        }
        return;
    }

    public final void stopFloatingWindow()
    {
        this.stopService(new android.content.Intent(this, com.vcamor.vv.service.OverlayService));
        this.setFloatingWindowRunning(0);
        return;
    }
}
