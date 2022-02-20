dodaj nowy produkt - produkt jest określony nazwą oraz ceną
POST: http://localhost:8080/api/produkt
Przykładowy JSON:
{
    "nazwa": "RH Sound DB-02",
    "cena": 84.9
}

zwróć listę produktów
GET: http://localhost:8080/api/produkt

złóż zamówienie - zamówienie może zawierać wiele produktów
POST: http://localhost:8080/api/zamowienie
Przykładowy JSON:
{
    "produkty": [
        {"id": 6},
        {"id": 7},
        {"id": 8},
        {"id": 10}
    ]
}

aktualizuj produkt (nazwa, cena) – zmiany nie powinny wpływać
na kwotę całkowitą już złożonych zamówień
PUT: http://localhost:8080/api/produkt
Przykładowy JSON:
{
    "id": 11,
    "nazwa": "RH Sound DB-02",
    "cena": 85.9
}

przelicz zamówienie – powoduje aktualizację kwoty zamówienia
według aktualnych cen produktów
PUT: http://localhost:8080/api/zamowienie/{zamId}
Na przykład: http://localhost:8080/api/zamowienie/9

zwróć wszystkie zamówienia w okresie
GET: http://localhost:8080/api/zamowienie (wszystkie zamówienia)
GET: http://localhost:8080/api/zamowienie?start=2022-02-17&end=2022-02-18
(zamówienia w okresie)
