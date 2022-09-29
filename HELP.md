# Mikroservis za organizovanje nagradnih igara
> Predstavlja servis koji služi za organizovanje nagradnih igara, odnosno pronalaženje dobitnog tiketa po nekom od kriterijuma - duzini tiketa, visini ukupne kvote na tiketu, datumu uplate tiketa, pri određenim uslovima specifičnim za svaku nagradnu igru: broj redova, minimalna uplata na tiketu, uplatna mesta koja učestvuju, takmičenja koja su uključena u nagradnu igru...


## Tehnologije i alati
- Java 8, uz korišćenje Spring Boot i MyBatis framework-a
- Oracle baza
- Docker
- ActiveMQ kao podrska za messaging

Za potrebe razvoja servisa oslanjanjem na Oracle bazu korišćen je docker image oracle-uos-db, tj. 'prazna' Oracle xe baze na verziji 11g gde je pri pokretanju kontejnera prosleđen spisak usera koji su kreirani, pri čemu je password isti kao i username(obuka 1).

```bash
docker pull docker.mozzartio.com:5000/oracle-uos-db
 
 docker run --name test_container -p 1522:1521 -p 8080:8080 -e ORACLE_PWD=sys --shm-size="2g" -e DB_USERS="obuka1 obuka2" -d 07890775f278
```
ActiveMQ - podaci(tiketi) se dobijaju sa spoljnih servisa a zatim odgovarajući JMS listeneri te podatke obrađuju dalje:
Queue: obuka_queue
Podešavanja za ActiveMQ:

spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin


## Funkcionalnosti
Funkcionalnosti ovog mikroservisa odnose se pretežno na čuvanje tiketa, njihovu obradu, određivanje kandidata kao i pobedničkih tiketa nagradnih igara.
U njemu postoje dve celine:

1. Procesiranje i čuvanje tiketa pristiglih sa ActiveMQ-a
2. Obrada tiketa koji su kandidati i određivanje pobednika za svaku od nagradnih igara

- Procesiranje i čuvanje tiketa pristiglih sa ActiveMQ-a
	Poruke koje se pošalju na red obuka_queue, u okviru TicketListener-a pretvaraju se u Ticket objekte. U trenutku pristizanja tiketa, proverava se da li svaki od njih već postoji u bazi, i ukoliko postoji, tada se vrednost kolone time_changed koja predstavlja vreme kada se desila neka promena na tiketu, postavlja na sistemsko vreme kako bi taj tiket ušao u sledeći ciklus obrade kandidata. Ukoliko se neki tiket ne nalazi u bazi podataka, tada se u okviru transakcije čuvaju odgovarajući podaci u tabele ticket i ticket_row. Prilikom tog čuvanja, proverava se da li tiket ispunjava osnovne uslove koji ga čine kandidatom za neku trenutno aktivnih nagradnih igara, a to su uslovi koji se odnose na sam tiket (poput ukupne kvote ili uplate na tiketu, broja redova…), i ukoliko je to slučaj, to se beleži u ticket_giveaway tabeli.

- Obrada tiketa koji su kandidati i određivanje pobednika za svaku od nagradnih igara
	U okviru GiveawayScheduler-a, vrši se obrada i utvrđivanje trenutno najboljih tiketa nagradnih igara na određeni period definisan u application.properties fajlu. Za trenutno aktuelnu nagradnu igru, i takvu njenu fazu, iz baze se izvlače svi tiketi kandidati. U ovom trenutku, za njih se proveravaju i sva ostala pravila koja važe za tu nagradnu igru (odnose se na ograničenja broja dobitnih i gubitnih redova na tiketu, da li su takmičenja u okviru kojih se održavaju utakmice na redovima tiketa uključena u nagradnu igru...), a na njoj je definisan i redosled kriterijuma po kojima će se tiketi koji ispune sve uslove rangirati. Ti kandidati se zatim upoređuju sa trenutno najboljim tiketima za aktivnu fazu posmatrane nagradne igre koji su sačuvani u bazi, ukoliko oni postoje, i na osnovu definisanih kriterijuma poređenja, u tabeli ticket_stage_winner se čuvaju novi trenutni pobednici giveaway-a.


## Model podataka
Ovde se nalazi [sql fajl] sa eksportovanom Oracle bazom podataka. Model podataka je prikazan na slici ispod:

![Relacioni model](./img/relacioni.png)
<img src="/img/relacioni.jpg" alt="Alt text" title="Optional title">




