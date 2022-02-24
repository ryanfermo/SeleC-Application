package com.ryanfermo.voterregistrationapp;

public class candidate {
    String Name;
    String Party;
    String Advocacy;
    String Image;

    public candidate(String name, String party, String image, String advocacy) {
        this.Name = name;
        this.Party = party;
        this.Image=image;
        this.Advocacy=advocacy;
    }

    public String getName() { return Name;
    }
    public String getParty() { return Party;
    }
    public String getAdvocacy() { return Advocacy;
    }
    public String getImage() { return Image;
    }
}

