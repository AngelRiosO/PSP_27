# Tarea 3 – Impresoras con Runnable

Simulación de tres impresoras trabajando en paralelo mediante hilos en Java.

## Estructura

```
src/
├── Main.java       → crea las tres tareas, las asocia a un Thread y las inicia con start()
└── Impresora.java  → implementa Runnable; imprime página a página con Thread.sleep(1000)
```

## Funcionamiento

- **Impresora A** → 3 páginas
- **Impresora B** → 5 páginas
- **Impresora C** → 4 páginas

Cada página tarda 1 segundo. Como los hilos se ejecutan en paralelo, los mensajes
aparecen intercalados y el orden puede cambiar en cada ejecución.

## Captura de la ejecución

![Ejecución del programa](captura.png)
