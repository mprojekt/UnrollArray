# Rozwijanie Tablicy (Unroll Array)
## Spiralne rozwijanie tablicy typu int.

### 1. O co chodzi?

Zaprezentowana biblioteka zajmuje się "rozwijaniem" tablic prostokątnych spiralnie, zaczynając z jednej ze stron i zagłębiając się do środka, tak jak to przedstawia poniższy rysunek:

![array](http://mpietroszek.pl/image/array.jpg)

Wynikiem działania dla powyższej tablicy będzie `[0, 1, 2, 3, 7, 11, 15, 14, 13, 12, 8, 4, 5, 6, 10, 9]`.

### 2. Możliwości

*  Biblioteka działa dla tablic liczb całkowitych (`int[][]`).
*  Tablica wejściowa musi być prostokątna tzn. wszystkie wiersze są tej samej długości.
*  Tablica może być rozwijana w kierunku ruchu wskazówek zegara (jak na rysunku) lub przeciwnie.
*  Wynikiem jest jednowymiarowa tablica liczb całkowitych (`int[]`) zawierająca wszystkie liczby z tablicy wejściowej.
	
### 3. Użycie

*  Biblioteka udostępnia interfejs `UnrollArray` oraz jego implementację `Spiral`:
```
UnrollArray spiral = new Spiral();
```
* Metody, które można użyć:
	* Metody, które określają początkową krawędź, od której zacznie się rozwijanie:
		* `Spiral top()` (jest to domyślna strona)
    	* `Spiral right()` 
    	* `Spiral bottom()`
    	* `Spiral left()` 
   	* Metody, które określają kierunek rozwijania:
    	* `Spiral clockwise()` (jest to domyślny kierunek)
    	* `Spiral anticlockwise()`
   	* `int[] unroll(int[][] array)` - metoda powodująca wykonanie rozwijania. Zwraca wyjątek `IllegalArgumentException` jeśli tablica nie spełnia warunków lub jej nie ma (`null`).
* Przykładowe użycie:
```
int[] result = spiral.left().anticlockwise().unroll(array);
```