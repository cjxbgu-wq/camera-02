// class: Lcom/vcamor/vv/MainActivity$aj$ab;
package com.vcamor.vv;
public final class MainActivity$aj$ab implements ur0 {
    public final synthetic com.vcamor.vv.MainActivity ap;

    public MainActivity$aj$ab(com.vcamor.vv.MainActivity p1)
    {
        this.ap = p1;
        return;
    }

    public static synthetic g83 ab(com.vcamor.vv.MainActivity p0)
    {
        return com.vcamor.vv.MainActivity$aj$ab.ap(p0);
    }

    public static synthetic g83 ac(com.vcamor.vv.MainActivity p0)
    {
        return com.vcamor.vv.MainActivity$aj$ab.aq(p0);
    }

    public static synthetic g83 ad(com.vcamor.vv.MainActivity p0)
    {
        return com.vcamor.vv.MainActivity$aj$ab.ar(p0);
    }

    public static synthetic g83 ae(com.vcamor.vv.MainActivity p0)
    {
        return com.vcamor.vv.MainActivity$aj$ab.as(p0);
    }

    public static synthetic g83 ah(com.vcamor.vv.MainActivity p0)
    {
        return com.vcamor.vv.MainActivity$aj$ab.at(p0);
    }

    public static synthetic g83 ai()
    {
        return com.vcamor.vv.MainActivity$aj$ab.ax();
    }

    public static final synthetic boolean ak(zm1 p0)
    {
        return com.vcamor.vv.MainActivity$aj$ab.ao(p0);
    }

    public static final synthetic void al(zm1 p0, boolean p1)
    {
        com.vcamor.vv.MainActivity$aj$ab.au(p0, p1);
        return;
    }

    public static final synthetic void am(zm1 p0, boolean p1)
    {
        com.vcamor.vv.MainActivity$aj$ab.aw(p0, p1);
        return;
    }

    public static final boolean ao(zm1 p0)
    {
        return ((Boolean) p0.getValue()).booleanValue();
    }

    public static final g83 ap(com.vcamor.vv.MainActivity p0)
    {
        p0.requestCameraPermission();
        return g83.ab;
    }

    public static final g83 aq(com.vcamor.vv.MainActivity p0)
    {
        p0.requestOverlayPermission();
        return g83.ab;
    }

    public static final g83 ar(com.vcamor.vv.MainActivity p0)
    {
        p0.startFloatingWindow();
        return g83.ab;
    }

    public static final g83 as(com.vcamor.vv.MainActivity p0)
    {
        p0.stopFloatingWindow();
        return g83.ab;
    }

