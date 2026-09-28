public class Main {

    public static void main(String[] args) {

        CSVLoader loader1 = new CSVLoader("AlgebraRelazione2/src/Persone.csv");
        CSVLoader loader2 = new CSVLoader("AlgebraRelazione2/src/Ordini.csv");
        CSVLoader loader3 = new CSVLoader("AlgebraRelazione2/src/Prodotti.csv");

        Relation persone = loader1.loadCSVinRelation();
        Relation ordini = loader2.loadCSVinRelation();
        Relation prodotti = loader3.loadCSVinRelation();

        System.out.println("prodotto cartesiano:");
        System.out.println(persone.prodotto(prodotti));


        System.out.println("joni:");
        String[] join1 = {"id_prodotto", "id_prodotto"};
        Relation joinOrdiniProdotti = ordini.join(prodotti, join1);

        System.out.println(joinOrdiniProdotti);


        System.out.println("\n query num. 1:");

        int totaleGenerale = 0;

        for (int i = 0; i < ordini.getRows().size(); i++) {
            Row ordine = ordini.getRows().get(i);

            int idProdotto = Integer.parseInt(ordine.getValue(2));
            int quantita = Integer.parseInt(ordine.getValue(3));

            for (int j = 0; j < prodotti.getRows().size(); j++) {
                Row prodotto = prodotti.getRows().get(j);
                if (Integer.parseInt(prodotto.getValue(0)) == idProdotto) {

                    int prezzo = Integer.parseInt(prodotto.getValue(2));
                    totaleGenerale += prezzo * quantita;
                }

            }
        }

        System.out.println("tot: " + totaleGenerale);


        System.out.println("\n query num. 2:");


        System.out.println("\n totale per ordjne");

        for (int i = 0; i < ordini.getRows().size(); i++) {
            Row ordine = ordini.getRows().get(i);

            int idOrdine = Integer.parseInt(ordine.getValue(0));
            int idProdotto = Integer.parseInt(ordine.getValue(2));

            int quantita = Integer.parseInt(ordine.getValue(3));

            for (int j = 0; j < prodotti.getRows().size(); j++) {

                Row prodotto = prodotti.getRows().get(j);
                if (Integer.parseInt(prodotto.getValue(0)) == idProdotto) {

                    int prezzo = Integer.parseInt(prodotto.getValue(2));

                    int totaleOrdine = prezzo * quantita;

                    System.out.println("Ordine " + idOrdine + " -> " + totaleOrdine + " euro");
                }
            }

        }

        System.out.println("\n query num. 3:");

        int prezzoMax = 0;
        String idProdottoCostoso = "";

        for (int i = 0; i < prodotti.getRows().size(); i++) {

            Row prodotto = prodotti.getRows().get(i);
            int prezzo = Integer.parseInt(prodotto.getValue(2));

            if (prezzo > prezzoMax) {
                prezzoMax = prezzo;
                idProdottoCostoso = prodotto.getValue(0);
            }
        }

        System.out.println("\n utenti che hanno acquisto il prodotto piu costoso");

        for (int i = 0; i < ordini.getRows().size(); i++) {

            Row ordine = ordini.getRows().get(i);

            if (ordine.getValue(2).equals(idProdottoCostoso)) {

                String idUtente = ordine.getValue(1);
                for (int j = 0; j < persone.getRows().size(); j++) {
                    Row persona = persone.getRows().get(j);

                    if (persona.getValue(0).equals(idUtente)) {
                        System.out.println(persona.getValue(1) + " " + persona.getValue(2));
                    }
                }
            }
        }
    }
}