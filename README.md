# Algebra Relazionale - Parte 2

## Descrizione del progetto

Questo progetto estende l'esercitazione precedente sull'Algebra Relazionale implementando due nuove operazioni:

- Cartesian Product
- Join

Successivamente tali operazioni vengono utilizzate per eseguire alcune query su un insieme di dati composto da utenti, prodotti e ordini.

---

# Struttura del progetto

Il progetto è composto dalle seguenti classi:

## Row

Rappresenta una singola tupla della relazione.

```java
ArrayList<String> values;
```

Ogni oggetto `Row` contiene i valori di una riga del file CSV.

---

## Relation

Rappresenta una relazione.

Contiene:

```java
ArrayList<String> header;
ArrayList<Row> rows;
```

Questa classe implementa le operazioni dell'algebra relazionale:

- Selection
- Projection
- Union
- Difference
- Cartesian Product
- Join

---

## CSVLoader

Permette di leggere un file CSV e convertirlo in una relazione.

Metodo principale:

```java
loadCSVinRelation()
```

---

## Main

Contiene il codice di test delle operazioni e delle query richieste dall'esercitazione.

---

# Dataset utilizzati

## Persone.csv

```csv
id,nome,cognome
0,Mario,Pavan
1,Giuseppe,Rossi
2,Giovanni,Bianchi
3,Piero,Neri
```

---

## Prodotti.csv

```csv
id_prodotto,nome,prezzo_unitario
0,IPhone,1000
1,Samsung Galaxy,1200
2,Google Pixel,800
```

---

## Ordini.csv

```csv
id,id_utente,id_prodotto,qty
0,0,0,1
1,0,1,2
2,1,1,3
```

---

# Operazioni implementate

## Cartesian Product

Il prodotto cartesiano combina ogni tupla della prima relazione con tutte le tuple della seconda relazione.

Formalmente:

```text
R × S
```

Se una relazione contiene n tuple e l'altra m tuple, il risultato conterrà:

```text
n × m tuple
```

### Esempio

```java
Relation result =
        persone.cartesianProduct(prodotti);
```

---

## Join

La join permette di unire due relazioni confrontando il valore di uno o più attributi comuni.

Formalmente:

```text
R ⋈ S
```

### Esempio

```java
String[] joinField =
        {"id_prodotto","id_prodotto"};

Relation result =
        ordini.join(prodotti, joinField);
```

Questa operazione unisce ogni ordine con il corrispondente prodotto.

---

# Query richieste

## Query 1

### Visualizzare il totale di tutti gli ordini

Per ogni ordine viene recuperato il prezzo del prodotto acquistato e moltiplicato per la quantità.

Formula:

```text
Totale = prezzo_unitario × quantità
```

### Risultato

| Ordine | Totale |
|----------|----------|
| 0 | 1000 |
| 1 | 2400 |
| 2 | 3600 |

Totale generale:

```text
7000 €
```

---

## Query 2

### Visualizzare il totale per ogni singolo ordine

Risultati:

```text
Ordine 0 -> 1000 €
Ordine 1 -> 2400 €
Ordine 2 -> 3600 €
```

---

## Query 3

### Visualizzare gli utenti che hanno acquistato il prodotto più costoso

Analizzando la relazione dei prodotti:

| Prodotto | Prezzo |
|-----------|-----------|
| IPhone | 1000 |
| Samsung Galaxy | 1200 |
| Google Pixel | 800 |

Il prodotto più costoso risulta:

```text
Samsung Galaxy
```

Successivamente vengono individuati gli utenti che hanno acquistato tale prodotto.

### Risultato

```text
Mario Pavan
Giuseppe Rossi
```

---

# Esempi di utilizzo

## Esempio di Cartesian Product

```java
Relation cp =
        persone.cartesianProduct(prodotti);

System.out.println(cp);
```

---

## Esempio di Join

```java
String[] joinField =
        {"id_prodotto","id_prodotto"};

Relation join =
        ordini.join(prodotti, joinField);

System.out.println(join);
```

---

# Conclusioni

L'estensione del progetto ha permesso di implementare due nuove operazioni dell'Algebra Relazionale:

- Cartesian Product
- Join

Grazie a queste operazioni è stato possibile effettuare interrogazioni più complesse sui dati relativi a utenti, prodotti e ordini.

L'esercitazione mostra come le operazioni dell'Algebra Relazionale possano essere implementate utilizzando strutture dati semplici come `ArrayList` e applicate a dati memorizzati in file CSV.
