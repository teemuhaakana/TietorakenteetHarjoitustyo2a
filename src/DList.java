//luokka kahteen suuntaan ketjutetulle rengaslistalle
public class DList {
	//listan ensimmäinen ja viimeinen solmu tallennetaan muuttujiin
	private Solmu ensimmainen;
    private Solmu viimeinen;
    
    //parametritön konstruktori listan luomiselle
    public DList() {
        this.ensimmainen = null;
        this.viimeinen = null;
    }
    //metodi, jolla lisätään parametrinä annettu luku i listaan
    //lisää luvun listan loppuun
    public void insert(int i) {
    	//tarkistetaan löytyykö lisättävä luku listasta, koska ei saa sisältää samaa lukua kahta kertaa
    	if (find(i) != -1) {
    		//jos löytyy, ilmoitetaan siitä ja lopetetaan metodin suorittaminen
    	        System.out.println("Annettu luku on jo listassa, lukua ei lisätty");
    	        return;
    	}
    	//luodaan uusi solmu, jonka luvuksi asetetaan luku i
        Solmu solmu = new Solmu(i);
        //jos lista on tyhjä, asetetaan lisätty solmu listan ensimmäiseksi ja viimeiseksi solmuksi
        if (ensimmainen == null) {
            ensimmainen = solmu;
            viimeinen = solmu;
        } else {
        	//asetetaan listan viimeiseen solmuun viittaus seuraavaan solmuun lisättävästä solmusta
            viimeinen.seuraava = solmu;
            //lisättävä solmu asetetaan viittaamaan siihen solmuun, joka oli viimeinen solmu listassa ennen lisäämistä
            solmu.edellinen = viimeinen;
            //asetetaan listan viimeiseksi solmuksi lisätty solmu
            viimeinen = solmu;
        }
    }
    //parametrinä luku j, joka etsitään listasta ja jonka indeksi palautetaan
    public int find(int j) {
    	//lähdetään liikkeelle ensimmäisestä solmusta
        Solmu nykyinen = ensimmainen;
        //indeksi listan läpi käymistä varten
        int indeksi = 0;
        while (nykyinen != null) {
        	//jos nykyisen solmun sisältämä luku vastaa etsittävää lukua, palautetaan solmun indeksi
            if (nykyinen.luku == j) {
                return indeksi;
            }
            //muuten mennään seuraavaan solmuun ja kasvatetaan indeksiä
            nykyinen = nykyinen.seuraava;
            indeksi++;
        }
        //palauttaa arvon -1 mikäli etsittävää lukua ei ole listassa
        return -1;
    }
    //metodi, joka poistaa solmun, joka sisältää annetun luvun
    public void delete(int k) {
    	//asetetaan muuttuja osoittamaan ensimmäiseen solmuun listassa
        Solmu poistettava = ensimmainen;
        while (poistettava != null) {
        	//tarkistetaan onko nykyisen solmun sisältämä luku sama kuin poistettava luku, hyödynnetään find metodia
            if (poistettava.luku == k) {
            	//jos poistettava solmu ei ole listan ensimmäinen niin muutetaan edellisen solmun viittaus seuraavaan solmuun
                if (poistettava.edellinen != null) {
                    poistettava.edellinen.seuraava = poistettava.seuraava;
                } else {
                	//poistettavan luvun sisältämän solmun ollessa listan ensimmäinen solmu, asetetaan poistettavasta seuraava solmu listan ensimmäiseksi
                    ensimmainen = poistettava.seuraava;
                }
                //jos poistettava solmu ei ole listan viimeinen niin muutetaan seuraavan solmun viittaus edelliseen solmuun
                if (poistettava.seuraava != null) {
                    poistettava.seuraava.edellinen = poistettava.edellinen;
                    //poistettavan luvun sisältämän solmun ollessa viimeinen, asetetaan poistettavasta edellinen solmu viimeiseksi solmuksi
                } else {
                    viimeinen = poistettava.edellinen;
                }
                //lopettaa metodin, kun poistettava solmu löytyy
                return;
            }
            //siirrytään seuraavaan solmuun niin kauan kunnes poistettava solmu löytyy
            poistettava = poistettava.seuraava;
        }
    }
    //metodi joka tulostaa listan oikeassa järjestyksessä
    public void print() {
    	//käydään lista läpi ensimmäisestä solmusta lähtien ja tulostetaan listan luvut
        Solmu nykyinen = ensimmainen;
        while (nykyinen != null) {
            System.out.print(nykyinen.luku);
            if (nykyinen.seuraava != null) {
                System.out.print(", ");
            }
          //mennään aina seuraavaan solmuun
            nykyinen = nykyinen.seuraava;
        }
        System.out.println();
    }
    //metodi joka tulostaa listan käänteisessä järjestyksessä
    public void printInv() {
    	//käydään lista läpi viimeisestä solmusta lähtien ja tulostetaan listan luvut
        Solmu nykyinen = viimeinen;
        while (nykyinen != null) {
            System.out.print(nykyinen.luku);
            if (nykyinen.edellinen != null) {
                System.out.print(", ");
            }
            //mennään aina edelliseen solmuun
            nykyinen = nykyinen.edellinen;
        }
        System.out.println();
    }
}
