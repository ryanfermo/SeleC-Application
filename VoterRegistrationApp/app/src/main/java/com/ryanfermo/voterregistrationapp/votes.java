package com.ryanfermo.voterregistrationapp;

public class votes {

    String president;
    String vicepresident;
    Integer PA,PB,VPA,VPB;
    public votes(String president, String vicepresident, Integer PA, Integer PB, Integer VPA, Integer VPB) {
        this.president = president;
        this.vicepresident = vicepresident;
        this.PA=PA;
        this.PB=PB;
        this.VPA=VPA;
        this.VPB=VPB;
    }

    public String getPresident() {
        return president;
    }

    public String getVicepresident() {
        return vicepresident;
    }

    public Number getPA() { return PA;
    }
    public Number getPB() { return PB;
    }
    public Number getVPA() { return VPA;
    }
    public Number getVPB() { return VPB;
    }
}
