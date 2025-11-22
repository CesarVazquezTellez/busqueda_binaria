¿Qué es la Búsqueda Binaria?
La búsqueda binaria es un algoritmo eficiente para encontrar un elemento específico dentro de un "arreglo ordenado". Funciona dividiendo repetidamente el espacio de búsqueda a la mitad, comparando el elemento del medio con el valor buscado.
Características Importantes:

Complejidad temporal: O(log n) - mucho más eficiente que la búsqueda lineal O(n)
Requisito crítico: El arreglo DEBE estar ordenado previamente
Tipo de algoritmo: Divide y vencerás
Uso de memoria: O(1) - búsqueda in-place sin espacio adicional
Mejor caso: O(1) cuando el elemento está en el centro
Peor caso: O(log n) cuando el elemento está en los extremos o no existe

Ventajas:

Muy rápido para grandes conjuntos de datos ordenados
Reduce dramáticamente el número de comparaciones necesarias

Desventajas:

Requiere que los datos estén ordenados
No es eficiente para arreglos pequeños (el overhead no compensa)


Funcionamiento del Código
Este programa implementa búsqueda binaria con lectura/escritura de archivos:
1. Lectura de datos (readNumbersFromFile)

Lee números desde un archivo de texto
Permite múltiples números por línea separados por espacios
Convierte los números a una lista y luego a un arreglo

2. Algoritmo de búsqueda (binarySearch)

Define dos punteros: low (inicio) y high (final)
En cada iteración:

Calcula el índice medio: mid = low + (high - low) / 2
Si arr[mid] == x: elemento encontrado, retorna el índice
Si arr[mid] < x: el elemento está en la mitad derecha, actualiza low = mid + 1
Si arr[mid] > x: el elemento está en la mitad izquierda, actualiza high = mid - 1


Si low > high: el elemento no existe, retorna -1

3. Salida de resultados (printResult y writeResultToFile)

Muestra en consola si el número fue encontrado y su posición
Escribe los mismos resultados en un archivo de salida

4. Flujo principal (main)

Solicita nombres de archivos de entrada/salida
Lee el arreglo y el número objetivo
Ejecuta la búsqueda y guarda resultados


Prueba de Escritorio (Ejemplo Manual)
Datos de entrada:
Archivo de entrada: numeros.txt
2 5 8 12 16 23 38 45 56 67 78
Número a buscar: 23
Ejecución paso a paso:
Arreglo ordenado (índices 0-10):
[2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78]
Iteración 1:

low = 0, high = 10
mid = 0 + (10 - 0) / 2 = 5
arr[5] = 23
23 == 23 ¡ENCONTRADO!
Retorna índice: 5

Resultado:
Número buscado: 23
Resultado: ENCONTRADO
Posición: 5

Ejemplo 2: Elemento no encontrado
Número a buscar: 30
Iteración 1:

low = 0, high = 10
mid = 5
arr[5] = 23
23 < 30 → Buscar en mitad derecha
low = 6

Iteración 2:

low = 6, high = 10
mid = 6 + (10 - 6) / 2 = 8
arr[8] = 56
56 > 30 → Buscar en mitad izquierda
high = 7

Iteración 3:

low = 6, high = 7
mid = 6 + (7 - 6) / 2 = 6
arr[6] = 38
38 > 30 → Buscar en mitad izquierda
high = 5

Fin:

low = 6, high = 5
low > high → Elemento no existe
Retorna: -1

Resultado:
Número buscado: 30
Resultado: NO ENCONTRADO