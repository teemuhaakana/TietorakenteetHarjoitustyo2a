import java.util.Scanner;
//simppeli käyttöliittymä DListille

public class Kayttoliittyma {
	//toteutetaan main-metodissa
    public static void main(String[] args) {
    	//luodaan uusi DList olio eli siis uusi lista
        DList lista = new DList();
        //käytetään javan scanneria käyttäjän syötteen lukemiseen
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        	//eri operaatiot
            System.out.println("1. Lisää luku");
            System.out.println("2. Etsi luku");
            System.out.println("3. Poista luku");
            System.out.println("4. Listan tulostaminen");
            System.out.println("5. Listan tulostaminen käänteisessä järjestyksessä");
            System.out.println("6. Lopeta ohjelman käyttö");
            
            //muuttuja, johon tallennetaan käyttäjän valinta
            int valinta = scanner.nextInt();
            
            //valinnan perusteella kutsutaan jotakin listan metodia tai lopetetaan ohjelman suorittaminen
            switch (valinta) {
            		//luvun lisääminen
                case 1:
                    System.out.println("Syötä luku, jonka haluat lisätä listaan:");
                    //käyttäjältä luku joka lisätään
                    int luku = scanner.nextInt();
                    lista.insert(luku);
                    break;
                    //luvun etsiminen
                case 2:
                    System.out.println("Syötä etsittävä luku:");
                    //käyttäjältä luku jonka indeksi etsitään
                    int etsittavaLuku = scanner.nextInt();
                    //kutsutaan find metodia
                    int indeksi = lista.find(etsittavaLuku);
                    //jos metodi ei palauta -1, luku löytyy listasta ja sen indeksi tulostetaan
                    if (indeksi != -1) {
                        System.out.println("Luvun " + etsittavaLuku + " indeksi on " + indeksi);
                        //muuten ilmoitetaan että ei löytynyt listasta
                    } else {
                        System.out.println("Lukua " + etsittavaLuku + " ei löytynyt listasta.");
                    }
                    break;
                    //luvun poistaminen listasta
                case 3:
                    System.out.println("Syötä poistettava luku:");
                    //pyydetään käyttäjältä luku joka halutaan poistaa
                    int poistettavaLuku = scanner.nextInt();
                    //kutsutaan delete metodia
                    lista.delete(poistettavaLuku);
                    break;
                    //listan tulostaminen
                case 4:	
                    System.out.println("Lista:");
                    //kutsutaan print metodia
                    lista.print();
                    break;
                    //käänteinen tulostus
                case 5:
                    System.out.println("Lista käänteisessä järjestyksessä:");
                    //kutsutaan printInv metodia
                    lista.printInv();
                    break;
                    //käyttäjän syötteen vastaanottamisen lopettaminen
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