    public static final g83 at(com.vcamor.vv.MainActivity p3)
    {
        com.vcamor.vv.MainActivity.access$setPickingVideo$p(p3, 1);
        com.vcamor.vv.MainActivity.access$getVideoPickerLauncher$p(p3).ab(new String[] {db0.ab(8412129879847260439), db0.ab(8412129845487522071)}));
        return g83.ab;
    }

    public static final void au(zm1 p0, boolean p1)
    {
        p0.setValue(Boolean.valueOf(p1));
        return;
    }

    public static final boolean av(zm1 p0)
    {
        return ((Boolean) p0.getValue()).booleanValue();
    }

    public static final void aw(zm1 p0, boolean p1)
    {
        p0.setValue(Boolean.valueOf(p1));
        return;
    }

    public static final g83 ax()
    {
        return g83.ab;
    }

    public final void an(m10 p24, int p25)
    {
        m10 v15_0 = p24;
        db0.ab(8412133101072732439);
        if (((p25 & 3) == 2) && (p24.au())) {
            p24.bb();
            return;
        } else {
            if (q10.bi()) {
                q10.br(-1983512044, p25, -1, db0.ab(8412132645806199063));
            }
            p24.bt(-1640593409);
            db0.ab(8412132259259142423);
            df1 v1_17 = p24.ag();
            Object v2_6 = m10.ab;
            int v5_0 = 0;
            if (v1_17 == v2_6.ab()) {
                v1_17 = gr2.aj(Boolean.FALSE, 0, 2, 0);
                p24.bj(v1_17);
            }
            df1 v1_29 = ((zm1) v1_17);
            p24.bi();
            p24.bt(-1640591138);
            db0.ab(8412132104640319767);
            int v4_9 = p24.ag();
            if (v4_9 == v2_6.ab()) {
                v4_9 = gr2.aj(Boolean.TRUE, 0, 2, 0);
                p24.bj(v4_9);
            }
            int v4_11 = ((zm1) v4_9);
            p24.bi();
            p24.bt(-1640587528);
            db0.ab(8412131950021497111);
            boolean v6_13 = p24.al(this.ap);
            boolean v7_7 = this.ap;
            boolean v8_7 = p24.ag();
            if ((v6_13) || (v8_7 == v2_6.ab())) {
                v8_7 = new com.vcamor.vv.MainActivity$aj$ab$ab(v7_7, v1_29, v4_11, 0);
                p24.bj(v8_7);
            }
            boolean v8_9 = ((ur0) v8_7);
            p24.bi();
            zh0.ad(g83.ab, v8_9, p24, 6);
            if (!com.vcamor.vv.MainActivity$aj$ab.av(v4_11)) {
                if (com.vcamor.vv.MainActivity$aj$ab.ao(v1_29)) {
                    p24.bt(683351247);
                    db0.ab(8412131417445552407);
                    df1 v1_33 = com.vcamor.vv.MainActivity.access$getCameraViewModel$p(this.ap);
                    if (v1_33 == null) {
                        x31.aw(db0.ab(8412131069553201431));
                        v1_33 = 0;
                    }
                    int v3_2 = com.vcamor.vv.MainActivity.access$getActivationViewModel$p(this.ap);
                    if (v3_2 == 0) {
                        x31.aw(db0.ab(8412131000833724695));
                        v3_2 = 0;
                    }
                    int v4_1 = com.vcamor.vv.MainActivity.access$getVideoListVM$p(this.ap);
                    if (v4_1 == 0) {
                        x31.aw(db0.ab(8412130914934378775));
                        v4_1 = 0;
                    }
                    boolean v6_2 = com.vcamor.vv.MainActivity.access$getTransformVM$p(this.ap);
                    if (!v6_2) {
                        x31.aw(db0.ab(8412130863394771223));
                        v6_2 = 0;
                    }
                    boolean v7_1 = com.vcamor.vv.MainActivity.access$getController$p(this.ap);
                    if (!v7_1) {
                        x31.aw(db0.ab(8412130811855163671));
                        v7_1 = 0;
                    }
                    boolean v8_1 = this.ap.getHasCameraPermission();
                    boolean v9_1 = this.ap.getHasOverlayPermission();
                    er0 v10_1 = this.ap.isFloatingWindowRunning();
                    er0 v11_1 = com.vcamor.vv.MainActivity.access$getPrefs$p(this.ap);
                    if (v11_1 != null) {
                        v5_0 = v11_1;
                    } else {
                        x31.aw(db0.ab(8412130764610523415));
                    }
                    int v5_1 = v5_0.getBoolean(db0.ab(8412130738840719639), 0);
                    p24.bt(-1640502278);
                    db0.ab(8412130652941373719);
                    er0 v11_8 = p24.al(this.ap);
                    er0 v13_1 = this.ap;
                    er0 v14_0 = p24.ag();
                    if ((v11_8 != null) || (v14_0 == v2_6.ab())) {
                        v14_0 = new ze1(v13_1);
                        p24.bj(v14_0);
                    }
                    er0 v14_2 = ((er0) v14_0);
                    p24.bi();
                    p24.bt(-1640499461);
                    db0.ab(8412130498322551063);
                    er0 v11_12 = p24.al(this.ap);
                    er0 v13_2 = this.ap;
                    er0 v12_1 = p24.ag();
                    if ((v11_12 != null) || (v12_1 == v2_6.ab())) {
                        v12_1 = new af1(v13_2);
                        p24.bj(v12_1);
                    }
                    er0 v11_15 = ((er0) v12_1);
                    p24.bi();
                    p24.bt(-1640496778);
                    db0.ab(8412130343703728407);
                    er0 v12_6 = p24.al(this.ap);
                    er0 v13_3 = this.ap;
                    int v25_1 = v1_33;
                    df1 v1_1 = p24.ag();
                    if ((v12_6 != null) || (v1_1 == v2_6.ab())) {
                        v1_1 = new bf1(v13_3);
                        p24.bj(v1_1);
                    }
                    int v17_2;
                    er0 v12_9 = ((er0) v1_1);
                    p24.bi();
                    p24.bt(-1640494283);
                    db0.ab(8412130189084905751);
                    er0 v13_4 = this.ap;
                    int v17_1 = p24.al(this.ap);
                    df1 v1_7 = p24.ag();
                    if (v17_1 != 0) {
                        v17_2 = v2_6;
                        v1_7 = new cf1(v13_4);
                        p24.bj(v1_7);
                    } else {
                        v17_2 = v2_6;
                        if (v1_7 == v17_2.ab()) {
                        }
                    }
                    Object v18_1;
                    er0 v13_6 = ((er0) v1_7);
                    p24.bi();
                    p24.bt(-1640491958);
                    db0.ab(8412130034466083095);
                    Object v2_3 = this.ap;
                    Object v18_0 = p24.al(this.ap);
                    df1 v1_14 = p24.ag();
                    if (v18_0 != null) {
                        v18_1 = v3_2;
                        v1_14 = new df1(v2_3);
                        p24.bj(v1_14);
                    } else {
                        v18_1 = v3_2;
                        if (v1_14 == v17_2.ab()) {
                        }
                    }
                    df1 v1_16 = ((er0) v1_14);
                    p24.bi();
                    pf1.am(v25_1, v18_1, v4_1, v6_2, v7_1, v8_1, v9_1, v10_1, v5_1, v14_2, v11_15, v12_9, v13_6, v1_16, p24, 0, 0);
                    p24.bi();
                } else {
                    p24.bt(682860269);
                    db0.ab(8412131795402674455);
                    p24.bt(-1640537057);
                    db0.ab(8412131572064375063);
                    df1 v1_21 = p24.ag();
                    if (v1_21 == v2_6.ab()) {
                        v1_21 = new ye1();
                        p24.bj(v1_21);
                    }
                    df1 v1_23 = ((er0) v1_21);
                    p24.bi();
                    _f.ab(v1_23, g00.ab.ab(), 0, 0, 0, qz.ae(1258829791, 1, new com.vcamor.vv.MainActivity$aj$ab$ac(this.ap), p24, 54), qz.ae(1381733728, 1, new com.vcamor.vv.MainActivity$aj$ab$ad(this.ap), p24, 54), 0, 0, 0, 0, 0, 0, 0, p24, 1769526, 0, 16284);
                    v15_0 = p24;
                    p24.bi();
                }
            } else {
                p24.bt(682743740);
                p24.bi();
            }
            com.vcamor.vv.MainActivity.access$UpdateDialogHost(this.ap, v15_0, 0);
            com.vcamor.vv.MainActivity.access$RestartDialogHost(this.ap, v15_0, 0);
            if (q10.bi()) {
                q10.bq();
            }
            return;
        }
    }

    public bridge synthetic Object invoke(Object p1, Object p2)
    {
        this.an(((m10) p1), ((Number) p2).intValue());
        return g83.ab;
    }
}
