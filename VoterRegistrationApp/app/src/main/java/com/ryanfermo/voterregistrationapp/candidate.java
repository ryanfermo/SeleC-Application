package com.ryanfermo.voterregistrationapp;

public class candidate {
    String Name;
    String Party;
    String Image;
    public candidate(String name, String party, String image) {
        this.Name = name;
        this.Party = party;
        this.Image=image;
    }

    public String getName() { return Name;
    }
    public String getParty() { return Party;
    }
    public String getImage() { return Image;
    }
}

