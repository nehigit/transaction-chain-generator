# transaction-chain-generator

## Treść zadania
Stwórz klasę `Transaction` która zawiera pola `ammount` typu `double`, `lastTransaction` typu `String` i `nonce` typu `int`. Przykładowy obiekt:
```java
{
ammount: 15.40,
lastTransaction: “4d00d79b6733c9cc066584a02ed03410”,
nonce: 1234567
}
```
Pole `lastTransaction` zawsze zawiera hash. Klasa powinna zawierać metodę `toString()` która pozwala zamienić obiekt na stringa.
Wygeneruj jakiś losowy hash początkowy, stwórz obiekt zawierający jakąś wartość `ammoun` (dowolna, może być losowa), wartość `lastTransaction` zawierającą hash początkowy.
Zadanie polega na tym aby napisać algorytm który w tym obiekcie znajdzie taki nonce aby wynik hashowania tego tego obiektu zamienionego na `String` miał `“0”` na pięciu ostatnich pozycjach.
Taki obiekt należy zapisać do listy i wygenerować kolejne 4 obiekty w ten sam sposób.
Każdy kolejny obiekt posiada w polu `lastTransaction` hash poprzedniego i należy znaleźć nonce który powoduje że po zahashowaniu obiekt wynik zawiera `“0”` na pięciu ostatnich pozycjach.

Przykład:
wylosowany hash początkowy: `“4d00d79b6733c9cc066584a02ed03410”`
pierwszy obiekt:
```java
{
ammount: 20.50,
lastTransaction: “4d00d79b6733c9cc066584a02ed03410”,
nonce: 3453454443
}
```
po zahashowaniu ten obiekt daje hash `“a3115c33e1a3d05c42ca74c3d4400000“` (5 ostatnich pozycji hasha to znak `“0”`, znaleźliśmy naszym algorytmem odpowiedni nonce aby tak się stało).

Kolejny obiekt wygląda tak:
```java
{
ammount: 156.25, (dowolna wartość)
lastTransaction: “a3115c33e1a3d05c42ca74c3d4400000”, (hash poprzedniego obiektu Transaction)
nonce: 78324569378 (do znalezienia)
}
```
po zahashowaniu ten obiekt daje hash `“c5c1a75de8f1c7e464f68efe1e700000”` - po zahashowaniu tego obiektu 5 ostatnich znaków hasha to `“0”`, znaleźliśmy odpowiednią wartość nonce).

Kolejny obiekt:
```java
{
ammount: 1000.00, (dowolna wartość)
lastTransaction: “c5c1a75de8f1c7e464f68efe1e700000”, (hash poprzedniego obiektu Transaction)
nonce: 123 (do znalezienia)
}
```
po zahashowaniu ten obiekt daje hash `“58afa62d433d42831496649c97c00000”` - 5 ostatnich znaków to `“0”`.
Należy wygenerować 5 takich obiektów.
