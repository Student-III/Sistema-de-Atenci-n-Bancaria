# Sistema de Atención Bancaria

Implementación de un **sistema de gestión de turnos bancarios** desarrollado en **Java**, cuyo núcleo es una **lista doblemente enlazada (Double Linked List)** construida desde cero, sin usar las colecciones del JDK. El proyecto demuestra el uso práctico de estructuras de datos enlazadas para administrar una cola de turnos de clientes, permitiendo insertar, eliminar, consultar y atender turnos de forma secuencial.

---

## 📋 Descripción General

El sistema simula la atención de una sucursal bancaria: los clientes toman un turno (con número, nombre, tipo de cliente y minutos de espera) y son atendidos en orden de llegada. Toda la lógica de almacenamiento se apoya en una **lista doblemente enlazada** implementada manualmente, lo que permite recorrer la estructura en ambos sentidos y realizar inserciones/eliminaciones eficientes en cualquier posición.

El punto de entrada (`SistemaAtencionBancaria`) carga varios turnos de ejemplo, permite insertar un turno en una posición específica y luego ofrece un menú interactivo (vía `JOptionPane`) para **atender al siguiente cliente** o **salir** del sistema.

---

## 🧱 Estructura del Proyecto

com.mycompany.sistemaatencionbancaria

│

├── IList.java → Interfaz genérica que define el contrato de la lista

├── DNode.java → Nodo doblemente enlazado (info, next, prev)

├── DoubleLinkedList.java → Implementación de la lista doblemente enlazada

├── Turno.java → Modelo de datos: número, cliente, tipo, espera

└── SistemaAtencionBancaria.java → Clase principal con el menú y la lógica de atención


---

##  La Lista Doblemente Enlazada

La clase `DoubleLinkedList<T>` implementa la interfaz `IList<T>` y constituye la **base estructural** del sistema. Cada elemento se encapsula en un `DNode<T>` que guarda:

- `info` → el dato genérico (`T`)
- `next` → referencia al nodo siguiente
- `prev` → referencia al nodo anterior

### Atributos principales

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `first`  | `DNode<T>` | Referencia al primer nodo de la lista |
| `size`   | `int` | Cantidad de elementos almacenados |

### Operaciones implementadas

| Método | Descripción |
|--------|-------------|
| `add(T t)` | Agrega un elemento al **final** de la lista recorriendo los nodos hasta el último. |
| `add(T t, int index)` | Inserta un elemento en una **posición específica**. Si el índice es 0, inserta al inicio; si es mayor o igual al tamaño, agrega al final. |
| `remove(int index)` | Elimina el nodo en la posición indicada y **reconecta los enlaces** `prev`/`next` de los nodos vecinos. Retorna la info eliminada. |
| `get(int index)` | Recorre la lista hasta la posición indicada y devuelve su información. |
| `size()` | Devuelve la cantidad de elementos. |
| `clear()` | Vacía la lista liberando los enlaces de cada nodo y retorna cuántos se eliminaron. |
| `isEmpty()` | Indica si la lista está vacía (`first == null`). |

### Detalles técnicos destacados

- **Inserción al inicio (`index == 0`)**: se actualiza `first`, se enlaza el nuevo nodo con el antiguo primero y se corrige `prev`.
- **Inserción intermedia**: se recorren los nodos con un cursor y un auxiliar para reconectar `prev` y `next` correctamente.
- **Eliminación**: se distinguen dos casos —eliminar la cabeza (`index == 0`) o un nodo intermedio—, reconectando siempre los vecinos y limpiando las referencias del nodo eliminado.
- **Genérica (`<T>`)**: la estructura es reutilizable para cualquier tipo de objeto; en este proyecto se instancia con `Turno`.

---

## 🎫 Modelo `Turno`

Representa a un cliente en espera dentro del sistema:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `numeroturno` | `String` | Identificador del turno |
| `nombrecliente` | `String` | Nombre del cliente |
| `tipocliente` | `String` | Tipo de cliente (ext, dep, com, etc.) |
| `minutosespera` | `int` | Minutos estimados de espera |

Incluye constructor y métodos getters/setters para cada atributo.

---

## ⚙️ Funcionamiento del Sistema (`SistemaAtencionBancaria`)

1. **Carga inicial**: se crean cinco turnos de ejemplo y se agregan a una `DoubleLinkedList<Turno>`.
2. **Inserción en posición específica**: se demuestra `add(p, 20)` (índice fuera de rango → se agrega al final).
3. **Atención de turnos**: el método `atenderSiguienteTurno` extrae el primer nodo de la lista (la cabeza), actualiza `first`, corrige `prev` del nuevo primero y decrementa `size`. Si la lista está vacía lanza `IllegalStateException`.
4. **Menú interactivo** (bucle con `JOptionPane`):
   - `1` → Atender siguiente turno (muestra el nombre del cliente atendido).
   - `2` → Salir.
   - Cualquier otra opción → mensaje de opción no válida.

---

## 🚀 Cómo ejecutar

1. Abrir el proyecto en un IDE Java (NetBeans, IntelliJ, Eclipse, etc.).
2. Compilar todas las clases del paquete `com.mycompany.sistemaatencionbancaria`.
3. Ejecutar la clase `SistemaAtencionBancaria` (método `main`).
4. Interactuar con el menú emergente para atender turnos o salir.

> Requisito: **JDK 8 o superior**.

---

## 🎯 Objetivo académico

Este proyecto fue desarrollado como práctica de **estructuras de datos enlazadas**, poniendo especial énfasis en la implementación manual de una **lista doblemente enlazada** en Java: manejo de referencias `next`/`prev`, inserciones en distintas posiciones, eliminación con reconexión de nodos y recorrido secuencial. La lista es el componente central sobre el que se construye toda la lógica del sistema bancario.

---

## 👥 Autor

Proyecto escolar — *Sistema de Atención Bancaria*  
Implementación de Double Linked List en Java.

