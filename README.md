# Tanyamánia

## A feladat leírása

A Tanyamánia egy egyszemélyes játék, melyben a 21. század IT-világából kell kitörni és sikeres agrármenedzserré válni. Ehhez kezdetben egy 30x30 mezőből álló területet és 100.000 petákot kapunk. A játék körökre osztott, egy körben lehetőség van:

- Szabad mezőre ültetni
- Betakarítani a beérett terményt
- Eladni a terményt
- Épületet építeni
- Gépet vásárolni
- Növelni a földterületet

Egy körben egy mezővel csak egyszer lehet interakcióba lépni, tehát például ha egy terményt betakarítottunk egy mezőről, oda csak a következő körben ültethetünk. A terület bővítése 10.000 petákba kerül mezőnként és maximum 50x50-ig van rá lehetőség. Ha a játékos a kör befejezését választja, eltelik egy nap a játék órája szerint, a kijelölt változások végbemennek.

A játék célja minél több pénz megszerzése. Ha bármely pillanatban 0 alá csökkenne az egyenlegünk, vesztettünk.

# Növények

Név | Ültetés ára (peták/mező) | Bevétel eladáskor (peták/mező) | Idő amíg beérik (nap)
--- | --- | --- | ---
Búza | 10 | 30 | 30
Kukorica | 15 | 50 | 20
Rizs | 30 | 100 | 20
Árpa | 50 | 150 | 22
Zab | 100 | 230 | 24

A növények betakarítás után a magtárunkba kerülnek, ahonnan az állattenyésztő épületek automatikusan felhasználják a szükséges mennyiséget, illetve a felesleget lehetőségünk van a táblázatban feltüntetett áron eladni.

## Vis maior helyzetek