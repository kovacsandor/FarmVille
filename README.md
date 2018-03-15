# Tanyamánia

## A feladat leírása

A Tanyamánia egy egyszemélyes játék, melyben a 21. század IT-világából kell kitörni és sikeres agrármenedzserré válni. Ehhez kezdetben egy 30x30 mezőből álló területet és 100&nbsp;000 petákot kapunk. A játék körökre osztott, egy körben lehetőség van:

- Szabad mezőre ültetni
- Betakarítani a beérett terményt
- Eladni a terményt
- Épületet építeni
- Gépet vásárolni
- Növelni a földterületet

Egy körben egy mezővel csak egyszer lehet interakcióba lépni, tehát például ha egy terményt betakarítottunk egy mezőről, oda csak a következő körben ültethetünk. A terület bővítése 10&nbsp;000 petákba kerül mezőnként és maximum 50x50-ig van rá lehetőség. Ha a játékos a kör befejezését választja, eltelik egy nap a játék órája szerint, a kijelölt változások végbemennek.

A játék célja minél több pénz megszerzése. Ha bármely pillanatban 0 alá csökkenne az egyenlegünk, vesztettünk.

## Növények

Név | Ültetés ára (peták/mező) | Bevétel eladáskor (peták/mező) | Idő amíg beérik (nap)
:-- | :-- | :-- | :--
Búza | 10 | 30 | 30
Kukorica | 15 | 50 | 20
Rizs | 30 | 100 | 20
Árpa | 50 | 150 | 22
Zab | 100 | 230 | 24

A növények betakarítás után a magtárunkba kerülnek, ahonnan az állattenyésztő épületek automatikusan felhasználják a szükséges mennyiséget, illetve a felesleget lehetőségünk van a táblázatban feltüntetett áron eladni.

## Vis maior helyzetek

A farmon előfordulhatnak különféle nem várt negatív események, amik miatt a
gazdaságunkat kár éri. Ezek az alábbiak lehetnek:

- Minden nap, minden növény 7% valószínűséggel áldozatul esik valamilyen kórokozónak. Ilyenkor a mezőt le kell takarítani és egy petákot sem kap érte a játékos.
- Minden nap, minden növény 2% valószínűséggel kigyulladhat. A tűz a kigyulladt növényt és a szomszéd növényeket is kiégeti (minden irányban, átlósan is). A kiégett növények mezőit le kell takarítani. Ezekért egy petákot sem kap a játékos.

## Épületek

Név | Építés ára (peták) | Építés ideje (nap) | Kukoricafogyasztás (mező/nap) | Funkció
:-- | :-- | :-- |  :-- | :---
Garázs | 150&nbsp;000 | 20 | - | Szükség van rá gépek vásárlásához. **Csak 1 építhető.**
Baromfiól | 50&nbsp;000 | 10 | 10 | Elkészülte után naponta 100 petákot termel. Több is építhető.
Disznóól | 150&nbsp;000 | 15 | 30 | Elkészülte után naponta 1 000 petákot termel. Több is építhető.
Laboratórium | 15&nbsp;000 | 10 | - | Elkészülte után lehetőség van kutatásokat végezni a növényeken.
Tűzoltó bázis | 10&nbsp;000 | 20 | - | A tüzek okozta károk valószínűsége csökkenthető, ha tűzoltó bázist építünk és megfelelő eszközöket vásárolunk bele.

Ha nincs megfelelő mennyiségű kukorica raktáron az állatok etetésére, akkor az ólak nem termelnek semmit aznap.

## Gépek

Lehetőségünk van további gépeket vásárolnunk:

Név | Ár (peták) | Működési költség (peták/mező) | Előfeltétel | Funkció
:-- | :-- | :-- | :-- | :--
Traktor | 50&nbsp;000 | 10 | Garázs szükséges a vásárláshoz. | Egy  alakú terület két sarkának megadásával az egész területet egyszerre beveti a kiválasztott növénnyel.
Kombájn | 150&nbsp;000 | 20 | Garázs szükséges a vásárláshoz. | Hasonlóan a traktorhoz, egy nagyobb területet lehet vele egyszerre betakarítani.
Inkubátor | 6&nbsp;000 | - | Laboratórium szükséges a vásárláshoz. | A növények megbetegedését csökkenti 2%-al.
Mikroszkóp | 8&nbsp;000 | - | Laboratórium szükséges a vásárláshoz. | A növények megbetegedését csökkenti 3%-al.
Poroltó | 1&nbsp;000 | - | Tűzoltó bázis szükséges a vásárláshoz. | 1%-al csökkenti a tüzek okozta károk valószínűségét.
Tűzcsap | 5&nbsp;000 | - | Tűzoltó bázis szükséges a vásárláshoz. | 1%-al csökkenti a tüzek okozta károk valószínűségét.

A mezőgazdasági gépek a táblázatban megadott költséggel üzemelnek, így például egy 10x10-es terület bevetése traktorral 10x10x10 = 1&nbsp;000 petákba kerül, plusz a vetőmag ára (lásd fentebb).

## Linkek

[zynga.com/games/farmville](https://www.zynga.com/games/farmville)

## Megjegyzések

Plusz pont szerezhető:

- grafikus megvalósításért
- Mentés és betöltés funkció megvalósításáért
- körökre osztott működés helyett valósidejű megvalósításért
- illetve a feladat egyéni ötletekkel való kiegészítéséért