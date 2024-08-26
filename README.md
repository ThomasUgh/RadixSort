# RadixSort in Java
Dieses Projekt implementiert den Radix-Sortieralgorithmus in Java, speziell angepasst, um einen String zu sortieren, der sowohl Zahlen als auch Buchstaben enthält.

Funktionsweise:
- Radix Sort ist ein nicht vergleichender Sortieralgorithmus, der die Elemente durch ihre Stellenwerte (Ziffern) sortiert.
- Der gegebene String wird in drei Kategorien unterteilt: Ziffern, Großbuchstaben und Kleinbuchstaben.
- Jede Kategorie wird separat mithilfe von Radix Sort sortiert.
- Das Ergebnis wird in der Reihenfolge ausgegeben: Kleinbuchstaben, Großbuchstaben, und dann Ziffern.