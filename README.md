# MyP-Practica01
- Practica 1 de Modelado y Programación 2027-1:

Nombre del equipo: LOS TROYANOS

Nombre de los integrantes:

- Santos Alcocer Antonio de Jesús. N.C: 420003090
- Huaxcuahutli Teopantzin José Luis N.C: 320204603
- Martínez Martínez Marco Antonio N.C: 

# NOTAS DE LA PRÁCTICA.

La práctica fue un simple uso de los patrones de diseño "Strategy" y "Observer" el cuál fue prácticado en la realización de esta práctica. El patrón de diseño "Strategy" se utilizo para la creación de diferentes objetos(objetos consumibles por los personajes) y habilidades de estos objetos para su uso en la simulación de combates  que se nos pidió en esta práctica, de manera que, gracias al patrón de diseño Strategy pudimos generar varios objetos y habilidades de estos objetos sin estar instanciando y generando copias de código para la generación de esto, por lo que creemos que aplicar este patrón fue una decisión muy práctica para este tipo de problemas.

El patrón de diseño Observer se puede contemplar en el grupo de clases referido a los espectadores y a la clase "CombateSimulacion" ya que estos replican la estructura de observado y observador que tienen un evento como de lucha libre o de carreras ya que en si, el CombateSimulacion sería como el campo o el comentarista que le dice a todos los espectadores que es lo que está pasando, así mismo está obligado a notificar a cada uno de los Espectadores en su bitacora, de tal manera que cuando pase algo en el campo de batalla los observadores no solo sabrán lo que paso, si no que también lo recordarán en su bitacora, por tanto, utilizar el patrón de estrategía Observer en estas clases fue crucial para todo lo referido con los Espectadores y como se iban a generar los archivos de bitacora de la pelea de los espectadores.

Juntando todo ese grupo de clases del Observer, los personajes y generando todos los objetos y habilidades que queramos gracias al patrón Strategy lo usamos en nuestra clase Combate, el cuál, solo generá combates "semi-automaticos" basado en un esquema de Eventos Aleatorios que pueden pasar en el campo, claramente basado en probabilidades aleatorias, por tanto, de esta manera, podemos acercarnos a una simulación un poco más parecida como lo que hacen los juegos de peleas actualmente (sin rondas). Así, creemos que con esta estructura que creamos para resolver el problema, no solo resolvemos el problema, también lo hacemos flexible ante cualquier cambio y/o error que pudiese aparecer ahora o en un momento después.

## Compilación y Ejecución Manual

Para compilar y ejecutar el proyecto desde la terminal, abre tu consola en la raíz del repositorio: "MyP-Practica01" y sigue estos pasos:

### 1. Compilación
Este comando busca recursivamente todos los archivos `.java` dentro de `src/` y guarda los archivos compilados (`.class`) en una carpeta `bin/`:

**En Windows (PowerShell):**
```powershell
mkdir bin -ErrorAction SilentlyContinue
javac -d bin (Get-ChildItem -Path src -Filter *.java -Recurse)
```


**En Linux / macOS / Git Bash:**
```bash
mkdir -p bin
javac -d bin $(find src -name "*.java")
```

---

### 2. Ejecución
Una vez compilado, ejecuta la clase `Main` especificando la carpeta `bin` como el *classpath*:

  ```bash
  java -cp bin Main
  ```

Ó

  ```bash
  java -cp bin Main.Main
  ```