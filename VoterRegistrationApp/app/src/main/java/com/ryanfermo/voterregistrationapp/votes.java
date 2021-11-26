package com.ryanfermo.voterregistrationapp;

public class votes {

    String president;
    String vicepresident;
    String secretary;
    String treasurer;
    String auditor;
    String pro;
    String representative;
    Integer PA,PB,VPA,VPB,SA,SB,TA,TB,OA,OB,PRA,PRB,RA,RB;
    public votes(String president, String vicepresident, Integer PA, Integer PB, Integer VPA, Integer VPB,String secreatry, String treasurer, Integer SA, Integer SB, Integer TA, Integer TB,String auditor, String pro, Integer OA, Integer OB, Integer PRA, Integer PRB, String representative, Integer RA, Integer RB) {
        this.president = president;
        this.vicepresident = vicepresident;
        this.secretary = secreatry;
        this.auditor = auditor;
        this.treasurer = treasurer;
        this.pro = pro;
        this.representative = representative;
        this.PA=PA;
        this.PB=PB;
        this.VPA=VPA;
        this.VPB=VPB;
        this.SA=SA;
        this.SB=SB;
        this.TA=TA;
        this.TB=TB;
        this.OA=OA;
        this.OB=OB;
        this.PRA=PRA;
        this.PRB=PRB;
        this.RA=RA;
        this.RB=RB;
    }

    public String getPresident() {
        return president;
    }

    public String getVicepresident() {
        return vicepresident;
    }
    public String getSecretary() {
        return secretary;
    }

    public String getAuditor() {
        return auditor;
    }
    public String getTreasurer() {
        return treasurer;
    }

    public String getPro() {
        return pro;
    }
    public String getRepresentative() {
        return representative;
    }


    public Number getPA() { return PA;
    }
    public Number getPB() { return PB;
    }
    public Number getVPA() { return VPA;
    }
    public Number getVPB() { return VPB;
    }
    public Number getSA() { return SA;
    }
    public Number getSB() { return SB;
    }
    public Number getTA() { return TA;
    }
    public Number getTB() { return TB;
    }
    public Number getOA() { return OA;
    }
    public Number getOB() { return OB;
    }
    public Number getPRA() { return PRA;
    }
    public Number getPRB() { return PRB;
    }
    public Number getRA() { return RA;
    }
    public Number getRB() { return RB;
    }
}
