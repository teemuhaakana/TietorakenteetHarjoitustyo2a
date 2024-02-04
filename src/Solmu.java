//luokka listan solmuille
public class Solmu {
	//listan solmu koostuu kokonaisluvusta sekä viittauksista seuraavaan ja edelliseen solmuun
    int luku;
    Solmu seuraava;
    Solmu edellinen;

    //konstruktori solmujen luomista varten
    public Solmu(int luku) {
        this.luku = luku;
        this.seuraava = null;
        this.edellinen = null;
    }
}